package Calculator.main;

//public class Calculator {
//}
import java.util.Scanner;

/**
 * A simple calculator application that performs arithmetic, advanced, and trigonometric operations,
 * and manages memory.
 */
public class Calculator {
    private static double memory = 0; // Memory variable to store values

    /**
     * Main method to start the calculator application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Display the welcome message and ask the user to check the menu or press enter to continue
        displayWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine().toLowerCase();
            if (input.equals("help")) {
                displayMenu(scanner);
            } else if (input.equals("")) {
                System.out.println("To continue enter a number from 1 to 5 or 'help' for the menu.");
            } else {
                processCommand(input, scanner);
            }
        } while (true);
    }

    /**
     * Gets the value stored in the memory.
     * @return The value stored in the memory.
     */
    public static double getMemory() {
        return memory;
    }

    /**
     * Displays a welcome message to the user.
     */
    private static void displayWelcomeMessage() {
        System.out.println("Welcome to My Calculator App!");
        System.out.println("This calculator can perform various mathematical operations.");
        System.out.println("Type 'help' to see the menu OR enter the command corresponding to operation type:");
    }

    /**
     * Displays the menu of operations and prompts the user to choose one.
     * @param scanner Scanner object to read user input.
     */
    private static void displayMenu(Scanner scanner) {
        System.out.println("The Calculator Menu:");
        System.out.println("1. Arithmetic Operations");
        System.out.println("2. Advanced Operations");
        System.out.println("3. Trigonometric Operations");
        System.out.println("4. Memory Operations");
        System.out.println("5. Exit");
        System.out.println("Type the number corresponding to the operation you want to perform.");
        System.out.println("Enter command:");
        String input = scanner.nextLine().toLowerCase();
        processCommand(input, scanner);
    }

    /**
     * Processes the user's input command and performs the corresponding operation.
     * @param input User input command.
     * @param scanner Scanner object to read user input.
     */
    private static void processCommand(String input, Scanner scanner) {
        switch (input) {
            case "1":
                performArithmeticOperations(scanner);
                break;
            case "2":
                performAdvancedOperations(scanner);
                break;
            case "3":
                performTrigonometricOperations(scanner);
                break;
            case "4":
                performMemoryOperations(scanner);
                break;
            case "5":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command! Please enter a number from 1 to 5.");
        }
    }

    /**
     * Performs arithmetic operations (addition, subtraction, multiplication, division).
     * @param scanner Scanner object to read user input.
     */
    private static void performArithmeticOperations(Scanner scanner) {
        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter operator (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        System.out.println("Enter second number:");
        double num2 = scanner.nextDouble();
        double result = performArithmeticOperations(num1, operator, num2);
        System.out.println("Result: " + result);
        memory = result;
    }

//    /**
//     * Performs advanced operations (square root, power).
//     * @param scanner Scanner object to read user input.
//     */
//    private static void performAdvancedOperations(Scanner scanner) {
//        System.out.println("Enter operation (sqrt, pow):");
//        String operation = scanner.next();
//        System.out.println("Enter a number:");
//        double number = scanner.nextDouble();
//        double result = performAdvancedOperations(operation, number);
//        System.out.println("Result: " + result);
//    }

    /**
     * Performs trigonometric operations (sin, cos, tan).
     * @param scanner Scanner object to read user input.
     */
    private static void performTrigonometricOperations(Scanner scanner) {
        System.out.println("Enter operation (sin, cos, tan):");
        String operation = scanner.next();
        System.out.println("Enter angle in degrees:");
        double angle = scanner.nextDouble();
        double result = performTrigonometricOperations(operation, angle);
        System.out.println("Result: " + result);
    }

    /**
     * Performs memory operations (store, recall, clear).
     * @param scanner Scanner object to read user input.
     */
    public static void performMemoryOperations(Scanner scanner) {
        System.out.println("Memory Operations:");
        System.out.println("1. Store result to memory");
        System.out.println("2. Recall memory value");
        System.out.println("3. Clear memory");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter value to store to memory:");
                memory = scanner.nextDouble();
                System.out.println("Value stored to memory: " + memory);
                break;
            case 2:
                System.out.println("Memory value: " + memory);
                break;
            case 3:
                memory = 0;
                System.out.println("Memory cleared.");
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    /**
     * Performs arithmetic operations (addition, subtraction, multiplication, division).
     * @param num1 First operand.
     * @param operator Operator.
     * @param num2 Second operand.
     * @return Result of the arithmetic operation.
     */
    public static double performArithmeticOperations(double num1, char operator, double num2) {
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero!");
                    return Double.NaN; // Not a number
                }
                break;
            default:
                System.out.println("Invalid operator!");
                return Double.NaN;
        }
        return result;
    }

    /**
     * Performs advanced operations (square root, power).
     * @param scanner Scanner object to read user input.
     */
    private static void performAdvancedOperations(Scanner scanner) {
        System.out.println("Enter operation (sqrt, pow):");
        String operation = scanner.next();
        System.out.println("Enter a number:");
        double number = scanner.nextDouble();
        double result = performAdvancedOperations(operation, number, scanner);
        System.out.println("Result: " + result);
    }

    /**
     * Performs advanced operations (square root, power).
     * @param operation Operation to perform (sqrt, pow).
     * @param number Number on which the operation is performed.
     * @param scanner Scanner object to read user input.
     * @return Result of the operation.
     */
    public static double performAdvancedOperations(String operation, double number, Scanner scanner) {
        switch (operation) {
            case "sqrt":
                if (number >= 0) {
                    double result = Math.sqrt(number);
                    System.out.println("Square root: " + result);
                    return result;
                } else {
                    System.out.println("Cannot calculate square root of a negative number!");
                    return Double.NaN;
                }
            case "pow":
                System.out.println("Enter exponent:");
                double exponent = scanner.nextDouble();
                double result = Math.pow(number, exponent);
                System.out.println("Result: " + result);
                return result;
            default:
                System.out.println("Invalid operation!");
                return Double.NaN;
        }
    }


    /**
     * Performs trigonometric operations (sin, cos, tan).
     * @param operation Trigonometric operation to perform (sin, cos, tan).
     * @param angle Angle in degrees for the operation.
     * @return Result of the operation.
     */
    public static double performTrigonometricOperations(String operation, double angle) {
        angle = Math.toRadians(angle);

        switch (operation) {
            case "sin":
                double sinResult = Math.sin(angle);
                System.out.println("Sin(" + angle + " degrees): " + sinResult);
                return sinResult;
            case "cos":
                double cosResult = Math.cos(angle);
                System.out.println("Cos(" + angle + " degrees): " + cosResult);
                return cosResult;
            case "tan":
                double tanResult = Math.tan(angle);
                System.out.println("Tan(" + angle + " degrees): " + tanResult);
                return tanResult;
            default:
                System.out.println("Invalid operation!");
                return Double.NaN;
        }
    }
}
