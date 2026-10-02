package string.practice_problems;

import java.util.Scanner;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double getFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double getFare() {
        return 1.00 + 0.15 * distance;
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double getFare() {
        return 2.50 + 0.16 * distance;
    }
}

class Metro extends Transport {
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double getFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class TransportFareCalculator {

    static Transport createTransport(String type, double distance,
                                     double factor) {
        switch (type) {
            case "BUS":
                return new Bus(distance);
            case "TRAIN":
                return new Train(distance);
            case "METRO":
                return new Metro(distance, factor);
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
            double distance = sc.nextDouble();
            double factor = 1.0;

            if (type.equals("METRO")) {
                factor = sc.nextDouble();
            }

            Transport transport =
                    createTransport(type, distance, factor);

            double fare = transport.getFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
