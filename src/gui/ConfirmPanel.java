package gui;

import cinema.Entity.Ticket;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

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
    JLabel ticketLabel = new JLabel("",JLabel.CENTER);
    //JButton
    JButton confirmButton = new JButton("Confirm");
    //JPanel
    JPanel ticketInfoPanel = new JPanel(new FlowLayout());
    public ConfirmPanel(Ticket ticket){
        super();
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
        ticketLabel.setText(ticket.toString());
        ticketInfoPanel.add(ticketLabel);
        confirmLabel.setFont(f);
        this.add(confirmLabel,BorderLayout.NORTH);
        this.add(ticketInfoPanel,BorderLayout.CENTER);
        this.add(confirmButton,BorderLayout.SOUTH);



    }
}
