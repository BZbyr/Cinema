package cinema.IO;

import Test.Test;
import cinema.Entity.Screen;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class ScreenIO {
    File ScreenInfo = new File("src/texts/ScreenInfo.txt");
    //format of date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");

    //return numbers of screen
    public int calScreenNum() {
        BufferedReader br = null;
        String line = "";
        int count = 0;
        try {
            br = new BufferedReader(new FileReader(ScreenInfo));
            while ((line = br.readLine()) != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void writeScreenInfo(Screen screen, boolean appendFlag) {
        BufferedWriter bw = null;
        String line = "" + screen.getScreenId() + "$" + screen.getFilmId() + "$" + sdf.format(screen.getDate()) + "$" + screen.getTimeInterval() + "$"
                + screen.getLeftTicketNum() + "$" + screen.getTotalSeatNum() + "$" + screen.getLayoutId();
        //debug
        if (Test.Debug)
            System.out.println(line);
        try {
            //追加写 append: true
            bw = new BufferedWriter(new FileWriter(ScreenInfo, appendFlag));
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Screen> readScreenInfo() {

        ArrayList<Screen> screenArr = new ArrayList<Screen>();
        BufferedReader br = null;
        String line = "";
        String lineElement[];
        try {
            br = new BufferedReader(new FileReader(ScreenInfo));
            while ((line = br.readLine()) != null) {
                //文件分割符
                lineElement = line.split("\\$");
                //String line = "" + screen.screenId + "$" + screen.filmId + "$" + sdf.format(screen.date) + "$" +
                // screen.timeInterval + "$"
                //+ screen.leftTicketNum + screen.totalSeatNum + screen.layoutId;
                Screen tempScreen = new Screen();
                tempScreen.setScreenId(Integer.parseInt(lineElement[0]));
                tempScreen.setFilmId(Integer.parseInt(lineElement[1]));
                tempScreen.setDate(sdf.parse(lineElement[2]));
                tempScreen.setTimeInterval(Integer.parseInt(lineElement[3]));
                tempScreen.setLeftTicketNum(Integer.parseInt(lineElement[4]));
                tempScreen.setTotalSeatNum(Integer.parseInt(lineElement[5]));
                tempScreen.setLayoutId(Integer.parseInt(lineElement[6]));
                screenArr.add(tempScreen);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return screenArr;
    }
}
