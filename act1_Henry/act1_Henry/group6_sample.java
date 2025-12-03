package act1_Henry;

import java.util.Scanner;

public class group6_sample {

    // Define and initialize global variables
    static String studentName = "";
    static int studentId = 0;
    static double[] grades = null;
    static double average = 0.0;
    static String status = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char choice;
        do {
            displayMenu();
            System.out.print("Enter choice: ");
            choice = input.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'A':
                    inputStudentInfo(input);
                    break;

                case 'B':
                    if (grades == null) {
                        System.out.println("Please enter student info first (Option A).");
                    } else {
                        average = computeAverage(grades);
                        status = getStatus(average);
                        System.out.println("Average: " + average);
                        System.out.println("Status: " + status);
                    }
                    break;

                case 'C':
                    displayStudentInfo();
                    break;

                case 'D':
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            } // end of switch statement

        } while (choice != 'D');

        input.close();
    } // end of main method

    // Displays the menu
    static void displayMenu() {
        System.out.println("\n===== STUDENT GRADING SYSTEM =====");
        System.out.println("A - Add Student Information");
        System.out.println("B - Compute Student Average");
        System.out.println("C - Display Student Information");
        System.out.println("D - Exit");
    } // end of displayMenu method

    // Input student details and grades
    static void inputStudentInfo(Scanner input) {
        System.out.print("Enter student name: ");
        input.nextLine();
        studentName = input.nextLine();

        System.out.print("Enter student ID: ");
        studentId = input.nextInt();

        System.out.print("Enter number of subjects: ");
        int count = input.nextInt();

        grades = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            grades[i] = input.nextDouble();
        }

        System.out.println("===== STUDENT SAVED =====");
    } // end of inputStudentInfo method

    // Compute average grade
    static double computeAverage(double[] grades) {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    } // end of computeAverage method

    // Determine if pass or fail
    static String getStatus(double avg) {
        return (avg >= 75) ? "PASS" : "FAIL";
    } // end of getStatus method

    // Display student details
    static void displayStudentInfo() {
        if (grades == null) {
            System.out.println("No student data yet. Please choose option A in the menu.");
            return;
        }

        System.out.println("\n===== STUDENT SUMMARY =====");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Average Grade: " + average);
        System.out.println("Status: " + status);
        System.out.println("===========================");
    } // end of displayStudentInfo method

} // end of BasicJavaGroupProject class
