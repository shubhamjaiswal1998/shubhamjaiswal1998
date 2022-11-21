import java.util.Arrays;
public class anagram {
    public static void sort_array(char arr[]){
        for (int i = 0; i < arr.length; i++)   
        {  
        for (int j = i + 1; j < arr.length; j++)   
        {  
        char tmp = '0';  
        if (arr[i] > arr[j])   
        {  
        tmp = arr[i];  
        arr[i] = arr[j];  
        arr[j] = tmp;  
        }  
        }  
    }
    }
public static void main(String[] args) {

    String name1="abcd"; String name2="bcda";
      //name1= name1.toLowerCase(); name2= name2.toLowerCase();
     char arr1[]=name1.toCharArray();  char arr2[]=name2.toCharArray();
       
            sort_array(arr1);   sort_array(arr2); // used sort function made above
       /*  Arrays.sort(arr1);  
                    Arrays.sort(arr2); */

       if (Arrays.equals(arr1, arr2)) {
           System.out.println("anagram");
       } else {
          System.out.println("not anagram");
       }
       
}

}

    

