import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks for each subject
        System.out.print("Enter Marks for Subject 1 (out of 100): ");
        double subject1 = scanner.nextDouble();

        System.out.print("Enter Marks for Subject 2 (out of 100): ");
        double subject2 = scanner.nextDouble();

        System.out.print("Enter Marks for Subject 3 (out of 100): ");
        double subject3 = scanner.nextDouble();

        // Calculate total marks
        double totalMarks = subject1 + subject2 + subject3;

        // Calculate average percentage
        double averagePercentage = totalMarks / 3;

        // Determine letter grade
        char letterGrade = calculateLetterGrade(averagePercentage);

        // Display results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Letter Grade: " + letterGrade);

        scanner.close();
    }

    // Method to calculate letter grade based on average percentage
    private static char calculateLetterGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
