
package string.assignment_problems;

import java.util.Scanner;

public class DigitSumNumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int sum = 0;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;

            sum = sum + digit;
            reverse = reverse * 10 + digit;

            num = num / 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);

        sc.close();
    }
}
