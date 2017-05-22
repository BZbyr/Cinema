package cinema;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import Test.*;
import cinema.TicketControl;
import cinema.FilmIO;

/**
 * Created by wangchao on 2017/3/24.
 */
public class Ticket {
    //Random number as ticketID
    private String ticketId;
    private int filmId;
    private Date date;
    private int timeInterval;
    private int screenId;
    private int[] seat;
    private int ticketType;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int[] getSeat() {
        return seat;
    }

    public void setSeat(int[] seat) {
        this.seat = seat;
    }

    public int getTicketType() {
        return ticketType;
    }

    public void setTicketType(int ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        Film film = (new FilmIO()).readFilmInfo(""+filmId);
        return  "\nFilm Name:" + film.getfilmName()+
                "\nTime: " + date +
                "\n" + timeInterval + "min" +
                "\nScreen: " + screenId +
                "\nseat: " + Arrays.toString(seat) +
                "\nTick type: " + ticketType ;
    }

    //Constructor
    public Ticket(){

    }
    public Ticket(int filmId,Date passedDate,int timeInterval,int screenId,int[] seat, int ticketType){

        TicketControl tc = new TicketControl();
        this.ticketId = tc.getRandomID();
        this.filmId = filmId;
        this.seat = seat;
        if(Test.Debug){
            System.out.println(seat);
        }
        this.screenId = screenId;
        this.date = passedDate;

        this.timeInterval = timeInterval;
        this.ticketType = ticketType;
    }
    public Film getFilm(){
        Film film = (new FilmIO()).readFilmInfo(""+filmId);
        return film;
    }




}
