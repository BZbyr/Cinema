package gui;

import cinema.Control.ScreenControl;
import cinema.Entity.Film;
import cinema.Entity.Screen;
import cinema.IO.FilmIO;
import cinema.IO.ScreenIO;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class FilmDetailPanel extends JPanel{
    Font f = new Font("Arial",Font.PLAIN, 30);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");

    //JLabel
    JLabel filmNameLabel = new JLabel();
    JLabel filmIntro = new JLabel();
    //JButton
    JButton filmDateButton[];
    //JPanel
    JPanel filmButtonPanel = new JPanel();
    public FilmDetailPanel(String filmName){
        super();
        this.setLayout(new BorderLayout());
        this.filmButtonPanel.setLayout(new FlowLayout());

        FilmIO fi = new FilmIO();
        Film film = fi.readFilmInfo(filmName);

        System.out.println(film.getFilmId());
        filmNameLabel.setText(film.getfilmName());
        filmNameLabel.setHorizontalAlignment(JLabel.CENTER);
        filmNameLabel.setFont(f);
        filmIntro.setText("Brief Intro: "+film.getFilmIntro()+"\n" + "Time last:"+film.getTimeInterval());
        filmIntro.setHorizontalAlignment(JLabel.CENTER);
        filmIntro.setFont(f);
        ScreenIO si = new ScreenIO();
        ScreenControl sc = new ScreenControl();
        ArrayList<Screen> screenArr = new ArrayList<Screen>();
        ArrayList<Date>dateArr = new ArrayList<Date>();
        dateArr = sc.getTimeByFilm(film.getFilmId());
        System.out.println(dateArr.get(1).toString());
        screenArr = si.readScreenInfo();

        filmDateButton = new JButton[dateArr.size()];

        for(int i = 0; i < dateArr.size(); i++){
            filmDateButton[i] = new JButton(sdf.format(dateArr.get(i)));
            filmButtonPanel.add(filmDateButton[i]);
        }

        this.add(filmNameLabel,BorderLayout.NORTH);
        this.add(filmIntro,BorderLayout.CENTER);
        this.add(filmButtonPanel,BorderLayout.SOUTH);



    }
}
