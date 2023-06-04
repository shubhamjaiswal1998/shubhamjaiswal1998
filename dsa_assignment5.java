import java.util.*;

public class dsa_assignment5 {

    public static int Min_element(int[] arr) {
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
///////////////////////////////////////////////////////////////////////////////////////////////////////
 /* question 6
 Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each
  integer appears once or twice, return an array of all the integers that appears twice.
   nums = [4,3,2,7,8,2,3,1] , o/p={2,3}
  * 
  */
    public static List<Integer> duplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                duplicates.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        return duplicates;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 5
  Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
  The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] 
  where |arr1[i]-arr2[j]| <= d.
  arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2

**Output:** 2

 */
    public static int distance(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        for (int num1 : arr1) {
            boolean isValid = true;

            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                distance++;
            }
        }

        return distance;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 4
     * Given two **0-indexed** integer arrays nums1 and nums2, return *a list*
     * answer *of size* 2 *where:*
     * answer[0] *is a list of all **distinct** integers in* nums1 *which are
     * **not** present in* nums2*.*
     * - answer[1] *is a list of all **distinct** integers in* nums2 *which are
     * **not** present in* nums1.
     * nums1 = [1,2,3], nums2 = [2,4,6]; o/p:** [[1,3],[4,6]]
     */
    public static List<List<Integer>> Missing_ele(int[] arr1, int[] arr2) {
        List<Integer> distinctNums1 = new ArrayList<>();
        List<Integer> distinctNums2 = new ArrayList<>();

        for (int num : arr1) {
            if (!contains(arr2, num)) {
                distinctNums1.add(num);
            }
        }

        for (int num : arr2) {
            if (!contains(arr1, num)) {
                distinctNums2.add(num);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(distinctNums1);
        answer.add(distinctNums2);

        return answer;
    }

    public static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 3
     * Given an integer array nums sorted in **non-decreasing** order, return *an
     * array of **the squares of
     * each number** sorted in non-decreasing order*.
     * nums = [-4,-1,0,3,10]
     * Output:** [0,1,9,16,100]
     */
    public static int[] Sq_sorted(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[idx] = leftSquare;
                left++;
            } else {
                result[idx] = rightSquare;
                right--;
            }

            idx--;
        }

        return result;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 2
     * You have n coins and you want to build a staircase with these coins. The
     * staircase consists of k rows where
     * the ith row has exactly i coins. The last row of the staircase **may be**
     * incomplete.
     * Given the integer n, return *the number of **complete rows** of the staircase
     * you will build*.
     */
    public static int count_total_Rows(int n) {
        int count = 0;
        int row = 1;

        while (n >= row) {
            n -= row;
            count++;
            row++;
        }

        return count;
    }

    /////////////////////////////////////////////////////////////////////////
    // question1
    // Convert 1D Array Into 2D Array
    public static int[][] one_dTo2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];

        if (original.length != m * n) {
            return new int[0][0]; // Return empty 2D array if impossible
        }

        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index++];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // for question 1
        int[] original = { 1, 2, 3, 4, 5, 6 }; // Example 1D array
        int m = 2; // Number of rows
        int n = 3; // Number of columns

        int[][] ans = one_dTo2DArray(original, m, n);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        // for question 2
        int n1 = 10;
        int completeRows = count_total_Rows(n1);
        System.out.println("Number of complete rows: " + completeRows);

        // for question 3
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] arr2 = Sq_sorted(nums);

        System.out.println("Sorted squares: " + Arrays.toString(arr2));

        // for question 4

        int[] arr1 = {1, 2, 3};
         int[] arr3 = {2, 4, 6};

    List<List<Integer>> res = Missing_ele(arr1, arr3);
    System.out.println(res);

      // for question 5

      int[] arr4 = {4, 5, 8};
    int[] arr5 = {10, 9, 1, 8};
    int d = 2;

int dist =distance(arr4, arr5, d);

    System.out.println(dist);

    // for question 6
    int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
   List<Integer> duplicates = duplicates(arr);

    System.out.println(duplicates);
   
    int[] ar8 = {3, 4, 5, 1, 2};
        System.out.println(Min_element(ar8));


    }
}
