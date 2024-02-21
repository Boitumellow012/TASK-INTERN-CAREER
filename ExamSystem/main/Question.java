package ExamSystem;

public class Question {
    private String text;
    private QuestionType type;
    private String correctAnswer;

    public Question(String text, QuestionType type, String correctAnswer) {
        this.text = text;
        this.type = type;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public QuestionType getType() {
        return type;
    }

    public String getQuestion() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
