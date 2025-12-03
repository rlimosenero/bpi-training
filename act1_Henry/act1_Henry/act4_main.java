package act1_Henry;

import java.util.Scanner;

public class act4_main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for age as a whole number
        System.out.print("Hello there! How young are you? ");
        String input = scanner.nextLine();

        // Convert to int (simple version assumes valid input)
        int age = Integer.parseInt(input);

        // Determine category
        String category;
        if (age < 18) {
            category = "a minor, good for you!";
        } else if (age <= 59) {
            category = "an adult, somehow.";
        } else {
            category = "a senior citizen!";
        }

        // Output result
        System.out.println("You are " + category);

        scanner.close();
    }
}
