import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class pwdsa_assignment5 {


/* question 8
 *  Given an array changed, return original if changed is a doubled array. If changed is not a doubled array,
 *  return an empty array. The elements in original may be returned in any order.
 * changed = [1,3,4,2,6,8] Output: [1,3,4]
 */
     public static int[] original_Array(int[] arr) {
        if (arr.length % 2 != 0) {
            return new int[0]; 
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();
        for (int num : arr) {
            if (freq.containsKey(num) && freq.containsKey(num * 2)) {
                l.add(num);
                int new_freq = freq.get(num * 2) - 1;
                if (new_freq == 0) {
                    freq.remove(num * 2);
                } else {
                    freq.put(num * 2, new_freq);
                }
            }
        }

        if (freq.isEmpty()) {
            int[] originalArray = new int[l.size()];
            for (int i = 0; i < l.size(); i++) {
                originalArray[i] = l.get(i);
            }
            return originalArray;
        } else {
            return new int[0]; 
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
/*  question 7
 *  Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, 
 * the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 */
  public static int get_Min_ele(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                
                left = mid + 1;
            } else {
                
                right = mid;
            }
        }

        return arr[left];
    }


////////////////////////////////////////////////////////////////////////////////////

/* question 6
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each
 *  integer appears once or twice, return an array of all the integers that appears twice.
 */
     public static List<Integer> get_Duplicates(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            
            if (arr[index] < 0) {
                result.add(index + 1);
            } else {
                arr[index] = -arr[index];
            }
        }

        return result;
    }
/* question 5
 * Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
 * The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
 */
     public static int Distance(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean valid = true;

            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans++;
            }
        }

        return ans;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

/* question 4
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 *  nums1 = [1,2,3], nums2 = [2,4,6] Output: [[1,3],[4,6]]
 */
       public static List<List<Integer>> Disjoint_Array(int[] arr1, int[] arr2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            set2.add(num);
        }

        List<Integer> distinctArr1 = new ArrayList<>();
        List<Integer> distinctArr2 = new ArrayList<>();

        for (int num : arr1) {
            if (!set2.contains(num)) {
                distinctArr1.add(num);
            }
        }

        for (int num : arr2) {
            if (!set1.contains(num)) {
                distinctArr2.add(num);
            }
        }

        ans.add(distinctArr1);
        ans.add(distinctArr2);

        return ans;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*question 3
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
 sorted in non-decreasing order.
 */
     public static int[] sortedSq(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int sqLeft = arr[left] * arr[left];
            int sqRight = arr[right] * arr[right];

            if (sqLeft > sqRight) {
                result[index] = sqLeft;
                left++;
            } else {
                result[index] = sqRight;
                right--;
            }

            index--;
        }

        return result;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where
 *  the ith row has exactly i coins. The last row of the staircase may be incomplete.
 * Given the integer n, return the number of complete rows of the staircase you will build.
 */
    public static int arrange_Coins(int n) {
    int row = 0;
    while (n >= row + 1) {
        row++;
        n =n- row;
    }
    return row;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 1
You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. 
You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements 
from original.
 * */
  public static int[][] oneDTo2DArray(int[] arr, int m, int n) {
    int[][] result = new int[m][n];
    int size_arr = arr.length;

    if (size_arr != m * n) {
        return new int[0][0];
    }

    for (int i = 0; i < size_arr; i++) {
        int row = i / n;                    // find row & col index by doing divide & modulus by n
        int col = i % n;
        result[row][col] = arr[i];
    }

    return result;
}
//////////////////////////////////////////////////////////////////////////////////////
  public static void display_2darray(int arr[][]){

         for (int i = 0; i < arr.length; i++) {
             for (int j = 0; j < arr[0].length; j++) {
                   System.out.print(arr[i][j]+" ");
             }
             System.out.println();
         }
        System.out.println();   
  }
    public static void main(String[] args) {
        // for question 1
           int arr[]={1,2,3,4};

             int res[][]=oneDTo2DArray(arr, 2, 2);
             display_2darray(res);

          /////////////////////////////////////////////////////////////////  
          System.out.println(arrange_Coins(5));

          // for question 3
           int[] arr2 = {-4, -1, 0, 3, 10};
           int sorted[]=sortedSq(arr2);
           System.out.println(Arrays.toString(sorted));

           // for question 4
              int[] arr3 = {1, 2, 3};
        int[] arr4 = {2, 4, 6};

          List<List<Integer>> disjoint = Disjoint_Array(arr3, arr4);
            System.out.println(disjoint.get(0));
            System.out.println(disjoint.get(1));

            // for question 5
            
            int[] arr5 = {4, 5, 8};
        int[] arr6 = {10, 9, 1, 8};
             System.out.println(Distance(arr5, arr6, 2));

           // for question 6
            
           int[] arr7= {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = get_Duplicates(arr7);
         System.out.println(duplicates);

          // for question 7

           int[] arr8 = {3, 4, 5, 1, 2};
           System.out.println(get_Min_ele(arr8));

           

    }
}
