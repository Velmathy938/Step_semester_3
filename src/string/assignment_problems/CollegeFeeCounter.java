

import java.util.Scanner;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getFee();

    boolean isBusEligible() {
        return false;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + (isBusEligible() ? 12000 : 0);
    }

    boolean isBusEligible() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double getFee() {
        return 20000 + (isBusEligible() ? 12000 : 0);
    }

    boolean isBusEligible() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            switch (type.toUpperCase()) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    s = new Scholar(name);
                    break;
                default:
                    System.out.println("Invalid student type");
                    continue;
            }

            double fee = s.getFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}