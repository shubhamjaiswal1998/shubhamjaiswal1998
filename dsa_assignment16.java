import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class dsa_assignment16 {




public static Queue<Integer> reverseK_ele(Queue<Integer> queue, int k) {
        if (k <= 0 || k > queue.size()) {
            return queue;
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Enqueue the first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Dequeue the next element and enqueue it back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step 3: Move the remaining (size - k) elements to the back of the queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.offer(queue.poll());
        }

        return queue;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    /*
     * question 
     * Given a number , write a program to reverse this number using stack.
     */

 public static int reverseNumber(int number) {
        Stack<Integer> stack = new Stack<>();
        
        // Push each digit onto the stack
        while (number > 0) {
            int digit = number % 10;
            stack.push(digit);
            number /= 10;
        }
        
        int revnum = 0;
        int dec_num = 1;
        
        // Pop each digit from the stack to form the reversed number
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            revnum += digit * dec_num;
            dec_num *= 10;
        }
        
        return revnum;
    }

    /* question 4
    Given a Queue consisting of first n natural numbers (in random order). The task is to check
     whether the given Queue elements can be arranged in increasing order in another Queue using
      a stack. The operation allowed are:
      Queue[] = { 5, 1, 2, 3, 4 } 
     * 
     */
public static String Order_checking(Queue<Integer> q1) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> sortq = new LinkedList<>();
        int expectedElement = 1;
        
        while (!q1.isEmpty()) {
            if (q1.peek() == expectedElement) {
                sortq.add(q1.poll());
                expectedElement++;
            } else if (!stack.isEmpty() && stack.peek() == expectedElement) {
                sortq.add(stack.pop());
                expectedElement++;
            } else {
                stack.push(q1.poll());
            }
        }
        
        while (!stack.isEmpty() && !q1.isEmpty()) {
            if (q1.peek() == expectedElement) {
                sortq.add(q1.poll());
                expectedElement++;
            } else if (stack.peek() == expectedElement) {
                sortq.add(stack.pop());
                expectedElement++;
            } else {
                break;
            }
        }
        
        if (q1.isEmpty() && stack.isEmpty()) {
            for (int i = 1; i <= sortq.size(); i++) {
                if (!sortq.contains(i)) {
                    return "No";
                }
            }
            return "Yes";
        }
        
        return "No";
    }
    

/* question 3
 * Given a stack with push(), pop(), and empty() operations, The task is to delete the middle element of
 *  it without using any additional data structure.
 */
    public static void delete_Mid(Stack<Integer> stack, int mid, int currentIndex) {
        if (stack.isEmpty() || currentIndex > mid) {
            return;
        }
        
        if (currentIndex == mid) {
            stack.pop();
            return;
        }
        
        int temp = stack.pop();
        delete_Mid(stack, mid, currentIndex + 1);
        stack.push(temp);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*question 2
     * Given an array, for each element find the value of the nearest element to the right which is
     *  having a frequency greater than that of the current element. If there does not exist an answer for a
     *  position, then make the value ‘-1’.
     * Input: a[] = [1, 1, 2, 3, 4, 2, 1]
       Output : [-1, -1, 1, 2, 2, 1, -1]

     */
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void sorting_stack(Stack<Integer> Stack) {
        Stack<Integer> tempStack = new Stack<>();
        
        while (!Stack.isEmpty()) {
            int temp = Stack.pop();
            
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                Stack.push(tempStack.pop());
            }
            
            tempStack.push(temp);
        }
        
        Stack<Integer> sortedStack = new Stack<>();
        while (!tempStack.isEmpty()) {
            sortedStack.push(tempStack.pop());
        }
        
        
        while (!sortedStack.isEmpty()) {
            Stack.push(sortedStack.pop());
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 1
Given an array, for each element find the value of the nearest element to the right which is having a 
frequency greater than that of the current element. If there does not exist an answer for a position, 
then make the value ‘-1’.
 *  Input: a[] = [1, 1, 2, 3, 4, 2, 1]
Output : [-1, -1, 1, 2, 2, 1, -1]
 */
  public static int[] Nearest_Greater_Freq(int[] arr) {
         Map<Integer, Integer> frequency = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

            stack.push(num);

            while (!stack.isEmpty() && frequency.get(num) >= frequency.get(stack.peek())) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
        }

        return result;
    }
      public static void main(String[] args) {
        
           //////////////////////////////////////////////////////////////////////
           int[] arr = {1, 1, 2, 3, 4, 2, 1};
        int[] result = Nearest_Greater_Freq(arr);
        System.out.println(Arrays.toString(result));
///////////////////////////////////////////////////////////////////////////////
         // question 2     
       Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(2);
        st.push(9);
        st.push(1);
        st.push(7);
        sorting_stack(st);
        System.out.println(st);

///////////////////////////////////////////////////////////////////////////////////////////

    Queue<Integer> q1 = new LinkedList<>();
        q1.add(5);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
              Order_checking(q1);

        /////////////////////////////////////////////////////////////////////////





      }
}
