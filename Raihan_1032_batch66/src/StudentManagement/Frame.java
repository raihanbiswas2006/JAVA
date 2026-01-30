package StudentManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class Frame extends JFrame {
    private Container c;
    private JLabel lbl, lbl1, lbl2, lbl3, lbl4;
    private JComboBox<String> comboBox;
    private Font f, f1;

    Frame() {
        method();
        setVisible(true);
        setBounds(200, 100, 400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Raihan Project");
    }

    public void method() {
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        f = new Font("Arial", Font.BOLD, 20);
        f1 = new Font("Arial", Font.BOLD, 14);

        lbl = new JLabel();
        lbl.setText("Student M. System");
        lbl.setBounds(100, 50, 200, 30);
        lbl.setForeground(Color.red);
        lbl.setFont(f);
        c.add(lbl);

        lbl1 = new JLabel();
        lbl1.setText("Select Admin/User: ");
        lbl1.setBounds(100, 150, 200, 30);
        lbl1.setForeground(Color.BLUE);
        lbl1.setFont(f1);
        c.add(lbl1);

        comboBox = new JComboBox<String>();
        comboBox.setBounds(100, 150, 200, 30);
        comboBox.setForeground(Color.BLUE);
        comboBox.setFont(f1);
        c.add(comboBox);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}