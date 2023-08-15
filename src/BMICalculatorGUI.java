import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI {
    private JFrame frame;
    private JTextField weightField;
    private JTextField heightField;
    private JTextArea resultArea;

    public BMICalculatorGUI() {
        frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();

        JLabel heightLabel = new JLabel("Height (m):");
        heightField = new JTextField();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());

                BMICalculator calculator = new BMICalculator();
                double bmi = calculator.calculateBMI(weight, height);
                String interpretation = calculator.interpretBMI(bmi);

                resultArea.setText(String.format("BMI: %.2f\n%s", bmi, interpretation));
            }
        });

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(new JLabel());
        frame.add(calculateButton);
        frame.add(resultArea);

        frame.pack();
        frame.setVisible(true);
    }
}
