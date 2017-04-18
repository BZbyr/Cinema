package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//WELCOME Page
public class WelcomePanel extends JPanel{

    //Font Style
    Font f = new Font("Arial",Font.PLAIN, 30);

    JLabel welcomeLabel = new JLabel("Welcome to XXX Cinema!",JLabel.CENTER);
    JLabel welcomePicLabel;

    JButton welcomeButton = new JButton("Start!");

    ImageIcon image = new ImageIcon("src/pic/01.jpg");

    public WelcomePanel(){
        super();
        welcomeLabel.setFont(f);
        this.setLayout(new BorderLayout());
        welcomePicLabel = new JLabel(image);
        welcomeButton.setFont(f);
        this.add(welcomeLabel,BorderLayout.NORTH);
        this.add(welcomePicLabel, BorderLayout.CENTER);
        this.add(welcomeButton,BorderLayout.SOUTH);
    }

}
