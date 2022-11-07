class duplicate{

   public static void main(String[] args) {
    
            int arr[]={4,0,1,9,6,0};
                
            for(int i = 0; i < arr.length; i++) {

                for(int j = i + 1; j <arr.length; j++) {

                    if(arr[i] == arr[j])

                          System.out.println("duplicate number is "+arr[i]);  
                }  
            }  
           }
}