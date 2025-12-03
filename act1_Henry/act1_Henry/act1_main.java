package act1_Henry;

import java.util.Scanner;

public class act1_main {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their name
        System.out.print("Give me your name: ");
        String name = scanner.nextLine();

        // Output the name
        System.out.println("Hello there " + name + ". Nice to meet you!");

        // Close the scanner
        scanner.close();
    }
}
