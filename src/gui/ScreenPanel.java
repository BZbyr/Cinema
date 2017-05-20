package gui;

import cinema.Control.LayoutControl;
import cinema.Control.ScreenControl;
import cinema.Control.TicketControl;
import cinema.Control.Utility;
import cinema.Entity.Film;
import cinema.Entity.Layout;
import cinema.Entity.Screen;
import cinema.Entity.Seat;
import cinema.IO.FilmIO;
import cinema.IO.LayoutIO;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by wangchao on 2017/4/17 0017.
 */

public class ScreenPanel extends JPanel{
    final Font f = new Font("Arial",Font.PLAIN, 30);

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");

    Screen screen;
    //JLabel
    JLabel filmNameLabel;
    JLabel screenIdLabel;
    //JButton
    JButton  seatButton[][];
    JButton submitButton;
    //JPanel
    JPanel seatPanel ;
    JPanel submitPanel;

    int rowNum;
    int colNum;

    //HashSet for not existing seats
    HashSet<Seat> seatHashSet;
    public ScreenPanel(String filmName,String date){
        super();
        this.setLayout(new BorderLayout());

        filmNameLabel = new JLabel(filmName,JLabel.CENTER);
        filmNameLabel.setFont(f);

        FilmIO fi = new FilmIO();
        Film film = fi.readFilmInfo(filmName);
        ScreenControl sc = new ScreenControl();
        screen = sc.getScreenByDate(film.getfilmName(),date);
        screenIdLabel = new JLabel("NO. "+screen.getScreenId()+"Date: "+date,JLabel.CENTER);

        screenIdLabel.setFont(f);
        LayoutControl lc = new LayoutControl();
        TicketControl tc = new TicketControl();
        Layout layout = lc.getLayoutById(screen.getLayoutId());

        seatHashSet = layout.getMissSeatSet();
        System.out.println(seatHashSet);
        HashSet<Seat> takenHashSet = tc.getTakenSeat(screen.getScreenId());
        colNum = layout.getColNum();
        rowNum = layout.getRowNum();

        seatButton = new JButton[rowNum][colNum];
        seatPanel= new JPanel(new GridLayout(rowNum,colNum));
        for(int rowCount = 0; rowCount < rowNum; rowCount++){
            int countNotExist = 0;

            for(int colCount = 0; colCount < colNum; colCount++){
                seatButton[rowCount][colCount] = new JButton(""+ Utility.intToChar(rowCount)+(colCount+1-countNotExist));
                seatButton[rowCount][colCount].setBackground(Utility.c);
                seatPanel.add(seatButton[rowCount][colCount]);
                Seat seat = new Seat(false,rowCount,colCount);

                //此Seat不存在
                if(seatHashSet.contains(seat)){
                    seatButton[rowCount][colCount].setVisible(false);
                    countNotExist++;
                }
                //此Seat已经被占用了
                if(takenHashSet.contains(seat)){
                    seatButton[rowCount][colCount].setBackground(Color.BLUE);
                    seatButton[rowCount][colCount].setEnabled(false);
                }

            }
        }
        JLabel screenLable = new JLabel("Screen",JLabel.CENTER);
        submitPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("submit");
        submitPanel.add(screenLable);
        submitPanel.add(submitButton);
        this.add(filmNameLabel,BorderLayout.NORTH);
        this.add(screenIdLabel,BorderLayout.NORTH);
        this.add(seatPanel,BorderLayout.CENTER);
        this.add(submitPanel,BorderLayout.SOUTH);

    }
    //第一个值传所在行，第二个值传想要判断的按钮的位置，返回这个按钮前面有多少个空位
    public int getNoExist(int rowNum, int butNum){
        HashSet<Seat> seatHashSet=this.seatHashSet;
        int notexistCount=0;
        for(Iterator it = seatHashSet.iterator(); it.hasNext();)
        {

            Seat tempSeat  = (Seat) it.next();
            if(tempSeat.getRowNum()==rowNum){
                if(tempSeat.getColNum()<butNum){
                    notexistCount++;
                }
            }

        }
        return notexistCount;

    }
}
