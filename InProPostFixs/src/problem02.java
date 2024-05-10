import java.util.*;
/**

Program description: This program will match the brackets or not.it works like stack.

Author: Berke Şahin

E-mail address: Sayanati517@gmail.com

Homework Number: 210401050

Last Changed: 21.03.2024

*/
  //
    class Node {
    	//Node= data next, NodeList= val next. I used Node because we do not need to value.
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public class problem02 {
    	
    static Node head; //İt will be use
    
    //This program works with push and pop functions that we learned at stack function.
    //Logic: First in, Last out.if the stack is empty, input is correct otherwise it is false.
    
    public static void push(char data) {
        Node newNode = new Node(data); 
        newNode.next = head;
        head = newNode;
        //Adds a newNode
    }

    public static char pop() {
        if (head == null) {
        	//if user do not write anything, than this if will work.
            throw new EmptyStackException();
        }
        char data = head.data;
        head = head.next;
        return data;
        // deletes last bracket.
    }

    public static boolean bracketMatcher(String str) {
        for (char c : str.toCharArray()) { // I used this before this problem. 
            if (c == '(' || c == '[' || c == '{') {
                push(c); // (,[,{ adds.
            } else if (c == ')' || c == ']' || c == '}') {
            	
                if (head == null) {
                    return false;
                }
                char top = pop();
                if ((c == ')' && top != '(') ||(c == ']' && top != '[') || (c == '}' && top != '{')) {
                	// top means: last input. if top is not ( and c is ) or other brackets, return false.
                    return false;
                }
            }
        }
        // :)
        return head == null;
    }

    
}


