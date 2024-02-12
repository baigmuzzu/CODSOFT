import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    ArrayList<String> options;
    int correctOption;

    public QuizQuestion(String question, ArrayList<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApp {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static ArrayList<QuizQuestion> quizQuestions;
    private static Timer timer;

    public static void main(String[] args) {
        initializeQuiz();

        timer = new Timer();

        displayNextQuestion();

        // Allow the quiz to run for a certain duration (e.g., 30 seconds)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                displayResult();
            }
        }, 30000);
    }

    private static void initializeQuiz() {
        // Create quiz questions
        quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("What is the capital of France?", new ArrayList<>(List.of("A. Berlin", "B. Madrid", "C. Paris", "D. Rome")), 2));
        quizQuestions.add(new QuizQuestion("Which planet is known as the Red Planet?", new ArrayList<>(List.of("A. Mars", "B. Jupiter", "C. Venus", "D. Saturn")), 0));
        // Add more questions as needed
    }

    private static void displayNextQuestion() {
        if (currentQuestionIndex < quizQuestions.size()) {
            QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);

            System.out.println("Question: " + currentQuestion.question);
            for (String option : currentQuestion.options) {
                System.out.println(option);
            }

            // User input for selecting an option
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer (A, B, C, or D): ");
            String userAnswer = scanner.nextLine().toUpperCase();

            // Check user's answer
            checkAnswer(userAnswer, currentQuestion.correctOption);

            // Move to the next question
            currentQuestionIndex++;
            displayNextQuestion();
        } else {
            // Quiz is completed
            displayResult();
        }
    }

    private static void checkAnswer(String userAnswer, int correctOption) {
        if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
            int selectedOptionIndex = userAnswer.charAt(0) - 'A';
            if (selectedOptionIndex == correctOption) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + (char)('A' + correctOption));
            }
        } else {
            System.out.println("Invalid option. Please select A, B, C, or D.");
        }
    }

    private static void displayResult() {
        // Display final score and summary
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + quizQuestions.size());
        // Add more details if needed

        // Stop the timer
        timer.cancel();
        timer.purge();
    }
}
