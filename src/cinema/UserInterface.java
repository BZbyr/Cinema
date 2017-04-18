package cinema;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import cinema.Entity.Layout;
import cinema.Entity.Screen;
import cinema.Entity.Ticket;

/**
 * Created by wangchao on 2017/3/23.
 */
public class UserInterface {
    //日期格式
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");


    public void refund(){

    }


  /*  private void listDateByFilm(int chosenFilm){
        Screen tmpScreen = new Screen();
        ArrayList<Date> tmpDateArr = new ArrayList<Date>();
        tmpDateArr = tmpScreen.getTimeByFilm(chosenFilm);
        int count;
        for(count = 0 ; count < tmpDateArr.size(); count++){
            Date tmpDate = tmpDateArr.get(count);
            System.out.println("No. " + (count+1) + sdf.format(tmpDate));
        }
        boolean dateFlag = false;
        do{
            System.out.println("Please choose the No. of date");
            Scanner sc = new Scanner(System.in);
            int chosenDate = Integer.parseInt(sc.nextLine());
            if((chosenFilm<=0)||(chosenFilm>count+1)){
                dateFlag = true;
                System.out.println("Wrong!");
            }else{
                this.listScreenByDate(tmpDateArr.get(chosenDate-1));
            }
        }while(dateFlag);
    }

    private void listScreenByDate(Date chosenDate){
        Screen tmpScreen = new Screen();
        System.out.println("chosenDate = "+sdf.format(chosenDate));
        tmpScreen = tmpScreen.getScreenByDate(sdf.format(chosenDate));
        System.out.println(""+tmpScreen.getScreenId());
        this.chooseSeat(tmpScreen);
    }

    private void chooseSeat(Screen screen){
        int rowChosen;
        int colChosen;
        int typeChosen;

        Layout layout = (new Layout()).getLayoutById(screen.getLayoutId());
        int rowNum = layout.getRowNum();
        int colNum = layout.getColNum();
        System.out.print("  ");
        for(int m = 0 ; m < colNum ; m++ ){
            System.out.print((m+1)+" ");
        }
        System.out.println("");
        for(int i = 0; i<rowNum; i++){
            for(int j = 0; j < colNum+1; j++) {
                if(j==0)
                    System.out.print((i+1)+" ");
                else
                System.out.print("* ");
            }
            System.out.println("");
        }
        boolean seatFlag = false;
        do{
            System.out.println("Please enter the No. of row");
            Scanner sc = new Scanner(System.in);
            rowChosen = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter the No. of colomn");
            colChosen = Integer.parseInt(sc.nextLine());
            if((rowChosen<=0)||(rowChosen>rowNum)||(colChosen<=0)||(colChosen>colNum))
            {
                seatFlag = true;
                System.out.println("Wrong!");
            }else{

            }
        }while(seatFlag);

        do{
            System.out.println("1-------Student Ticket");
            System.out.println("2-------Adult Ticket");
            Scanner sc = new Scanner(System.in);
            typeChosen = Integer.parseInt(sc.nextLine());

            if((typeChosen<=0)||(typeChosen>2))
            {
                seatFlag = true;
                System.out.println("Wrong!");
            }else{

            }
        }while(seatFlag);

        int [] seat = new int[2];
        seat[0] = rowChosen;
        seat[1] = colChosen;
        this.generateTicket(screen,seat,typeChosen);
    }

    private void generateTicket(Screen chosenScreen,int [] seat,int ticketType){
        Ticket ticket = new Ticket(chosenScreen.getFilmId(),chosenScreen.getDate(),chosenScreen.getTimeInterval()
        ,chosenScreen.getScreenId(),seat,ticketType);
        System.out.println(ticket);
        //确认机制
        boolean confirmFlag = false;

        do{
            System.out.println("Please check the information of your ticket");
            System.out.println("1-------Correct");
            System.out.println("2-------Wrong");
            Scanner sc = new Scanner(System.in);
            int confirm = Integer.parseInt(sc.nextLine());

            if((confirm<=0)||(confirm>2))
            {
                confirmFlag = true;
                System.out.println("Wrong input!");
            }else{

            }
        }while(confirmFlag);
        ticket.writeTicketInfo(ticket);
    }
    */
}
