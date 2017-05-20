package gui;

import javafx.scene.control.RadioButton;

import javax.swing.*;
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
    Font f = new Font("Arial",Font.PLAIN, 30);

    //JLabel
    JLabel ticketTypeLabel ;
    //JButton
    JRadioButton normalButton = new JRadioButton("Normal",true);
    JRadioButton studentButton = new JRadioButton("Student");
    JRadioButton childButton = new JRadioButton("Child");
    ButtonGroup typeButtonGroup = new ButtonGroup();
    JButton submitButton = new JButton("Submit!");
    JTextArea textArea = new JTextArea();
    //JPanel
    JPanel radioButtonPanel = new JPanel(new FlowLayout());
    JPanel textAreaPanel = new JPanel(new FlowLayout());

    //TicketTypeResult ArrayList
    ArrayList<Integer> ticketTypeArr = new ArrayList<Integer>();

    public TicketTypePanel(int num){
        super();
        ticketTypeLabel= new JLabel("Please choose type of your "+num+" ticket: ",JLabel.CENTER);
        this.setLayout(new BorderLayout());
        //ButtonGroup中按钮互斥，不需要放入panel中
        typeButtonGroup.add(normalButton);
        typeButtonGroup.add(studentButton);
        typeButtonGroup.add(childButton);

        radioButtonPanel.add(normalButton);
        radioButtonPanel.add(studentButton);
        radioButtonPanel.add(childButton);


        textArea.setVisible(false);
        ticketTypeLabel.setFont(f);
        textAreaPanel.add(submitButton);
        normalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setVisible(false);
                textAreaPanel.removeAll();
                textAreaPanel.add(submitButton);
                textAreaPanel.validate();
            }
        });
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaPanel.removeAll();
                textArea.setText("Enter your Student ID here");
                textArea.setVisible(true);
                textAreaPanel.add(textArea);
                textAreaPanel.add(submitButton);
                textAreaPanel.validate();
            }
        });
        childButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaPanel.removeAll();
                textArea.setText("Enter your Age here");
                textArea.setVisible(true);
                textAreaPanel.add(textArea);
                textAreaPanel.add(submitButton);
                textAreaPanel.validate();
            }
        });

        this.add(ticketTypeLabel,BorderLayout.NORTH);
        this.add(radioButtonPanel,BorderLayout.CENTER);
        this.add(textAreaPanel,BorderLayout.SOUTH);

    }
//    遍历ButtonGroup返回对应ticket类型
    public int returnTicketType(){
        String chosenButtonString = "";
        int ticketType=-1;
        Enumeration<AbstractButton> radioBtns=typeButtonGroup.getElements();
        while (radioBtns.hasMoreElements()) {
            AbstractButton btn = radioBtns.nextElement();
            if(btn.isSelected()){
                chosenButtonString=btn.getText();
                break;
            }
        }
        switch (chosenButtonString){
            case "Normal":
                ticketType = 1;
                break;
            case "Student":
                ticketType = 2;
                break;
            case "Child":
                ticketType = 3;
                break;
            default:
                System.out.println("Error input");
                break;
        }
        return ticketType;
    }
}
