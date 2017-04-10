package cinema;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import Test.*;
/**
 * Created by wangchao on 2017/3/24.
 */
public class Ticket {
    //ticket.txt
    File TicketInfo = new File("src/texts/TicketInfo.txt");
    //随机数作为TicketID
    private String ticketId;
    //电影ID
    private int filmId;
    //日期
    private Date date;
    //日期格式
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");
    //时间 分钟记
    private int timeInterval;
    //厅（屏幕）号
    private int screenId;
    //座位号,不确定数据类型是否合适
    private int[] seat;
    //票类型
    private int ticketType;

    @Override
    public String toString() {
        Film film = (new Film()).readFilmInfo(""+filmId);
        return "Your Ticket:" +
                "\nFilm Name:" + film.getfilmName()+
                "\nTime: " + date +
                "\n" + timeInterval + "min" +
                "\nNo.of screen: " + screenId +
                "\nseat number: " + Arrays.toString(seat) +
                "\nTick type is " + ticketType ;
    }

    //构造函数
    public Ticket(int filmId,Date passedDate,int timeInterval,int screenId,int[] seat, int ticketType){
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
        this.screenId = screenId;
        this.date = passedDate;

        this.timeInterval = timeInterval;
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
                + ticket.timeInterval + "$" + ticket.screenId + "$" + ticket.seat[0] + ticket.seat[1] + "$" + ticket.ticketType;
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
