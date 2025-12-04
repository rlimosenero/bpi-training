/**
 * 
 */
package student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    private static final double PASSING_MARK = 75.0;

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();
	
	    public static void main(String[] args) {
	        String choice;
	        do {
	            printMenu();
	            choice = readNonEmptyLine("Enter choice: ");
	            
	            switch (choice) {
	                case "A" -> addStudent();
	                case "B" -> computeGradesForStudent();
	                case "C" -> displayStudentDetails();
	                case "D" ->System.out.println("Exiting... Thank you!");
	                default -> System.out.println("Invalid choice. Please try again.");
	            }
	            System.out.println(); // spacer
	        } while (choice != "");
	    }

	    private static void printMenu() {
			System.out.println("==== STUDENT GRADING SYSTEM ====");
			System.out.println("A - Add Student Information ");
			System.out.println("B - Compute Student Average ");
			System.out.println("C - Display Student Information ");
			System.out.println("D - Exit ");
	    }	

	    private static void addStudent() {

	        String name = readNonEmptyLine("Enter student Name: ");	        
	        String id = readNonEmptyLine("Enter student ID: ");	   
	        
	        if (findStudentById(id) != null) {
	            System.out.println("A student with this ID already exists. Please use a unique ID.");
	            return;
	        }
	        
	        int subjectCount = readIntInRange("Enter number of subjects (1-20): ", 1, 20);

	        List<Double> grades = new ArrayList<>();
	        for (int i = 1; i <= subjectCount; i++) {
	            double grade = readDoubleInRange("Enter grade for Subject " + i + " : ", 0, 100);
	            grades.add(grade);
	        }
         
	        students.add(new Student(name, id, grades));
	        System.out.println("=====STUDENT SAVED=====.");
	        
	    }


	    private static void computeGradesForStudent() {
	        
	        if (students.isEmpty()) {
	            System.out.println("Please enter student info first (Option A).");
	            return;
	        }
	        
	         for(Student s : students) {
	        	if (!s.getGrades().isEmpty()) {
	        		double avg = s.computeAverage();
	        		boolean passed = s.isPassed(PASSING_MARK);
	        		System.out.printf("Average      : %.2f%n", avg);
	        		System.out.println("Status       : " + (passed ? "PASS" : "FAIL"));
	        	}
	        
	         }
	    }


	    private static void displayStudentDetails() {
	    	
	    	 if (students.isEmpty()) {
		            System.out.println("Please enter student info first (Option A).");
		            return;
		    }
	        System.out.println("\n===== STUDENT SUMMARY =====");	    
	        for (Student s: students) {
	        	System.out.print(s);
	        	if (!s.getGrades().isEmpty()) {
	        		double avg = s.computeAverage();
	        		boolean passed = s.isPassed(PASSING_MARK);
	        		System.out.printf("Average      : %.2f%n", avg);
	        		System.out.println("Status       : " + (passed ? "PASS" : "FAIL"));
	        	}
	        }
	    } 

	    // ---------- Helpers ----------

	    private static Student findStudentById(String id) {
	        for (Student s : students) {
	            if (s.getStudentId().equalsIgnoreCase(id.trim())) return s;
	        }
	        return null;
	    }

	    private static String readNonEmptyLine(String prompt) {
	        String line;
	        do {
	            System.out.print(prompt);
	            line = scanner.nextLine();
	            if (line == null) line = "";
	            line = line.trim();
	            if (line.isEmpty()) {
	                System.out.println("Input cannot be empty. Please try again.");
	            }
	        } while (line.isEmpty());
	        return line;
	    }

	    private static int readInt(String prompt) {
	        while (true) {
	            System.out.print(prompt);
	            try {
	                String line = scanner.nextLine();
	                return Integer.parseInt(line.trim());
	            } catch (NumberFormatException ex) {
	                System.out.println("Invalid integer. Please try again.");
	            }
	        }
	    }

	    private static int readIntInRange(String prompt, int min, int max) {
	        while (true) {
	            int val = readInt(prompt);
	            if (val < min || val > max) {
	                System.out.printf("Value must be between %d and %d.%n", min, max);
	            } else {
	                return val;
	            }
	        }
	    }

	    private static double readDoubleInRange(String prompt, double min, double max) {
	        while (true) {
	            System.out.print(prompt);
	            try {
	                String line = scanner.nextLine();
	                double val = Double.parseDouble(line.trim());
	                if (val < min || val > max) {
	                    System.out.printf("Value must be between %.2f and %.2f.%n", min, max);
	                } else {
	                    return val;
	                }
	            } catch (NumberFormatException ex) {
	                System.out.println("Invalid number. Please try again.");
	            }
	        }
	    }
}



