package com.bpi.group5;




import java.util.Scanner;
//import com.bpi.group5.Student;


public class BasicGroupStudent {
	//constant variables
	static String pass = "PASS";
	static String fail = "FAIL";
	static int passingGrade = 75;
	
	
	
	//global variables
	static String varStudentName = "";
	static String varStudentId = "";
	static double[] varStudentGrades = null;
	static double varStudentAvg = 0;
	static String varStudentStatus = "";
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);
    	String tempInput;
		

    	char option;
        do {
        	//always display the menu
        	displayStudentMenu();
        	
        	System.out.print("Enter choice: ");
        	tempInput = input.nextLine().trim().toUpperCase();
        	
        	
        	//check the encoded option
        	if ((tempInput == null) || (tempInput.length() != 1) ) {
        		//set to 0 to make it an invalid choice
        		option = "0".charAt(0);
        	} else {
        		option = tempInput.charAt(0);
        	}
        	
        	
        	//check option
            switch (option) {
	            case 'A':
	            	addStudentInfo(input);
	                break;
	
	            case 'B':
	                if (varStudentGrades == null) {
	                    System.out.println("No student information recorded. Please select option A in the menu.");
	                } else {
	                	varStudentAvg = computeStudentAverage(varStudentGrades);
	                	varStudentStatus = checkStudentStatus(varStudentAvg);
	                }
	                break;
	
	            case 'C':
	                displayStudentInfo();
	                break;
	
	            case 'D':
	                System.out.println("Thank you!");
	                break;
	
	            default:
	                System.out.println("Invalid choice. Please try again.");
            } // end of switch statement

        } while (option != 'D');
        
        
        //close the Scanner
        input.close();
        
        //setting back to null for more efficient gc
    	varStudentName = null;
    	varStudentId = null;
    	varStudentGrades = null;
    	varStudentStatus = null;
		
	}

	
	
	/*
	 * MAIN MENU
	 */
	private static void displayStudentMenu() {
		System.out.println();
        System.out.println("===== STUDENT GRADING SYSTEM =====");
        System.out.println("A - Add Student Information");
        System.out.println("B - Compute Student Average");
        System.out.println("C - Display Student Information");
        System.out.println("D - Exit");
	}

	
	/*
	 * Option A
	 * Add student information and grades
	*/
	private static void addStudentInfo(Scanner input) {
        System.out.print("Enter student name: ");
        varStudentName = input.nextLine();
        
        System.out.print("Enter student ID: ");
        varStudentId = input.nextLine();

        System.out.print("Enter number of subjects: ");
        int cnt = input.nextInt();

        varStudentGrades = new double[cnt];

        for (int i = 0; i < cnt; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            varStudentGrades[i] = input.nextDouble();
        }

        varStudentAvg = 0;
        varStudentStatus = null;
        
        
        System.out.println("========== STUDENT SAVED =========");

	}
	

	/* 
	 * Option B 
	 * Part 1 - Compute Student Average
	*/
	private static double computeStudentAverage(double[] grades) {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];   //same with sum = sum + grades[i];
        }
        double avg = sum / grades.length;
        System.out.println("Average: " + avg);
        return avg;

	}

	
	/* 
	 * Option B 
	 * Part 2 - Check Student Status
	*/
	private static String checkStudentStatus(double avg) {
		String status;
		status = (avg >= passingGrade) ? pass : fail;
        System.out.println("Status: " + status);
        return status;
	}
	
	
	/* 
	 * Option C 
	 * Display Student Info 
	*/
	private static void displayStudentInfo() {
        if (varStudentGrades == null) {
            System.out.println("No student information recorded. Please select option A in the menu.");
            return;
        }
        
        if (varStudentStatus == null) {
            System.out.println("Please compute the average first (select option B in the menu).");
            return;
        }
        
    	
        System.out.println();
        System.out.println("========= STUDENT SUMMARY ========");
        System.out.println("Student Name: " + varStudentName);
        System.out.println("Student ID: " + varStudentId);
        System.out.println("Average Grade: " + varStudentAvg);
        System.out.println("Status: " + varStudentStatus);
        System.out.println("==================================");

		
		
	}
	
	
}
