import java.util.Arrays;

public class dsa_assignment1 {

    
        
   
    
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 7.Given an integer array nums, move all 0's to the end of it while maintaining
     * the relative order of the
     * nonzero elements.
     * 
     */
    public static void move_zeroes(int[] arr) {
        int index = 0; // variable to keep track of the current index

        // Move all nonzero elements to the beginning of the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill the remaining elements with 0
        while (index < arr.length) {// if index value is in range of array then
            arr[index] = 0;
            index++;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Q6. Given an integer array nums, return true if any value appears at least
     * twice in the array, and
     * return false if every element is distinct
     * 
     */
    public static boolean contains_duplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true; // Duplicate found
            }
        }

        return false; // No duplicates found
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Q. 5. You are given two integer arrays nums1 and nums2, sorted in
     * non-decreasing order, and two integers m
     * and n,representing the number of elements in nums1 and nums2 respectively.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     */
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1; // Index of the last element in arr1
        int j = n - 1; // Index of the last element in arr2
        int k = m + n - 1; // Index of the last element in the merged array

        // Merge the arrays from right to left
        while (i >= 0 && j >= 0) { // both index must be in their range
            if (arr1[i] > arr2[j]) { // if valu of first array is big then assign it from last index
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }

        // Copy the remaining elements from arr2 to arr1
        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Q4. You are given a large integer represented as an integer array digits,
     * where each digits[i] is the
     * ith digit of the integer. The digits are ordered from most significant to
     * least significant in left-to-right
     * order. The large integer does not contain any leading 0's.Increment the large
     * integer by one and return
     * the resulting array of digits.
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     */
    public static int[] plus_One() {

        int[] digits = { 1, 2, 3 };
        int n = digits.length;

        // Start from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the digit by one
            digits[i]++;

            // If the digit becomes 10, set it to 0 and carry the 1 to the next digit
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // If the digit is less than 10, we don't need to carry the 1 anymore
                return digits;
            }
        }

        // If we reach here, it means all digits were 9s, so we need to add an
        // additional digit
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Q3. Given a sorted array of distinct integers and a target value, return the
     * index if the target is
     * found. If not, return the index where it would be if it were inserted in
     * order.
     * 
     */
    public static int binary_search() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 5; // t(c)=logn
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {// if target is grater move right side of array
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Q2. Given an integer array nums and an integer val, remove all occurrences of
     * val in nums in-place.
     * The order of the elements may be changed. Then return the number of elements
     * in nums which are not
     * equal to val.
     */
    public static int removeElement(int[] arr, int val) {
        int k = 0; // count Number of elements are not equal to val

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[k] = arr[i]; // Overwrite element at index k with element not equal to val
                                 // those value does not match update it
                k++; // Increment k
            }
        }

        return k;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Q1. Given an array of integers nums and an integer target, return indices of
     * the two numbers such that
     * they add up to target.
     */
    public int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    // question no 8
    
    public static int[] Error_nums(int[] arr) {
        int[] result = new int[2];
        
        for (int i = 0; i < arr.length; i++) {
            int num = Math.abs(arr[i]);
            
            if (arr[num - 1] > 0) {
                arr[num - 1] = -arr[num - 1];
            } else {
                result[0] = num; // duplicate number
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[1] = i + 1; // missing number
                break;
            }
        }
        
        return result;
    }

    ////////////////////// Main function
    public static void main(String[] args) {
        //////////////////////////////////////////////////////////////////////////////////////////////
        // for question 1
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        dsa_assignment1 o1 = new dsa_assignment1();
        int ans1[] = o1.twoSum(arr, target);

        for (int index : ans1) {
            System.out.print(index + " ");
        }
        System.out.println();
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        // for question 2
        int arr1[] = { 1, 3, 3, 2, 3, 2, 3, 4 };
        int val = 3; // it will remove 1,2,2,4 4 times here
        System.out.println("no of removed element " + removeElement(arr1, val));
        /////////////////////////////////////////////////////////////////////////////////////////////////////

        // for question 3

        System.out.println("after doing binary search index is " + binary_search());
        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // for question 4
        System.out.println("after processing array are ");
        int arr2[] = plus_One();
        for (int i : arr2) {
            System.out.print(" " + i);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // for question 5
        System.out.println("after merging two array ");
        int num1[] = { 1, 2, 3, 0, 0, 0 };
        int num2[] = { 2, 5, 6 };
        int n = 3;
        int m = num2.length;
        merge(num1, m, num2, n);
        /*
         * for (int i : num1) {
         * System.out.println(i); OR
         * }
         */
        System.out.println(Arrays.toString(num1));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        // for question 6
        System.out.println("check duplicate ");
        System.out.println(contains_duplicate(num1));
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        // for question 7
        int zeros[] = { 1, 2, 3, 0, 2, 0, 2, 0 };
        System.out.println("after moving all zeroes");
        move_zeroes(zeros);
        System.out.println(Arrays.toString(zeros));
        ///////////////////////////////////////////////////////////////////////////////////////////////

        // for question 8
          System.out.println("missing duplicate and missing number are ");
            int error_arr[]={1,2,2,4};
            Error_nums(error_arr);
             System.out.println("duplicate number is "+error_arr[0]);
             System.out.println("missing number is "+error_arr[1]);

    }
}
