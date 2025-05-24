// src/StudentPerformanceAnalysis.java

import java.util.*;

class Student {
    String name;
    double[] scores;
    double attendance;

    Student(String name, double[] scores, double attendance) {
        this.name = name;
        this.scores = scores;
        this.attendance = attendance;
    }

    double getAverageScore() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return scores.length > 0 ? sum / scores.length : 0;
    }

    String getPerformanceGrade() {
        double avg = getAverageScore();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }
}

public class StudentPerformanceAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter data for Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter number of subjects: ");
            int numSubjects = scanner.nextInt();
            double[] scores = new double[numSubjects];

            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Score for subject " + (j + 1) + ": ");
                scores[j] = scanner.nextDouble();
            }

            System.out.print("Attendance percentage: ");
            double attendance = scanner.nextDouble();
            scanner.nextLine();

            students.add(new Student(name, scores, attendance));
        }

        System.out.println("\n=== Student Performance Report ===");
        for (Student s : students) {
            System.out.printf("\nName: %s\n", s.name);
            System.out.printf("Average Score: %.2f\n", s.getAverageScore());
            System.out.printf("Attendance: %.1f%%\n", s.attendance);
            System.out.printf("Grade: %s\n", s.getPerformanceGrade());

            if (s.attendance < 75) {
                System.out.println("⚠ Warning: Low Attendance");
            }
        }

        scanner.close();
    }
}

