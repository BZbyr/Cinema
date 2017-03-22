import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wc on 2017/3/21.
 */
public class Main {
    //存放各个cinema的座位信息
    static ArrayList <CinemaInfo> cinemaInfos = new ArrayList<CinemaInfo>();
    //cinema个数
    static int cinemaNum;

    public static void main(String args[]) {

        System.out.println("Show the cinemaInfo:");
        Main main = new Main();
        //调用读文件方法
        cinemaInfos = main.readCinemaInfo();
        //遍历输出cinema信息
        for (int j = 0; j <cinemaNum; j++) {
            System.out.println("Hall" + cinemaInfos.get(j).getHallId());
        }
        //输入想查看的具体cinema号
        Scanner sc = new Scanner(System.in);
        System.out.println("plesae enter the No. of cinema hall you want to see details");
        String input = sc.nextLine();
        int selectCinema = Integer.parseInt(input);
        //展示具体cinema座位信息
        main.showLayout(cinemaInfos.get(selectCinema+1));

    }
    public void showLayout(CinemaInfo cinemaInfo){
        int row = cinemaInfo.getLayout()[0];
        int col = cinemaInfo.getLayout()[1];

        for(int i =0 ; i< row ; i++){
            for(int j = 0 ; j < col ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public ArrayList<CinemaInfo> readCinemaInfo(){
        ArrayList<CinemaInfo> tempCinemaInfos = new ArrayList<CinemaInfo>();
        File CinemaFile = new File("C:\\Users\\wc\\IdeaProjects\\CinemaManagement\\src\\CinemaFile");
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(CinemaFile));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String line = "" ;
        String everyLine = "";
        String lineElement [] ;
        try{
            int tempLayout[]=new int[2];
            int countCinema = 0;
            while((line = br.readLine()) != null){
                //临时储存该行的cinemaInfo
                CinemaInfo tempCinemaInfo = new CinemaInfo();
                lineElement =  line.split("\\,");

               tempCinemaInfo.setHallId(Integer.parseInt(lineElement[0]));
               tempCinemaInfo.setFilmId(Integer.parseInt(lineElement[1]));
               tempCinemaInfo.setSeatLeft(Integer.parseInt(lineElement[2]));
               tempLayout[0]=Integer.parseInt(lineElement[3]);
               tempLayout[1]=Integer.parseInt(lineElement[4]);
               tempCinemaInfo.setLayout(tempLayout);
               tempCinemaInfos.add(tempCinemaInfo);
               countCinema++;
            }
            cinemaNum = countCinema;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempCinemaInfos;
    }
}
