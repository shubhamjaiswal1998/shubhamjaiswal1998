public class max_occurchar {

 public static char MaxOccuringChar(String str1) {
  int arr[] = new int[200];
  int l = str1.length();
  for (int i = 0; i < l; i++)
  
   arr[str1.charAt(i)]++;
  int max = -1;
  char result = ' ';
  
  for (int i = 0; i < l; i++) {
   if (max < arr[str1.charAt(i)]) {
    max = arr[str1.charAt(i)];
    result = str1.charAt(i);
   }
  }

  return result;
}
    public static void main(String[] args) {
          String name="shubhamjaiswalbbbbb";
        System.out.println("maximum occuring char is "+MaxOccuringChar( name));
    }
    
}
