package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class UserPanel extends JPanel{
    Font f = new Font("Arial",Font.PLAIN, 30);

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
        userButton1.setPreferredSize(new Dimension(200,100));

        userButtonPanel.add(userButton1);
        userLabel.setFont(f);

        this.add(userLabel,BorderLayout.NORTH);
        this.add(userButtonPanel,BorderLayout.CENTER);
    }
}
