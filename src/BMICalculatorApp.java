import javax.swing.SwingUtilities;

public class BMICalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BMICalculatorGUI calculatorGUI = new BMICalculatorGUI();
        });
    }
}