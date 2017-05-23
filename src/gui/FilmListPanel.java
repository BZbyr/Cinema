package gui;

import cinema.FilmControl;
import cinema.Film;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class FilmListPanel extends JPanel{
    Font f = new Font("Arial",Font.PLAIN, 30);

    //JLabel
    JLabel filmListLabel = new JLabel("Film List",JLabel.CENTER);

    //JButton
    JButton filmListButton[];
    JPanel filmListButtonPanel = new JPanel();

    public FilmListPanel(){
        super();
        this.setLayout(new BorderLayout());
        FilmControl fc = new FilmControl();
        ArrayList<Film> filmList = fc.listFilm();
        filmListButton = new JButton[filmList.size()];

        for(int i = 0; i < filmList.size() ; i++){
            JButton tempButton = new JButton(""+filmList.get(i).getfilmName());
            filmListButton[i] = tempButton;
            filmListButton[i].setPreferredSize(new Dimension(200,100));
            filmListButtonPanel.add(filmListButton[i]);
        }

        filmListLabel.setFont(f);
        this.setLayout(new BorderLayout());
        this.add(filmListLabel,BorderLayout.NORTH);
        this.add(filmListButtonPanel,BorderLayout.CENTER);

    }
}
