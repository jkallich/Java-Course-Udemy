/* Unit 3, Program 10
 * Jahnavi Kallichanda
 *
 * 9/13/2021
 *
 * prints a pyramid of stars with some number of rows specified by the user (with input)
 */

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        int cols = rows * 2 - 1;
        int numStars = 1;
        for (int i = 0; i < rows; i++){
                for (int s = 0; s < (cols - numStars) / 2; s++) {
                    System.out.print(" ");
                }
                for (int t = 0; t < numStars; t++) {
                    System.out.print("*");
                }
                for (int s = 0; s < (cols - numStars) / 2; s++) {
                    System.out.print(" ");
                }

            numStars += 2;
            System.out.println();
        }
    }
}