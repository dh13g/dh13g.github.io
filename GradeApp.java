/** This is a grade average application where the program asks the user to input grades. It will keep asking the user to input grades until 
-1 is entered. Then it will calculate the total percent average grade. **/

import java.util.*;

public class GradeApp {
    public static void main(String[] args){

 	System.out.println("Please enter grades that range from 0 to 100.");
 	System.out.println("Grade average and total is rounded to 2 decimal places.");
 	System.out.println("Note: Program does not *not* check for non-numeric characters.");
 	System.out.println("To end program enter -1.\n");


 	int count = 0;
 	double grade = 0.0;
 	double sum = 0.0;

 	Scanner sc = new Scanner (System.in);
 	
 	while (grade != -1){  								//loops until user inputs -1

	System.out.print("Enter grade: ");		
    grade = sc.nextDouble();							//User inputs grade
 	
 	
 		if (grade <= 100.0 && grade >= 0.0){			//Grades that are between 0 and 100
 			sum += grade;
 			count++;
 		}
 		else if (grade > 100.0 || grade < -1){			//Grades that are not between -1 and 100
 			System.out.println ("Invalid entry, not counted.");
 		}
 		
 		else if (grade == -1){							//When the user inputs -1
 		    System.out.print("\n");
 			System.out.println("Grade count:   " + count);
 			System.out.printf("Grade total:   %.2f", sum);
 			System.out.print("\n");
 			System.out.printf("Average grade: %.2f", sum / count);
 			System.out.println("\n");
 		}
        
 	}//end of for loop

    }//end of main
}//end of class
