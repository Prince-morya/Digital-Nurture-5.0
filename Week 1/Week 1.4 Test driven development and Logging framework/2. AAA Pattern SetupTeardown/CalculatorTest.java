import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAddition() {
        double firstValue = 10;
        double secondValue = 5;

        double result = calculator.add(firstValue, secondValue);

        assertEquals(15, result, 0.001);
    }

    @Test
    public void testSubtraction() {
        double firstValue = 10;
        double secondValue = 5;

        double result = calculator.subtract(firstValue, secondValue);

        assertEquals(5, result, 0.001);
    }
}
