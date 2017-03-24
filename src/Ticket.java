import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by wangchao on 2017/3/24.
 */
public class Ticket {
    //随机数作为TicketID
    private int ticketId;
    //电影ID
    private int filmId;
    //时间
    private Date date;
    //厅（屏幕）号
    private int screen;
    //座位号,不确定数据类型是否合适
    private String[] seat;
    //票类型
    private int ticketType;

    public Ticket(int filmId,String stringDate,int screen,String[]seat, int ticketType){
        int max=99999999;
        int min=10000000;
        Random random = new Random();
        int random8 = random.nextInt(max)%(max-min+1) + min;
        this.ticketId = random8;
        //检查这个id是否已经被应用过了,从ticket.txt中读取
        while(checkId){
            int random8 = random.nextInt(max)%(max-min+1) + min;
        }


    }
    public boolean checkId(){
        
    }

}
