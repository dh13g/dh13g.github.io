/* 
By pressing the options listed 1, 2, or 3, it gives the user different settings to control. Option 1 is to create a desired channel, option 2 is to play 
a channel, and option 3 is to exit the Pandora. 

*/

import java.util.Scanner; //needed to use Scanner for input

public class Pandora {
  public static void main(String[] args) {
   
        //Declare variables
        int menuSelection;
        String lastName = "";
     
        //Create a Scanner object
        Scanner input = new Scanner(System.in);
    
        //Display the Opening Statement which includes the Pandora Menu
        System.out.println("\n***************************************WELCOME TO PANDORA***************************************\n");
        System.out.println("                         PANDORA MENU: ");
        System.out.println("                         1 - Create New Pandora Channel");
        System.out.println("                         2 - Play Pandora Channel");
        System.out.println("                         3 - Exit Pandora\n");
        System.out.println("************************************************************************************************\n\n");
  
        //Prompt the user for their last name and menu choice option
        System.out.print("Please enter your last name followed by your Pandora Menu Choice (e.g. Summer 3): " );
        
        //Read the user's lastname and read the user's menu choice; 
        lastName = input.next();
        menuSelection = input.nextInt();
        //Convert last name to uppercase
        lastName = lastName.toUpperCase();

       
                //process the user's menu choice (options:  1, 2, 3, other)
        switch(menuSelection){
            case 1:
               //Create channel
                String firstChannel = "";
                String lastChannel = "";
                
                System.out.println("\n\nYou have selected the CREATE NEW PANDORA CHANNEL menu item!\n");
                
                System.out.print("Please enter the name of the new channel: ");
                firstChannel = input.next();
                lastChannel = input.nextLine();
                
                firstChannel = firstChannel.toUpperCase();
                lastChannel =  lastChannel.toUpperCase();
                
                System.out.print("\nYou have successfully created the following Pandora Channel: " + firstChannel + lastChannel);
                break;


            case 2: //Play a desired channel
                int channelSelection;
                
                String channel1, channel2, channel3, channel4, channel5, channel6, channel7, channel8, channel9, channel10;
                channel1 = "Aretha Franklin";
                channel2 = "Madonna";
                channel3 = "Prince";
                channel4 = "Lady Gaga";
                channel5 = "Bruno Mars";
                channel6 = "Linkin Park";
                channel7 = "Walk Off the Earth";
                channel8 = "Chris Brown";
                channel9 = "Christina Aguilera";
                channel10 = "Tye Tribett";
                
                
                System.out.println("\n\nYou have selected the PLAY PANDORA CHANNEL menu item!");
                System.out.println("\nThe user: " + lastName + " currently has created the following channels: \n");
                System.out.println("1.    " + channel1 + "\n2.    " + channel2 + "\n3.    " + channel3 + "\n4.    " + channel4 + "\n5.    " + channel5 + "\n6.    " + channel6 + "\n7.    " + channel7 + "\n8.    " + channel8 + "\n9.    " + channel9 + "\n10.   " + channel10);
                    
                System.out.print("\nWhich channel would you like to listen to? (Enter 1, 2, 3, 4, 5, 6, 7, 8, 9, or 10): ");
                channelSelection = input.nextInt();
                
                    switch(channelSelection){
                        case 1:
                            System.out.print("\nYou are now listening to: " + channel1.toUpperCase());
                            break;
                        case 2:
                            System.out.print("\nYou are now listening to: " + channel2.toUpperCase());
                            break;
                        case 3:
                            System.out.print("\nYou are now listening to: " + channel3.toUpperCase());
                            break;    
                        case 4:
                            System.out.print("\nYou are now listening to: " + channel4.toUpperCase());
                            break;
                        case 5:
                            System.out.print("\nYou are now listening to: " + channel5.toUpperCase());
                            break;
                        case 6:
                            System.out.print("\nYou are now listening to: " + channel6.toUpperCase());
                            break;
                        case 7:
                            System.out.print("\nYou are now listening to: " + channel7.toUpperCase());
                            break;
                        case 8:
                            System.out.print("\nYou are now listening to: " + channel8.toUpperCase());
                            break;
                        case 9:
                            System.out.print("\nYou are now listening to: " + channel9.toUpperCase());
                            break;
                        case 10:
                            System.out.print("\nYou are now listening to: " + channel10.toUpperCase());
                            break;
                        default:
                            System.out.println("Unknown channel. Please choose again.");
                    }
                break;

                
            case 3: //Exit out of pandora
                System.out.println("\n\nYou have selected the Exit Pandora menu item!");
                break;
                

            default:
            System.out.println("\nPlease try again.");
            
        }
        //Display Thank you message
    System.out.println("\n\n\n" + lastName + "!\t Thank you for being a valued listner!" );
    System.out.println("\n\n***************************************GOODBYE PANDORA LISTENER**************************************");
  }//end of main
}//end of class
