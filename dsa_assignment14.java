import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class dsa_assignment14 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode random;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
            this.random=null;

        }
    }
/*Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until 
there are no such sequences.
 * After doing so, return the head of the final linked list. 
 */
       public static ListNode erase_0_SumSublists(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;
        ListNode current = temp;

        while (current != null) {
            prefixSum += current.val;

            if (map.containsKey(prefixSum)) {
                ListNode start = map.get(prefixSum).next;
                int sum = prefixSum + start.val;

                while (start != current) {
                    map.remove(sum);
                    start = start.next;
                    sum += start.val;
                }

                map.get(prefixSum).next = current.next;
            } else {
                map.put(prefixSum, current);
            }

            current = current.next;
        }

        return temp.next;
    }
/* You are given the head of a linked list with n nodes.
 * For each node in the list, find the value of the next greater node. That is, for each node, 
 * find the value of the first node that is next to it and has a strictly larger value than it.
 * Return an integer array answer where answer[i] is the value of the next greater node of the ith
 *  node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
 */
 public static int[] next_Larg_Nodes(ListNode head) {
        if (head == null)
            return new int[0];

        List<Integer> list = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            int currentValue = list.get(i);

            while (!stack.isEmpty() && stack.peek() <= currentValue) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            stack.push(currentValue);
        }

        return result;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
/*question 5
 Given the `head` of a singly linked list, group all the nodes with odd indices together followed by the 
 nodes with even indices, and return *the reordered list
*/
     public static ListNode odd_even_List(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddH = head;
        ListNode evenH = head.next;
        ListNode odd = oddH;
        ListNode even = evenH;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenH;
        return oddH;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////

/* question 4
 * Construct a copy of the given list. The copy should consist of exactly N new nodes, where each new node has
 *  its value set to the value of its corresponding original node. Both the next and random pointer of the new 
 * nodes should point to new nodes in the copied list such that the pointers in the original list and copied
 *  list represent the same list state. None of the pointers in the new list should point to nodes in the
 *  original list.
 */
public static ListNode copy_RandomList(ListNode head) {
        if (head == null)
            return null;

        Map<ListNode, ListNode> nodeMap = new HashMap<>();
     ListNode current = head;
        while (current != null) {
            nodeMap.put(current, new ListNode(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            ListNode copyNode = nodeMap.get(current);
            copyNode.next = nodeMap.get(current.next);
            copyNode.random = nodeMap.get(current.random);
            current = current.next;
        }

        return nodeMap.get(head);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
 /* question 3
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:(i) 
a next pointer to the next node,(ii) a bottom pointer to a linked list where this node is head.Each of the 
sub-linked-list is in sorted order.Flatten the Link List such that all the nodes appear in a single level
 while maintaining the sorted order. Note: The flattened list will be printed using the bottom pointer 
 instead of next pointer.
  */ 
   public static ListNode flattenLL(ListNode head) {
        if (head == null || head.next == null)
            return head;
   head.next = flattenLL(head.next);

        head = mergeLists(head, head.next);

        return head;
    }  
 public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode result;
        if (list1.val <= list2.val) {
            result = list1;
            result.prev = mergeLists(list1.prev, list2);
        } else {
            result = list2;
            result.prev = mergeLists(list1, list2.prev);
        }

        result.next = null;
        return result;
    }
   
    ///////////////////////////////////////////////////////////////////////////////////
/* question 2
   A number N is represented in Linked List such that each digit corresponds to a node in linked list. 
   You need to add 1 to it.
 * LinkedList: 4->5->6
 Output:457
*/
 public static ListNode add_One(ListNode head) {
        if (head == null)
            return new ListNode(1); // If the list is empty, return a new node with value 1

        ListNode lastNonNine = null;
        ListNode current = head;

        while (current != null) {
            if (current.val != 9) {
                lastNonNine = current;
            }
            current = current.next;
        }

        if (lastNonNine != null) {
            lastNonNine.val++;
            current = lastNonNine.next;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
            current = head.next;
        }
    
           while (current != null) {
            current.val = 0;
            current = current.next;
        }

        return head;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 1
   Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the 
   loop.
 * 
 */
    public static ListNode removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No loop present
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return head;
        }

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
        return head;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void display(ListNode head) {

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        // for question 1
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        display(head);

        node5.next = node3;
        ListNode removed_LL = removeLoop(head);
        display(removed_LL);
    ////////////////////////////////////////////////////////////////////////////////////////////////
       
    ListNode added_LL=add_One(head);

       display(added_LL);

       
       
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode odd_evenll=odd_even_List(head1);
          display(odd_evenll);

       //////////////////////////////////////////////////////////////////////////////////////////////
       
       ListNode delatedll=erase_0_SumSublists(head1);
        
             display(delatedll);
       

    }
}
