import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class pwdsa_assignment2 {

/*
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise
 */
     public static boolean isMonotonic(int[] arr) {
        boolean increase = true;
        boolean decrease = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                increase = false;
            }
            if (arr[i] < arr[i-1]) {
                decrease = false;
            }
            if (!increase && !decrease) {
                return false;
            }
        }

        return true;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
/*  question 6
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise,
return -1
 */
    public  static int search_binary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
/* question 5
 *  find max product 
 */
      public static int max_Product(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int maxPro1 = arr[length - 1] * arr[length - 2] * arr[length - 3];
        int maxPro2 = arr[0] * arr[1] * arr[length - 1];
        return Math.max(maxPro1, maxPro2);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 4
You have a long flowerbed in which some of the plots are planted, and some are not.
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, 
and an integer n, return true if n new flowers can be planted in the flowerbed without violating the
 no-adjacent-flowers rule and false otherwise.

 */
    public  static boolean doPlace_flower(int[] arr, int n) {
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && (i == 0 || arr[i - 1] == 0) && (i == arr.length - 1 || arr[i + 1] == 0)) {
                arr[i] = 1;
    
                n--;
            }
        }
        if (n <= 0) {
            return true;
        } else {
            return false;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////

/* question 3
 * We define a harmonious array as an array where the difference between its maximum value
and its minimum value is exactly 1.
Given an integer array nums, return the length of its longest harmonious subsequence
among all its possible subsequences.
A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

 */
    public static int find_LHS(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                int currLen = countMap.get(key) + countMap.get(key + 1);
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2

 * Given the integer array candyType of length n, return the maximum number of different types of 
 * candies she can eat if she only eats n / 2 of them.
 * 
 */
public static int distribute_Candies(int[] arr) {
          int size=arr.length;
        HashSet<Integer> unique_Candies = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            unique_Candies.add(arr[i]);
        }
        return Math.min(unique_Candies.size(), size / 2);
    }

/////////////////////////////////////////////////////////////////////////////////
/* question 1
  Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), 
  (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized 
  sum.
 * 
 */

 public  static int pair_Sum(int[] arr) {
        Arrays.sort(arr);
        int sumMin = 0;
        for (int i = 0; i < arr.length; i=i+ 2) {
            sumMin = sumMin+arr[i];
        }
        return sumMin;
    }

    /////////////////////////////////////////////////////////////////////////
        public static int minimum_Score(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        if (minVal + k <= maxVal - k) {
            return maxVal - k - (minVal + k);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        // for question 1

            int[] arr1 = {1, 4, 3, 2};
            System.out.println(pair_Sum(arr1));

         // for question 2
           int[] arr2 = {1, 1, 2, 2, 3, 3};
           System.out.println(distribute_Candies(arr2));
        // for question 3
            int arr3[]={1,3,2,2,5,2,3,7};
            System.out.println(find_LHS(arr3));

        // for question 4
          int arr4[]={1, 0, 0, 0, 1};
             System.out.println(doPlace_flower(arr4, 1));

        // for question 5
              int[] arr5 = {1, 2, 3};
             System.out.println(max_Product(arr5));
         
         // for question 6
            
            int[] arr6 = {-1, 0, 3, 5, 9, 12};
            System.out.println(search_binary(arr6, 9));

         // for question 7
              
         int[] arr7 = {1, 2, 2, 3};
           System.out.println(isMonotonic(arr7));

          // for question 8

           int arr8[]={1};
           System.out.println(minimum_Score(arr8, 0));


    }
}
