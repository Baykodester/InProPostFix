/**

Program description: This program gets a infix expression and turns a postfix expression and gives result.

Author: Berke Şahin

E-mail address: Sayanati517@gmail.com

Homework Number: 210401050

Last Changed: 21.03.2024

*/
import java.util.*;

// Before the run!!
// Don't use space. Write like this (3+4)*5-6/2. Not like this (3 + 4) * 5 - 6 / 2.

public class problem03 {

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
        	//infix.length == postfix.length(if  we dont  use brackets.)
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
                
            } else if (c == '(') {
                stack.push(c);
                
            } else if (c == ')') {
            	
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); //This deletes the '(' bracket.
            } else {
                //This part means operator input.
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                	//precedence gets 1 , -1 or 2. -1 means default. 1 means + -. 2 means / *.
                	// * and / have a priority that's why they are 2. 
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        } //this part continuous until stack is empty. 
       
        return postfix.toString();
    }

    public static int postfixEvaluation(String postfix) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
                
            } else {
            	//this part important. integer integer ... operator operator ... goes on.
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = Result(operand1, operand2, c); // Result!!
                stack.push(result);
            }
        }

        return stack.pop();
    }
    //Operator part.
    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    // This part finds the result.
    public static int Result(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                	// This part extra. İf the user write the like 5/0, this is a error. But we can throw Exception.
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator"); // if user use except +-/* , this will create a crash.
                //I used IllegalArgumentException because we do not want to do this.
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();
        // Write like this (3+4)*5-6/2. Do not use space.
        
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);

        int result = postfixEvaluation(postfixExpression);
        System.out.println("Result: " + result);
    }
}
