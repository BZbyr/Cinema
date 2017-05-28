
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
//Label
//Button
public class FilmListPanel extends JPanel{
    Font f = new Font("Arial",Font.BOLD, 30);
    Font fs = new Font("Arial",Font.PLAIN,18);
    Color c = new Color(157,195,229);

    //JLabel
    JLabel filmListLabel = new JLabel("Film List:",JLabel.CENTER);

    //JButton
    JButton filmListButton[];
    JPanel filmListButtonPanel = new JPanel();

    public FilmListPanel(){
        super();
        set();
    }
    
    private void set(){
        this.setLayout(new BorderLayout());
        FilmControl fc = new FilmControl();
        ArrayList<Film> filmList = fc.listFilm();
        filmListButton = new JButton[filmList.size()];
        filmListButtonPanel.setLayout(new GridLayout(5,0,0,20));
        filmListButtonPanel.setBorder(new EmptyBorder(20, 250, 50, 250));

        for(int i = 0; i < filmList.size() ; i++){
            JButton tempButton = new JButton(""+filmList.get(i).getfilmName());
            filmListButton[i] = tempButton;
            filmListButton[i].setPreferredSize(new Dimension(200,100));
            filmListButton[i].setBackground(c);
            filmListButton[i].setFont(fs);
            filmListButtonPanel.add(filmListButton[i]);
        }

        filmListLabel.setFont(f);
        this.setLayout(new BorderLayout());
        this.add(filmListLabel,BorderLayout.NORTH);
        this.add(filmListButtonPanel,BorderLayout.CENTER);
    }
}
