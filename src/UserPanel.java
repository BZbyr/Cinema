
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class UserPanel extends JPanel{
    Font f = new Font("Arial",Font.PLAIN, 30);
    Font fs = new Font("Arial",Font.PLAIN,21);
    Color c = new Color(157,195,229);
    //JLabel
    JLabel userLabel = new JLabel("What can I do for you",JLabel.CENTER);
    //JButton
    JButton userButton1 = new JButton("Buy ticket");

    public UserPanel(){
        super();
        set();
    }

    private void set() {
        this.setLayout(new BorderLayout());

        //user panel
        JPanel userButtonPanel = new JPanel();
        userButtonPanel.setLayout(new FlowLayout());
        userButtonPanel.setBorder(new EmptyBorder(50, 100, 50, 100));
        userButton1.setPreferredSize(new Dimension(400,150));
        userButton1.setBackground(c);
        userButton1.setFont(fs);
        userButtonPanel.add(userButton1);
        userLabel.setFont(f);

        this.add(userLabel,BorderLayout.NORTH);
        this.add(userButtonPanel,BorderLayout.CENTER);
    }
}
