
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by wangchao on 2017/5/16 0016.
 */
public class AdminPanel extends JPanel{
    JLabel adminLabel = new JLabel("Please choose the function: ");
    JButton adminChoice ;
    JButton returnButton ;
    JPanel labelPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    Font f = new Font("Arial",Font.BOLD, 30);
    Font fs = new Font("Arial",Font.PLAIN,16);
    Color c = new Color(157,195,229);

    public AdminPanel(){
        super();
        set();
    }
    
    private void set(){
        buttonPanel.setLayout(new GridLayout(2,0,30,30));
        this.setLayout(new BorderLayout());
        adminLabel.setFont(f);
        adminChoice = new JButton("Report");
        returnButton = new JButton("Close");
        adminChoice.setBackground(c);
        adminChoice.setPreferredSize(new Dimension(300,100));
        returnButton.setBackground(c);
        returnButton.setPreferredSize(new Dimension(300,100));
        adminChoice.setFont(fs);
        returnButton.setFont(fs);
        labelPanel.add(adminLabel,BorderLayout.NORTH);
        buttonPanel.add(adminChoice);
        buttonPanel.add(returnButton);
        buttonPanel.setBorder(new EmptyBorder(150,100,100,100));
        this.add(labelPanel,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.CENTER);
    }
}
