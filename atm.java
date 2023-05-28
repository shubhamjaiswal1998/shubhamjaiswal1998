package atmminiproject2.com;

import java.util.Scanner;

public class atm {

	public static void main(String[] args) {
		System.out.println("welcome shubahm in bank of india");
          opration ob=new opration();
	}
    
}
class Data{
	int actual_balance; 
}
 class opration{
	 static int passwordpin=321; 
	opration(){ 
		Data ob1=new Data();
		ob1.actual_balance=0;
		  checkpin(ob1);
	}
	public static void checkpin(Data ob1) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter your atm pin");
		  int pin=sc.nextInt();
		   if(passwordpin==pin) { 
			   System.out.println("your passord is right");
			   menu(ob1);
		   }
		   else {
			  System.out.println("your password is wrong ");
		   }
	 }
	public static void menu(Data ob){
		System.out.println(" click on choice for  transaction");
		System.out.println("choice 1 for see transaction");
		System.out.println("choice 2 for deposit money");
		System.out.println("choice 3 for withdrawl money");
		System.out.println("enter any key apart from above for exit");
		//////////////////////////////////////////////////////////
		System.out.println();
		System.out.println("enter your choice ");
		Scanner sc=new Scanner(System.in);
		  int choice=sc.nextInt();
		  if(choice==1) {
			  seetransaction(ob);
			    menu(ob);                 
				  }
		  else if(choice==2) {
			  deposit(ob);
			  menu(ob);
		  }
		  else if(choice==3) {
			  withdrawal(ob); menu(ob); 
		  }
		  else {
			  System.out.println("thank you"); 
			  System.exit(0);
		  }
      }
	public static void deposit(Data ob) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter deposit money");
		  int depositmoney =sc.nextInt();
		  
		  ob.actual_balance=ob.actual_balance+depositmoney;
		    System.out.println(" deposit money is successfull for "+depositmoney);
		    menu(ob);
		
	}
	public static void withdrawal(Data ob) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter withdwral money");
		  int withdrawalamount =sc.nextInt();
		 
		  ob.actual_balance=ob.actual_balance-withdrawalamount;
		  System.out.println(" withdwral money is successfull for "+withdrawalamount);
		    menu(ob);
	}
	public static void seetransaction(Data ob) {
		System.out.println("your availlable money is "+ob.actual_balance); menu(ob);
	}


}