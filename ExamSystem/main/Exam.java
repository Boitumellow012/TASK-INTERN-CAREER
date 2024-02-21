package ExamSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam {
    private String title;
    private int duration;
    private List<Question> questions;
    private boolean started;
    private List<String> answers;
    private Scanner scanner;

    public Exam(String title, int duration) {
        this.title = title;
        this.duration = duration;
        this.questions = new ArrayList<>();
        this.started = false;
        this.answers = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void startExam() {
        if (!started) {
            started = true;
        } else {
            System.out.println("Exam has already started.");
        }
    }

    public void displayQuestions() {
        if (started) {
            System.out.println("Exam: " + title);
            for (int i = 0; i < questions.size(); i++) {
                System.out.println("Question " + (i + 1) + ": " + questions.get(i).getQuestion());
                // You can add more logic here to display options for multiple choice questions
            }
        } else {
            System.out.println("Exam has not started yet.");
        }
    }

    public void submitExam() {
        if (started) {
            System.out.println("Submitting exam...");
            int totalQuestions = questions.size();
            int correctAnswers = 0;

            // You can add logic here to collect answers from the student
            // For simplicity, let's assume the student enters answers interactively
            for (int i = 0; i < totalQuestions; i++) {
                System.out.println("Question " + (i + 1) + ": " + questions.get(i).getQuestion());
                System.out.println("Enter your answer:");
                String answer = scanner.nextLine();
                answers.add(answer);

                // Check if the answer is correct
                if (answer.equalsIgnoreCase(questions.get(i).getCorrectAnswer())) {
                    correctAnswers++;
                }
            }

            // Calculate score
            double score = ((double) correctAnswers / totalQuestions) * 100;

            // Provide feedback and score to the student
            System.out.println("Exam submitted successfully.");
            System.out.println("Total questions: " + totalQuestions);
            System.out.println("Correct answers: " + correctAnswers);
            System.out.println("Score: " + score);
        } else {
            System.out.println("Exam has not started yet.");
        }
    }
}