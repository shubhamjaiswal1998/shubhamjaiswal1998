import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class dsa_assignment10 {

  // question 8
    public static int count_Consonants(String str) {
        str = str.toLowerCase(); 
        return countConsonant(str, 0);
    }
    
    private static int countConsonant(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        
        char ch = str.charAt(index);
        
        if (isConsonant(ch)) {
            return 1 + countConsonant(str, index + 1);
        } else {
            return countConsonant(str, index + 1);
        }
    }
    
    public static boolean isConsonant(char ch) {
        return ch >= 'a' && ch <= 'z' && !isVowel(ch);
    }
    
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

/*
Given a string str, the task is to print all the permutations of str. A permutation is an arrangement 
of all or part of a set of objects, with regard to the order of the arrangement. For instance, 
the words ‘bat’ and ‘tab’ represents two distinct permutation (or arrangements) of a similar three 
letter word.
 * 
 */
    public static void print(String str) {
        List<String> arr = new ArrayList<>();
        permute(str.toCharArray(), 0, arr);
        for (String permutation : arr) {
            System.out.print(permutation + " ");
        }
    }

    public static void permute(char[] str, int index, List<String> permutations) {
        if (index == str.length - 1) {
            permutations.add(String.valueOf(str));
            return;
        }

        Set<Character> seen = new HashSet<>();
        for (int i = index; i < str.length; i++) {
            if (!seen.contains(str[i])) {
                seen.add(str[i]);
                swap(str, index, i);
                permute(str, index + 1, permutations);
                swap(str, index, i);
            }
        }
    }

    public static void swap(char[] strArray, int i, int j) {
        char temp = strArray[i];
        strArray[i] = strArray[j];
        strArray[j] = temp;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 5
 * We are given a string S, we need to find count of all contiguous substrings starting and ending with 
 * same character.
 */
    public static int count_Contiguous_Substrings(String S) {
        int count = 0;
        
        for (int i = 0; i < S.length(); i++) {
            count += expandFromCenter(S, i, i); // odd length substrings
            count += expandFromCenter(S, i, i + 1); // even length substrings
        }
        
        return count;
    }
    
    public static int expandFromCenter(String S, int left, int right) {
        int count = 0;
        
        while (left >= 0 && right < S.length() && S.charAt(left) == S.charAt(right)) {
            count++;
            left--;
            right++;
        }
        
        return count;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////
/* question 4
 *   find length of string
 */
   public static int find_Length(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        
        return 1 + find_Length(str, index + 1);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
/* question 3
 * Given a set represented as a string, write a recursive code to print all subsets of it. The subsets can be printed in any order.
 */
    public static void Subset(String str, String currentSubset, int idx, List<String> subsets) {
        if (idx == str.length()) {
            subsets.add(currentSubset);
            return;
        }
        
        Subset(str, currentSubset, idx + 1, subsets); // Exclude the current character
        Subset(str, currentSubset + str.charAt(idx), idx + 1, subsets); // Include the current character
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////

    /* question 2
     * You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order.
     *  Apply the following algorithm on arr:
     * Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
     * Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from 
     * the remaining numbers.
     * Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
     * Given the integer n, return the last number that remains in arr
     * 
     */
    public static int last_num(int n, boolean bool) {
        if (n == 1) {
            return 1;
        }
        
        if (bool) {
            return 2 * last_num(n / 2, false);
        } else {
            if (n % 2 == 0) {
                return 2 * last_num(n / 2, true) - 1;
            } else {
                return 2 * last_num(n / 2, true);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /*  question 1
     * Given an integer `n`, return *`true` if it is a power of three. Otherwise, return `false`*.
      An integer `n` is a power of three, if there exists an integer `x` such that `n == 3x`.
     */
     public static boolean isPowerOf_3(int n) {
        if (n == 1) {
            return true;
        }
        
        if (n <= 0 || n % 3 != 0) {
            return false;
        }
        
        return isPowerOf_3(n / 3);
    }
    public static void main(String[] args) {
        // for question 1
          System.out.println(isPowerOf_3(27));

        // for question 2
         System.out.println(last_num(9, true));

         // for question 3
         List<String> ans = new ArrayList<>();
         Subset("abc", "", 0, ans);
         System.out.println(ans);

         // for question 4
           System.out.println(find_Length("abc", 0));

            // for question 5
           
            System.out.println(count_Contiguous_Substrings("abc"));

            print("abb");

          System.out.println(count_Consonants("Hello, World!"));

    }
}
