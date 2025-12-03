package act1_Henry;

import java.util.Scanner;

public class act3_main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for two integers
        System.out.println("Gimme a number: ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.println("Gimme another number: ");
        int b = Integer.parseInt(scanner.nextLine());

        // Compute results
        int sum = a + b;
        int diff = a - b;
        int product = a * b;
        
        // Output results
        System.out.println("\nResults:");
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Product: " + product);

        scanner.close();
    }
}

