package ExamSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OnlineExamSystem {
    private Map<String, User> users;
    private List<Exam> exams;
    private Scanner scanner;

    public OnlineExamSystem() {
        this.users = new HashMap<>();
        this.exams = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void registerUser() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase(); // Capitalize first letter

        // Check if the username already exists
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Select role:");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Role role = (roleChoice == 1) ? Role.STUDENT : Role.TEACHER;

        users.put(username, new User(username, password, role));
        System.out.println(username + " you have registered successfully. Now you can login.");
    }


    public User login(String username, String password) {
        username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase(); // Capitalize first letter
        User user = users.get(username);
        while (user == null || !user.getPassword().equals(password)) {
            System.out.println("Invalid username or password. Please try again.");
            System.out.println("Enter username:");
            username = scanner.nextLine();
            username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase(); // Capitalize first letter
            System.out.println("Enter password:");
            password = scanner.nextLine();
            user = users.get(username);
        }
        System.out.println("Welcome " + username + ". You have login successful.");
        return user;
    }


    public void createExam(User teacher) {
        if (teacher.getRole() == Role.TEACHER) {
            System.out.println("Enter exam title:");
            String title = scanner.nextLine();

            System.out.println("Enter exam duration in minutes:");
            int duration = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Exam exam = new Exam(title, duration);
            // Add questions to the exam
            // For simplicity, let's add a sample question
            exam.addQuestion(new Question("What is 2 + 2?", QuestionType.SHORT_ANSWER, "4"));
            exams.add(exam);
            System.out.println("Exam created successfully.");
        } else {
            System.out.println("Only teachers can create exams.");
        }
    }

    public void displayExams() {
        if (exams.isEmpty()) {
            System.out.println("No exams available.");
        } else {
            System.out.println("Available Exams:");
            for (int i = 0; i < exams.size(); i++) {
                System.out.println((i + 1) + ". " + exams.get(i).getTitle());
            }
        }
    }

    public void takeExam(User student) {
        System.out.println("Select an exam to take:");
        displayExams();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (choice >= 1 && choice <= exams.size()) {
            Exam exam = exams.get(choice - 1);
            exam.startExam();
            System.out.println("Exam started. You have " + exam.getDuration() + " minutes to complete.");
            exam.displayQuestions();
            exam.submitExam();
        } else {
            System.out.println("Invalid exam choice.");
        }
    }

    public static void main(String[] args) {
        OnlineExamSystem system = new OnlineExamSystem();
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;

        System.out.println("Welcome to Maggy Academy School.");
        System.out.println("To join our school, students and teachers can register or login on our program.\n");

        while (true) {
            try {
                if (loggedInUser == null) {
                    System.out.println("Please enter a valid number corresponding to what you would like to do:");
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    switch (choice) {
                        case 1:
                            system.registerUser();
                            break;
                        case 2:
                            System.out.println("Enter username:");
                            String username = scanner.nextLine();
                            System.out.println("Enter password:");
                            String password = scanner.nextLine();
                            loggedInUser = system.login(username.toUpperCase(), password); // Capitalize the username
                            break;
                        case 3:
                            System.out.println("Exiting...");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    // User is logged in, display menu
                    if (loggedInUser.getRole() == Role.STUDENT) {
                        System.out.println("1. Take Exam");
                        System.out.println("2. View Results");
                    } else {
                        System.out.println("1. Create Exam");
                        System.out.println("2. Display Exams");
                    }
                    System.out.println("3. Logout");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    switch (choice) {
                        case 1:
                            if (loggedInUser.getRole() == Role.STUDENT) {
                                system.takeExam(loggedInUser);
                            } else {
                                system.createExam(loggedInUser);
                            }
                            break;
                        case 2:
                            if (loggedInUser.getRole() == Role.STUDENT) {
                                // View Results
                                // Add implementation here
                            } else {
                                system.displayExams();
                            }
                            break;
                        case 3:
                            loggedInUser = null;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume invalid input to prevent an infinite loop
            }
        }
    }
}
