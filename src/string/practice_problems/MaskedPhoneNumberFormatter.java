package string.practice_problems;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        if (phoneNumber.length() >= 4) {

            int length = phoneNumber.length();
            String lastFour = phoneNumber.substring(length - 4);

            String masked = "*".repeat(length - 4) + lastFour;

            System.out.println("Masked phone number: " + masked);

        } else {

            System.out.println("Invalid phone number");
        }

        sc.close();
    }
}