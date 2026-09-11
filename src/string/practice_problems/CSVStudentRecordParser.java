package string.practice_problems;

import java.util.Scanner;

public class CSVStudentRecordParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String record = sc.nextLine();

        String[] fields = record.split(",");

        if (fields.length == 3) {

            String rollNumber = fields[0].trim();
            String name = fields[1].trim();
            String marks = fields[2].trim();

            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);

        } else {

            System.out.println("Invalid record");
        }

        sc.close();
    }
}