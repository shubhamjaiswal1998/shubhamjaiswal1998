import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class dsa_assignment11 {

/*
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element
 *  in the result must appear as many times as it shows in both arrays and you may return the 
 * result in any order.
 */
public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ob = new ArrayList<>();
// first add both common ele into list then convert again list to array
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ob.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[ob.size()];
        for (int idx = 0; idx < ob.size(); idx++) {
            result[idx] = ob.get(idx);
        }

        return result;
    }
    /////////////////////////////////////////////////////////////////////////// 
/*
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of
 *  a given target value.
 * If target is not found in the array, return [-1, -1].
 */

     public static int binary(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                index = mid;
                
                if (left) {
                    high = mid - 1; // Search for the leftmost occurrence
                } else {
                    low = mid + 1; // Search for the rightmost occurrence
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return index;
    }
public static int[] Range(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Search for the leftmost occurrence of the target
        int leftIndex = binary(nums, target, true);
        
        // If the leftmost occurrence is not found, return [-1, -1]
        if (leftIndex == -1) {
            return result;
        }
        
        
        int rightIndex = binary(nums, target, false);
        
        result[0] = leftIndex;
        result[1] = rightIndex;
        
        return result;
    }

/* question 6
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * [3,4,5,1,2] o/p =>1
 * 
 */
public static int Min_element(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s < e) {
            int mid = (s+e)/2;

            
            if (nums[mid] > nums[e]) {  //
                
                s = mid + 1;
            } else {
        
                e = mid;
            }
        }

        // At the end of the loop, s and e will point to the minimum element
        return nums[s];
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* question 5
     * Given two integer arrays nums1 and nums2, return an array of their intersection. 
     * Each element in the result must be unique and you may return the result in any order.
     */
     public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add all elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Add common elements of nums2 to set2 also those value should be in set1 
        for (int num : nums2) {
            if (set1.contains(num)) {  // if set1 contains some num2 value that means sone num is commen
                set2.add(num);   //then that all commen valu add in set2
            }
        }
        
        // Convert set2 to an array
           int result_size=set2.size();  // it will be eqal to set2 of size

        int[] result = new int[result_size];
        int index = 0;
        for (int num : set2) {
            result[index] = num;   // insert all set2 value in resut array now
            index++;
        }
        
        return result;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 4
 * There is only one repeated number in nums, return this repeated number.
 */
    public static int Duplicate_ele(int[] nums) {
        int n = nums.length - 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        
        return -1; // or any other value indicating no duplicate found
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
   /*
     question 3
     Given an array nums containing n distinct numbers in the range [0, n], return the only number
      in the range that is missing from the array.
      nums = [3,0,1] o/p =>2 
    */ 
    public static int missing_num(int[] nums) {
        HashSet<Integer> ob = new HashSet<>();

        // Add all numbers from the array to the HashSet
        for (int num : nums) {
            ob.add(num);
        }

        // Check for the missing number in the range [0, n]
        for (int i = 0; i <= nums.length; i++) {

            if (!ob.contains(i)) {  // if ele does not contain that return that index
                                   // and that index will be missing number here
                return i;
            }
        }
         return -1;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
/*  question 2
 *  Given a 0-indexed integer array nums, find a peak element, and return its index. If the array 
 * contains multiple peaks, return the index to any of the peaks.
 */
    public static int PeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
/* question 1

 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 *  The returned integer should be non-negative as well.
 */
    public static int Sqrt(int x) {
        if (x == 0)
            return 0;

        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)){
                return mid;  }

            else if (mid > x / mid){
                right = mid - 1;   
            }
            else {
                left = mid + 1;  }
        }

        return -1; // This line should never be reached.
    }
    public static void main(String[] args) {
       // for question 1 
      System.out.println(Sqrt(8));

        // for question 2
       int[] arr = {1, 2, 3, 1};
       System.out.println(PeakElement(arr));

       // for question 3
      
       int[] nums = {3, 0, 1};
         System.out.println(missing_num(nums));

       // for question 4  

       int arr1[] = {1,3,4,2,2};
       System.out.println(Duplicate_ele(arr1));

       // for question 5
  int array1[]={4,9,5}; int array2[]={9,4,9,8,4};

       int res[]=intersection(array1, array2);
         for (int i : res) {
            System.out.print(i+" ");
         }
         System.out.println();
         // for question 6

         int min_ele[]={3,4,5,1,2};
         System.out.println(Min_element(min_ele));


       System.out.println("range are ");

         // for question 7
         int range_arr[]={5,7,7,8,8,10}; int target=8;
         
           int range_ans[]=Range(range_arr, target);
           for (int i : range_ans) {
              System.out.print(i+" ");
           }
        System.out.println();
             // for question 8
          int[] nums11 = {1, 2, 2, 1};
        int[] nums22 = {2, 2};
        intersect(nums11, nums22);
         for (int i : nums22) {
              System.out.print(i+" ");
         }

    }
}
