package string.practice_problems;

import java.util.Scanner;

public class BankTransactionReferenceGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter transaction amount: ");
        String amount = sc.nextLine();

        String reference = "TXN" + accountNumber.substring(accountNumber.length() - 4) + amount;

        System.out.println("Transaction Reference: " + reference);

        if (reference.startsWith("TXN")) {
            System.out.println("Valid transaction reference");
        } else {
            System.out.println("Invalid transaction reference");
        }

        sc.close();
    }
}