import java.util.*;

public class dsa_assignment12 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /*
     * question
     * Given two linked lists, insert nodes of second list into first list at
     * alternate positions of first list.
     * 
     */
    public void insertAtPos(ListNode first, ListNode second) {
        ListNode firstPtr = first;
        ListNode secPtr = second;

        while (firstPtr != null && secPtr != null) {
            ListNode firstNext = firstPtr.next;
            ListNode secNext = secPtr.next;

            firstPtr.next = secPtr;
            secPtr.next = firstNext;

            firstPtr = firstNext;
            secPtr = secNext;
        }

        second = secPtr;
    }

    /*
     * A linked list is called circular if it is not NULL-terminated and all nodes
     * are connected in
     * the form of a cycle. Below is an example of a circular linked list.
     */
    public boolean check_Circular(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true; // get it
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false; // No cycle found
    }

    /*
     * question 6
     * 
     * Given a linked list and two integers M and N. Traverse the linked list such
     * that you retain M nodes
     * then delete next N nodes, continue the same till end of the linked list.
     * M = 2, N = 2
     * Linked List: 1->2->3->4->5->6->7->8
     * output-> 1->2->5->6
     * 
     */
    public ListNode traverse_Delete(ListNode head, int M, int N) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {

            for (int i = 0; i < M && current != null; i++) {
                prev = current;
                current = current.next;
            }

            for (int i = 0; i < N && current != null; i++) {
                current = current.next;
            }

            prev.next = current;
        }

        return head;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 5
     * Remove the loop from the linked list, if it is present, i.e. unlink the last
     * node which is forming the loop.
     * N = 3
     * value[] = {1,3,4}
     * X = 2
     */
    public ListNode Remove_Loop(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return head;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode loopStart = slow;
        while (fast.next != loopStart) {
            fast = fast.next;
        }
        fast.next = null;

        return head;
    }

    /*
     * question 4
     * Given a singly linked list of characters, write a function that returns true
     * if the given list is a
     * palindrome, else false.
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        Stack<Character> stack = new Stack<>();

        while (fastPtr != null && fastPtr.next != null) {

            stack.push(slowPtr.val);
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        while (slowPtr != null) {
            if (slowPtr.val != stack.pop()) {
                return false;
            }
            slowPtr = slowPtr.next;
        }

        return true;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 3
     * Given a linked list consisting of L nodes and given a number N. The task is
     * to find the Nth node
     * from the end of the linked list.
     */
    public static ListNode node_from_end(ListNode head, int n) {

        ListNode temp = head;
        int size = 0;

        while (temp != null) { // first calculate size
            size++;
            temp = temp.next;
        }
        int size2 = size - n + 1; // get node on this size that will

        temp = head;

        for (int i = 1; i <= size2 - 1; i++) {
            temp = temp.next;
        }

        return temp;

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * question 2
     * Given a linked list of N nodes. The task is to check if the linked list has a
     * loop.
     * Linked list can contain self loop.
     */

    public static boolean has_cycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                return true;
            }
        }

        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 1
     * Given a singly linked list, delete middle of the linked list. For example, if
     * given linked list is
     * 1->2->3->4->5 then linked list should be modified to 1->2->4->5.If there
     * are even nodes, then
     * there would be two middle nodes, we need to delete the second middle element.
     * For example,
     * if given linked list is 1->2->3->4->5->6 then it should be modified to
     * 1->2->3->5->6.If the input
     * linked list is NULL or has 1 node, then it should return NULL
     * 
     */
    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next.next != null && fast.next.next.next != null) {
            // for even & odd both condition it will run

            slow = slow.next;
            fast = fast.next.next; // increase 2 times
        }

        slow.next = slow.next.next;// here do not use fast bcoz slow is moving 1 by 1

        return head;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(17);
        head1.next.next.next = new ListNode(13);
        head1.next.next.next.next = new ListNode(11);

         ListNode current = head1;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
