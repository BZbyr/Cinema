
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class TicketTypePanel extends JPanel{
    Font f = new Font("Arial",Font.BOLD, 30);
    Font fs = new Font("Arial",Font.PLAIN,16);
    Color c = new Color(157,195,229);
    //JLabel
    JLabel ticketTypeLabel ;
    //JButton
    JRadioButton adultButton = new JRadioButton("Normal",true);
    JRadioButton studentButton = new JRadioButton("Student");
    JRadioButton childButton = new JRadioButton("Child");
    JRadioButton seniorButton = new JRadioButton("Senior");
    ButtonGroup typeButtonGroup = new ButtonGroup();
    JButton submitButton = new JButton("Submit");
    JButton returnButton = new JButton("Return");
    JTextArea textArea = new JTextArea();
    //JPanel
    JPanel radioButtonPanel = new JPanel(new GridLayout(1,4,10,10));
    JPanel textAreaPanel = new JPanel(new FlowLayout());

    //TicketTypeResult ArrayList
    ArrayList<Integer> ticketTypeArr = new ArrayList<Integer>();

    public TicketTypePanel(int num){
        super();
        set(num);
    }
//    遍历ButtonGroup返回对应ticket类型
    public int returnTicketType(){
        adultButton.setFont(fs);
        adultButton.setPreferredSize(new Dimension(150,100));
        studentButton.setFont(fs);
        studentButton.setPreferredSize(new Dimension(150,100));
        childButton.setFont(fs);
        childButton.setPreferredSize(new Dimension(150,100));
        seniorButton.setFont(fs);
        seniorButton.setPreferredSize(new Dimension(150,100));

        String chosenButtonString = null;
        int ticketType=-1;
        Enumeration<AbstractButton> radioBtns=typeButtonGroup.getElements();
        while (radioBtns.hasMoreElements()) {
            AbstractButton btn = radioBtns.nextElement();
            if(btn.isSelected()){
                chosenButtonString=btn.getText();
                break;
            }
        }
        if("Normal".equals(chosenButtonString)){
            ticketType = 1;
        }else if("Student".equals(chosenButtonString)){
            ticketType = 2;
        }else if("Child".equals(chosenButtonString)){
            ticketType = 3;
        }else if("Senior".equals(chosenButtonString)){
            ticketType = 4;
        }else{
            System.out.println("Error input");
        }
        
        return ticketType;
    }

    private void set(int num) {
        ticketTypeLabel= new JLabel("Please choose type of your "+num+" ticket: ",JLabel.CENTER);
        this.setLayout(new BorderLayout());
        //buttons in ButtonGroup do not have to put into panel
        typeButtonGroup.add(adultButton);
        typeButtonGroup.add(studentButton);
        typeButtonGroup.add(childButton);
        typeButtonGroup.add(seniorButton);

        radioButtonPanel.add(adultButton);
        radioButtonPanel.add(studentButton);
        radioButtonPanel.add(childButton);
        radioButtonPanel.add(seniorButton);
        radioButtonPanel.setBorder(new EmptyBorder(100, 100, 100, 100));

        returnButton.setBackground(c);
        returnButton.setPreferredSize(new Dimension(100,50));
        returnButton.setFont(fs);

        textArea.setVisible(false);
        ticketTypeLabel.setFont(f);
        submitButton.setBackground(c);
        submitButton.setPreferredSize(new Dimension(100,50));
        submitButton.setFont(fs);
        textAreaPanel.add(submitButton);
        textAreaPanel.add(returnButton);

        adultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setVisible(false);
                textAreaPanel.removeAll();
                textAreaPanel.add(submitButton);
                textAreaPanel.setVisible(false);
                textAreaPanel.setVisible(true);
                textAreaPanel.validate();
            }
        });
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel prompt = new JLabel("Please input student ID:");
                prompt.setFont(fs);
                textAreaPanel.removeAll();
                textArea.setVisible(true);
                textArea.setPreferredSize(new Dimension(100,50));
                textAreaPanel.add(prompt);
                textAreaPanel.add(textArea);
                textAreaPanel.add(submitButton);
                textAreaPanel.validate();
            }
        });
        childButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel prompt = new JLabel("Please input your age:");
                prompt.setFont(fs);
                textAreaPanel.removeAll();
                textArea.setVisible(true);
                textArea.setPreferredSize(new Dimension(100,50));
                textAreaPanel.add(prompt);
                textAreaPanel.add(textArea);
                textAreaPanel.add(submitButton);
                textAreaPanel.validate();
            }
        });
        seniorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setVisible(false);
                textAreaPanel.removeAll();
                textAreaPanel.add(submitButton);
                textAreaPanel.setVisible(false);
                textAreaPanel.setVisible(true);
                textAreaPanel.validate();
            }
        });

        this.add(ticketTypeLabel,BorderLayout.NORTH);
        this.add(radioButtonPanel,BorderLayout.CENTER);
        this.add(textAreaPanel,BorderLayout.SOUTH);
    }
}
