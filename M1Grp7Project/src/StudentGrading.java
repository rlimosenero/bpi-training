
import java.util.Scanner;

public class StudentGrading {

    public static Scanner scanner = new Scanner(System.in);

    public static class GradeResult {
        double average_grade;
        String status;

        public GradeResult(double aveGrade, String status) {
            this.average_grade = aveGrade;
            this.status = status;
        } //GradeResult

    } //GradeResult()

    public static class Student {
        String name;
        String id;
        double[] grades;

        public Student(String name, String id, double[] grades) {
            this.name = name;
            this.id = id;
            this.grades = grades;
        } // Student();

        public GradeResult compute_student_average_grade() {

            double ave_grade = 0.00;
            double sum_of_grade = 0.00;
            for (int i = 0; i < this.grades.length ; i++) {
                sum_of_grade += this.grades[i];
            }
            String status = "";
            ave_grade = sum_of_grade / this.grades.length;
            if (ave_grade < 75.0)
                status = "FAIL";
            else
                status = "PASS";

            return new GradeResult(ave_grade, status);

        } //compute_student_average_grade

        public void display_student_computed_ave_grade() {
            GradeResult results = compute_student_average_grade();
            System.out.printf("Average: %.2f%n", results.average_grade);
            System.out.println("Status: " + results.status);
        } //display_student_computed_ave_grade

        public void display_student_info() {
            System.out.println("\n===== STUDENT SUMMARY =====");
            System.out.println("Student Name: " + this.name);
            System.out.println("Student ID: " + this.id);
            GradeResult results = compute_student_average_grade();
            System.out.printf("Average Grade: %.2f%n", results.average_grade);
            System.out.println("Status: " + results.status);
            System.out.println("=============================");

        } //display_student_info()

    } //Student()

    public static void show_menu(){
        System.out.println("\n===== STUDENT GRADING SYSTEM =====");
        System.out.println("A - Add Student Information");
        System.out.println("B - Compute Student Average");
        System.out.println("C - Display Student Information");
        System.out.println("D - Exit");
        System.out.print("Enter choice: ");
    } //show_menu()

    public static Student get_student_info() {
        System.out.print("Enter Student Name: ");
        String student_name = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String student_id = scanner.nextLine();
        System.out.print("Enter number of subjects: ");
        int student_no_subjects = scanner.nextInt();

        double[] grades = new double[student_no_subjects];
        for(int i = 0; i < student_no_subjects; i++){
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        } // for

        // Consume the leftover newline so the next menu input works correctly
        scanner.nextLine();

        System.out.println("===== STUDENT SAVED =====");
        return new Student(student_name,student_id,grades);

    } //get_student_info

    public static void main(String[] args) {

        boolean exit = false;
        Student a_student = null;

        while (!exit) {
            show_menu();
            String user_choice = scanner.nextLine();
            switch (user_choice.toUpperCase()) {
                case "A":   a_student = get_student_info();
                            break;
                case "B":   if(a_student == null) System.out.println("No student data yet. Please choose option A in the menu.");
                            else a_student.display_student_computed_ave_grade();
                            break;
                case "C":   if(a_student == null) System.out.println("Please enter student info first (Option A)");
                            else a_student.display_student_info();
                            break;
                case "D": exit = true;
                            break;
            } //switch
        } // while

    } //main
}
