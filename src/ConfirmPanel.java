
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class ConfirmPanel extends JPanel{
    Font f = new Font("Arial",Font.PLAIN, 30);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");

    //JLabel
    JLabel confirmLabel = new JLabel("Check the information of your ticket",JLabel.CENTER);
    JLabel filmNameLabel = new JLabel("",JLabel.CENTER);
    JLabel timeLabel = new JLabel("",JLabel.CENTER);
    JLabel screenLabel = new JLabel("",JLabel.CENTER);
    JLabel seatLabel = new JLabel("",JLabel.CENTER);
    JLabel typeLabel = new JLabel("",JLabel.CENTER);
    //JButton
    JButton confirmButton = new JButton("Confirm");
    //JPanel
    JPanel ticketInfoPanel = new JPanel(new FlowLayout());
    public ConfirmPanel(ArrayList<Ticket> ticketArrayList){
        super();
        set(ticketArrayList);
    }
    private void set(ArrayList<Ticket> ticketArrayList){
        this.setLayout(new BorderLayout());
        /*filmNameLabel.setText(ticket.getFilm().getfilmName());
        timeLabel.setText(""sdf.format(ticket.getDate()));
        screenLabel.setText("Screen:"ticket.getScreenId());

        TicketInfoPanel.add(filmNameLabel);
        TicketInfoPanel.add(timeLabel);
        TicketInfoPanel.add(screenLabel);
        TicketInfoPanel.add(seatLabel);
        TicketInfoPanel.add(typeLabel);
        */
        for(int i = 0 ;i<ticketArrayList.size();i++){
            JLabel ticketLabel = new JLabel(ticketArrayList.get(i).toString());
            ticketInfoPanel.add(ticketLabel);
        }
        confirmLabel.setFont(f);
        this.add(confirmLabel,BorderLayout.NORTH);
        this.add(ticketInfoPanel,BorderLayout.CENTER);
        this.add(confirmButton,BorderLayout.SOUTH);
    }
}
