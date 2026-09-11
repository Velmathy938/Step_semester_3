package string.assignment_problems;

import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    public static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() >= 3) {
            code = code.substring(0, 3).toUpperCase()
                    + code.substring(3);
        }

        return code;
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: ISBN body must contain only digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(publisher)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String raw = sc.nextLine();

        String normalizedCode = normalizeCode(raw);

        System.out.println(validateAndFormat(normalizedCode));

        sc.close();
    }
}
