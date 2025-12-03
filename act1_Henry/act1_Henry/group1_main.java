package act1_Henry;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class group1_main {

	public static void showMenuScreen2() {
    	// Display the main screen
		group1_main obj = new group1_main();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*          GROUP6'S STUDENT GRADING SYSTEM        *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*            A | UPDATE STUDENT INFO              *");
        System.out.println("*            B | COMPUTE STUDENT AVERAGE          *");
        System.out.println("*            C | DISPLAY STUDENT INFO             *");
        System.out.println("*            D | EXIT                             *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        // Ask for an input
      //  obj.choiceMain = obj.scanner.next();
    }
	
    public static void main(String[] args) {

	String firstName = "", tempSubject = "";
	Double tempGrades = 0.0;
	int subjectCount = 0;
    Map<String, Double> subjectGrades = new HashMap<>();
	
	 while (true) {
    	// Display the main screen
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*          GROUP6'S STUDENT GRADING SYSTEM        *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*            A | ADD STUDENT INFO                 *");
        System.out.println("*            B | COMPUTE STUDENT AVERAGE          *");
        System.out.println("*            C | DISPLAY STUDENT INFO             *");
        System.out.println("*            D | EXIT                             *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        // Ask for an input
        System.out.print("* Hello there! How can I help? --> ");
        Scanner scanner = new Scanner(System.in);
        String choiceMain = scanner.next();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        
        switch (choiceMain.toUpperCase()) {
        case "A":
        	if(firstName == "") {

                // codes for adding the student
            	System.out.println("You selected A.");
            	firstName = "AAA";

                System.out.println("* SUBJECT:                                        *");
                System.out.println("* How many subjects do you have?");
         
                Scanner scanner1 = new Scanner(System.in);
                subjectCount = Integer.parseInt(scanner1.next());
                // scanner1.close();

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                for (int i = 0; i < subjectCount; i++) {
                	
                    Scanner scanner2 = new Scanner(System.in);
                    

                    System.out.println("* What's your Subject " + i + "?");
                    tempSubject = scanner2.next();
                   
                    // scanner2.close();

                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    
                    Scanner scanner3 = new Scanner(System.in);

                    System.out.println("* Your grade in [" + tempSubject + "]?");
                    tempGrades = Double.parseDouble(scanner3.next());
                    //  scanner3.close();
                	
                	subjectGrades.put(tempSubject, tempGrades);

                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
				}
                
                System.out.println("* Thanks Henry! Save complete!                    *");
                System.out.println("* Returning to the main menu                      *");

            	
        	} else {

            	// codes for updating the student
            	System.out.println("You selected A pa rin.");
            	firstName = "";
        	}
        	
            continue;
        case "B":
            // codes to show average (bakit compute ung tawag e auto na un?)
            System.out.println("You selected B.");
            

            double sum = 0.0;
            int count = 0;

            for (double value : subjectGrades.values()) {
                sum += value;
                count++;
            }

            double average = (count > 0) ? sum / count : 0.0;

            System.out.println("Average = " + average);

            continue;
        case "C":
            // codes to display student info, kung ano man nainput sa A
            System.out.println("You selected C.");
            continue;
        case "D":
            System.out.println("* Removing temporary information in the system... *");
            System.out.println("* Thank you, see you again soon!                  *");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            return;
        default:
            System.out.println("Invalid choice. Please select A, B, C, or D.");
            continue;
            
        }
	 

    }
    }
}
