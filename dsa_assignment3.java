import java.util.*;

public class dsa_assignment3 {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*
question7.
 A number x is considered missing if x is in the range [lower, upper] and x is not in
nums.
Return the shortest sorted list of ranges that exactly covers all the missing
numbers. That is, no element of nums is included in any of the ranges, and each
missing number is covered by one of the ranges.
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]
 */    
    public static List<String> missing_range(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<>();
        int start = lower;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                start++;
            } else if (nums[i] > start) {
                missingRanges.add(getRange(start, nums[i] - 1));
                start = nums[i] + 1;
            }
        }

        if (start <= upper) {
            missingRanges.add(getRange(start, upper));
        }

        return missingRanges;
    }

    public static String getRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * question 6.
     * Given a non-empty array of integers nums, every element appears twice except
     * for one. Find that single one.
     * must implement a solution with a linear runtime complexity and use only
     * constant extra space.=> nums = [2,2,1]
     * 0 ^ 2 = 2.
     * 2 ^ 2 = 0
     * 0 ^ 1 = 1
     * o/p=1
     */
    public static int DO_XOR(int[] arr) {
        int result = 0;
        int i = 0;
        while (i < arr.length) { // those value are same will be 0 & then 0^number = number
            result ^= arr[i];
            i++;
        }
        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Question 5. You are given a large integer represented as an integer array
     * digits, where each
     * digits[i] is the ith digit of the integer. The digits are ordered from most
     * significant
     * to least significant in left-to-right order. The large integer does not
     * contain any
     * leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     * 
     */
    public static int[] plus_1(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
            if (carry == 0) {
                break;
            }
        }

        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }

        return digits;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 4. Given a sorted array of distinct integers and a target value, return the
     * index if the
     * target is found. If not, return the index where it would be if it were
     * inserted in
     * order.
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // At this point, the target is not found in the array
        // The left pointer indicates the index where the target
        // would be inserted in order
        return left;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Question 3
     * A permutation of an array of integers is an arrangement of its members into a
     * sequence or linear order.
     * arr = [1,2,3], the following are all the permutations of arr
     * [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
     * The next permutation of an array of integers is the next lexicographically
     * greater
     * permutation of its integer. More formally, if all the permutations of the
     * array are
     * sorted in one container according to their lexicographical order, then the
     * next
     * permutation of that array is the permutation that follows it in the sorted
     * container.
     * ● For example, the next permutation of arr = [1,2,3] is [1,3,2].
     */
    public static void next_permutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }

            swap(arr, i, j);
        }

        reverse(arr, i + 1, arr.length - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Question 2
     * Given an array nums of n integers, return an array of all the unique
     * quadruplets
     * [nums[a], nums[b], nums[c], nums[d]] such that:
     * ● 0 <= a, b, c, d < n
     * ● a, b, c, and d are distinct.
     * ● nums[a] + nums[b] + nums[c] + nums[d] == target
     * 
     * You may return the answer in any order.
     * nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     */

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Question 1
     * Given an integer array nums of length n and an integer target, find three
     * integers
     * in nums such that the sum is closest to the target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * 
     */
    public static int three_Sum_Closest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;// this will be ans at last

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1; // we have to select 3 ele then leave 2 value from starting & end index
            int right = n - 1;

            while (left < right) { // iterte untill cross two pointer
                int currentSum = nums[i] + nums[left] + nums[right]; // add all 3 L R & anyone
                if (currentSum == target) { // if matched
                    return target;
                }
                // take difference by target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum; //
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        // for question 1

        int arr1[] = { -1, 2, 1, -4 };
        System.out.println("closet sum is " + three_Sum_Closest(arr1, 1));
        // for question 2

        int arr2[] = { 1, 2, 3 };
        next_permutation(arr2);
        System.out.println("next permutation " + Arrays.toString(arr2));

        // for question 4
        int arr3[] = { 1, 3, 5, 6 };
        System.out.println("index is " + search(arr3, 3));

        // for question 5
        int plus[] = { 1, 2, 3 };
        plus_1(plus);
        System.out.println(Arrays.toString(plus));

        // for question 6
        int arr4[]={3,2,2};
        System.out.println(DO_XOR(arr4));

        // for question 7
        int nums[] = {0,1,3,50,75}; int lower = 0; int upper = 99;
        
          List <String> ob=missing_range(nums, lower, upper);
            
           System.out.println(ob);
       
      // for question 8


           


    }
}
