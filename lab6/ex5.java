package lab6;
import javax.swing.*;
import java.awt.*;

public class ex5 extends JFrame {

    public ex5() {
        setTitle("First GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));

        add(new JLabel("Calculator"));

        add(new JLabel("A="));
        JTextField aField = new JTextField(20);
        add(aField);

        add(new JLabel("B="));
        JTextField bField = new JTextField(20);
        add(bField);

        JButton addBtn = new JButton("A + B");
        JLabel addResult = new JLabel("");
        JButton subBtn = new JButton("A - B");
        JLabel subResult = new JLabel("");
        JButton mulBtn = new JButton("A * B");
        JLabel mulResult = new JLabel("");
        JButton divBtn = new JButton("A / B");
        JLabel divResult = new JLabel("");

        add(addBtn); add(addResult);
        add(subBtn); add(subResult);
        add(mulBtn); add(mulResult);
        add(divBtn); add(divResult);

        addBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                addResult.setText("= " + (a + b));
            } catch (NumberFormatException ex) { addResult.setText("Invalid"); }
        });

        subBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                subResult.setText("= " + (a - b));
            } catch (NumberFormatException ex) { subResult.setText("Invalid"); }
        });

        mulBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                mulResult.setText("= " + (a * b));
            } catch (NumberFormatException ex) { mulResult.setText("Invalid"); }
        });

        divBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                if (b == 0) divResult.setText("Error: division by zero");
                else divResult.setText("= " + (a / b));
            } catch (NumberFormatException ex) { divResult.setText("Invalid"); }
        });

        pack();
        setSize(300, 320);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ex5().setVisible(true));
    }
}