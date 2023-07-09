import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class pwdsa_assignment6 {

/* question 8
 * Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2.
 *  You may assume that multiplication is always possible.
 */
    public static int[][] multiply(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int k = arr1[0].length;
        int n = arr2[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (arr1[i][j] != 0) {
                    for (int l = 0; l < n; l++) {
                        result[i][l] += arr1[i][j] * arr2[j][l];
                    }
                }
            }
        }

        return result;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void display(int arr[][]){

    for (int i = 0; i < arr.length; i++) {
        
        for (int j = 0; j < arr[0].length; j++) {
              System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }


    }
/* question 7
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * 
 */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;

        while (num <= n * n) {
            for (int i = colStart; i <= colEnd; i++)
                matrix[rowStart][i] = num++;
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++)
                matrix[i][colEnd] = num++;
            colEnd--;

            if (rowStart > rowEnd)
                break;

            for (int i = colEnd; i >= colStart; i--)
                matrix[rowEnd][i] = num++;
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--)
                matrix[i][colStart] = num++;
            colStart++;
        }

        return matrix;
    }

/*question 5
The product sum of two equal-length arrays a and b is equal to the sum of a[i] * b[i] for all 0 <= i < a.length 
(0-indexed). 
 * Given two arrays nums1 and nums2 of length n, return the minimum product sum if you are allowed to rearrange
 *  the order of the elements in nums1.
 */
    public static int min_Product_Sum(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int left = 0;
        int right = arr1.length - 1;
        int minProductSum = 0;

        while (left <= right) {
            minProductSum += arr2[left] * arr1[right];
            left++;
            right--;
        }

        return minProductSum;
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////

/* question 4
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
       int nums[]={0,1}
 * o/p 2
 */
    public static int MaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1) ? 1 : -1;

            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }

        return maxLength;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 3
 * Given an array of integers arr, return *true if and only if it is a valid mountain array*.
Recall that arr is a mountain array if and only if:
- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
    - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */
    public static boolean validMountain_Arr(int[] arr) {
        int n = arr.length;
        
        if (n < 3) {
            return false;
        }
        
        int i = 0;
        
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        
        if (i == 0 || i == n - 1) {
            return false;
        }
        
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2
  search key in 2d matrix 
 */
    public static boolean search_key(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;

        int left = 0;
        int right = m * n - 1;  

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arr[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* question 1
     * A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a
     *  string s of length n where:
     * s[i] == 'I' if perm[i] < perm[i + 1], and s[i] == 'D' if perm[i] > perm[i + 1].
     * Given a string s, reconstruct the permutation perm and return it. If there are multiple valid
     *  permutations perm, return any of them.
     */
    public static int[] Permutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        List<Integer> stack = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                stack.add(i + 1);
                while (!stack.isEmpty()) {
                    perm[index++] = stack.remove(stack.size() - 1);
                }
            } else {
                stack.add(i + 1);
            }
        }

        stack.add(n + 1);
        while (!stack.isEmpty()) {
            perm[index++] = stack.remove(stack.size() - 1);
        }

        return perm;
    }

    /////////////////////////////////////////////////////////////////////////////////
     public static void display(int arr[]){
          for (int i : arr) {
            System.out.print(i+" ");
          }
          System.out.println();
     }
     public static void main(String[] args) {
         
        // for question 1
        String s = "IDID";
         int permu[]=Permutation(s);
         System.out.println(Arrays.toString(permu));

             //for question 2
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

         System.out.println(search_key(arr, 5));

         // for question 3
             
         int[] arr2 = {2, 1};
         System.out.println(validMountain_Arr(arr2));

         // for question 4
         
               int arr3[]={0,1};
               System.out.println(MaxLength(arr3));

         // for question 5

         int[] arr4 = {5, 3, 4, 2};
         int[] arr5 = {4, 2, 2, 5};

         min_Product_Sum(arr4, arr5);
         System.out.println(min_Product_Sum(arr4, arr5));

         // for question 6

                  int arr7[][]=generateMatrix(3);
                  display(arr7);

          // for question 8

          int[][] arr8 = {
            {1, 0, 0},
            {-1, 0, 3}
        };

        int[][] arr9 = {
            {7, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        };
            
          int arr10[][]= multiply(arr8, arr9);

          display(arr10);
     }
}
