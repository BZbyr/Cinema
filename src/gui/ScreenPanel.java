package gui;

import cinema.Control.LayoutControl;
import cinema.Control.ScreenControl;
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
    Font f = new Font("Arial",Font.PLAIN, 30);

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");

    Screen screen;
    //JLabel
    JLabel filmNameLabel;
    JLabel screenIdLabel;
    //JButton
    JButton  seatButton[][];
    //JPanel
    JPanel seatPanel ;
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
        Layout layout = lc.getLayoutById(screen.getLayoutId());

        HashSet<Seat> seatHashSet = layout.getMissSeatSet();
        System.out.println(seatHashSet);
        int colNum = layout.getColNum();
        int rowNum = layout.getRowNum();
        int totalSeat = colNum*rowNum;

        seatButton = new JButton[rowNum][colNum];
        seatPanel= new JPanel(new GridLayout(rowNum,colNum));
        char rowChar = 'A';
        for(int rowCount = 0; rowCount < rowNum; rowCount++){
            rowChar += 1;
            for(int colCount = 0; colCount < colNum; colCount++){
                seatButton[rowCount][colCount] = new JButton(""+rowChar+colCount);
               // System.out.print("row"+rowCount+"col"+colCount);
                seatPanel.add(seatButton[rowCount][colCount]);
                Seat seat = new Seat(false,rowCount,colCount);

                if(seatHashSet.contains(seat)){
                    seatButton[rowCount][colCount].setVisible(false);
                }

            }
            //System.out.println();
        }
        this.add(filmNameLabel,BorderLayout.NORTH);
        this.add(screenIdLabel,BorderLayout.NORTH);
        this.add(seatPanel,BorderLayout.CENTER);

    }
}
