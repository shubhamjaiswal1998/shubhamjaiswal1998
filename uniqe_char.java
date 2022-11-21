public class uniqe_char {
   public static void main(String[] args) {
    String name = "inurorns";
 
    for (int i = 0; i < name.length(); i++)
    {
        int flag = 0;
        for (int j = 0; j < name.length(); j++)
        {
            
            if (name.charAt(i) == name.charAt(j) && i != j)
            {
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            System.out.print(name.charAt(i));
    }
}
   }
    

