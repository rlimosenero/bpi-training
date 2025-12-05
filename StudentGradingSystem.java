package ph.com.bpi.hello;
import java.util.Scanner;

public class StudentGradingSystem {
		// * @param args
		
		public static String studname;
		public static int studID;
		public static int numSubjects;
		public static double[] grades;
		public static double average;
		public static String result;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			char option;
	 
			do
			{
				System.out.println("==== STUDENT GRADING SYSTEM =====");
				System.out.println("A - Add Student Information");
				System.out.println("B - Compute Student Average");
				System.out.println("C - Display Student Information");
				System.out.println("D - Exit");
				
				System.out.print("Enter Choice:");
			
					option = sc.next().toUpperCase().charAt(0);
					sc.nextLine();
					
					switch (option)
					{
					case 'A':
						addinfo(sc);
						break;
			        case 'B':
			        	computestudAve();
			        	break;
			        case 'C':
			        	displayStudInfo();
			        	break;
			        case 'D':
			        	System.out.println("Exiting");
			        	System.exit(0);
			        default:
			            System.out.println("Invalid option! Please try again.\n");
					}
			}
			while (option != 'D');
				sc.close();
	}
	public static void addinfo (Scanner sc)
	{
		System.out.print("Enter Student name:");
		 studname=sc.nextLine();
		
		System.out.print("Enter Student ID:");
		studID=sc.nextInt();
		
		System.out.print("Enter Number of Subject:");
			int numSubjects = sc.nextInt();
			grades = new double[numSubjects];
			
		for (int i=0; i < numSubjects; i++)
		{
			System.out.print("Enter Grade for Subject "+(i +1) +":");
			grades[i] = sc.nextDouble();
			//System.out.println(grades[i]);
		}
		sc.nextLine();
		System.out.println("=====STUDENT SAVED=====\n");
	 
	}
	public static void displayStudInfo()
	{	
		if(studname == null )
		{
			System.out.println("No record found");
			return;
		}
		System.out.println("===== STUDENT SUMMARY =====");
		System.out.println("Student Name: "+ studname);
		System.out.println("Student ID: "+ studID);
		System.out.println("Average Grade: "+average);
		System.out.println("Status: "+result);
		System.out.println("==================");
	}
	public static void computestudAve()
	{	
		if(grades == null )
		{
			System.out.println("No record found. Insert Record First");
			return;
		}
	 
		double sum = 0;
		
		for (double grade : grades)
		{
			sum+=grade;
			//System.out.println(grades.length);
		}
		average = sum / grades.length;
	 
		if (average < 75)
		{
			result="Failed";
		}
		else
			result="Passed";
		
		System.out.println("Average: "+ average);
		System.out.println("Status: "+ result);
	 
	}
}
