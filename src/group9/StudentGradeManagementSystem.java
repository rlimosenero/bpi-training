package group9;

import java.util.Scanner;

public class StudentGradeManagementSystem {

	static String name = "";
	static int id = 0;
	static int num = 0;
	static double[] grade = new double[0];

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			char choice;
			do {
				displayMenu();

				System.out.print("\nEnter choice: ");
				choice = input.next().toUpperCase().charAt(0);

				switch (choice) {
				case 'A':
					addStudentInfo(input);
					break;
				case 'B':
					computeStudentAvg();
					break;
				case 'C':
					displayStudentInfo();
					break;
				case 'D':
					System.out.println("Exiting the program...");
					break;
				default:
					System.out.println("Invalid option. Please choose from A to D.");
				}
			} while (choice != 'D');

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void displayMenu() {
		System.out.println("\n===== Student Grading System =====");
		System.out.println("A - Add Student Information");
		System.out.println("B - Compute Student Average");
		System.out.println("C - Display Student Information");
		System.out.println("D - Exit");
	}

	private static void addStudentInfo(Scanner input) {
		try {
			input.nextLine();
			System.out.print("Enter student name: ");
			name = input.nextLine();
			System.out.print("Enter student ID: ");
			id = input.nextInt();
			System.out.print("Enter number of subjects: ");
			num = input.nextInt();

			grade = new double[num];

			for (int i = 0; i < num; i++) {
				System.out.print("Enter grade for subject " + (i + 1) + ": ");
				grade[i] = input.nextDouble();
			}

			System.out.println("===== STUDENT SAVED =====");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void computeStudentAvg() {
		if (grade.length == 0) {
			System.out.println("No student data found. Please add student information first.");
			return;
		}

		double sum = 0;
		for (double x : grade) {
			sum += x;
		}

		double avg = sum / num;
		System.out.println("Average: " + avg);

		String status = "";
		if (avg >= 75) {
			status = "PASS";
		} else {
			status = "FAIL";
		}
		System.out.println("Status: " + status);

	}

	private static void displayStudentInfo() {
		if (grade.length == 0) {
			System.out.println("No student data found. Please add student information first.");
			return;
		}

		System.out.println("\n===== STUDENT SUMMARY =====");
		System.out.println("Student Name: " + name);
		System.out.println("Student ID: " + id);

		double sum = 0;
		for (double x : grade) {
			sum += x;
		}

		double avg = sum / num;
		System.out.println("Average: " + avg);

		String status = "";
		if (avg >= 75) {
			status = "PASS";
		} else {
			status = "FAIL";
		}
		System.out.println("Status: " + status);
		System.out.println("=========================");

	}

}