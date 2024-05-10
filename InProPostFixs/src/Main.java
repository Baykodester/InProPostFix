
// problem01 and problem02 works.
// problem03 only works if there is no space between the given operations (3+4)*5-6/2 like this.



import java.util.Scanner;
import java.util.*;

public class Main {
	
    public static void main(String[] args) {
          
    	//problem01
    	  Scanner scanner = new Scanner(System.in);
          System.out.print("Enter a string: ");
         
          String input = scanner.nextLine();
          ListNode head = problem01.createLinkedList(input);
          head = problem01.reverseLinkedList(head);

          System.out.print("Reversed string: ");
          problem01.printLinkedList(head);
          //----------------------------------
          
          //problem02
          
          //Scanner scanner = new Scanner(System.in);
          System.out.print("Enter a string, just use brackets: ");
          String input2 = scanner.nextLine();

          if (problem02.bracketMatcher(input2)) { //Boolean. 0 or 1.
              System.out.println("The brackets are correctly matched and nested.");
          } else {
              System.out.println("The brackets are not correctly matched and nested.");
          }
          
          //------------------------------------
          
          //problem03
          
          System.out.print("Enter an infix expression: (3 + 4) * 5 - 6 / 2\n");
          String infixExpression;

          // Write like this (3+4)*5-6/2. Do not use space.
          
          String postfixExpression = problem03.infixToPostfix("(3+4)*5-6/2");
          System.out.println("Postfix expression: " + postfixExpression);

          int result = problem03.postfixEvaluation(postfixExpression);
          System.out.println("Result: " + result);
          
          System.out.print("Enter an infix expression: 5 * (6 - 2)\n");
          
          String postfixExpression2 = problem03.infixToPostfix("5*(6-2)");
          System.out.println("Postfix expression: " + postfixExpression2);

          int result2 = problem03.postfixEvaluation(postfixExpression2);
          System.out.println("Result: " + result2);
          
   
    }
}