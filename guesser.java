import java.util.Scanner;

public class Guesser{
          
           int guessernum;
           int guessernum(){
        Scanner sc=new Scanner(System.in);
             System.out.println("gues a number by geser");
              guessernum=sc.nextInt();
              return guessernum;
        
       }}
     class Umpire{
        int guessernum1;   int numplayer1;  int numplayer2;   int numplayer3; 
            void storeguessernum(){
               Guesser g=new Guesser();
               guessernum1=g.guessernum(); 

            }
            void storeplayernum(){
             Player h1=new Player();
             Player h2=new Player();
             Player h3=new Player();
             numplayer1=h1.guessernum(); numplayer2=h2.guessernum(); numplayer3=h3.guessernum();
                     
            }
            void compare(){
              if (guessernum1==numplayer1) {

                if (guessernum1==numplayer2 && guessernum1==numplayer3) {
                    System.out.println("all player won");
                } else if(guessernum1==numplayer2){
                     System.out.println("player 1 & 2 won");
                }
                else if(guessernum1==numplayer3){
                           System.out.println("player 1 & 3 won");
                }else{
                    System.out.println("player 1 is won");
                }
                
              } else if(guessernum1==numplayer2) {

                    if (guessernum1==numplayer3) {
                        System.out.println("player 2 & 3 won ");
                    } else {
                        System.out.println("player 2 is won");
                    }
              }
               else if(guessernum1==numplayer3){
                System.out.println("player3 is won");
               }
               
               else{
                System.out.println("no one won");
               }
                     }
     
}
 public class Player{ 
                          
    int guessernum;  
    int guessernum(){
    Scanner sc=new Scanner(System.in);
    System.out.println("gues a number by player");
     guessernum=sc.nextInt();
     return guessernum;
    }
   }

public class Guesser {
    public static void main(String[] args) {
        Umpire  k = new Umpire();
             k.storeguessernum(); k.storeplayernum(); k.compare();
        
    }
    
}