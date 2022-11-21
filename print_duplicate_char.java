import java.util.Arrays;
public class print_duplicate_char {

    public static void main(String[] args) {
            
        //int arr[]={1,4,4,4,1};   int s=0; int e=arr.length-1;
           String n="abcdae";
           char arr[]=n.toCharArray();  
         for (int i = 0; i < arr.length; i++) {
          for (int j = i+1; j < arr.length; j++) {
              if (arr[i]==arr[j]) {
                   System.out.println(arr[i]);
              }
          }
          
         }

       }
    
}
