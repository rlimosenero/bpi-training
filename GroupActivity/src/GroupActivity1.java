package src;

import java.util.Scanner;

public class GroupActivity1 {
	public static String[][] student_grades;
	public static String[][] student_info;
	public static int student_num = 0, loopin = 0, valid_num_sub = 0, valid_sub_grade = 0, computed_grades = 0, max_subj = 0;
	
	public static void main(String[] args) {
		student_info = new String[10][3];
		student_grades = new String[10][10];
		choices();
		System.out.print("EXIT");
	}
	
	public static void choices() {
		while (loopin == 0) {
			Scanner choice_menu = new Scanner(System.in);
			print_menu();
			System.out.print("Enter choice: ");
			String choice = choice_menu.nextLine().toUpperCase();
			switch (choice) {
	        	case "A":
	        		if (student_num == 10) {
	        			System.out.print("===== MAXIMUM OF 10 STUDENT ONLY =====\n");
	        		} 
	        		else {
	        			add_student_info();
	        		}
	        		break;
	        	case "B":
	        		computed_grades = 1;
	        		compute_student_average();
	        		break;
	        	case "C":
	        		display_studen_info();
	        		break;
	        	case "D":
	        		loopin = 1;
	        		break;
	        	default:
	        		System.out.println("Invalid choice. Please select A, B, C, or D.");
	        	}
			} 
	}
	
	public static void print_menu() {
        System.out.print("===== STUDENT GRADING SYSTEM =====\n");
        System.out.print("A : Add Student Information\n");
        System.out.print("B : Compute Student Average\n");
        System.out.print("C : Display Student Information\n");
        System.out.print("D : Exit\n");
	}
	
	public static void add_student_info() {
		Scanner stud_name = new Scanner(System.in);
        System.out.print("Enter Student Name : ");
        student_info[student_num][0] = stud_name.nextLine();
        
        Scanner stud_id = new Scanner(System.in);
        System.out.print("Enter Student ID : ");
        student_info[student_num][1] = stud_id.nextLine();
        
        while (valid_num_sub == 0) {
        	process_subject();
        }

        System.out.print("===== STUDENT SAVED =====\n");
        valid_num_sub = 0 ;
        student_num = student_num + 1;
        choices();
	}
	
	public static void compute_student_average() {
		if (student_num != 0 ) {
			double sum_subject = 0;
	        System.out.print("===== STUDENT GRADING SYSTEM =====\n");
	        for (int j = 0; j < student_num; j++) {
	        	for (int k = 0; k < Integer.parseInt(student_info[j][2]); k++) {
	        		sum_subject = sum_subject + Integer.parseInt(student_grades[j][k]);
	        	}
	        	sum_subject = sum_subject / Double.parseDouble(student_info[j][2] + "\n");
	        	System.out.print("Student Name : " + student_info[j][0] + "\n");
	        	System.out.print("Avarage Grade : " + sum_subject + "\n");
	        	if (sum_subject >= 75) {
	        		System.out.print("STATUS : PASS" + "\n");
	        	}else {
	        		System.out.print("STATUS : FAIL" + "\n");
	        	}
	        	System.out.print("===========================\n");
	    		sum_subject = 0;
	        }
        }
		else {
			System.out.print("===== No Student Data =====\n");
		}
		
	}
	
	public static void display_studen_info() {
		if (student_num != 0 ) {
	        System.out.print("===== STUDENT SUMMARY =====\n");
	        double sum_subject = 0;
	        for (int j = 0; j < student_num; j++) {
	        	for (int k = 0; k < Integer.parseInt(student_info[j][2]); k++) {
	        		sum_subject = sum_subject + Integer.parseInt(student_grades[j][k]);
	        	}
	        	sum_subject = sum_subject / Double.parseDouble(student_info[j][2] + "\n");
	        	System.out.print("Student Name : " + student_info[j][0] + "\n");
	        	System.out.print("Student ID : " + student_info[j][1] + "\n");
	        	if (computed_grades == 1) {
		        	System.out.print("Avarage Grade : " + sum_subject + "\n");
		        	if (sum_subject >= 75) {
		        		System.out.print("STATUS : PASS" + "\n");
		        	}else {
		        		System.out.print("STATUS : FAIL" + "\n");
		        	}
	        	}
	        	else {
	        		System.out.print("Avarage Grade : 0.0\n");
	        	}
	        	System.out.print("===========================\n");
	    		sum_subject = 0;
	        }
        }
		else {
			System.out.print("===== No Student Data =====\n");
		}			
	}
	
	public static void process_subject() {
		Scanner num_subject = new Scanner(System.in);
        System.out.print("Enter Number of Subject/s : ");
        if (num_subject.hasNextInt()) {
            student_info[student_num][2] = num_subject.nextLine();	
	        int num_subjects = Integer.parseInt(student_info[student_num][2]);
	        if (num_subjects > 10) {
	        	System.out.print("===== MAXIMUM OF 10 SUBJECTS ONLY =====\n");
	        }
	        else {
		        for (int i = 0; i < num_subjects; i++) {
			        while (valid_sub_grade == 0) {
				        Scanner subjects = new Scanner(System.in);
			        	System.out.print("Enter grade for subject " + (i + 1) + " : ");
			        	if (subjects.hasNextInt()) {
				        	student_grades[student_num][i] = subjects.nextLine();
				        	valid_sub_grade = 1 ;
			        	}else {
			        		System.out.print("===== Invalid input for Grade for subject " + (i + 1) + "=====\n");
			        	}
			        }
			        valid_sub_grade = 0 ;
		        }
		        valid_num_sub = 1 ;
	        }
        }else {
        	System.out.print("===== Invalid input for Number of Subject! =====\n");
        }		
	}
}
