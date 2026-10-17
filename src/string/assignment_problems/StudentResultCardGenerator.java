
package string.assignment_problems;

import java.util.Scanner;

class ResultStudent {
    String name;
    int[] marks;

    ResultStudent(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return sum / 3.0;
    }

    char getGrade() {
        double avg = getAverage();

        if (avg >= 75) {
            return 'B';
        } else if (avg >= 60) {
            return 'C';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        int[] marks = new int[3];

        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }

        ResultStudent student = new ResultStudent(name, marks);

        System.out.printf("%s: Average %.1f, Grade %c%n",
                student.name.toUpperCase(),
                student.getAverage(),
                student.getGrade());

        sc.close();
    }
}
