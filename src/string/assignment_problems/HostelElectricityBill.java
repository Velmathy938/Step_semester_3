package string.assignment_problems;

import java.util.Scanner;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double getBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    double getBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double getBill() {
        return (units * 6) / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(int units) {
        super(units);
    }

    double getBill() {
        return units * 10 + 200;
    }
}

public class HostelElectricityBill {

    static Room createRoom(String type, int units, int occupants) {
        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                return new SharedRoom(units, occupants);
            case "AC":
                return new AcRoom(units);
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
            int units = sc.nextInt();
            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room = createRoom(type, units, occupants);
            double bill = room.getBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
