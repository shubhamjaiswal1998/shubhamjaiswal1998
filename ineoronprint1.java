public class ineoronprint1 {
     public static void main(String[] args) {
                  int n=10;
    for (int i = 0; i <n; i++) {

        for (int j=0; j <n; j++) {   // I

               if(j==0){
                 System.out.print("*");
            
               }
            else{
                System.out.print(" ");
            }   
          }
          for (int j=0; j <n; j++) {   // N
    
            if(j==0||j==(3*n/4)||i==j){
              System.out.print("*");
         
            }
         else{
             System.out.print(" ");
         }   
       }

       for (int j=0; j <n-1; j++) {       // E
    
        if(j==0||i==(n-1)/2 && j<=(3*n)/4|| (i==0 && j<=(3*n)/4)|| i==n-1&& j<=(3*n)/4){
          System.out.print("*");
     
        }
     else{
         System.out.print(" ");
     }   
   }    
   for (int j=0; j <n; j++) {           // U
    
    if( (j==0 && i<n-1)    ||    (j==n-1 && i<n-1)
    ||(i==n-1 && j<n-1 && j>0)     )
    {
      System.out.print("*");
 
    }
 else{
     System.out.print(" ");
 }   
} 
        for (int j=0; j <n; j++) {      // R
    
  if( j==0  || i==(n-1)/2 && j<n-1  ||
  i==0 && j<n-1||
   j==n-1 && i>0 && i!=(n-1)/2    )
  {
    System.out.print("*");
        
  }
else{
   System.out.print(" ");
}   
}      
for (int j=0; j <n; j++) {             // O
    
  if(i==n/4 && j>n/4 && j<(3*n)/4||  i==(3*n)/4 && j>n/4 && j<(3*n)/4 ||
     j==n/4 && i>n/4 && i<(3*n)/4||  j==(3*n)/4&& i>n/4 && i<(3*n)/4  
    
  ){
    System.out.print("*");
           
  }
else{
   System.out.print(" ");
}   
}      
for (int j=0; j <n; j++) {     // N
    
  if(j==0||j==n-1||i==j){
    System.out.print("*");

  }
else{
   System.out.print(" ");
}   
}
           System.out.println();
        } 
        
}    
   
    
}