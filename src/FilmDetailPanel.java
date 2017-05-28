
import javax.rmi.CORBA.Util;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class FilmDetailPanel extends JPanel{
    ArrayList<Screen> screenArr = new ArrayList<>();
    ArrayList<Date>dateArr = new ArrayList<>();

    //JLabel
    JLabel filmNameLabel = new JLabel();
    JLabel filmIntro = new JLabel();
    JLabel imageLabel;
    //JButton
    JButton filmDateButton[];
    JButton detailReturnBut = new JButton("Return");
    //JPanel
    JPanel filmButtonPanel = new JPanel();
    JPanel filmInfoPanel = new JPanel();
    public FilmDetailPanel(String filmName){
        super();
        set(filmName);
    }
    private void set(String filmName){
        this.setLayout(new BorderLayout());
        this.filmButtonPanel.setLayout(new GridLayout(0,3,20,20));

        FilmIO fi = new FilmIO();
        Film film = fi.readFilmInfo(filmName);

        filmNameLabel.setText(film.getfilmName());
        filmNameLabel.setHorizontalAlignment(JLabel.CENTER);
        filmNameLabel.setFont(Utility.f);
        ImageIcon image = new ImageIcon(film.getPictureSrc());
        imageLabel = new JLabel(image);
        filmIntro.setText("<html>Brief Intro: "+film.getFilmIntro()+"\n" + "<br>Time last:"+film.getTimeInterval()+"mins<html>");
        filmIntro.setHorizontalAlignment(JLabel.CENTER);
        filmIntro.setFont(Utility.f);
        ScreenIO si = new ScreenIO();
        ScreenControl sc = new ScreenControl();
        
        dateArr = sc.getTimeByFilm(film.getFilmId());
//        System.out.println(dateArr.get(1).toString());
        screenArr = si.readScreenInfo();

        filmDateButton = new JButton[dateArr.size()];
        detailReturnBut.setPreferredSize(new Dimension(100,60));
        detailReturnBut.setBackground(Utility.c);
        detailReturnBut.setFont(Utility.fs);
        for(int i = 0; i < dateArr.size(); i++){
            filmDateButton[i] = new JButton(Utility.sdf.format(dateArr.get(i)));
            filmDateButton[i].setPreferredSize(new Dimension(100,60));
            filmDateButton[i].setBackground(Utility.cl);
            filmDateButton[i].setFont(Utility.fs);
            Date current = new Date();
            try {
                current = Utility.sdf.parse(Utility.sdf.format(new Date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(current.getTime()>dateArr.get(i).getTime()){
                filmDateButton[i].setVisible(false);
            }
            filmButtonPanel.add(filmDateButton[i]);
        }
        filmButtonPanel.add(detailReturnBut);
        filmInfoPanel.setLayout(new GridLayout(0,2,10,0));
        filmInfoPanel.add(filmIntro);
        filmInfoPanel.add(imageLabel);

        this.add(filmNameLabel,BorderLayout.NORTH);
        this.add(filmInfoPanel,BorderLayout.CENTER);
        this.add(filmButtonPanel,BorderLayout.SOUTH);
    }
}
