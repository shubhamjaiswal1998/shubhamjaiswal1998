import java.util.Arrays;

public class dsa_assignment2 {
    /*.  
        question 8.
     * In one operation, you can choose any index i where 0 <= i < nums.length and
     * change nums[i] to nums[i] + x where x is an integer from the range [-k, k].
     * You can apply this operation at most once for each index i.
     * 
     * The score of nums is the difference between the maximum and minimum elements
     * in nums.
     * 
     * Return the minimum score of nums after applying the mentioned operation at
     * most once for each index in it.
     * 
     * Example 1:
     * Input: nums = [1], k = 0
     * Output: 0
     * 
     * Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
     */

    public static int minimum_Score(int[] arr, int k) {
        int minimum = arr[0];
        int maximum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            minimum = Math.min(minimum, arr[i] - k);
            maximum = Math.max(maximum, arr[i] + k);
        }

        return Math.max(0, maximum - minimum);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 7.An array is monotonic if it is either monotone increasing or monotone
     * decreasing.
     * 
     */
    public static boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) { // left side value grater
                increasing = false;
            }

            if (nums[i] > nums[i - 1]) {// left side value smaller
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 6. Given an array of integers nums which is sorted in ascending order, and an
     * integer target,
     * write a function to search target in nums. If target exists, then return its
     * index. Otherwise,
     * return -1.
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found, return the index
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target not found
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Question 5
     * Given an integer array nums, find three numbers whose product is maximum and
     * return the maximum product.
     * Input: nums = [1,2,3]
     * Output: 6
     * 
     */
    public static int max_Product(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        int n = nums.length;

        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3]; // Product of three largest elements
        int product2 = nums[0] * nums[1] * nums[n - 1]; // Product of two smallest elements and the largest element

        // Compare the two products and return the larger one
        if (product1 > product2) {
            return product1;
        } else {
            return product2;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 4.You have a long flowerbed in which some of the plots are planted, and some
     * are not.
     * However, flowers cannot be planted in adjacent plots.
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
     * and 1 means not empty, and an integer n, return true if n new flowers can be
     * planted in the flowerbed without violating the no-adjacent-flowers rule and
     * false otherwise.
     * 
     * Example 1:
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: true
     * 
     */
    public static boolean ISPlace_Flower(int[] arr, int n) {
        int count = 0;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            // Check if the current plot is empty and adjacent plots are also empty or out
            // of bounds
            if (arr[i] == 0 && (i == 0 || arr[i - 1] == 0) && (i == length - 1 || arr[i + 1] == 0)) {
                arr[i] = 1;
                count++;

                // Check if we have planted enough flowers
                if (count >= n) {
                    return true;
                }
            }
        }

        return count >= n;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Question 3
     * We define a harmonious array as an array where the difference between its
     * maximum value
     * and its minimum value is exactly 1.
     * 
     * Given an integer array nums, return the length of its longest harmonious
     * subsequence
     * among all its possible subsequences.
     * 
     * A subsequence of an array is a sequence that can be derived from the array by
     * deleting some or no elements without changing the order of the remaining
     * elements.
     * 
     * Input: nums = [1,3,2,2,5,2,3,7]
     * Output: 5
     * The longest harmonious subsequence is [3,2,2,2,3].
     * 
     */
    public static int LongestSeq_no(int[] nums) {
        // Initialize an array to count the frequency of each number
        int[] frequency = new int[2001]; // The range of numbers is [-1000, 1000], so we need an
        // array of size 2001

        // Count the frequency of each number
        for (int num : nums) {
            frequency[num + 1000]++;
        }

        int maxLen = 0;

        // Iterate through the array
        for (int i = 0; i < frequency.length - 1; i++) {
            // Check if the current number and the next number form a harmonious subsequence
            if (frequency[i] > 0 && frequency[i + 1] > 0) {
                int currentLen = frequency[i] + frequency[i + 1];
                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 2.Alice has n candies, where the ith candy is of type candyType[i]. Alice
     * noticed that she
     * started to gain weight, so she visited a doctor. The doctor advised Alice to
     * only eat n / 2 of the
     * candies she has (n is always even). Alice likes her candies very much, and
     * she wants to eat the
     * maximum number of different types of candies while still following the
     * doctor's advice.
     * Given the integer array candyType of length n, return the maximum number of
     * different types of candies
     * she can eat if she only eats n / 2 of them.
     * candyType = [1,1,2,2,3,3]
     */

    public static int maxCandies(int[] candyType) {
        int maxCandiesAllowed = candyType.length / 2;
        // bcoz of she can eat if she only eats n / 2 of them.
        Arrays.sort(candyType); // nlogn

        int uniqueCandies = 1; // At least one candy type is guaranteed

        // Count the number of unique candies
        for (int i = 1; i < candyType.length && uniqueCandies < maxCandiesAllowed; i++) { // n
            if (candyType[i] != candyType[i - 1]) { // compare adjacent ele must not be eqaul
                // then increASE uniqe cmandy
                uniqueCandies++;
            }
        }

        return uniqueCandies;// total =nlogn+ n=o(nlogn)
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 1. Given an integer array nums of 2n integers, group these integers into n
     * pairs (a1, b1), (a2, b2),...,
     * (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the
     * maximized sum
     */
    public static int pair_Sum(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i = i + 2) {
            sum = sum + arr[i]; // go alternatively and add that number gt o/p
        }

        return sum;
    }

    public static void main(String[] args) {
        // for question 1
        int arr[] = { 6, 2, 6, 5, 1, 2 };
        System.out.println("minimum pair sum is " + pair_Sum(arr));

        // for question 2
        int candyType[] = { 1, 1, 2, 2, 3, 3 };
        System.out.println("max eaten uniqe candies are " + maxCandies(candyType));

        // for question 3
        int arr2[] = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println("longest seq no is " + LongestSeq_no(arr2));

        // for question 4

        int flowerbed[] = { 1, 0, 0, 0, 1 };
        System.out.println(ISPlace_Flower(flowerbed, 1));

        // for question 5
        int maxpro[] = { 1, 2, 3, 4 };
        System.out.println(max_Product(maxpro));

        // for question 6
        System.out.println(search(arr2, 2));

        // for question 7
        int mono[] = { 1, 2, 2, 3 };
        System.out.println(isMonotonic(mono));

        // for question 8
        int nums[]={1}; int k=0;
        System.out.println(minimum_Score(nums, k));

    }
}
