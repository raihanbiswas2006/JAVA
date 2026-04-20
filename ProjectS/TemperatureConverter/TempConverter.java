// Temperature Converter For Sohan (Prime University Friend)
import javax.swing.*;
import java.awt.*;

public class TempConverter {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(380, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MAIN PANEL
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 248, 252));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        frame.add(panel);

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // TITLE
        JLabel title = new JLabel("Temperature Converter", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(title);

        // INPUT
        JTextField input = new JTextField();
        input.setFont(font);
        input.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(input);

        // COMBO
        String[] options = {
                "Celsius → Fahrenheit",
                "Fahrenheit → Celsius",
                "Celsius → Kelvin",
                "Kelvin → Celsius"
        };

        JComboBox<String> combo = new JComboBox<>(options);
        combo.setFont(font);
        panel.add(combo);

        // BUTTON
        JButton btn = new JButton("Convert");
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(new Color(0, 120, 215));
        btn.setForeground(Color.WHITE);
        panel.add(btn);

        // RESULT
        JLabel result = new JLabel("Result: ", JLabel.CENTER);
        result.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(result);

        // LOGIC (unchanged)
        btn.addActionListener(e -> {
            try {
                double temp = Double.parseDouble(input.getText());
                double r = 0;

                switch (combo.getSelectedIndex()) {
                    case 0: r = (temp * 9 / 5) + 32; break;
                    case 1: r = (temp - 32) * 5 / 9; break;
                    case 2: r = temp + 273.15; break;
                    case 3: r = temp - 273.15; break;
                }

                result.setText("Result: " + String.format("%.2f", r));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        frame.setVisible(true);
    }
}