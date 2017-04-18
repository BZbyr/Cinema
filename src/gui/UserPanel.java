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
    JButton userButton2 = new JButton("Refund");

    public UserPanel(){
        super();
        this.setLayout(new BorderLayout());

        //user panel
        JPanel userButtonPanel = new JPanel();
        userButtonPanel.setLayout(new FlowLayout());
        userButton1.setPreferredSize(new Dimension(100,200));
        userButton2.setPreferredSize(new Dimension(100,200));

        userButtonPanel.add(userButton1);
        userButtonPanel.add(userButton2);
        userLabel.setFont(f);

        this.add(userLabel,BorderLayout.NORTH);
        this.add(userButtonPanel,BorderLayout.CENTER);

    }
}
