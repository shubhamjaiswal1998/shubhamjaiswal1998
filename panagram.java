public class panagram {
        public static void main(String[] args) {
                boolean flag=true;
            String s="the quick brown fox jumps over lazy dog";
                  s=s.toUpperCase();
                 s=s.replace(" ", "");
             char arr[]=s.toCharArray();
               int arr1[]=new int[26];
             
             for (int i = 0; i < arr.length; i++) {
                    int k=arr[i]-65;
                     arr1[k]++;
             }
            for (int i = 0; i < arr1.length; i++) {
                  if (arr1[i]==0) {
                       System.out.println("this is not pangram");
                       flag=false;
                  }
            }
            if (flag) {
                System.out.println("this is pangram");
            }
        }
    
}
