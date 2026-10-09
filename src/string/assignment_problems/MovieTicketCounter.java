
import java.util.Scanner;

abstract class Ticket {
    static final double FEE = 20.0;
    abstract double getPrice();

    double getTotal(int count) {
        return (getPrice() + FEE) * count;
    }
}

class Regular extends Ticket {
    double getPrice() {
        return 150.0;
    }
}

class Premium extends Ticket {
    double getPrice() {
        return 250.0;
    }
}

class Recliner extends Ticket {
    double getPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();
            Ticket t;

            switch (seat) {
                case "REGULAR": t = new Regular(); break;
                case "PREMIUM": t = new Premium(); break;
                case "RECLINER": t = new Recliner(); break;
                default:
                    System.out.println("Invalid seat type");
                    continue;
            }

            double amount = t.getTotal(count);
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}