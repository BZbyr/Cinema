
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/18 0018.
 */
public class TicketIO implements IO{
    File TicketInfo = new File(Utility.Prepath+"texts/TicketInfo.txt");
    ArrayList<Ticket> ticketArr = new ArrayList<>();

    public boolean writeInfo(Object obj){
        Ticket ticket = (Ticket) obj;
        genTicketFile(ticket);
        boolean flag = true;
        BufferedWriter bw = null;
        String line = "" + ticket.getTicketId() + "$" + ticket.getFilmId() + "$" + Utility.sdf.format(ticket.getDate()) + "$"
                + ticket.getTimeInterval() + "$" + ticket.getScreenId() + "$" + ticket.getSeat()[0] +"$"+ ticket.getSeat()[1] + "$" + ticket.getTicketType();

        try {
            //append: true
            bw = new BufferedWriter(new FileWriter(TicketInfo,true));
//            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    private void genTicketFile(Ticket ticket){
        File ticketFile = new File(Utility.Prepath+"texts/"+ticket.getTicketId()+".txt");
        FilmControl fc = new FilmControl();
        String filmName = fc.getFilmByName(""+ticket.getFilmId()).getfilmName();
        BufferedWriter bw = null;
        try {
            if(!ticketFile.exists())
                ticketFile.createNewFile();
            // append: true
            bw = new BufferedWriter(new FileWriter(ticketFile,true));
            bw.write("Ticket ID: "+ticket.getTicketId());
            bw.newLine();
            bw.write("Film Name: " + filmName);
            bw.newLine();
            bw.write("Time: " + Utility.sdf.format(ticket.getDate()));
            bw.newLine();
            bw.write("Last: " + ticket.getTimeInterval()+"mins");
            bw.newLine();
            bw.write("Screen: NO." + ticket.getScreenId());
            bw.newLine();
            bw.write("Seat: [" + (char)('A'+ticket.getSeat()[0])+ticket.getSeat()[1] +"]");
            bw.newLine();
            bw.write("Tick type: " + ticket.getTypeName());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ticket> readInfo(){
        
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
