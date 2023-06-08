
import java.util.*;
public class prac11 {
/*
 * Given two strings s and goal, return true if you can swap two letters in s so the result is
 *  equal to goal, otherwise, return false.
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and 
 * swapping the characters at s[i] and s[j].
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 *  s = "ab", goal = "ba"  ,output -> true
 * 
 */
  public static boolean doSwap(String s, String goal) {
    int count = 0;
    int fst_index = -1;
    int sec_index = -1;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != goal.charAt(i)) {
            count++;
            if (fst_index == -1) {
                fst_index = i;
            } else {
                sec_index = i;
            }
        }
    }

    if (count != 2) {
        return false;
    }

    char[] sChars = s.toCharArray();
    char temp = sChars[fst_index];
    sChars[fst_index] = sChars[sec_index];
    sChars[sec_index] = temp;

    return new String(sChars).equals(goal);
}


/*
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
 * Note that k is guaranteed to be a positive integer.
 * s = "3[a]2[bc]" output-> "aaabcbc"
 */
  public static String decodeString(String s) {
  StringBuilder str = new StringBuilder();
  int count = 0;

  for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
          count = count * 10 + (ch - '0');
      } else if (ch == '[') {
          StringBuilder temp = new StringBuilder();
          int repeatCount = count;
          count = 0;
          while (repeatCount > 0) {
              temp.append(str);
              repeatCount--;
          }
          str = temp;
      } else if (ch == ']') {
          return str.toString();
      } else {
          str.append(ch);
      }
  }

  return str.toString();
  }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 *  You may return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 *  typically using all the original letters exactly once.
 * s = "cbaebabacd", p = "a , output -[0,6]
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    int[] pFreq = new int[26];
    int[] windowFreq = new int[26];
    int left = 0, right = 0;

    for (char ch : p.toCharArray()) {
        pFreq[ch - 'a']++;
    }

    while (right < s.length()) {
        char ch = s.charAt(right);
        windowFreq[ch - 'a']++;

        if (right - left + 1 == p.length()) {
            if (matches(pFreq, windowFreq)) {
                result.add(left);
            }

            char leftChar = s.charAt(left);
            windowFreq[leftChar - 'a']--;
            left++;
        }

        right++;
    }

    return result;
}

private static boolean matches(int[] pFreq, int[] windowFreq) {
    for (int i = 0; i < 26; i++) {
        if (pFreq[i] != windowFreq[i]) {
            return false;
        }
    }
    return true;
}
/*  question 
 * chars = ["a","a","b","b","c","c","c"]
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 */
  public static int compress_char(char[] chars) {
    int n = chars.length;
    int index = 0;
    int count = 1;

    for (int i = 1; i <= n; i++) {
        if (i < n && chars[i] == chars[i - 1]) {
            count++;
        } else {
            chars[index++] = chars[i - 1];
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
            count = 1;
        }
    }

    return index;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*question 3
 * Given two strings word1 and word2, return the minimum number of steps 
 * required to make word1 and word2 the same.
 * In one step, you can delete exactly one character in either string
 * word1 = "sea", word2 = "eat"
 * Output: 2
 */
public static int minSteps(String str1, String str2) {
    int[][] memo = new int[str1.length() + 1][str2.length() + 1];
    return minStepsRecursive(str1, str2, 0, 0, memo);
}

private static int minStepsRecursive(String str1, String str2, int i, int j, int[][] memo) {
    if (memo[i][j] != 0) {
        return memo[i][j];
    }

    if (i == str1.length()) {
        memo[i][j] = str2.length() - j;
        return memo[i][j];
    }
    if (j == str2.length()) {
        memo[i][j] = str1.length() - i;
        return memo[i][j];
    }

    if (str1.charAt(i) == str2.charAt(j)) {
        int result = minStepsRecursive(str1, str2, i + 1, j + 1, memo);
        memo[i][j] = result;
        return result;
    }

    int deleteFromStr1 = minStepsRecursive(str1, str2, i + 1, j, memo);
    int deleteFromStr2 = minStepsRecursive(str1, str2, i, j + 1, memo);
    int result = Math.min(deleteFromStr1, deleteFromStr2) + 1;
    memo[i][j] = result;
    return result;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis
 *  '(' or an empty string "".
 *  s = "()" ,o/p -true
 * 
 */
public static boolean isValid(String s) {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> star_Stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == '(') {
            stack.push(i);
        } else if (c == '*') {
            star_Stack.push(i);
        } else {
            if (!stack.isEmpty()) {
                stack.pop();
            } else if (!star_Stack.isEmpty()) {
                star_Stack.pop();
            } else {
                return false;
            }
        }
    }
    while (!stack.isEmpty() && !star_Stack.isEmpty()) {
      if (stack.pop() > star_Stack.pop()) {
          return false;
      }
  }

  return stack.isEmpty();
}


  /////////////////////////////////////////////////////////////////////////////////////////////////////////
/*question 1
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 * s1 = "sea", s2 = "eat", o/p=231
 * 
 */
  public static int minimum_delete_sum(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    
    // Create a 2D array to store the minimum ASCII sum of deleted characters
    int[][] table = new int[m + 1][n + 1];
    
    // Initialize the first row and column of the table
    for (int i = 1; i <= m; i++) {
        table[i][0] = table[i - 1][0] + s1.charAt(i - 1);
    }
    for (int j = 1; j <= n; j++) {
        table[0][j] = table[0][j - 1] + s2.charAt(j - 1);
    }
    
    // Fill in the rest of the table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                table[i][j] = table[i - 1][j - 1];
            } else {
                table[i][j] = Math.min(table[i - 1][j] + s1.charAt(i - 1), table[i][j - 1] + s2.charAt(j - 1));
            }
        
    }
  }

   // Return the minimum ASCII sum of deleted characters
   return table[m][n];
}
  public static void main(String[] args) {
    // for question 1
    String s1 = "sea";
    String s2 = "eat";
    int result = minimum_delete_sum(s1, s2);
    System.out.println(result);
     
   //for question 2
   String s = "()";
   boolean res = isValid(s);
   System.out.println(res);
     
   //for question 3 
   String str1 = "sea";
        String str2 = "eat";
        int minSteps = minSteps(str1, str2);
        System.out.println("Minimum number of steps: " + minSteps);

     // for question 4

     char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
     int l = compress_char(chars);

     System.out.println("New length: " + l);
     System.out.print("Modified array: ");
     for (int i = 0; i < l; i++) {
         System.out.print(chars[i] + " ");
     }

    ////////////////////////////////////////////////////////////////////////////////////////////

    String string = "cbaebabacd";
        String p = "abc";
        List<Integer> indices = findAnagrams(string, p);
        System.out.println(indices);
///////////////////////////////////////////////////////////////////////////////////////////////////
       
String deocdestr = "3[a]2[bc]";
System.out.println(decodeString(deocdestr));
//////////////////////////////////////////////////////////////////////
String swaped_str = "ab";
        String goal = "ba";
        System.out.println(doSwap(swaped_str, goal));  
    
  }

}
