package StudentManagement;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class AdminLogin extends JFrame {
    
    private Container c;
    
    AdminLogin(){
        method();
    setVisible(true);
    setBounds(111,123,555,444);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setTitle("Raihan Project");
    }
    
    public void method(){
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GREEN);
    }
    
    public static void main(String[] args) {
        AdminLogin frame = new AdminLogin();
    }
    
}