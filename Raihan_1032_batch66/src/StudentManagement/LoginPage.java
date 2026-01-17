package StudentManagement;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class LoginPage extends JFrame {

    private Container c;

    LoginPage() {
        method(); // can use any name for method
        setVisible(true);
        setBounds(123, 147, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Raihan Project");
    }

    public void method() {
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#11c5fc"));
    }

    public static void main(String[] args) {
        LoginPage frame = new LoginPage();
    }

}