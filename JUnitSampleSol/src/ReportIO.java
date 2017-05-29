
import java.io.*;
import java.util.ArrayList;

/**
 * Created by dell on 2017/5/18.
 */
public class ReportIO {

    private static final double ChildTicketDiscount = 0.5;
    private static final double StudentTicketDiscount = 0.85;
    private  static  final double SeniorTicketDiscount = 0.8;
    ArrayList<Ticket> ticketArr = new ArrayList<Ticket>();
    int count;
    public boolean generateReport() {
        try{
            ticketArr = (new TicketIO()).readInfo();
            File report = new File(Utility.Prepath+"texts/ReportInfo.txt");
            if (!report.exists()){
                report.createNewFile();
            }
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(report));

            String line;

            BufferedReader br = new BufferedReader(new FileReader(Utility.Prepath+"texts/FilmInfo.txt"));
            while ((line = br.readLine()) != null){
                count += 1;
            }
            //System.out.print("TEST MY PROGRAM"+ count);
            int[] saleNum = new int[count];
            int[] FilmId = new int[count];
            FilmIO filmio = new FilmIO();
            for (int x = 0; x < saleNum.length; x++){
                FilmId[x] = filmio.readFilmInfo(""+x).getFilmId();
            }
            for (int i = 0; i<saleNum.length ;i++){
                int count1 = 0;
                for(Ticket t:ticketArr){
                    if(t.getFilmId()== FilmId[i]){
                        count1 += 1;
                    }
                }
                saleNum[i] = count1;
            }

            int[] count2 = {0,0,0,0};
            String[] ticketType = {"Normal","Student","Child", "Senior"};
            for(Ticket t: ticketArr){
                switch(t.getTicketType()){
                    case 1 :count2[0]++;break;
                    case 2 :count2[1]++;break;
                    case 3 :count2[2]++;break;
                    case 4 :count2[3]++;break;
                }
            }

            double sumOfSelling;
            sumOfSelling = (count2[0]+count2[1]*StudentTicketDiscount+count2[2]*ChildTicketDiscount+count2[3]*SeniorTicketDiscount)*16;
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
            for (int a = 0; a<count2.length; a++) {
                bw.write("Type " + ticketType[a] + "Sales for : " + count2[a]);
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