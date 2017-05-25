import javax.swing.*;
import java.awt.*;

/**
 * Created by wangchao on 2017/5/26 0026.
 */
public class PaymentPanel extends JFrame{
    JPanel buttonPanel = new JPanel(new FlowLayout());
    JButton finishButton = new JButton("Finished Payment!");
    JLabel label = new JLabel("Please Finish the payment!",JLabel.CENTER);
    public PaymentPanel(){
        this.setLayout(new BorderLayout());
        label.setFont(Utility.f);
        this.add(label,BorderLayout.NORTH);
        buttonPanel.add(finishButton);
        this.add(buttonPanel,BorderLayout.NORTH);
        this.setSize(300, 200);
        this.setVisible(true);
    }
}
