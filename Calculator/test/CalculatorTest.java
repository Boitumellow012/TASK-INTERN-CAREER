package Calculator.test;

import org.junit.Test;
import Calculator.main.Calculator;;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        double result = Calculator.performArithmeticOperations(5, '+', 3);
        assertEquals(8, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = Calculator.performArithmeticOperations(5, '-', 3);
        assertEquals(2, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double result = Calculator.performArithmeticOperations(5, '*', 3);
        assertEquals(15, result, 0.0001);
    }

    @Test
    public void testDivision() {
        double result = Calculator.performArithmeticOperations(6, '/', 2);
        assertEquals(3, result, 0.0001);
    }

    @Test
    public void testSquareRoot() {
        double result = Calculator.performAdvancedOperations("sqrt", 9, new java.util.Scanner("2"));
        assertEquals(3, result, 0.0001);
    }

    @Test
    public void testPower() {
        double result = Calculator.performAdvancedOperations("pow", 2, new java.util.Scanner("3"));
        assertEquals(8, result, 0.0001);
    }

    @Test
    public void testSine() {
        double result = Calculator.performTrigonometricOperations("sin", 30);
        assertEquals(0.5, result, 0.0001);
    }
}
