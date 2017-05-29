
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;


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
        String ticketTypeString = getTypeName();

        return  "<html><body>" +
                "Ticket ID: "+ticketId+
                "<br/>Film Name:" + film.getfilmName()+
                "<br/>Time: " + Utility.sdf.format(date) +" "+
                 timeInterval + "min" +
                "<br/>" +"\nScreen: " + screenId +
                "<br/>seat: [" + (char)('A'+seat[0])+seat[1] +"]"+
                "<br/>Tick type: " + ticketTypeString
                +"</body></html>";
    }

    //Constructor
    public Ticket(){

    }
    public String getTypeName(){
        String ticketTypeString = "";
        switch (this.ticketType){
            case 1:
                ticketTypeString = "Normal";
                break;
            case 2:
                ticketTypeString = "Student";
                break;
            case 3:
                ticketTypeString = "Children";
                break;
            case 4:
                ticketTypeString = "Senior";
                break;
            default:
                ticketTypeString = "Normal";
                break;
        }
        return ticketTypeString;
    }
    public Ticket(int filmId,Date passedDate,int timeInterval,int screenId,int[] seat, int ticketType){

        TicketControl tc = new TicketControl();
        this.ticketId = getRandomID();
        this.filmId = filmId;
        this.seat = seat;
        /*if(Test.Debug){
            System.out.println(seat);
        }*/
        this.screenId = screenId;
        this.date = passedDate;

        this.timeInterval = timeInterval;
        this.ticketType = ticketType;
    }
    public Film getFilm(){
        Film film = (new FilmIO()).readFilmInfo(""+filmId);
        return film;
    }

    public String getRandomID(){
        int max=4;
        int min=1;
        String randomID;
        do {
            Random random = new Random();
            int random1 = random.nextInt(max) % (max - min + 1) + min;
            int random2 = random.nextInt(max) % (max - min + 1) + min;
            int random3 = random.nextInt(max) % (max - min + 1) + min;
            int random4 = random.nextInt(max) % (max - min + 1) + min;
            int random5 = random.nextInt(max) % (max - min + 1) + min;
            int random6 = random.nextInt(max) % (max - min + 1) + min;

            randomID = "" + random1 + random2 + random3 + random4 + random5 + random6;
        }while(!checkId(randomID));

        return randomID;
    }
    public boolean checkId(String randomID){
        ArrayList<Ticket> ticketArr = new ArrayList<>();

        boolean checkFlag = true;

        ticketArr = (new TicketIO()).readInfo();

        for(int i = 0; i < ticketArr.size(); i++){
            if (ticketArr.get(i).getTicketId().equals(randomID)){
                checkFlag = false;
            }
        }
        //true means there is no duplicate
        return checkFlag;
    }




}
