import java.util.*;

public class dsa_assignment4 {
    /*
     * Given the array nums consisting of 2n elements in the form
     * [x1,x2,...,xn,y1,y2,...,yn]. 
     * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     nums = [2,5,1,3,4,7], n = 3  ,Output: [2,3,5,4,1,7]
     * Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is
     * [2,3,5,4,1,7].
     */
    public static int[] arry_shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            result[idx++] = nums[i];
            result[idx++] = nums[i + n];
        }

        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 6
     * Given an integer array nums sorted in non-decreasing order, return an array
     * of the squares of each number sorted in non-decreasing order.
     * 
     */
    public static int[] sorted_sq(int[] nums) {
        int[] squarednums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squarednums[i] = nums[i] * nums[i];
        }

        Arrays.sort(squarednums);

        return squarednums;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 5
     * 💡 You have n coins and you want to build a staircase with these coins. The
     * staircase consists of k
     * rows where the ith row has exactly i coins. The last row of the staircase
     * **may be** incomplete.
     * 
     * Given the integer n, return *the number of **complete rows** of the staircase
     * you will build
     */
    public static int total_Complete_Rows(int n) {
        int k = 1;
        while (k * (k + 1) / 2 <= n) {
            k++;
        }
        return k - 1;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 4
     * Given an integer array nums of 2n integers, group these integers into n pairs
     * (a1, b1), (a2, b2), ..., (an, bn)
     * such that the sum of min(ai, bi) for all i is maximized. Return the maximized
     * sum.
     * 
     * 
     */
    public static int pair_sum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }

        return maxSum;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 3
     * Given a 2D integer array matrix, return the transpose of matrix.
     * 
     */
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] transposeMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        return transposeMatrix;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 2
     * nums1 = [1,2,3], nums2 = [2,4,6]
     ** 
     * Output: [[1,3],[4,6]]
     * 
     * return *a list* answer *of size* 2 *where:*
     * 
     * answer[0] *is a list of all **distinct integers in nums1 which are
     * not* present in* nums2*.*
     * answer[1] *is a list of all distinct integers in nums2 which are
     * not** present in* nums1.
     * 
     */
    public static List<List<Integer>> disjoint_array(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : nums1) {
            if (!contains(nums2, num)) {
                list1.add(num);
            }
        }

        for (int num : nums2) {
            if (!contains(nums1, num)) {
                list2.add(num);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        return answer;
    }

    public static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // question 1
    /*
     * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
     * Output: [1,5]
     */
    public static List<Integer> Common_Elements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // for question 1
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 5, 7, 9 };
        int[] arr3 = { 1, 3, 4, 5, 8 };

        List<Integer> commonElements = Common_Elements(arr1, arr2, arr3);
        System.out.println(commonElements);

        // for question 2
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 4, 6 };

        List<List<Integer>> result = disjoint_array(nums1, nums2);
        System.out.println(result);

        // for question 3
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] transposeMatrix = transpose(matrix);

        // Print the transpose matrix
        for (int i = 0; i < transposeMatrix.length; i++) {
            for (int j = 0; j < transposeMatrix[0].length; j++) {
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }
        // for question 4
        int[] nums = { 1, 4, 3, 2 };
        int maxSum = pair_sum(nums);
        System.out.println("Maximized sum: " + maxSum);

        // for question 5
        System.out.println(total_Complete_Rows(5));

        // for question 6
        int[] num = { -4, -1, 0, 3, 10 };
        int[] result1 = sorted_sq(num);

        System.out.println(Arrays.toString(result1));
        // for question 7

        int[] nums3 = {2, 5, 1, 3, 4, 7};
        int n = 3;
        //
        int[] result2 = arry_shuffle(nums3, n);
        
        System.out.println(Arrays.toString(result2));

    }
}
