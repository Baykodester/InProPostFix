/**

Program description: This program reverse the strings.

Author: Berke Şahin

E-mail address: Sayanati517@gmail.com

Homework Number: 210401050

Last Changed: 21.03.2024

*/
import java.util.Scanner;

//Actually, we dont need to use Node, head terms. They just prolongs the progressing time.
//But we learned Node. That's why I used them.

class ListNode {
    char val;
    ListNode next; 
    //Classic part.
    ListNode(char x) {
        val = x;
        next = null;
    }
}

public class problem01 {
  
    public static ListNode createLinkedList(String str) {
        ListNode count = new ListNode('0');// This party actually works like dummy.
        ListNode current = count;
        //This part creates linkedlist.
        for (char ch : str.toCharArray()) {  // I used toCharArray. str comes from user.
            ListNode newNode = new ListNode(ch);
            
            current.next = newNode;
            current = newNode;
        }

        return count.next; //it returns the actual head.
    }

    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) 
        {return head;}
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
        	//This part reverse linkedlist.
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev; // New head after reversal
    }
     //This part prints linkedlist.
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
        System.out.println();
    }
}
