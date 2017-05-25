import javax.swing.*;
import java.awt.*;

/**
 * Created by wangchao on 2017/5/26 0026.
 */
public class MessagePanel extends JPanel{
    JLabel label = new JLabel("",JLabel.CENTER);
    public MessagePanel(String message){
        super();
        set( message);
    }
    private void set(String message){
        this.setLayout(new BorderLayout());
        label.setText(message);
        label.setFont(Utility.f);
        this.add(label,BorderLayout.CENTER);
    }
}
