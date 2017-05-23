package cinema;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wangchao on 2017/3/29.
 */
public class Screen {
    ArrayList<Screen> screenArr = new ArrayList<>();

    private int  screenId;
    private int filmId;
    private Date date;
    private int timeInterval;//in minute
    private int leftTicketNum;//number of ticket left
    private int totalSeatNum;
    private int layoutId;

    //Getter
    public int getScreenId() {
        return screenId;
    }
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
    //Setter
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
            this.date = Utility.sdf.parse(stringDate);
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
            this.date = Utility.sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.timeInterval = timeInterval;
        this.leftTicketNum = totalSeatNum;
        this.totalSeatNum = totalSeatNum;
        this.layoutId = layoutId;

    }

}
