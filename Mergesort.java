
class Mergesort {
    
   public static void merge(int arr[], int s, int m, int e)
    {
        
        int n1 = m - s + 1;
        int n2 = e - m;
 
        
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
 
    
        for (int i = 0; i < n1; ++i)
            arr1[i] = arr[s + i];
        for (int j = 0; j < n2; ++j)
            arr2[j] = arr[m + 1 + j];
 
        
        int i = 0, j = 0; int k = s;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            }
            else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
 
        
        while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
 
        
        while (j < n2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
 
    
    public static void sort(int arr[], int s, int e)
    {
        if (s < e) {
            // Find the middle point
            int m = s + (e - s) / 2;
 
            // Sort first and second halves
            sort(arr, s, m);
            sort(arr, m + 1, e);
 
            // Merge the sorted halves
            merge(arr, s, m, e);
        }
    }
 
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
    
        sort(arr, 0, arr.length - 1);
 
        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    
    }
}
