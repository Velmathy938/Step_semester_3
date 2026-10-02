package string.practice_problems;

import java.util.Scanner;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double getFinalAmount();
}

class Card extends Payment {
    Card(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount * 1.02;
    }
}

class Wallet extends Payment {
    Wallet(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount * 1.01;
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount;
    }
}

public class PaymentSystemFeeCalculation {

    static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD":
                return new Card(amount);
            case "WALLET":
                return new Wallet(amount);
            case "BANKTRANSFER":
                return new BankTransfer(amount);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment = createPayment(type, amount);
            double finalAmount = payment.getFinalAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
