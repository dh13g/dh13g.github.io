/** Using switch case, the program calculate and output invoice report depending on customer's type and subtotal. **/

import java.util.Scanner;
 
public class InvoiceApp
{
    public static void main(String[] args)
    {
        double sub, dca = 6, tot, dcp = 0;;     //dca = discount amount;   dcp = discount percent;  tot = total;   sub = subtotal
        int cus;    //cus = customer
        Scanner num = new Scanner(System.in);
        
        //Display a welcome message
        System.out.println("*****************************************************************************************************");
        System.out.println("                     Welcome to the Invoice Total Calculator             ");
        System.out.println("*****************************************************************************************************\n");
 
        //Prompt user for customer type
        System.out.print("Please enter the customer type (Enter 1 for Silver, 2 for Gold, or 3 for Platinum): ");
        
 
        //Read customer type
         cus = num.nextInt();
           
        //Prompt user for subtotal   
        System.out.print("\nPlease enter the subtotal:    ");
        
        //Read subtotal
        sub = num.nextDouble();
        
        //Calculate Discount Rate
      
             switch(cus)
             {
             case 1:                             //Subtotal >= 500.00 then 20% discount
                 if(sub >= 500.00){
                     
                     dca = sub * .20;
                     dcp = 0.20;
                 } 
                 else if(sub < 500.00 && sub >= 250.00){      //Subtotal < 500.00 & subtotal >=250.00 then 15% discount
                     dca = sub * .15;
                     dcp = 0.15;
                 }
                 else if(sub <250.00 && sub >= 100.00){       //Subtotal < 250.00 & subtotal >=100.00 then 10% discount
                     dca = sub * .10;
                     dcp = 0.10;
                 }
                 else{                           //If subtotal does not match any of standards above then 0% discount
                     dca = sub * 0.0;
                     dcp = 0.00;
                 }
                 break;
            case 2:
                dca = sub * .20;
                dcp = 0.20;
                break;
            case 3:
                if(sub >= 500.00){
                    dca = sub * .50;
                    dcp = 0.50;
                }
                else{
                    dca = sub * .40;
                    dcp = 0.40;
                }
                break;
            default:
                    dca = sub * 0.05;
                    dcp = 0.05;
             }
         
        
        
        
        //Calculate Invoice Total
        tot = sub - dca;

        //Display thank you message
        String thanks = ("Thank you!");

        //Format and display the results
        System.out.println("\n*****************************************************************************************************");
        System.out.println("                                      INVOICE REPORT:");
        System.out.printf("                                Subtotal:            %.2f", sub);
        System.out.printf("\n                                Customer type:      " + cus);
        System.out.printf("\n                                Discount percent:   %.2f", dcp);
        System.out.printf("\n                                Discount amount:    %.2f", dca);
        System.out.printf("\n                                Total:              %.2f", tot);
        System.out.println("\n\n                                     " + thanks + "\n");
        System.out.println("*****************************************************************************************************");

       
    }//end of main
}//end of class
