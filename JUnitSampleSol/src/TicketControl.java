
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by wangchao on 2017/4/18 0018.
 */
public class TicketControl {
    HashSet<Seat> seatHashSet = new HashSet<Seat>();
    //check is it an used ID,read from ticket.txt

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
    public HashSet<Seat> getTakenSeat(int screenID, Date date){

        TicketIO ti = new TicketIO();
        ArrayList<Ticket> ticketArrayList = ti.readInfo();
        //将已有Ticket的座位取出来
        for(int i = 0; i< ticketArrayList.size();i++){
            if(ticketArrayList.get(i).getScreenId()==screenID&&
                    ticketArrayList.get(i).getDate().equals(date)) {
                int seatInt[] = ticketArrayList.get(i).getSeat();
                Seat tempSeat = new Seat(false, seatInt[0], seatInt[1]);
                System.out.println("Taken Seat"+tempSeat.getRowNum()+":"+tempSeat.getColNum());
                seatHashSet.add(tempSeat);
            }
        }
        return seatHashSet;
    }
}
