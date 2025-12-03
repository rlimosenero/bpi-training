package act1_Henry;

import java.util.Scanner;
/* <Program Description>
 * Processing of grades is based on DepEd K-12 grading system 
 * (i.e. valid value for subject grade is 60-100 with decimal rounded off to whole number 
 */

/*
 - Displays program title.
- Displays menu choices that loops.
- Requests user input for menu choice then filters it for processing for A/B/C/D.
- With validation if menu choice is invalid.
- For process A (incomplete)
	- Requests user input for number of subjects.
	- Requests user input for grades that loops depending on number of subjects.
	- With validation of user inputs for number of subjects and grades.
	- Grades inputted are added up during the loop to get the total for computation of average grade.
- For process B (conditions and process not yet done)
- For process C (conditions and process not yet done)
- For process D
	- Stops the loop of program for the menu choice so user input is no longer requested.
	- Displays a goodbye message.
 */

public class group6_activity_joshua {


	private static Scanner input = new Scanner(System.in);
	
	private static int numberOfSubjects = 0;
	private static int totalOfGrades = 0;
	private static boolean allGradesValid = true;
	
	private static double averageGrade = 0;
	private static String academicStatus = "";
	
	public static void main(String[] args) {
		String menuChoice = "";
				
		group6_activity_joshua.displayProgramTitle();		
		do  {
			/* This loop is to repeat displaying menu, getting user's choice, and
			 * processing the choice while menu choice is not yet D (Exit)
			 */
			group6_activity_joshua.displayMenuChoices();
			menuChoice = group6_activity_joshua.getChoice();
			group6_activity_joshua.processChoice(menuChoice);
		} while (!menuChoice.equalsIgnoreCase("D"));
		
		input.close();
	}
	private static void displayProgramTitle() {		
		System.out.println("========== GROUP-6 STUDENT GRADING SYSTEM ===========");		
	}
	private static void displayMenuChoices() {		
		System.out.println("=====================================================");
		System.out.println("** Program Menu (Please choose from letters A - D) **");
		System.out.println("A - Add Student Information");
		System.out.println("B - Compute Student Average");
		System.out.println("C - Display Student Information");
		System.out.println("D - Exit");	
	}
	
	private static String getChoice() {		
		//Requests input from user from the menu choices
		String menuChoice = "";
		System.out.println();
		System.out.print("Enter menu choice: ");
		try {
			menuChoice = input.next();
		} catch (Exception e) {
			//If error is encountered from input for menu choice, set choice as empty string instead.
			menuChoice = "";
			input = new Scanner(System.in);
		}	
		return menuChoice;
	}
	
	private static void processChoice (String menuChoice) {
		//Check conditions based from user's choice then call method processChoice<letter>
		if (menuChoice.equalsIgnoreCase("A")) {
			// <Conditions then call method for choice A>
			processChoiceA();
			
		} else if (menuChoice.equalsIgnoreCase("B")) {
			// <Conditions then call method for choice  B>
			
			
		} else if (menuChoice.equalsIgnoreCase("C")) {
			// <Conditions then call method for choice  C>
			
			
		} else if (menuChoice.equalsIgnoreCase("D")) {
			//For choice D (Exit)
			System.out.println("=== Thank you for using the program. Goodbye \\(^_^) ===");	
		} else {
			System.out.println("=== You have entered an invalid choice. ===");
			System.out.println();
		}
	}
	
	private static void processChoiceA () {
		/* Check if there is already an existing Student Information. 
		 * If there is already existing, initialize variables related to choice A and B.
		 * Print that previous student record has been deleted.
		 */
		boolean withInvalidInput = false;
		numberOfSubjects = 0;
		
		System.out.print("Enter number of subjects: ");
		try {
			numberOfSubjects = input.nextInt();
			totalOfGrades = getTotalGrade(numberOfSubjects);
		} catch (Exception e) {
			//This is to catch error if input for number of subjects is not an integer.
			withInvalidInput = true;
			numberOfSubjects = 0;			
			input = new Scanner(System.in);
		} 	
		
		//This is to print that one of the grades or the number of subjects inputted is not valid and may require reinput
		if (!allGradesValid) {
			System.out.println("=== There's a grade with invalid value that is not a whole number or not within 60 - 100. === ");
			System.out.println("=== This will result to incorrect computations. === ");
			withInvalidInput = true;
		}		
		if (totalOfGrades == 0) {
			//This is to inform user if total grades is still in default value of 0, meaning no input was received for grades.
			System.out.println("=== No grades were saved.  === ");
			withInvalidInput = true;
		}
		if (numberOfSubjects < 1) {
			System.out.println("=== Please input a whole number greater than 0 for number of subjects.  === ");
			withInvalidInput = true;
		}
		if (withInvalidInput) {
			System.out.println("=== Choose 'A' from menu to reinput the student's information and grades. === ");
		}
		System.out.println();
	}
	
	private static int getTotalGrade(int numberOfSubjects) {
		/* This method is for requesting user to input the grades 
		 * which will loop based on the number of subjects.
		 * While also looping, the grades are added up to get the total.
		 * There is also a condition that will check if there is an invalid grade value.
		 */
		double subjectGrade = 0;		
		int roundedOffGrade = 0;
		int totalGrade = 0;
		allGradesValid = true;
		
		for (int i = 1; i <= numberOfSubjects; i++) {
			System.out.print("Enter grade for subject " + i + ": ");
			try {
				subjectGrade = input.nextDouble();
			} catch (Exception e) {
				//If input for grade is not a number, mark that there is an invalid grade then put a default valid value.
				allGradesValid = false;
				subjectGrade = 0;
				input = new Scanner(System.in);
			} 

			/* This is to check if all grades inputted are valid 
			 * in which 60 is the lowest grade and 100 is the highest.
			 */
			if (subjectGrade < 60 || subjectGrade > 100) {
				allGradesValid = false;
			}
			
			//Round off and parse grade to whole number for cases where user inputted grades with decimal
			roundedOffGrade = (int) Math.round(subjectGrade);
			
			//This is to add up the grades which will be used for computing average grade
			totalGrade += roundedOffGrade;
		}
		return totalGrade;
	}
	

	
	private static void processChoiceB () {
		

	}
	
	private static void processChoiceC () {
		

	}
}
