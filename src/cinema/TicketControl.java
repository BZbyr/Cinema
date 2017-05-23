package cinema;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by wangchao on 2017/4/18 0018.
 */
public class TicketControl {
    ArrayList<Ticket> ticketArr = new ArrayList<>();
    HashSet<Seat> seatHashSet = new HashSet<>();
    //check is it an used ID,read from ticket.txt
    public boolean checkId(String randomID){
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
            randomID = "" + random1 + random2 + random3 + random4;
        }while(!checkId(randomID));

        return randomID;
    }
    public Ticket generateTicket(Screen chosenScreen, Seat chosenSeat, int ticketType) {

        int seat[] = {chosenSeat.getRowNum(),chosenSeat.getColNum()};
        Ticket ticket = new Ticket(chosenScreen.getFilmId(), chosenScreen.getDate(), chosenScreen.getTimeInterval()
                , chosenScreen.getScreenId(), seat, ticketType);

        return ticket;
    }
    public boolean saveTicket(Ticket ticket){
        boolean flag = true;
        TicketIO ti = new TicketIO();
        flag = ti.writeInfo(ticket);

        String str = ticket.getTicketId();
        Film film = ticket.getFilm();
        
        return flag;
    }
    public HashSet<Seat> getTakenSeat(int screenID){
        
        TicketIO ti = new TicketIO();
        ArrayList<Ticket> ticketArrayList = ti.readInfo();
        //将已有Ticket的座位取出来
        for(int i = 0; i< ticketArrayList.size();i++){
            if(ticketArrayList.get(i).getScreenId()==screenID) {
                int seatInt[] = ticketArrayList.get(i).getSeat();
                Seat tempSeat = new Seat(false, seatInt[0], seatInt[1]);
                seatHashSet.add(tempSeat);
            }
        }
        return seatHashSet;
    }
}
