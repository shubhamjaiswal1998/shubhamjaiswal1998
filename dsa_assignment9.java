import java.util.*;
public class dsa_assignment9 {

    public static int compute_allProduct(int[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        return arr[index] * compute_allProduct(arr, index + 1);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 7
 * Given a string S="ABC", the task is to write a program to print all permutations of a given string.
 * “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”
 */
public static void print_list(List<String> arr) {
    for (String ele : arr) {
        System.out.println(ele);
    }
    System.out.println();
}
public static List<String> all_Permutations(String s) {
        List<String> result = new ArrayList<>();
        Do(s.toCharArray(), 0, result);
        return result;
    }

    public static void Do(char[] s, int index, List<String> result) {
        if (index == s.length - 1) {
            result.add(String.valueOf(s));
        } else {
            for (int i = index; i < s.length; i++) {
                swap(s, index, i);
                Do(s, index + 1, result);
                swap(s, index, i); 
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 6
 * Given first term (a), common difference (d) and a integer N of the Arithmetic Progression
 *  series, the task is to find Nth term of the series.
 */
    public static int NthTerm(int first_term, int d, int term) {
        if (term == 1) {
            return first_term;
        } else {
            return NthTerm(first_term + d, d, term - 1);// in AP a , a+d ,a+2d
                                                  // each time  common diff will be add          
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////
/* question 5
 * Given an array of integers arr, the task is to find maximum element of that array using recursion.
 */
    public static int Max_ele(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        } else {
            int currentElement = arr[index];
            int Rest_ele = Max_ele(arr, index + 1);
            return Math.max(currentElement, Rest_ele);
        }
    }

  //////////////////////////////////////////////////////////////////////////////////////////////////  
/* question 4
 *  Given a number N and a power P, the task is to find the exponent of 
 * this number raised to the given power, i.e. N^P.
 * time complexity o(power) and space complexity also same
 */
public static int find_power_exponent(int num, int power) {
      if (power==0) {
        return 1;
      }
       else {
          return num*find_power_exponent(num, power-1);
      }
}

/////////////////////////////////////////////////////////////////////////////////////////////////
/*  question 3
 *    find factorial
 */
   public static int factorial(int n) {
         if (n==0 || n==1) {
            return 1;
         } 
         else {
             return n*factorial(n-1);
         }
   }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2
* Given a number n, find the sum of the first natural numbers.
 */
    public static int sumof_natural(int n) {
          
        if (n == 1) {
            return 1;
        } else {
            return n + sumof_natural(n - 1);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 1
Given an integer `n`, return *`true` if it is a power of two. Otherwise, return `false`*.
An integer `n` is a power of two, if there exists an integer `x` such that `n == 2x`.
 *  
 */
    public static boolean check_powertwo(int n) {

        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {  // if rem is not 0 that means not divisible by 2
            return false;
        }
        return check_powertwo(n / 2);
    }

    public static void main(String[] args) {
         // for question 1
        
        System.out.println(check_powertwo(15));

        // for question 2
        int n = 5;
        int sum = sumof_natural(n);
        System.out.println("Sum of the first " + n + " natural numbers is " + sum);

        // for question 3

            System.out.println(factorial(n));

       // for question 4
         System.out.println(find_power_exponent(8, 3));   
         
         // for question 5
         int[] arr = {1, 4, 3, -5, -4, 8, 6};  int index=0;
         System.out.println(Max_ele(arr, index));

         // for question 6
         int a = 2; // First term
         int d = 1; // Common difference
         int N = 5; // Nth term
         
         int nthTerm = NthTerm(a, d, N);
         System.out.println("The " + N + "th term of the series is: " + nthTerm);

         // for question 7
         String string = "ABC";
         List<String> permutations =all_Permutations(string);
        print_list(permutations);

        // for question 8
          int arr1[]={1, 2, 3, 4, 5};
          System.out.println(compute_allProduct(arr1, 0));
    }
}
