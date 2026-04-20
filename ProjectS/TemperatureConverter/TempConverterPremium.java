import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConverterPremium {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GRADIENT BACKGROUND (smoother dark blend)
        JPanel bg = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(30, 30, 60),
                        0, getHeight(), new Color(70, 0, 120));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(null);
        frame.setContentPane(bg);

        // GLASS PANEL (cleaner glass look)
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(40, 40, 80, 160));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        panel.setBounds(75, 60, 350, 300);
        panel.setOpaque(false);
        panel.setLayout(null);
        bg.add(panel);

        // TITLE
        JLabel title = new JLabel("Temperature Converter", SwingConstants.CENTER);
        title.setBounds(0, 20, 350, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(new Color(245, 245, 255));
        panel.add(title);

        // INPUT FIELD
        JTextField input = new JTextField() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(255, 255, 255, 210));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        input.setBounds(80, 80, 200, 40);
        input.setOpaque(false);
        input.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        input.setForeground(new Color(40, 40, 40));
        input.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(input);

        // COMBO
        String[] options = {
                "Celsius → Fahrenheit",
                "Fahrenheit → Celsius",
                "Celsius → Kelvin",
                "Kelvin → Celsius"
        };

        JComboBox<String> combo = new JComboBox<>(options);
        combo.setBounds(80, 130, 200, 40);
        combo.setBackground(new Color(255, 255, 255));
        combo.setForeground(new Color(50, 50, 50));
        combo.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 220), 1, true));
        panel.add(combo);

        // BUTTON (fixed premium gradient)
        JButton btn = new JButton("Convert") {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(120, 90, 255),
                        getWidth(), getHeight(), new Color(80, 50, 200));

                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

                super.paintComponent(g);
            }
        };

        btn.setBounds(100, 190, 150, 45);
        btn.setForeground(new Color(255, 255, 255));
        btn.setOpaque(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);

        // HOVER + CLICK ANIMATION
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
                btn.setBounds(102, 192, 146, 42);
            }

            public void mouseReleased(MouseEvent e) {
                btn.setBounds(100, 190, 150, 45);
            }
        });

        panel.add(btn);

        // RESULT
        JLabel result = new JLabel("Result", SwingConstants.CENTER);
        result.setBounds(50, 250, 250, 30);
        result.setFont(new Font("Segoe UI", Font.BOLD, 15));
        result.setForeground(new Color(230, 230, 255));
        panel.add(result);

        // LOGIC
        btn.addActionListener(e -> {
            try {
                double temp = Double.parseDouble(input.getText());
                double r = 0;

                switch (combo.getSelectedIndex()) {
                    case 0:
                        r = (temp * 9 / 5) + 32;
                        break;
                    case 1:
                        r = (temp - 32) * 5 / 9;
                        break;
                    case 2:
                        r = temp + 273.15;
                        break;
                    case 3:
                        r = temp - 273.15;
                        break;
                }

                result.setText("Result: " + String.format("%.2f", r));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Enter valid number!");
            }
        });

        frame.setVisible(true);
    }
}