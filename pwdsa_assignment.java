import java.util.*;
public class pwdsa_assignment {
/* question 7
 * moves all zeros at end
 */
    public static int[] moves_zeros(int arr[]) {
         int k=0;
      for (int i = 0; i < arr.length; i++) {
                  if (arr[i]!=0) {
                                        // swap(arr[i], arr[k]);
                      int temp=arr[i];
                     arr[i]= arr[k] ;
                        arr[k]=temp;
                       k++; 
                  }
           }

           return arr;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 6
 *  Given an integer array nums, return true if any value appears at least twice in the array,
 *  and return false if every element is distinct.
 */
    public static boolean check_duplicate(int arr[]) {
        
       Arrays.sort(arr);

       for (int i = 0; i < arr.length; i++) {
           if (arr[i]==arr[i+1]) {
             return true;
           }
       }
        return false;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////
/* question 5
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m
 *  and n, representing the number of elements in nums1 and nums2 respectively. merge it
 */
    public static int[] merge_array(int arr1[], int arr2[]) {
        
                   int n=arr1.length; int m=arr2.length;
              int result[]=new int[n+m];
                   
              int i=0; int  j=0; int k=0;
              while (i<n && i<m ) {
                
                if (arr1[i]<arr2[j]) {
                    
                    result[k]=arr1[i]; k++; i++;
                } else {
                    result[k]=arr2[j];   k++; j++;
                }

              }
                
              while (i<n) {
                
                     result[k]=arr1[i]; i++; k++;
                 }
                 

              while(j<m){

                     result[k]=arr2[j]; j++; k++;
                
              }
              return result;
            }
            //////////////////////////////////////////////////////////////////////////////////////
    /*question 4
    You are given a large integer represented as an integer array digits, where each digits[i] is
 the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-
 right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
     */
    public static int[] increase_One(int[] arr) {
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) { // traval from right
            
            if (arr[i] < 9) {
                arr[i]++;    //  if last ele is 1 2 3 4 5 6 7 8 increase 1 & return that array
                return arr;  // after return it will not iterate again 
            }

            // If the current element is 9, set it to 0 bcoz 9+1=10 it is 2 digit 
            //we do not want  increase digit 
                        
            arr[i] = 0;
        }

        // if all ele is 9 
        int[] new_Arr = new int[n + 1];
        new_Arr[0] = 1;

        return new_Arr;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
/*
 * question 3
 * 
 */
public static int binary(int arr[],int target) {
    
     int s=0; int e=arr.length-1;
     int mid;

     while (s<=e) {
          
               mid=(s+e)/2;
         if (arr[mid]==target) {
            return mid;
         }
       if (arr[mid]>target) {
            e=mid-1;
       } else {
           s=mid+1;
       }

     }

   return s;

}

    /////////////////////////////////////////////////////////////////////////////////////////////////
/*question 2
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
 * The order of the elements may be changed. Then return the number of elements in nums which are not 
 * equal to val.
 */
    public static int remove_Ele(int[] arr, int val) {
        int countindex = 0;  
                                       int k=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {  //  those valu do not match with target
                                       // assign it again with starting 0 index
                arr[k++] = arr[i];
                countindex++;
            }
        }

        return countindex;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
/*
 * question 1
 * . Given an array of integers nums and an integer target, return indices of the two numbers such
 *  that they add up to target.
 * 
 */
    public static ArrayList<Integer> sum_target(int arr[],int target) {
         
              ArrayList<Integer> ob=new ArrayList<>();
           for (int i = 0; i < arr.length; i++) {
               for (int j = i+1; j < arr.length; j++) {
                    if (arr[i]+arr[j]==target) {
                          ob.add(i);
                          ob.add(j);
                          return ob;
                    }
               }
           }
           return new ArrayList<>();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
/*  question 8
 * Find the number that occurs twice and the number that is missing and return them in the form
 *  of an array.
 */
     public static int[] missing_twice_Nums(int[] nums) {
        int n = nums.length;
        int duplicate = -1;
        int missing = -1;

        HashSet<Integer> set = new HashSet<>();

        // Find the duplicate number
        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
            } else {
                set.add(num);
            }
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
    public static void main(String[] args) {
       // for question 1////////////////////////////////////////////////////////
        int arr1[]={2,7,11,15};

          ArrayList<Integer> target_index=sum_target(arr1, 26);
            System.out.println(target_index);
       // for question 2///////////////////////////////////////////////////

                int[] arr2 = { 3, 2, 2, 3 };
        int val = 3;
        int k = remove_Ele(arr2, val);

        System.out.println("count  " + k + ", nums " + Arrays.toString(arr2));
          // for question 3
          
          int arr3[]={1,3,5,6}; 
           int k1=5;
          System.out.println(binary(arr3, k1));
        
          // for question 4

              int[] arr4 = { 1, 2, 3 };
        int[] result = increase_One(arr4);

        System.out.println("Output: " + Arrays.toString(result));
          
        // for question 5

       int[] arr5 = { 1, 2, 3, 0, 0, 0 };

        int[] arr6= { 2, 5, 6 };
    
            int merge_array[]= merge_array(arr5, arr6);
            System.out.println(Arrays.toString(merge_array));
           
            // for question 6
               int[] nums = { 1, 2, 3, 1 };
               boolean result1 = check_duplicate(nums);
             System.out.println("Output: " + result1);

           // for question 7
              int arr8[]={1,3,0,2,0,2,0};
           int res11[]=moves_zeros(arr8);

              System.out.println(Arrays.toString(res11));
            //  for question 8

            int arr32[]={1,2,2,4};
            int miss[]=missing_twice_Nums(arr32);
            System.out.println("duplicate num & missing num "+Arrays.toString(miss));

    }
        
}
