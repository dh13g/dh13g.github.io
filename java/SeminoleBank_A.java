import java.util.*;

public class SeminoleBank_A {
    public static void main(String []args){
    	
    	//Declare Variables
    	double with, dep, bal=1000.00;
    	int acc;
    	Scanner input = new Scanner(System.in);

    	//Display welcome message and request and read user's account number
    	System.out.println("\n**********************************************************************");
    	System.out.println("				Welcome to Seminole Bank!");
		System.out.println("\n**********************************************************************");
		    	 
		System.out.print("\nPlease enter your 5-digit Seminole Account Number: ");
		acc = input.nextInt();

		System.out.println("\nThank you!\n");

		char menu = ' '; //declare menu to work while loop


		//while loop
		while(menu != 'X')
		{
		
		System.out.print("\nEnter D for deposit, W for withdrawal, B for balance or X to exit the menu: ");
		 menu = input.next().charAt(0); 

		 menu = Character.toUpperCase(menu);

		if(menu == 'W'){
			System.out.print("\nEnter the amount of the withdrawal: ");
			with = input.nextDouble();
			bal -= with;
		}

		else if (menu == 'D'){
			System.out.print("\nEnter the amount of the deposit: ");
			dep = input.nextDouble();
			bal += dep;
		}

		else if (menu == 'B'){
			System.out.printf("\nAccount number: " + acc +" has a current balance of: $%.2f", bal);
			System.out.println("");
		}


		}

		System.out.println("\n\nThank you for being a loyal Seminole Bank customer!");
    }
}
