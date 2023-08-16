import org.junit.Test;
import static org.junit.Assert.*;

public class BMICalculatorTest {

    @Test
    public void testCalculateBMI() {
        BMICalculator calculator = new BMICalculator();

        double weight = 70;
        double height = 1.75;

        double expectedBMI = weight / (height * height);
        double calculatedBMI = calculator.calculateBMI(weight, height);

        assertEquals(expectedBMI, calculatedBMI, 0.001);
    }

    @Test
    public void testUnderweightInterpretation() {
        BMICalculator calculator = new BMICalculator();

        double bmi = 17.5;

        String expectedInterpretation = "Underweight";
        String calculatedInterpretation = calculator.interpretBMI(bmi);

        assertEquals(expectedInterpretation, calculatedInterpretation);
    }

    @Test
    public void testNormalWeightInterpretation() {
        BMICalculator calculator = new BMICalculator();

        double bmi = 22.5;

        String expectedInterpretation = "Normal Weight";
        String calculatedInterpretation = calculator.interpretBMI(bmi);

        assertEquals(expectedInterpretation, calculatedInterpretation);
    }

    @Test
    public void testOverweightInterpretation() {
        BMICalculator calculator = new BMICalculator();

        double bmi = 28.0;

        String expectedInterpretation = "Overweight";
        String calculatedInterpretation = calculator.interpretBMI(bmi);

        assertEquals(expectedInterpretation, calculatedInterpretation);
    }

    @Test
    public void testObeseInterpretation() {
        BMICalculator calculator = new BMICalculator();

        double bmi = 32.5;

        String expectedInterpretation = "Obese";
        String calculatedInterpretation = calculator.interpretBMI(bmi);

        assertEquals(expectedInterpretation, calculatedInterpretation);
    }
}
