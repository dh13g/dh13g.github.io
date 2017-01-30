/** Used Java programming to create bank account. The program starts out with $5000.00 by default. It asks the user to type in how 
much he or she has deposited or withdrawed and calculates how much money the user has when balance is requested.  **/

import java.util.*;

public class BankAccount {
  public static void main(String[] args) {

  	//Initialize
  	double bal = 5000.00;
  	int acc = 0;
  	char menuInput = ' ';
  	double dep = 0.0;
  	double with = 0.0;


    //Welcome
    welcomeMessage();
    
    //input
    acc = accountInfo();
    
    do
    {
      
      menuInput = displayMenu();
      
      switch(menuInput){
        
        case 'D':
          bal = depositFunds(bal);
          break;
        case 'W':
         bal = withdrawFunds(bal);
          break;
        case 'B':
          checkBalance(acc, bal);
          break;
        case'X':
          break;
        default:
        System.out.print("\nERROR: Please ");
        
      }
    }while(menuInput != 'X');
    
    System.out.println("\n\nThank you for being a loyal Seminole Bank customer!");
    
  }//end of main
  public static void welcomeMessage(){
     
      System.out.println("***********************************************************************************");
      System.out.println("\t\t\tWelcome to Seminole Bank!");
      System.out.println("***********************************************************************************\n");
      
  }
  
 public static int accountInfo(){
      
       
       Scanner input = new Scanner(System.in);
       
      System.out.print("Please enter your 5-digit Account Number: ");
      int account = input.nextInt();
      System.out.println("\nThank you!\n\n");
      return account;
  } 
  
  public static char displayMenu(){     //Display menu choices to the user and Read the users’ banking choice
                                            // RETURN the user’s menu choice to main()
        Scanner input = new Scanner(System.in);
        
    System.out.print("Enter D for deposit, W for withdrawal, B for balance, X to exit the menu: ");
    char menu = input.next().charAt(0); 
    menu = Character.toUpperCase(menu);
    
    
    return menu;
  }
  
  public static double depositFunds(double balance){  ////Function when deposit is requested, it will add the amount inputted with the current balance.
    
    Scanner input = new Scanner(System.in);
   
   System.out.println();
    System.out.print("Enter the amount of the deposit: ");
    double deposit = input.nextDouble();
    balance += deposit;
    
    System.out.println();
    
    return balance;

  }//end of depositFunds
  
  public static double withdrawFunds (double balance){ //Function when withdrawal is requested, it will minus the amount inputted with the current balance.
     
     System.out.println();
     
     Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the amount of the withdrawal: ");
    double withdrawal = input.nextDouble();
    balance -= withdrawal;
    
    System.out.println();
    
    return balance;        
                
  }//end of withdrawFunds
  
  public static void checkBalance(int account, double balance){ //Output of balance. 
    
    System.out.print("\nAccount number: " + account);
    System.out.printf(" has a current balance of: $%.2f", balance);
    System.out.println("\n");
               
  }//end of checkBalance
         
}//end of class
