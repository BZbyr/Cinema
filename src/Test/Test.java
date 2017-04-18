package Test;
import cinema.Entity.Film;

/**
 * Created by wangchao on 2017/3/29.
 */
public class Test {
    public static boolean Debug = false;
    public static void main(String args[]){
        //Ticket
        /*char [] seat = {'A','1'};
        Ticket ticket = new Ticket(111,"2017-3-29-14",123,1,seat,2);
        ticket.writeTicketInfo(ticket);
        */
        //ScreenTest 测试添加一个screen 以及 修改余票量
        //Screen screen = new Screen(1,111,"2017-3-29-14", 123,100,100,3);
        //screen.writeScreenInfo(screen,true);
       /* Screen screen = new Screen();
        screen.update(1, "2017-03-29-14", -3);
                */
        //测试添加Film写入文件
        //Film film = new Film("Beast&Beauty",123,"/pic/01.jpg","tell about a story");
        // film.writeFilmInfo(film);
        //测试读取信息
        Film film = new Film();
       // film = film.readFilmInfo("0");
        System.out.println(""+film.getFilmIntro());
            }
}
