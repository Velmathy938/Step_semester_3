package string.practice_problems;

import java.util.Scanner;

abstract class Question {
    double points;

    Question(double points) {
        this.points = points;
    }

    abstract double getScore(String answer);
}

class MCQ extends Question {
    String correctAnswer;

    MCQ(String correctAnswer, double points) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    double getScore(String answer) {
        return answer.equals(correctAnswer) ? points : 0;
    }
}

class TF extends Question {
    String correctAnswer;

    TF(String correctAnswer, double points) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    double getScore(String answer) {
        return answer.equals(correctAnswer) ? points : 0;
    }
}

class Essay extends Question {
    String keywords;

    Essay(String keywords, double points) {
        super(points);
        this.keywords = keywords;
    }

    double getScore(String answer) {
        String[] words = keywords.split(",");
        int count = 0;

        for (String word : words) {
            if (answer.toLowerCase().contains(word.toLowerCase().trim())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.5;
        if (count == 1)
            return points * 0.25;

        return 0;
    }
}

public class ExaminationQuestionGrader {

    static Question createQuestion(String type, String correct,
                                   String keywords, double points) {
        switch (type) {
            case "MCQ":
                return new MCQ(correct, points);
            case "TF":
                return new TF(correct, points);
            default:
                return new Essay(keywords, points);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] p = line.split("\"");

            String[] first = p[0].trim().split("\\s+");
            String type = first[0];
            double points = Double.parseDouble(first[first.length - 1]);

            String correct = p[3].trim();
            String keywords = "";

            if (type.equals("ESSAY"))
                keywords = p[1].trim();

            Question q = createQuestion(type, correct, keywords, points);
            double score = q.getScore(correct);

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}