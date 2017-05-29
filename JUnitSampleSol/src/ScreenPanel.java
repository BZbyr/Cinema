
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by wangchao on 2017/4/17 0017.
 */

public class ScreenPanel extends JPanel{
    final Font f = new Font("Arial",Font.PLAIN, 30);
    Font fs = new Font("Arial",Font.BOLD,16);
    Color cn = new Color(255,134,61);
    Screen screen;
    //JLabel
    JLabel filmNameLabel;
    JLabel screenIdLabel;
    //JButton
    JButton  seatButton[][];
    JButton submitButton;
    JButton screenReturnButton;
    //JPanel
    JPanel seatPanel ;
    JPanel submitPanel;

    int rowNum;
    int colNum;

    //HashSet for not existing seats
    HashSet<Seat> seatHashSet;
    public ScreenPanel(String filmName,String date){
        super();
        set(filmName,date);
    }
    //First para: which row; Second para: which button to be judge; return: how many noexist button before this button
    public int getNoExist(int rowNum, int butNum){
        HashSet<Seat> seatHashSet1=this.seatHashSet;
        int notexistCount=0;
        for(Iterator it = seatHashSet1.iterator(); it.hasNext();) {

            Seat tempSeat  = (Seat) it.next();
            if(tempSeat.getRowNum()==rowNum){
                if(tempSeat.getColNum()<butNum){
                    notexistCount++;
                }
            }

        }
        return notexistCount;
    }

    private void set(String filmName, String date) {
        this.setLayout(new BorderLayout());

        filmNameLabel = new JLabel(filmName,JLabel.CENTER);
        filmNameLabel.setFont(f);

        FilmIO fi = new FilmIO();
        Film film = fi.readFilmInfo(filmName);
        ScreenControl sc = new ScreenControl();
//        System.out.println("film:"+film.getfilmName());
//        System.out.println("date:"+date);
        screen = sc.getScreenByDate(film.getfilmName(),date);
        screenIdLabel = new JLabel("Screen NO. "+(screen.getScreenId()+1)+" Time: "+date,JLabel.CENTER);
        screenIdLabel.setFont(f);
        LayoutControl lc = new LayoutControl();
        TicketControl tc = new TicketControl();
//        System.out.println("screen.getLayoutID: "+screen.getLayoutId());
//        System.out.println("screen.getScreenID: "+screen.getScreenId());
//        System.out.println("screen.getFilmID: "+screen.getFilmId());

        Layout layout = lc.getLayoutById(screen.getLayoutId());

        seatHashSet = layout.getMissSeatSet();
        System.out.println(seatHashSet);
        HashSet<Seat> takenHashSet = tc.getTakenSeat(screen.getScreenId(),screen.getDate());
        colNum = layout.getColNum();
        rowNum = layout.getRowNum();

        seatButton = new JButton[rowNum][colNum];
        seatPanel= new JPanel(new GridLayout(rowNum,colNum,30,30));
        int countNotExist = 0;
        for(int rowCount = 0; rowCount < rowNum; rowCount++){
            for(int colCount = 0; colCount < colNum; colCount++){
                seatButton[rowCount][colCount] = new JButton(""+ Utility.intToChar(rowCount)+(colCount+1-countNotExist));
                seatButton[rowCount][colCount].setBackground(Utility.c);
                seatPanel.add(seatButton[rowCount][colCount]);
            }
        }
        for(int rowCount = 0; rowCount < rowNum; rowCount++){
            countNotExist = 0;

            for(int colCount = 0; colCount < colNum; colCount++){

                Seat seat = new Seat(false,rowCount,colCount);

                //This seat is not exist
                if(seatHashSet.contains(seat)){
                    seatButton[rowCount][colCount].setVisible(false);
//                    System.out.println("notEXIST"+rowCount+colCount);
                    countNotExist++;
                }
                //This seat has been taken
                if(takenHashSet.contains(seat)){
//                    System.out.println("TAKEN"+rowCount+colCount);
                    seatButton[rowCount][(colCount+countNotExist)-1].setBackground(Color.GRAY);
                    seatButton[rowCount][(colCount+countNotExist)-1].setEnabled(false);
                }
            }
        }
        JLabel screenLable = new JLabel("Screen",JLabel.CENTER);
        screenLable.setFont(fs);
        screenReturnButton = new JButton("Return");
        screenReturnButton.setFont(fs);
        screenReturnButton.setBackground(Color.lightGray);
        submitPanel = new JPanel(new BorderLayout());
        screenReturnButton.setPreferredSize(new Dimension(120,20));
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.lightGray);
        submitButton.setFont(fs);
        submitButton.setPreferredSize(new Dimension(100,50));
        submitPanel.add(screenLable,BorderLayout.NORTH);
        submitPanel.add(submitButton,BorderLayout.EAST);
        submitPanel.add(screenReturnButton,BorderLayout.WEST);
        this.add(filmNameLabel,BorderLayout.NORTH);
        this.add(screenIdLabel,BorderLayout.NORTH);
        this.add(seatPanel,BorderLayout.CENTER);
        this.add(submitPanel,BorderLayout.SOUTH);
    }
}
