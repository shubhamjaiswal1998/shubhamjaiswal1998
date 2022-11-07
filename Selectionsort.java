public class Selectionsort {
    public static void main(String[] args) {
          
        int arr[]={4,5,6,7,3};
                 
           for (int i = 0; i < arr.length-1; i++) {
                       int minindex=i;

                   for (int j = i+1; j < arr.length; j++) {

                          if (arr[minindex]>arr[j]) {
                                    minindex=j;
                          }  
                        // swap(arr[minindex] ,arr[j])
                        int temp=arr[minindex];
                        arr[minindex]=arr[j];
                          arr[j]=temp;

                   }
                    }

           for (int i = arr.length-1; i >=0; i--) {   // for print sorted array
               System.out.print(arr[i]+" ");
           }


    }
    
}
