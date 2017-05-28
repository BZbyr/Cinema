import javax.swing.*;
import java.awt.*;

/**
 * Created by wangchao on 2017/5/26 0026.
 */
public class MessagePanel extends JPanel{
    JLabel label = new JLabel("",JLabel.CENTER);
    JButton button = new JButton("Return");
    public MessagePanel(String message){
        super();
        set( message);
    }
    private void set(String message){
        this.setLayout(new BorderLayout());
        button.setPreferredSize(new Dimension(100,60));
        button.setBackground(Utility.c);
        button.setFont(Utility.fs);
        label.setText(message);
        label.setFont(Utility.f);
        this.add(label,BorderLayout.CENTER);
        this.add(button,BorderLayout.SOUTH);
    }
}
