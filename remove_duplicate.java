public class remove_duplicate {

    public static void main(String[] args) {
        String input="abbcd";
    StringBuilder output=new StringBuilder(input); 
for (int i = 0; i < input.length(); i++) {

  for (int j = i+1; j < input.length(); j++) {
         if (input.charAt(i)==input.charAt(j)) {
              output.deleteCharAt(j);
                        }
  }
 }
        System.out.println(output);
       }
    
}
