package act1_Henry;

import java.util.Scanner;

public class act2_main {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their age as a String
        System.out.print("Enter your age: ");
        String ageString = scanner.nextLine();

        // Convert the String into an int
        int ageInt = Integer.parseInt(ageString);

        // Convert the int into a double
        double ageDouble = (double) ageInt;

        // Display both the int and double versions of the age
        System.out.println("Age as int: " + ageInt);
        System.out.println("Age as double: " + ageDouble);

        // Close the scanner
        scanner.close();
    }
}
