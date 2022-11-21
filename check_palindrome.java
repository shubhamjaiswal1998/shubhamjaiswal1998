

public class check_palindrome {
       public static void main(String[] args) {
          
              String input="2552"; boolean flag=true;

                char arr[]=input.toCharArray();  int s=0; int e=arr.length-1;

                while (s<=e) {
                    if (arr[s]!=arr[e]) {   // if both index char not matched
                           System.out.println("this is not palindrome");
                           flag=false;
                    }
                    s++; e--;            // increase starting & decrease end index
                }
             if (flag) {
                 System.out.println("this is palindrome");
             }
       }
}
