package string.practice_problems;

import java.util.Scanner;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double getFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double getFee() {
        return 5 + 0.5 * weight + 0.1 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double getFee() {
        return 15 + weight + 0.2 * distance;
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double getFee() {
        return 25 + 2 * weight + 0.5 * distance + customsFee;
    }
}

public class DeliveryFeeCalculator {

    static Delivery createDelivery(String type, double weight,
                                   double distance, double customsFee) {
        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                return new InternationalDelivery(weight, distance, customsFee);
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
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customsFee = 0;

            if (type.equals("INTERNATIONAL")) {
                customsFee = sc.nextDouble();
            }

            Delivery delivery = createDelivery(
                    type, weight, distance, customsFee);

            double fee = delivery.getFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}