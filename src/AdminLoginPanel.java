import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AdminLoginPanel extends JFrame
{
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel l = new JLabel("Please Login as Administrator",JLabel.CENTER);
    JLabel l1 = new JLabel("username");
    JTextField f1 = new JTextField();
    JLabel l2 = new JLabel("password");
    JTextField f2 = new JTextField();
    JButton b = new JButton("confirm");
    Font fs = new Font("Arial",Font.PLAIN,16);
    Color c = new Color(157,195,229);

//String[] str;
public AdminLoginPanel()
{
    this.setLayout(new BorderLayout());
    p1.setLayout(new GridLayout(3, 2));
    l.setFont(fs);
    l1.setFont(fs);
    l2.setFont(fs);
    b.setFont(fs);
    b.setBackground(c);
    p1.add(l1);
    p1.add(f1);
    p1.add(l2);
    p1.add(f2);
    this.add(p1, BorderLayout.NORTH);
    this.add(l,BorderLayout.SOUTH);
    p2.add(b, BorderLayout.CENTER);
    this.add(p2, BorderLayout.CENTER);
    this.setSize(400, 200);
    this.setVisible(true);
}

}