package cinema;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import Test.*;
/**
 * Created by wangchao on 2017/3/24.
 */
public class Ticket {
      //tick.txt
    File TicketInfo = new File("src/texts/TicketInfo.txt");
    //随机数作为TicketID
    private String ticketId;
    //电影ID
    private int filmId;
    //时间
    private Date date;
    //日期格式
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    //厅（屏幕）号
    private int screen;
    //座位号,不确定数据类型是否合适
    private char[] seat;
    //票类型
    private int ticketType;
    //构造函数
    public Ticket(int filmId,String stringDate,int screen,char[] seat, int ticketType){
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
        //ATTENTION如果过了4^4个id号怎么办
        this.ticketId = randomID;
        this.filmId = filmId;
        this.seat = seat;
        if(Test.Debug){
            System.out.println(seat);
        }
        this.screen = screen;
        try {
            this.date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.ticketType = ticketType;
    }
    //检查这个id是否已经被应用过了,从TicketInfo.txt中读取
    public boolean checkId(String randomID){
        boolean checkFlag = true;
        BufferedReader br = null;
        String line = "";
        String lineElement [];
        try {
            br = new BufferedReader(new FileReader(TicketInfo));
            while((line = br.readLine())!=null){
                //文件分割符
                lineElement = line.split("\\$");
                //如果第一位（ID位）与传进来的id相同，则有重复，返回假
                if(lineElement[0].equals(randomID))
                    checkFlag = false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //没有重复返回真，有重复返回假
        return checkFlag;
    }

    public void writeTicketInfo(Ticket ticket){
        BufferedWriter bw = null;
        String line = "" + ticket.ticketId + "$" + ticket.filmId + "$" + sdf.format(ticket.date) + "$"
                + ticket.screen + "$" + ticket.seat[0] + ticket.seat[1] + "$" + ticket.ticketType;
        //debug
        if(Test.Debug)
            System.out.println(line);

        try {
            //追加写 append: true
            bw = new BufferedWriter(new FileWriter(TicketInfo,true));
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
