
import javax.swing.*;
import java.awt.*;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//WELCOME Page
public class WelcomePanel extends JPanel{

    //Font Style
    Font f = new Font("Arial",Font.PLAIN, 30);
    Color c = new Color(157,195,229);

    JLabel welcomeLabel = new JLabel("Welcome to XXX Cinema!",JLabel.CENTER);
    JLabel welcomePicLabel;

    JButton welcomeButton = new JButton("Start!");

    ImageIcon image = new ImageIcon(Utility.Prepath+"pic/pic.jpg");

    public WelcomePanel(){
        super();
        set();
    }

    private void set() {
        welcomeLabel.setFont(f);
        welcomeButton.setBackground(c);
        this.setLayout(new BorderLayout());
        welcomePicLabel = new JLabel(image);
        welcomeButton.setFont(f);
        this.add(welcomeLabel,BorderLayout.NORTH);
        this.add(welcomePicLabel, BorderLayout.CENTER);
        this.add(welcomeButton,BorderLayout.SOUTH);
    }

}
