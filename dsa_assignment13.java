

public class dsa_assignment13 {

     public static class ListNode {
     int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val; 
            this.next = null;
            this.prev=null;
        }
    }

// question 8
/*
 * Given a doubly linked list and a position. The task is to delete a node from given position in a
 *  doubly linked list.
 */
public static ListNode deleteNode(ListNode head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        ListNode current = head;
        int count = 0;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head;
        }

        ListNode prevNode = current.prev;
        prevNode.next = current.next;

        if (current.next != null) {
            current.next.prev = prevNode;
        }

        current.prev = null;
        current.next = null;

        return head;
    }

   ///////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 7
Doubly Linked List**, the task is to reverse the given Doubly Linked List.

 */
public static ListNode reverse_doubly(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }

        return prev;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 6
 * Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the 
 * lists (in place) and return the head of the merged list.
 */
     public static ListNode mergeLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.val <= b.val) {
            a.next = mergeLists(a.next, b);
            return a;
        } else {
            b.next = mergeLists(a, b.next);
            return b;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
/* question 5
 * Given a linked list and a key to be deleted. Delete last occurrence of key from linked.
 *  The list may have duplicates.
 */
     public static ListNode delete_Last_occurrence(ListNode head, int key) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode lastOccurrenceNode = null;
        ListNode prevLastOccurrenceNode = null;

        while (current != null) {
            if (current.val == key) {
                lastOccurrenceNode = current;
                prevLastOccurrenceNode = prev;
            }
            prev = current;
            current = current.next;
        }

        if (lastOccurrenceNode != null) {
            if (prevLastOccurrenceNode == null) {
                head = head.next;
            } else {
                prevLastOccurrenceNode.next = lastOccurrenceNode.next;
            }

     }

        return head;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 4
Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function)
 in an efficient way. Give the complexity of your algorithm.
 * Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL.
 */
 public static ListNode reverseAlternateKNodes(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        // Reverse the first k nodes
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
   
          count = 0;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        // Recursively reverse the remaining linked list
        if (current != null) {
            current.next = reverseAlternateKNodes(current.next, k);
        }

        return prev;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 3
 * reverse linked list
 */
  public static  ListNode reverseList(ListNode head) {
        
        //Node* reverselin(ListNode* head){
    if (head==null )
    {
        return null;
    }
    ListNode prev=null;  ListNode curr=head;  ListNode forward=head.next;
   while (curr!=null)
   {    
        curr.next=prev; 
                         // increase all three pointer
                     prev=curr;
                      curr=forward;
      if(forward!=null){
          forward=forward.next;
          }
}   return prev;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2
Write a function that takes a list sorted in non-decreasing order and deletes any duplicate nodes from the 
list. The list should only be traversed once.
 * 
 */
    public static ListNode erase_Duplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /* question 1
 Given two linked list of the same size, the task is to create a new linked list using those linked lists. 
 The condition is that the greater node among both linked list will be added to the new linked list.
  * 
  Input: list1 = 5->2->3->8
list2 = 1->7->4->5
Output: New list = 5->7->4->8
  */
    public static ListNode make_newLL(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head, tail;

        if (list1.val >= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return head;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////

public static void display(ListNode head) {
     // Print the new linked list
       ListNode temp=head;
        while (temp != null) {
            
            System.out.print(temp.val+" ");
             temp=temp.next;
        }

        System.out.println();
}

    public static void main(String[] args) {
        
        // for question 1
    // linkedlist 1 created
      ListNode list1 = new ListNode(5);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(8);
     // linkedlist 2 created
         
       ListNode list2 = new ListNode(1);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);
        
        ListNode result_newList = make_newLL(list1, list2);

        // Print the new linked list
        while (result_newList != null) {
            System.out.print(result_newList.val + " ");
            result_newList = result_newList.next;
        }
        System.out.println();
      /////////////////////////////////////////////////////////////////////////////////
         
      //for question 2
         
         ListNode listremove = new ListNode(11);
        listremove.next = new ListNode(11);
        listremove.next.next = new ListNode(11);
        listremove.next.next.next = new ListNode(21);
        listremove.next.next.next.next = new ListNode(43);
        listremove.next.next.next.next.next = new ListNode(43);
        listremove.next.next.next.next.next.next = new ListNode(60);
         
         ListNode resulListNode1=erase_Duplicates(listremove);
           
             display(resulListNode1);

        ////////////////////////////////////////////////////////////////////////////////////////////////
        
        // for question 3
        
        ListNode reverseLL=reverseList(resulListNode1);
            display(reverseLL);

        // for question 4
        
          ListNode revers_alternateLL=reverseAlternateKNodes(resulListNode1, 3);

          display(revers_alternateLL);

        // for question 5
        
        ListNode delate_last_occer=delete_Last_occurrence(revers_alternateLL, 2);
           
        display(delate_last_occer);

        // for question 6
        
        ListNode mergedll=mergeLists(resulListNode1, listremove);
          display(mergedll);

        // for question  7
        
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        ListNode rever_doubly=reverse_doubly(head);
        display(rever_doubly);
         
        // for question 8
  
        ListNode delated_node=deleteNode(head, 2);
        display(delated_node);

        
    }
}
