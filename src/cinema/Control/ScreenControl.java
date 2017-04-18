package cinema.Control;

import Test.Test;
import cinema.Entity.Screen;
import cinema.IO.FilmIO;
import cinema.IO.ScreenIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class ScreenControl {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");

    //occred when book / refund ticket
    //update screen.txt modify leftTicketNum by int num
    public void update(int screenId, String Date, int num){
        ScreenIO si = new ScreenIO();
        ArrayList<Screen> screenArr = new ArrayList<Screen>();
        screenArr = si.readScreenInfo();
        //从Arraylist写入
        for(int j = 0; j < screenArr.size();j++){
            Screen writeTempScreen = new Screen();
            writeTempScreen = (Screen)screenArr.get(j);
            //如果第一位（screenId位）以及日期位（date位）与传进来的匹配，则唯一确定条目
            if(Test.Debug) {
                System.out.println("screen id " + writeTempScreen.getScreenId() + " compare " + screenId);
                System.out.println("date " + sdf.format(writeTempScreen.getDate()) + " compare " + Date);
            }
            if(writeTempScreen.getScreenId() == screenId && sdf.format(writeTempScreen.getDate()).equals(Date)){
                writeTempScreen.setLeftTicketNum(writeTempScreen.getLeftTicketNum()+num);
                if(writeTempScreen.getLeftTicketNum() < 0 || writeTempScreen.getLeftTicketNum()>writeTempScreen.getTotalSeatNum()){
                    System.out.println("Error");
                }
            }

            si.writeScreenInfo(writeTempScreen,false);
        }
    }

    public ArrayList<Date> getTimeByFilm(int filmId){
        ArrayList<Date> dateArr = new ArrayList<Date>();
        ArrayList<Screen>screenArr = new ArrayList<Screen>();
        screenArr = (new ScreenIO()).readScreenInfo();

        for(int i = 0 ; i < screenArr.size() ; i++){
            if(screenArr.get(i).getFilmId() == filmId){
                Date tmpDate = screenArr.get(i).getDate();
                dateArr.add(tmpDate);
            }
        }
        return dateArr;
    }
    public Screen getScreenByDate(String filmName,String date){
        int filmId = (new FilmControl().getFilmByName(filmName).getFilmId());

        Screen tempScreen = new Screen();
        ArrayList<Screen>screenArr = new ArrayList<Screen>();
        screenArr = new ScreenIO().readScreenInfo();

        for(int i = 0 ; i<screenArr.size();i++){
            if(sdf.format(screenArr.get(i).getDate()).equals(date)&& screenArr.get(i).getFilmId()==filmId){
                tempScreen = screenArr.get(i);
            }
        }
        return tempScreen;
    }
}
