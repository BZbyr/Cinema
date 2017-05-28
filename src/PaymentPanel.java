import javax.swing.*;
import java.awt.*;

/**
 * Created by wangchao on 2017/5/26 0026.
 */
public class PaymentPanel extends JFrame{
    JPanel buttonPanel = new JPanel(new GridLayout(2,2));
    JLabel acc = new JLabel("Account:");
    JLabel pass = new JLabel("Password:");
    JButton finishButton = new JButton("Finished Payment!");
    JLabel label = new JLabel("Please Finish the payment!",JLabel.CENTER);
    JTextField account = new JTextField();
    JTextField password = new JTextField();
    Font fs = new Font("Arial",Font.PLAIN,18);
    Color c = new Color(157,195,229);

    public PaymentPanel(){
        this.setLayout(new BorderLayout());
        label.setFont(fs);
        this.add(label,BorderLayout.NORTH);
        account.setPreferredSize(new Dimension(150,50));
        password.setPreferredSize(new Dimension(150,50));
        buttonPanel.add(acc);
        buttonPanel.add(account);
        buttonPanel.add(pass);
        buttonPanel.add(password);
        finishButton.setBackground(c);
        this.add(buttonPanel,BorderLayout.CENTER);
        this.add(finishButton,BorderLayout.SOUTH);
        this.setSize(400, 300);
        this.setVisible(true);
    }
}
