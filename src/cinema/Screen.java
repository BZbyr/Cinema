package cinema;

import Test.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Created by wangchao on 2017/3/29.
 */
public class Screen {
    ArrayList<Screen> screenArr = new ArrayList<Screen>();
    //screen.txt
    File ScreenInfo = new File("src/texts/ScreenInfo.txt");
    //日期格式
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");

    private int  screenId;

    public int getScreenId() {
        return screenId;
    }

    private int filmId;

    public int getFilmId() {
        return filmId;
    }

    public Date getDate() {
        return date;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public int getLeftTicketNum() {
        return leftTicketNum;
    }

    public int getTotalSeatNum() {
        return totalSeatNum;
    }

    public int getLayoutId() {
        return layoutId;
    }

    //日期
    private Date date;
    //时间长度(分钟计)
    private int timeInterval;
    //余票量
    private int leftTicketNum;
    //座位个数
    private int totalSeatNum;
    private int layoutId;

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public void setLeftTicketNum(int leftTicketNum) {
        this.leftTicketNum = leftTicketNum;
    }

    public void setTotalSeatNum(int totalSeatNum) {
        this.totalSeatNum = totalSeatNum;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public Screen(){

    }

    public Screen(int screenId,int filmId, String stringDate,int timeInterval, int totalSeatNum,
                  int layoutId){
        //int currentNum = this.calScreenNum();
        //this.screenId = currentNum+1;
        this.screenId = screenId;
        this.filmId = filmId;
        try {
            this.date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.timeInterval = timeInterval;
        this.leftTicketNum = totalSeatNum;
        this.totalSeatNum = totalSeatNum;
        this.layoutId = layoutId;
    }
    public Screen(int screenId, int filmId, String stringDate, int timeInterval, int leftTicketNum, int totalSeatNum,
                  int layoutId){
        /*int currentNum = this.calScreenNum();
        this.screenId = currentNum+1;*/
        this.screenId = screenId;
        this.filmId = filmId;
        try {
            this.date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.timeInterval = timeInterval;
        this.leftTicketNum = totalSeatNum;
        this.totalSeatNum = totalSeatNum;
        this.layoutId = layoutId;

    }
    public void writeScreenInfo(Screen screen,boolean appendFlag){
        BufferedWriter bw = null;
        String line = "" + screen.screenId + "$" + screen.filmId + "$" + sdf.format(screen.date) + "$" + screen.timeInterval + "$"
                + screen.leftTicketNum +"$"+ screen.totalSeatNum+ "$" + screen.layoutId;
        //debug
        if(Test.Debug)
            System.out.println(line);
        try {
            //追加写 append: true
            bw = new BufferedWriter(new FileWriter(ScreenInfo,appendFlag));
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //返回目前screen数量
    public int calScreenNum(){
        BufferedReader br = null;
        String line = "";
        int count = 0 ;
        try {
            br = new BufferedReader(new FileReader(ScreenInfo));
            while((line = br.readLine())!=null){
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    //
    public void readIntoArray(){
        BufferedReader br = null;
        String line = "";
        String lineElement [];
        try {
        br = new BufferedReader(new FileReader(ScreenInfo));
        while((line = br.readLine())!=null){
            //文件分割符
            lineElement = line.split("\\$");
            //String line = "" + screen.screenId + "$" + screen.filmId + "$" + sdf.format(screen.date) + "$" +
            // screen.timeInterval + "$"
            //+ screen.leftTicketNum + screen.totalSeatNum + screen.layoutId;
            Screen tempScreen = new Screen();
            tempScreen.screenId = Integer.parseInt(lineElement[0]);
            tempScreen.filmId = Integer.parseInt(lineElement[1]);
            tempScreen.date = sdf.parse(lineElement[2]);
            tempScreen.timeInterval = Integer.parseInt(lineElement[3]);
            tempScreen.leftTicketNum = Integer.parseInt(lineElement[4]);
            tempScreen.totalSeatNum = Integer.parseInt(lineElement[5]);
            tempScreen.layoutId = Integer.parseInt(lineElement[6]);
            screenArr.add(tempScreen);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
}

    //更新文件 int num 正数代表加，负数代表减，触发时间为退票/订票
    //先读后改再写
    public void update(int screenId, String Date, int num){
        readIntoArray();
        //从Arraylist写入
        for(int j = 0; j < screenArr.size();j++){
            Screen writeTempScreen = new Screen();
            writeTempScreen = (Screen)screenArr.get(j);
            //如果第一位（screenId位）以及日期位（date位）与传进来的匹配，则唯一确定条目
            if(Test.Debug) {
                System.out.println("screen id " + writeTempScreen.screenId + " compare " + screenId);
                System.out.println("date " + sdf.format(writeTempScreen.date) + " compare " + Date);
            }
            if(writeTempScreen.screenId == screenId && sdf.format(writeTempScreen.date).equals(Date)){
                writeTempScreen.leftTicketNum += num;
                if(writeTempScreen.leftTicketNum < 0 || writeTempScreen.leftTicketNum>writeTempScreen.totalSeatNum){
                    System.out.println("Error");
                }
            }

            writeScreenInfo(writeTempScreen,false);
        }
    }
    public ArrayList<Date> getTimeByFilm(int filmId){
        ArrayList<Date> dateArr = new ArrayList<Date>();
        BufferedReader br = null;
        String line = "";
        String lineElement [];
        try {
            br = new BufferedReader(new FileReader(ScreenInfo));
            while((line = br.readLine())!=null){
                lineElement = line.split("\\$");
                if(Integer.parseInt(lineElement[1]) == filmId) {
                    if (Test.Debug) {
                        System.out.println("Find film with same id");
                    }
                    Date tmpDate = sdf.parse(lineElement[2]);
                    dateArr.add(tmpDate);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateArr;
    }
    public Screen getScreenByDate(String date){
        BufferedReader br = null;
        String line = "";
        String lineElement [];
        Screen tempScreen = new Screen();

        try {
            br = new BufferedReader(new FileReader(ScreenInfo));
            while((line = br.readLine())!=null){
                lineElement = line.split("\\$");
                if(lineElement[2].equals(date)) {
                    if (Test.Debug) {
                        System.out.println("Find film with same date");
                    }
                    tempScreen.screenId = Integer.parseInt(lineElement[0]);
                    tempScreen.filmId = Integer.parseInt(lineElement[1]);
                    tempScreen.date = sdf.parse(lineElement[2]);
                    tempScreen.timeInterval = Integer.parseInt(lineElement[3]);
                    tempScreen.leftTicketNum = Integer.parseInt(lineElement[4]);
                    tempScreen.totalSeatNum = Integer.parseInt(lineElement[5]);
                    tempScreen.layoutId = Integer.parseInt(lineElement[6]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tempScreen;
    }

}
