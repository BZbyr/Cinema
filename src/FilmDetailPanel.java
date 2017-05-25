
import javax.swing.*;
import java.awt.*;
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
    Font f = new Font("Arial",Font.PLAIN, 30);
    //SimpleDateFormat sdfHours = new SimpleDateFormat("dd-HH:mm");
    //JLabel
    JLabel filmNameLabel = new JLabel();
    JLabel filmIntro = new JLabel();
    JLabel imageLabel;
    //JButton
    JButton filmDateButton[];
    //JPanel
    JPanel filmButtonPanel = new JPanel();
    JPanel filmInfoPanel = new JPanel();
    public FilmDetailPanel(String filmName){
        super();
        set(filmName);
    }
    private void set(String filmName){
        this.setLayout(new BorderLayout());
        this.filmButtonPanel.setLayout(new FlowLayout());

        FilmIO fi = new FilmIO();
        Film film = fi.readFilmInfo(filmName);

//        System.out.println(film.getFilmId());
        filmNameLabel.setText(film.getfilmName());
        filmNameLabel.setHorizontalAlignment(JLabel.CENTER);
        filmNameLabel.setFont(f);
        ImageIcon image = new ImageIcon(film.getPictureSrc());
        imageLabel = new JLabel(image);
        filmIntro.setText("Brief Intro: "+film.getFilmIntro()+"\n" + "Time last:"+film.getTimeInterval());
        filmIntro.setHorizontalAlignment(JLabel.CENTER);
        filmIntro.setFont(f);
        ScreenIO si = new ScreenIO();
        ScreenControl sc = new ScreenControl();
        
        dateArr = sc.getTimeByFilm(film.getFilmId());
//        System.out.println(dateArr.get(1).toString());
        screenArr = si.readScreenInfo();

        filmDateButton = new JButton[dateArr.size()];

        for(int i = 0; i < dateArr.size(); i++){
            filmDateButton[i] = new JButton(Utility.sdf.format(dateArr.get(i)));
            filmButtonPanel.add(filmDateButton[i]);
        }
        filmInfoPanel.setLayout(new FlowLayout());
        filmInfoPanel.add(filmIntro);
        filmInfoPanel.add(imageLabel);

        this.add(filmNameLabel,BorderLayout.NORTH);
        this.add(filmInfoPanel,BorderLayout.CENTER);
        this.add(filmButtonPanel,BorderLayout.SOUTH);
    }
}
