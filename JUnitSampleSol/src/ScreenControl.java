
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class ScreenControl {
    ArrayList<Screen>screenArr = new ArrayList<Screen>();
    ArrayList<Date> dateArr = new ArrayList<Date>();
    Screen writeTempScreen = new Screen();
    //update screen.txt modify leftTicketNum by int num
    public void update(int screenId, String Date, int num){
        ScreenIO si = new ScreenIO();
        
        screenArr = si.readScreenInfo();
        for(int j = 0; j < screenArr.size();j++){
            
            writeTempScreen = (Screen)screenArr.get(j);
            //unique screen need that screenID and date are both match
           /* if(Test.Debug) {
                System.out.println("screen id " + writeTempScreen.getScreenId() + " compare " + screenId);
                System.out.println("date " + sdf.format(writeTempScreen.getDate()) + " compare " + Date);
            }*/
            if(writeTempScreen.getScreenId() == screenId && Utility.sdf.format(writeTempScreen.getDate()).equals(Date)){
                writeTempScreen.setLeftTicketNum(writeTempScreen.getLeftTicketNum()+num);
                if(writeTempScreen.getLeftTicketNum() < 0 || writeTempScreen.getLeftTicketNum()>writeTempScreen.getTotalSeatNum()){
                    System.out.println("Error");
                }
            }

            si.writeScreenInfo(writeTempScreen,false);
        }
    }

    public ArrayList<Date> getTimeByFilm(int filmId){
        
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
        
        screenArr = new ScreenIO().readScreenInfo();

        for(int i = 0 ; i<screenArr.size();i++){

            if(Utility.sdf.format(screenArr.get(i).getDate()).equals(date)&& screenArr.get(i).getFilmId()==filmId){

                tempScreen = screenArr.get(i);
            }
        }
        return tempScreen;
    }

}
