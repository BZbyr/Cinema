
import javax.rmi.CORBA.Util;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class ConfirmPanel extends JPanel{

    //JLabel
    JLabel confirmLabel = new JLabel("Check the information of your ticket",JLabel.CENTER);
    JLabel filmNameLabel = new JLabel("",JLabel.CENTER);
    JLabel timeLabel = new JLabel("",JLabel.CENTER);
    JLabel screenLabel = new JLabel("",JLabel.CENTER);
    JLabel seatLabel = new JLabel("",JLabel.CENTER);
    JLabel typeLabel = new JLabel("",JLabel.CENTER);
    //JButton
    JButton confirmButton = new JButton("Confirm");
    JButton returnButton = new JButton("Return");
    //JPanel
    JPanel ticketInfoPanel = new JPanel(new FlowLayout());
    JPanel buttonPanel = new JPanel(new FlowLayout());
    Font f = new Font("Arial",Font.BOLD, 30);
    Font fs = new Font("Arial",Font.PLAIN,18);
    Color c = new Color(157,195,229);

    public ConfirmPanel(ArrayList<Ticket> ticketArrayList){
        super();
        set(ticketArrayList);
    }
    private void set(ArrayList<Ticket> ticketArrayList){
        this.setLayout(new BorderLayout());
        updateLabel(ticketArrayList);

        confirmLabel.setFont(Utility.f);
        confirmButton.setBackground(c);
        confirmButton.setPreferredSize(new Dimension(100,40));
        returnButton.setBackground(c);
        returnButton.setPreferredSize(new Dimension(100,40));
        this.add(confirmLabel,BorderLayout.NORTH);
        this.add(ticketInfoPanel,BorderLayout.CENTER);
        buttonPanel.add(confirmButton);
        buttonPanel.add(returnButton);
        this.add(buttonPanel,BorderLayout.SOUTH);
    }
    public void updateLabel(ArrayList<Ticket> ticketArrayList){
        ticketInfoPanel.removeAll();
        for(int i = 0 ;i<ticketArrayList.size();i++){
            JLabel ticketLabel = new JLabel(ticketArrayList.get(i).toString());
            ticketLabel.setFont(fs);
            ticketInfoPanel.add(ticketLabel);
            ticketInfoPanel.setBorder(new EmptyBorder(100,100,100,100));
        }
    }
}
