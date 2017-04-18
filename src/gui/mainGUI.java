package gui;

import cinema.Control.ScreenControl;
import cinema.Control.TicketControl;
import cinema.Entity.Film;
import cinema.Control.FilmControl;
import cinema.Entity.Screen;
import cinema.Entity.Seat;
import cinema.Entity.Ticket;
import cinema.IO.FilmIO;
import cinema.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/10 0010.
 */
public class mainGUI extends JFrame implements ActionListener{
    //Font Style
    Font f = new Font("Arial",Font.PLAIN, 30);

    //Container
    Container mainPanel;

    //labels

    //panels
    WelcomePanel welcomePanel = new WelcomePanel();
    IdentityPanel identityPanel = new IdentityPanel();
    UserPanel userPanel = new UserPanel();
    FilmListPanel filmListPanel = new FilmListPanel() ;
    FilmDetailPanel filmDetailPanel;
    ScreenPanel screenPanel;
    TicketTypePanel ticketTypePanel;
    ConfirmPanel confirmPanel;
    JPanel filmListButtonPanel;

    //buttons
    JButton filmButton[] = filmListPanel.filmListButton;
    JButton dateButton[];
    JButton seatButton[][];
    //Film List
    ArrayList<Film> filmList = new ArrayList<Film>();

    //number of films
    int filmNum;

    //buffer for chosenMovie
    //这些就是generate一张ticket所必须的属性，分别通过几个panel从user处收集齐
    String chosenFilmName;
    Seat chosenSeat;
    Screen chosenScreen;
    int chosenTicketType;
    Ticket userTicket;

    public mainGUI() {
        super("mainGUI");
        mainPanel = this.getContentPane();


        mainPanel.add(welcomePanel);


        //buy ticket panel
        //film list panel


        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton welcomeButton = welcomePanel.welcomeButton;
        welcomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(identityPanel);
                mainPanel.validate();
            }
        });

        JButton identityButton1 = identityPanel.identityButton1;
        JButton identityButton2 = identityPanel.identityButton2;

        identityButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(userPanel);
                mainPanel.validate();
            }
        });

        identityButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton userButton1 = userPanel.userButton1;
        JButton userButton2 = userPanel.userButton2;
        filmListButtonPanel = filmListPanel.filmListButtonPanel;
        userButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(filmListPanel);
                mainPanel.validate();
            }
        });


        for (int filmButtonCount = 0; filmButtonCount < filmButton.length; filmButtonCount++) {
            filmButton[filmButtonCount].addActionListener(filmActionListener);
        }


    }

    ActionListener filmActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton tempButton = (JButton) e.getSource();
            chosenFilmName = tempButton.getText();
            FilmDetailPanel filmDetailPanel = new FilmDetailPanel(chosenFilmName);
            dateButton = filmDetailPanel.filmDateButton;
            for (int dateButtonCount=0; dateButtonCount<dateButton.length;dateButtonCount++){
                dateButton[dateButtonCount].addActionListener(dateActionListener);
            }
            mainPanel.removeAll();
            mainPanel.add(filmDetailPanel);
            mainPanel.validate();
        }
    };
    ActionListener dateActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton tempButton = (JButton)e.getSource();
            String chosenDate = tempButton.getText();
            chosenScreen = (new ScreenControl()).getScreenByDate(chosenFilmName,chosenDate);
            screenPanel = new ScreenPanel(chosenFilmName,chosenDate);
            seatButton = screenPanel.seatButton;

            for(int i = 0 ; i <seatButton.length; i++){
                for(int j = 0; j<seatButton[i].length; j++){
                    seatButton[i][j].addActionListener(seatActionListener);
                }
            }
            mainPanel.removeAll();
            mainPanel.add(screenPanel);
            mainPanel.validate();

        }
    };

    ActionListener seatActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton chosenSeatButton = (JButton)e.getSource();
                char chosenSeatRowinChar = chosenSeatButton.getText().charAt(0);
                int chosenSeatRow = (int)(chosenSeatRowinChar-'A'-1);
                int chosenSeatCol = Integer.parseInt(""+chosenSeatButton.getText().charAt(1));
//            System.out.println("ChosenSeat"+chosenSeatRow+chosenSeatCol);

            chosenSeat = new Seat(false,chosenSeatRow,chosenSeatCol);
            ticketTypePanel = new TicketTypePanel();
            ticketTypePanel.submitButton.addActionListener(ticketTypeActionListener);
            mainPanel.removeAll();
            mainPanel.add(ticketTypePanel);
            mainPanel.validate();

        }
    };

    ActionListener ticketTypeActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chosenTicketType = ticketTypePanel.returnTicketType();
//            System.out.println("Ticket Type"+chosenTicketType);
            TicketControl tc = new TicketControl();
            userTicket = tc.generateTicket(chosenScreen,chosenSeat,chosenTicketType);
            confirmPanel = new ConfirmPanel(userTicket);
            confirmPanel.confirmButton.addActionListener(confirmActionListener);
            mainPanel.removeAll();
            mainPanel.add(confirmPanel);
            mainPanel.validate();
//            System.out.println(userTicket);

        }
    };

    ActionListener confirmActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            (new TicketControl()).saveTicket(userTicket);
        }
    };



        @Override
        public void actionPerformed (ActionEvent e){

        }
    }
