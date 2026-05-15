package lab6;

import javax.swing.*;
import java.awt.*;

public class ex4 extends JFrame {

    public ex4() {
        setTitle("GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(new JLabel("Find roots of quadratic equation ax^2+ bx +c=0"));

        add(new JLabel("a="));
        JTextField aField = new JTextField(20);
        add(aField);

        add(new JLabel("b="));
        JTextField bField = new JTextField(20);
        add(bField);

        add(new JLabel("c="));
        JTextField cField = new JTextField(20);
        add(cField);

        JButton findBtn = new JButton("Find");
        add(findBtn);

        JLabel resultLabel = new JLabel(" ");
        add(resultLabel);

        findBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());
                double disc = b * b - 4 * a * c;

                if (disc > 0) {
                    double x1 = (-b + Math.sqrt(disc)) / (2 * a);
                    double x2 = (-b - Math.sqrt(disc)) / (2 * a);
                    resultLabel.setText("x1 = " + x1 + ", X2 = " + x2);
                } else if (disc == 0) {
                    double x = -b / (2 * a);
                    resultLabel.setText("x1 = x2 = " + x);
                } else {
                    resultLabel.setText("No real roots");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        });

        pack();
        setSize(300, 260);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ex4().setVisible(true));
    }
}