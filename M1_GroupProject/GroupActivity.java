package com.example.M1_GroupProject;
import java.util.Scanner;

public class GroupActivity {
    // Student details
    static String studentName;
    static String studentID;
    static int numSubjects;
    static double[] grades;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            // Display menu
            System.out.println("\n=== STUDENT GRADING SYSTEM ===");
            System.out.println("A - Add student information");
            System.out.println("B - Compute Student Average");
            System.out.println("C - Display Student Information");
            System.out.println("D - Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'A':
                    addStudentInfo(scanner);
                    break;
                case 'B':
                    computeAverage();
                    break;
                case 'C':
                    displayStudentSummary();
                    break;
                case 'D':
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 'D');

        scanner.close();
    }

    // Method to add student information
    public static void addStudentInfo(Scanner scanner) {
        scanner.nextLine(); // Clear buffer

        // Validate Student Name
        do {
            System.out.print("Enter Student Name: ");
            studentName = scanner.nextLine().trim();
            if (studentName.isEmpty()) {
                System.out.println("Student Name cannot be empty. Please enter a value.");
            }
        } while (studentName.isEmpty());

        // Validate Student ID
        do {
            System.out.print("Enter Student ID: ");
            studentID = scanner.nextLine().trim();
            if (studentID.isEmpty()) {
                System.out.println("Student ID cannot be empty. Please enter a value.");
            }
        } while (studentID.isEmpty());

        // Validate number of subjects
        do {
            System.out.print("Enter number of subjects: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
            numSubjects = scanner.nextInt();
            if (numSubjects <= 0) {
                System.out.println("Number of subjects must be greater than 0.");
            }
        } while (numSubjects <= 0);

        grades = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter grade for subject " + (i + 1) + ": ");
                if(scanner.hasNextDouble()) {
                    double value = scanner.nextDouble();
                    if (value >= 0 && value <= 100) {
                        grades[i] = value;
                        break;
                    } else {
                        System.out.println("Grade must be between 0 - 100 ");
                    }
                } else {
                    System.out.println("Grade must be a numeric value");
                    scanner.next();
                }
            }
        }	 System.out.println("===== STUDENT SAVED ====");
    }


    // Method to compute average and pass/fail
    public static double computeAverage() {
        if (grades == null) {
            System.out.println("No student information found. Please add student info first.");
            return 0;
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / numSubjects;

        System.out.println("\nAverage: " + average);
        if (average >= 75) {
            System.out.println("Status: PASS");
        } else {
            System.out.println("Status: FAIL");
        }
        return average;
    }

    // Method to display student summary
    public static void displayStudentSummary() {
        if (studentName == null || studentID == null) {
            System.out.println("No student information found. Please add student info first.");
            return;
        }

        double average = computeAverage();
        String status = (average >= 75) ? "PASS" : "FAIL";

        System.out.println("\n===== STUDENT SUMMARY =====");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Average Grade: " + average);
        System.out.println("Status: " + status);
        System.out.println("===========================");
    }


}