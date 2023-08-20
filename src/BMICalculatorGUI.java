import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI {
    private final JFrame frame;
    private final JTextField weightField;
    private final JTextField heightField;

    public BMICalculatorGUI() {
        frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();

        JLabel heightLabel = new JLabel("Height (m):");
        heightField = new JTextField();

        JButton calculateButton = new JButton("Calculate BMI");

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());

                BMICalculator calculator = new BMICalculator();
                double bmi = calculator.calculateBMI(weight, height);
                String interpretation = calculator.interpretBMI(bmi);

                frame.dispose();

                JFrame resultFrame = new JFrame("BMI Result");
                resultFrame.setLayout(new BorderLayout());
                resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JTextArea resultTextArea = new JTextArea();
                resultTextArea.setText(String.format("BMI: %.2f\n%s", bmi, interpretation));

                Font font = new Font("Arial", Font.PLAIN, 26);
                resultTextArea.setFont(font);

                resultTextArea.setEditable(false);

                resultFrame.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

                resultFrame.setSize(200, 150);

                resultFrame.setVisible(true);
            }
        });

        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(new JLabel());
        frame.add(calculateButton);

        frame.pack();
        frame.setVisible(true);
    }
}
