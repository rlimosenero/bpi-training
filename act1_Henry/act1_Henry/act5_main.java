package act1_Henry;

public class act5_main {
  
    // Method to calculate the sum from 1 to 50
    public static int calculateSum() {
        int sum = 0;
        for (int i = 1; i <= 50; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = calculateSum();
        System.out.println("When I add the numbers 1 to 50...");
        System.out.println("The sum is " + result);
    }

}
