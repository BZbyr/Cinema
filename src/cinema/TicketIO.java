package cinema;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/18 0018.
 */
public class TicketIO implements IO{
    File TicketInfo = new File("src/texts/TicketInfo.txt");

    public boolean writeInfo(Object obj){
        Ticket ticket = (Ticket) obj;
        boolean flag = true;
        BufferedWriter bw = null;
        String line = "" + ticket.getTicketId() + "$" + ticket.getFilmId() + "$" + Utility.sdf.format(ticket.getDate()) + "$"
                + ticket.getTimeInterval() + "$" + ticket.getScreenId() + "$" + ticket.getSeat()[0] +"$"+ ticket.getSeat()[1] + "$" + ticket.getTicketType();

        try {
            //追加写 append: true
            bw = new BufferedWriter(new FileWriter(TicketInfo,true));
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public ArrayList<Ticket> readInfo(){
        ArrayList<Ticket> ticketArr = new ArrayList<Ticket>();
        BufferedReader br = null;
        String line = "";
        String lineElement [];
        try {
            br = new BufferedReader(new FileReader(TicketInfo));

        while((line = br.readLine()) != null){
            Ticket tempTicket = new Ticket();
            lineElement = line.split("\\$");
            tempTicket.setTicketId(lineElement[0]);
            tempTicket.setFilmId(Integer.parseInt(lineElement[1]));
            tempTicket.setDate(Utility.sdf.parse(lineElement[2]));
            tempTicket.setTimeInterval(Integer.parseInt(lineElement[3]));
            tempTicket.setScreenId(Integer.parseInt(lineElement[4]));
            int tempSeat[] = new int[2];
            tempSeat[0] = Integer.parseInt(lineElement[5]);
            tempSeat[1] = Integer.parseInt(lineElement[6]);
            tempTicket.setSeat(tempSeat);
            tempTicket.setTicketType(Integer.parseInt(lineElement[7]));

            ticketArr.add(tempTicket);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticketArr;
    }
}
