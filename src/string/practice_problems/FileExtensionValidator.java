
package string.practice_problems;

import java.util.Scanner;

public class FileExtensionValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter expected extension: ");
        String expectedExtension = sc.nextLine();

        int dotPosition = fileName.lastIndexOf('.');

        if (dotPosition != -1) {

            String extension = fileName.substring(dotPosition + 1);

            if (extension.equalsIgnoreCase(expectedExtension)) {
                System.out.println("Valid extension");
            } else {
                System.out.println("Invalid extension");
            }

        } else {

            System.out.println("No extension found");
        }

        sc.close();
    }
}
