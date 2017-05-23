
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dell on 2017/5/18.
 */
public class ReportIO {

    private static final double ChildTicketDiscount = 0.5;
    private static final double StudentTicketDiscount = 0.85;
    ArrayList<Ticket> ticketArr = new ArrayList<>();
    public boolean generateReport() {
        try{
            ticketArr = (new TicketIO()).readInfo();
            File report = new File("src/texts/ReportInfo.txt");
            if (!report.exists()){
                report.createNewFile();
            }
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(report));
            int[] saleNum = new int[2];
            int[] FilmId = new int[2];
            FilmId[0] =0;
            FilmId[1] =1;
            for (int i = 0; i<2 ;i++){
                int count1 = 0;
                for(Ticket t:ticketArr){
                    if(t.getFilmId()== FilmId[i]){
                        count1 += 1;
                    }
                }
                saleNum[i] = count1;
            }

            int[] count = {0,0,0};
            String[] ticketType = {"Normal","Student","Child"};
            for(Ticket t: ticketArr){
                switch(t.getTicketType()){
                    case 1 :count[0]++;break;
                    case 2 :count[1]++;break;
                    case 3 :count[2]++;break;
                }
            }

            double sumOfSelling;
            sumOfSelling = (count[0]+count[1]*StudentTicketDiscount+count[2]*ChildTicketDiscount)*16;
            bw.write("----------------------------------------------------");bw.newLine();
            bw.write("               SELLING      REPORT                  ");bw.newLine();
            bw.newLine();

            FilmIO filmIO = new FilmIO();
            for(int i = 0; i<saleNum.length;i++){
                bw.write("Sale of Movie "+filmIO.readFilmInfo(""+i).getfilmName()+": "+saleNum[i]);
                bw.newLine();

            }
//            bw.write("Sale of Movie Beauty&Beast : "+ saleNum[0]);bw.newLine();
//            bw.write("Sale of Movie X-MEN :"+saleNum[1]);bw.newLine();
            bw.newLine();
            bw.write("----------------------------------------------------");bw.newLine();
            for (int a = 0; a<3; a++) {
                bw.write("Type " + ticketType[a] + "Sales for : " + count[a]);
                bw.newLine();
            }
            bw.write("----------------------------------------------------");bw.newLine();
            bw.write("SUM OF SELLING:                               "+sumOfSelling);
            bw.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
