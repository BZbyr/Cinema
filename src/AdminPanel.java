
import javax.swing.*;
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
    public AdminPanel(){
        super();
        set();
    }
    
    private void set(){
        this.setLayout(new BorderLayout());
        adminChoice = new JButton("Report");
        returnButton = new JButton("Close");
        labelPanel.add(adminLabel,BorderLayout.NORTH);
        buttonPanel.add(adminChoice);
        buttonPanel.add(returnButton);
        this.add(labelPanel,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
    }
}
