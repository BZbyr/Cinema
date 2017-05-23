

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    AdminPanel adminPanel = new AdminPanel();

    FilmDetailPanel filmDetailPanel;
    ScreenPanel screenPanel;
    TicketTypePanel ticketTypePanel;
    ConfirmPanel confirmPanel;
    JPanel filmListButtonPanel;
    TicketTypePanel ticketTypePanelArr[];

    //buttons
    JButton filmButton[] = filmListPanel.filmListButton;
    JButton dateButton[];
    JButton seatButton[][];
    //Film List
    ArrayList<Film> filmList = new ArrayList<>();
    //chosenSeatArraylist
    ArrayList <Seat> chosenSeatArr = new ArrayList<>();
    //TicketTypeArrayList
    ArrayList<Integer> ticketTypeArr = new ArrayList<>();
    //number of films
    int filmNum;

    //number of Tickets
    int ticketNum;
    //buffer for chosenMovie
    //这些就是generate一张ticket所必须的属性，分别通过几个panel从user处收集齐
    String chosenFilmName;
    Seat chosenSeat;
    Screen chosenScreen;
    int chosenTicketType;
    ArrayList<Ticket>userTicketArr = new ArrayList<>();

    public mainGUI() {
        super("mainGUI");
        set();
    }

    ActionListener welcomeActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            mainPanel.add(identityPanel);
            mainPanel.validate();
            mainPanel.setVisible(false);
            mainPanel.setVisible(true);
        }
    };
    ActionListener filmActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton tempButton = (JButton) e.getSource();
            chosenFilmName = tempButton.getText();
            filmDetailPanel = new FilmDetailPanel(chosenFilmName);
            dateButton = filmDetailPanel.filmDateButton;
            for (int dateButtonCount=0; dateButtonCount<dateButton.length;dateButtonCount++){
                dateButton[dateButtonCount].addActionListener(dateActionListener);
            }
            mainPanel.removeAll();
            mainPanel.add(filmDetailPanel);
            mainPanel.validate();
            mainPanel.setVisible(false);
            mainPanel.setVisible(true);
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

            int rowNum = screenPanel.rowNum;
            int colNum = screenPanel.colNum;

            //generate actionlistener for every button
            ActionListener actionListener[][] = new ActionListener[rowNum][colNum];
            int counti=0;
            int countj=colNum;
            for(int i = 0 ; i < rowNum;i++){
                for(int j=0;j<colNum;j++){

                    //add every button an actionlistener
                    int finalI = i;
                    int finalJ = j;
                    actionListener[i][j] = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            //judge if there is a non-exsiting button before it.
                            int countNotExist = screenPanel.getNoExist(finalI,finalJ);
                            JButton evenSource = (JButton) e.getSource();
                            Seat seat = new Seat();
                            seat.setTakenFlag(false);
                            seat.setRowNum(finalI);
                            seat.setColNum((finalJ-countNotExist+1));
                            if(chosenSeatArr.contains(seat)){
                                System.out.println("exist remove");
                                chosenSeatArr.remove(seat);
                                evenSource.setBackground(Utility.c);
                            }else{
                                System.out.println("not exist, add");
                                chosenSeatArr.add(seat);
                                System.out.println("this is current size"+chosenSeatArr.size());
                                evenSource.setBackground(Color.BLACK);
                            }
                            for (int i = 0; i < chosenSeatArr.size(); i++) {
                                Seat seatTest = chosenSeatArr.get(i);
                                System.out.println("Row: " + seatTest.getRowNum() + "Col: "+seatTest.getColNum());
                            }
                        }
                    };
                }

            }

            for(int i = 0 ; i <seatButton.length; i++){
                for(int j = 0; j<seatButton[i].length; j++){
                    seatButton[i][j].addActionListener(actionListener[i][j]);
                }
            }
            screenPanel.submitButton.addActionListener(seatSubmitListener);
            screenPanel.screenReturnButton.addActionListener(screenReturnActionListener);
            mainPanel.removeAll();
            mainPanel.add(screenPanel);
            mainPanel.validate();
            mainPanel.setVisible(false);
            mainPanel.setVisible(true);

        }
    };
    ActionListener ticketTypeActionLisArr[];

    ActionListener seatSubmitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ticketNum = chosenSeatArr.size();
            ticketTypePanelArr = new TicketTypePanel[chosenSeatArr.size()];
            ticketTypeActionLisArr = new ActionListener[chosenSeatArr.size()];
            System.out.println("chosenSeatArr.size"+chosenSeatArr.size());
            for(int i = 0;i<ticketNum;i++) {
                int finalI = i;
                ticketTypePanelArr[finalI] =new TicketTypePanel((finalI+1));
                ticketTypeActionLisArr[finalI] = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(ticketTypeArr.size()!=(chosenSeatArr.size()-1)) {

                            ticketTypeArr.add(ticketTypePanelArr[finalI].returnTicketType());
                            mainPanel.removeAll();
                            mainPanel.add(ticketTypePanelArr[finalI + 1]);
                            mainPanel.validate();
                            mainPanel.setVisible(false);
                            mainPanel.setVisible(true);
                        }else{
                            ticketTypeArr.add(ticketTypePanelArr[finalI].returnTicketType());
                            for(int i = 0 ; i<ticketTypeArr.size();i++) {
                                System.out.println(i + "+" + ticketTypeArr.get(i));
                            }
                            for(int i=0; i<ticketNum; i++){
                                TicketControl tc = new TicketControl();
                                Ticket userTicket = tc.generateTicket(chosenScreen,chosenSeatArr.get(i),ticketTypeArr.get(i));
                                userTicketArr.add(userTicket);
                            }
                            confirmPanel = new ConfirmPanel(userTicketArr);
                            confirmPanel.confirmButton.addActionListener(confirmActionListener);
                            mainPanel.removeAll();
                            mainPanel.add(confirmPanel);
                            mainPanel.validate();
                            mainPanel.setVisible(false);
                            mainPanel.setVisible(true);
                        }
                    }
                };
                ticketTypePanelArr[i].submitButton.addActionListener(ticketTypeActionLisArr[i]);
            }
            mainPanel.removeAll();
            mainPanel.add(ticketTypePanelArr[0]);
            mainPanel.validate();
            mainPanel.setVisible(false);
            mainPanel.setVisible(true);
        }
    };

    ActionListener confirmActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0 ;i<userTicketArr.size();i++){
                (new TicketControl()).saveTicket(userTicketArr.get(i));
            }
        }
    };
    ActionListener screenReturnActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            mainPanel.add(filmDetailPanel);
            mainPanel.validate();
            mainPanel.setVisible(false);
            mainPanel.setVisible(true);
        }
    };
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    private void set(){
        mainPanel = this.getContentPane();


        mainPanel.add(welcomePanel);
        //buy ticket panel
        //film list panel
        this.setSize(1000, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton welcomeButton = welcomePanel.welcomeButton;
        welcomeButton.addActionListener(welcomeActionListener);

        JButton identityButton1 = identityPanel.identityButton1;
        JButton identityButton2 = identityPanel.identityButton2;
        JButton idreturnButton = identityPanel.returnButton;

        idreturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(welcomePanel);
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
                mainPanel.validate();
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });
        identityButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(userPanel);
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
                mainPanel.validate();
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });

        //Dialog for the login of Admin
        Dialog  adminLogin= new Dialog( this,"Dialog", true);
        adminLogin.setLayout(new BorderLayout());
        adminLogin.setBounds(400, 200, 1000, 300);
        TextArea usernameTA = new TextArea("username");
        TextArea passwordTA = new TextArea("password");
//        usernameTA.setFont(Utility.f);
//        passwordTA.setFont(Utility.f);
        JButton submitLogin = new JButton("submit");
        JLabel loginLabel = new JLabel("Text your username and password here: ",JLabel.CENTER);
        loginLabel.setFont(Utility.f);
        adminLogin.add(loginLabel,
                BorderLayout.NORTH);
        adminLogin.add(usernameTA,BorderLayout.WEST);
        adminLogin.add(passwordTA,BorderLayout.EAST);
        adminLogin.add(submitLogin,BorderLayout.SOUTH);
        adminLogin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminLogin.setVisible(false);
            }
        });


        identityButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLogin.setVisible(true);
            }
        });
        submitLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminControl ac = new AdminControl();
                boolean success = ac.login(usernameTA.getText(),passwordTA.getText());
                if(success){
                    adminLogin.setVisible(false);
                    mainPanel.removeAll();
                    mainPanel.add(adminPanel);
                    mainPanel.validate();
                    mainPanel.setVisible(false);
                    mainPanel.setVisible(true);
                }else{
                    loginLabel.setText("Wrong username or password, Enter again: ");
                    adminLogin.setVisible(true);
                    usernameTA.setText("username");
                    passwordTA.setText("password");
                    adminLogin.validate();
                    mainPanel.setVisible(false);
                    mainPanel.setVisible(true);
                }
            }
        });

        //Dialog for report
        JButton reportButton = adminPanel.adminChoice;
        JButton closeDialog = new JButton("OK");
        Dialog d = new Dialog( this,"Dialog", true);
        d.setLayout(new BorderLayout());
        d.setBounds(400, 200, 500, 150);
        d.add(new JLabel("Sucess Reported!",JLabel.CENTER),BorderLayout.NORTH);
        d.add(closeDialog,BorderLayout.SOUTH);
        d.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d.setVisible(false);
            }
        });
        closeDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(adminPanel);
                mainPanel.validate();
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
                d.setVisible(false);
            }
        });
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportControl reportControl = new ReportControl();
                reportControl.generateReport();
                d.setVisible(true);
            }
        });
        JButton returnButton = adminPanel.returnButton;
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                identityPanel = new IdentityPanel();
                System.exit(0);

            }
        });

        //User Button
        JButton userButton1 = userPanel.userButton1;
        filmListButtonPanel = filmListPanel.filmListButtonPanel;
        userButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(filmListPanel);
                mainPanel.validate();
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });

        for (int filmButtonCount = 0; filmButtonCount < filmButton.length; filmButtonCount++) {
            filmButton[filmButtonCount].addActionListener(filmActionListener);
        }
    }
}