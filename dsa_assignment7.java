

public class dsa_assignment7 {

/*
 * Given two strings s and goal, return true if and only if s can become goal after some number
 *  of shifts on s. A shift on s consists of moving the leftmost character of s to the rightmost position.
 * s = "abcde", goal = "cdeab"
 */
    public static boolean do_Shift(String s, String target) {
        if (s.length() != target.length()) {
            return false;
        }

        String temp = s + s;
        return temp.contains(target);
    }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////  
/* question5
 * Given a string s and an integer k, reverse the first k characters for every 2k
 *  characters counting from the start of the string.
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and leave the other as original.
 * s = "abcdefg", k = 2
 * o/p=>"bacdfeg"
 */
    public static String reverse_String(String str, int k) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 4
Given a string s, reverse the order of characters in each word within a sentence while 
still preserving whitespace and initial word order.
 * s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 */
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            result.append(reverse(word)).append(" ");
        }
        
        return result.toString().trim();
    }
    
    public static String reverse(String word) {
        char[] chars = word.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }


   /// ////////////////////////////////////////////////////////////////////////////////////////////////////

/* question 3
 * Given two non-negative integers, num1 and num2 represented as string,
 *  return the sum of num1 and num2 as a string.
 * num1 = "11", num2 = "123"
 * "134"
 */
    public static String add_strings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int x, y;
            if (i >= 0) {
                x = num1.charAt(i) - '0';
            } else {
                x = 0;
            }
            
            if (j >= 0) {
                y = num2.charAt(j) - '0';
            } else {
                y = 0;
            }
            
            int temp = x + y + carry;
            result.append(temp % 10);
            carry = temp / 10;
            i--;
            j--;
        }
        
        if (carry > 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }

/*
 * question 2
 * Given a string num which represents an integer, return true *if* num *is a **strobogrammatic number
  strobogrammatic number** is a number that looks the same when rotated 180 degrees (looked at upside down)
 */

    public static boolean check_Strobogrammatic(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            char c1 = str.charAt(left);
            char c2 = str.charAt(right);

            if (!check_Strobogrammatic_Pair(c1, c2)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean check_Strobogrammatic_Pair(char c1, char c2) {
        switch (c1) {
            case '0':
                return c2 == '0';
            case '1':
                return c2 == '1';
            case '6':
                return c2 == '9';
            case '8':
                return c2 == '8';
            case '9':
                return c2 == '6';
            default:
                return false;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
/* Question 1
    Given two strings s and t, *determine if they are isomorphic*.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of 
characters. No two characters may map to the same character, but a character may map to itself.
 s = "egg", t = "add"
     */
    public static boolean check_isomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] s_Char = new char[256];
        char[] t_Char = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (s_Char[c1] != 0) {
                if (s_Char[c1] != c2) {
                    return false;
                }
            } else {
                if (t_Char[c2] != 0) {
                    return false;
                }
                s_Char[c1] = c2;
                t_Char[c2] = c1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // for question 1
        String s = "egg";
        String t = "add";

        boolean isomorphic = check_isomorphic(s, t);
        System.out.println(isomorphic);

        //for question 2
        String str = "69";
          boolean Strobogrammatic = check_Strobogrammatic(str);
        System.out.println(Strobogrammatic);
      
        // for question 3
        String num1 = "11";
        String num2 = "123";
        System.out.println(add_strings(num1, num2));  // Output: "134"

        // for question 4
        String s1 = "Let's take LeetCode contest";
        System.out.println(reverseWords(s1));

        // for question 5

        String s2 = "abcde";
        String target = "cdeab";
        boolean result = do_Shift(s2, target);
        System.out.println(result); 

        //   for question 6


    }
}
 
