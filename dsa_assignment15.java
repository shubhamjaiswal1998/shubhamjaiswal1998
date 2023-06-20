import java.util.Stack;
/*question 7

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        dataStack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int popped = dataStack.pop();

        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }
    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////
public class dsa_assignment15 {

/*
 * question 8
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *  compute how much water it can trap after raining.
 * height = [0,1,0,2,1,0,1,3,2,1,2,1] ,o/p -6
 */
    public static int trap(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int L_max = 0;
        int R_max = 0;
        int w = 0;

        while (L <= R) {
            if (height[L] <= height[R]) {
                L_max = Math.max(L_max, height[L]);
                w += L_max - height[L];
                L++;
            } else {
                R_max = Math.max(R_max, height[R]);
                w += R_max - height[R];
                R--;
            }
        }

        return w;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
/*
   question 6

 * Given string S representing a postfix expression, the task is to evaluate the expression and
 *  find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.
 * S = "231*+9-" o/p->4
 */
     public static int Postfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (isOperand(ch)) {
                stack.push(ch - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result;

                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static boolean isOperand(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
/*
 * question 5
 * You are given a string S, the task is to reverse the string using stack.
 * S="GeeksforGeeks"
O/p-> skeeGrofskeeG
 * 
 */
public static String reverse_String(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
/*  question 4
 *  You are given a stack St. You have to reverse the stack using recursion.
 * St = {3,2,1,7,6}
 O/p->{6,7,1,2,3}
 */
 public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return;
        }

        int topElement = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, topElement);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int topElement = stack.pop();
        insertAtBottom(stack, element);
        stack.push(topElement);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2
Given an array a of integers of length n, find the nearest smaller number for every element such that the
 smaller element is on left side.If no small element present on the left print -1.
  n = 3
a = {1, 6, 2}
 * o/p-> -1 1 1
 */
     
  public static int[] Nearest_Smaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(arr[i]);
        }

        return result;
    }
    //////////////////////////////////////////////////////////////////////////////////
/*  question 1
 *  Given an array arr[ ] of size N having elements, the task is to find the next greater element for each 
 * element of the array in order of their appearance in the array.Next greater element of an element in
 *  the array is the nearest element on the right which is greater than the current element.If there does 
 * not exist next greater of current element, then next greater element for current element is -1. 
 * For example, next greater of the last element is always -1.
 * 
 * N = 4, arr[] = [1 3 2 4]
 *    o/p -> 3 4 4 -1
 */
    public static int[] NextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = arr[stack.peek()];
            } else {
                result[i] = -1;
            }

            stack.push(i);
        }

        return result;
    }
    public static void main(String[] args) {
        // for question 1
        int[] arr = {4, 5, 2, 25};
        int[] result = NextGreater(arr);
          for (int i : result) {
             System.out.print(" "+i);
          }
          System.out.println();
       // for question 2
       int[] arr1 = {1, 6, 4, 10, 2, 5};
        int[] result1 = Nearest_Smaller(arr1);

        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
                System.out.println();
         // for question 4

             Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(6);

        reverseStack(stack);
         System.out.println("reversed Stack: " + stack);
        // for question 5
             String str = "GeeksforGeeks";
             System.out.println(reverse_String(str));

        // for question 6
   
        String postfix = "231*+9-";
        System.out.println(Postfix(postfix));

        // for question 7

        MinStack stack1 = new MinStack();
        stack1.push(5);
        stack1.push(2);
        stack1.push(7);
        stack1.push(1);

        System.out.println("Top element " + stack1.top()); 
        System.out.println("Minimum element " + stack1.getMin()); 
       stack.pop();
       System.out.println("Top element " + stack1.top());
        
       // for question 8

           int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

           System.out.println("trapped water "+trap(height) );

    }
}
