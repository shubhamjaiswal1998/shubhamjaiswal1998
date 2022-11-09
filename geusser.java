import java.util.Scanner;

 class Umpirekgf{
    int p1; int p2; int p3; int guessernum1;
    void assignguesser_value(){
    
       
         startinggusser o=new startinggusser();
          guessernum1=o.guessernum();
       
    }
     void assignplayer_value(){
          
                team e1=new team();  team e2=new team();
                p1=e1.playerguess();  p2=e2.playerguess();
        
                   team e3=new team();
                     p3=e3.playerguess();
            }   
            
                  
    void ansteller(){
        int name1 =1234;  int name2=4321;
        Scanner sc=new Scanner(System.in); System.out.println(" audience enter password");
           int password=sc.nextInt();  
           if(name1==password || name2==password  )
         {             
            System.out.println("yes y can know who is won");
          if (guessernum1==p1) {
            if (guessernum1==p2 && guessernum1==p3 ) {
                System.out.println("all player won");
            } else if(guessernum1==p2) {
                System.out.println("playe 1 & 2 is won");
            }
            else if(guessernum1==p3){
                System.out.println("player 1 & 3 won ");
            }
            else{
                System.out.println(" player 1 is won");
            }
          } else if(guessernum1==p2){
                 if (guessernum1==p3) {
                      System.out.println("player 2 & 3 won");
                 } else {
                      System.out.println("player 2 is won");
                 }
          }
          else if(guessernum1==p3){
            System.out.println("playe3 is won");

          }else{
            System.out.println("no one is won");
          }
        } else{
            System.out.println("y can not  know");
        }
          }

     }  

 class team {
    int p;     int name=1;  int password;
    int playerguess(){ 
        
              Scanner sc=new Scanner(System.in) ; System.out.println("player enter password ");
                 password=sc.nextInt();
            if(name==password){
            System.out.println(" player please enter your value");
           p =sc.nextInt();
        
              } else{
                  System.out.println(" y can not play");
              }
              
              return p;
            }
        }
 class startinggusser {
    int guessernum;
         int guessernum(){ Scanner sc= new Scanner(System.in);
                System.out.println("enter value of geusser");
            guessernum =sc.nextInt(); return guessernum;
         }

}

public class geusser {
    public static void main(String[] args) {
             Umpirekgf j=new Umpirekgf();
               j.assignguesser_value();
               j.assignplayer_value();
               j.ansteller();
    }
    
}
