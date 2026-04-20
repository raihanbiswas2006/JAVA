import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CurrencyView {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GRADIENT BACKGROUND (Temp style)
        JPanel bg = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(58, 123, 213),
                        0, getHeight(), new Color(0, 210, 255));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(null);
        frame.setContentPane(bg);

        // GLASS PANEL
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(255, 255, 255, 180));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        panel.setBounds(75, 60, 350, 300);
        panel.setOpaque(false);
        panel.setLayout(null);
        bg.add(panel);

        // TITLE
        JLabel title = new JLabel("Currency Converter", SwingConstants.CENTER);
        title.setBounds(20, 20, 350, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(title);

        // ICON
        ImageIcon icon = new ImageIcon("icon.png");
        Image img = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(img));
        iconLabel.setBounds(50, 10, 60, 60);
        panel.add(iconLabel);

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // AMOUNT LABEL
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 70, 80, 25);
        amountLabel.setFont(font);
        panel.add(amountLabel);

        // INPUT FIELD
        JTextField amountField = new JTextField() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(255, 255, 255, 210));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                super.paintComponent(g);
            }
        };
        amountField.setBounds(120, 65, 180, 35);
        amountField.setFont(font);
        amountField.setOpaque(false);
        amountField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panel.add(amountField);

        // CURRENCIES
        String[] currencies = { "USD", "BDT", "EUR", "INR", "GBP", "JPY" };

        Font comboFont = new Font("Segoe UI", Font.BOLD, 13);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(30, 115, 80, 25);
        fromLabel.setFont(font);
        panel.add(fromLabel);

        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(120, 110, 90, 35);
        fromCurrency.setFont(comboFont);
        fromCurrency.setBackground(Color.WHITE);
        fromCurrency.setForeground(new Color(25, 25, 25));
        fromCurrency.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));
        fromCurrency.setFocusable(false);
        panel.add(fromCurrency);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(210, 115, 40, 25);
        toLabel.setFont(font);
        panel.add(toLabel);

        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(250, 110, 90, 35);
        toCurrency.setFont(comboFont);
        toCurrency.setBackground(Color.WHITE);
        toCurrency.setForeground(new Color(25, 25, 25));
        toCurrency.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));
        toCurrency.setFocusable(false);
        panel.add(toCurrency);

        // BUTTON (Temp style)
        JButton convertButton = new JButton("Convert") {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(0, 102, 204),
                        getWidth(), getHeight(), new Color(0, 160, 220));

                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

                super.paintComponent(g);
            }
        };

        convertButton.setBounds(100, 165, 150, 45);
        convertButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        convertButton.setForeground(Color.WHITE);
        convertButton.setContentAreaFilled(false);
        convertButton.setBorderPainted(false);
        convertButton.setFocusPainted(false);

        convertButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                convertButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        panel.add(convertButton);

        // RESULT
        JLabel resultLabel = new JLabel("Result:", SwingConstants.CENTER);
        resultLabel.setBounds(50, 250, 250, 30);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panel.add(resultLabel);

        // ================= BUTTON ACTION (ORIGINAL OFFLINE LOGIC) =================
        /*
         * convertButton.addActionListener(e -> {
         * try {
         * double amount = Double.parseDouble(amountField.getText());
         * String from = (String) fromCurrency.getSelectedItem();
         * String to = (String) toCurrency.getSelectedItem();
         * 
         * double amountInUSD = 0;
         * if (from.equals("USD")) amountInUSD = amount;
         * else if (from.equals("BDT")) amountInUSD = amount * 0.0091;
         * else if (from.equals("EUR")) amountInUSD = amount * 1.08;
         * else if (from.equals("INR")) amountInUSD = amount * 0.012;
         * else if (from.equals("GBP")) amountInUSD = amount * 1.27;
         * else if (from.equals("JPY")) amountInUSD = amount * 0.0068;
         * 
         * double result = 0;
         * if (to.equals("USD")) result = amountInUSD;
         * else if (to.equals("BDT")) result = amountInUSD * 109.5;
         * else if (to.equals("EUR")) result = amountInUSD * 0.93;
         * else if (to.equals("INR")) result = amountInUSD * 83;
         * else if (to.equals("GBP")) result = amountInUSD * 0.79;
         * else if (to.equals("JPY")) result = amountInUSD * 147;
         * 
         * resultLabel.setText("Result: " + String.format("%.2f", result));
         * 
         * } catch (Exception ex) {
         * JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
         * }
         * });
         */

        // LOGIC (UNCHANGED)
        convertButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();

                double amountInUSD = 0;
                if (from.equals("USD"))
                    amountInUSD = amount;
                else if (from.equals("BDT"))
                    amountInUSD = amount * 0.0091;
                else if (from.equals("EUR"))
                    amountInUSD = amount * 1.08;
                else if (from.equals("INR"))
                    amountInUSD = amount * 0.012;
                else if (from.equals("GBP"))
                    amountInUSD = amount * 1.27;
                else if (from.equals("JPY"))
                    amountInUSD = amount * 0.0068;

                double result = 0;
                if (to.equals("USD"))
                    result = amountInUSD;
                else if (to.equals("BDT"))
                    result = amountInUSD * 109.5;
                else if (to.equals("EUR"))
                    result = amountInUSD * 0.93;
                else if (to.equals("INR"))
                    result = amountInUSD * 83;
                else if (to.equals("GBP"))
                    result = amountInUSD * 0.79;
                else if (to.equals("JPY"))
                    result = amountInUSD * 147;

                resultLabel.setText("Result: " + String.format("%.2f", result));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
            }
        });

        frame.setVisible(true);
    }
}