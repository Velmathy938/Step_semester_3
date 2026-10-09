
import java.util.Scanner;

interface NightService {
    double getNightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double getFare() {
        return Math.max(100, km * getRate());
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double getNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double getNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            if (time.equals("NIGHT") && type.equals("MINI")) {
                System.out.println("MINI: night service not available");
                continue;
            }

            Cab c;

            switch (type) {
                case "MINI": c = new Mini(km); break;
                case "SEDAN": c = new Sedan(km); break;
                case "SUV": c = new SUV(km); break;
                default:
                    System.out.println("Invalid cab type");
                    continue;
            }

            double fare = c.getFare();

            if (time.equals("NIGHT") && c instanceof NightService) {
                fare = ((NightService) c).getNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
