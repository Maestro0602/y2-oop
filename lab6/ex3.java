package lab6;
import javax.swing.*;
import java.awt.*;

public class ex3 extends JFrame {

    public ex3() {
        setTitle("GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(new JLabel("Count number of Vowel, Consonant and Space"));

        add(new JLabel("Text:"));
        JTextField textField = new JTextField(20);
        add(textField);

        JButton findBtn = new JButton("Find");
        add(findBtn);

        JLabel resultLabel = new JLabel(" ");
        resultLabel.setPreferredSize(new Dimension(300, 60));
        add(resultLabel);

        findBtn.addActionListener(e -> {
            String text = textField.getText();
            int vowels = 0, consonants = 0, spaces = 0;
            String vowelSet = "aeiouAEIOU";
            for (char ch : text.toCharArray()) {
                if (ch == ' ') spaces++;
                else if (vowelSet.indexOf(ch) >= 0) vowels++;
                else if (Character.isLetter(ch)) consonants++;
            }
            resultLabel.setText("<html>Count of vowel is: " + vowels +
                "<br>Count of consonant is: " + consonants +
                "<br>Count of space is: " + spaces + "</html>");
        });

        pack();
        setSize(300, 220);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ex3().setVisible(true));
    }
}