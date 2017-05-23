
import javax.swing.*;
import java.awt.*;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//WELCOME Page
public class IdentityPanel extends JPanel{

    //Font Style
    Font f = new Font("Arial",Font.PLAIN, 30);

    JLabel identityLabel = new JLabel("Please choose your identity",JLabel.CENTER);

    JButton identityButton1 = new JButton("User");
    JButton identityButton2 = new JButton("Administrator");
    JButton returnButton = new JButton("Return");
    public IdentityPanel(){
        super();
        //identity panel
        set();
    }
    
    private void set(){
        JPanel identityButtonPanel = new JPanel();
        identityButtonPanel.setLayout(new FlowLayout());
        identityButton1.setPreferredSize(new Dimension(200,100));
        identityButton2.setPreferredSize(new Dimension(200,100));

        identityButtonPanel.add(identityButton1);
        identityButtonPanel.add(identityButton2);
        identityButtonPanel.add(returnButton);
        identityLabel.setFont(f);

        this.setLayout(new BorderLayout());
        this.add(identityLabel,BorderLayout.NORTH);
        this.add(identityButtonPanel,BorderLayout.CENTER);
    }

}
