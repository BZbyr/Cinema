package cinema;

import Test.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by wangchao on 2017/3/29.
 */
public class Film {
    //FilmInfo.txt
    File FilmInfo = new File("src/texts/FilmInfo.txt");
    private int filmId;
    private String filmName;
    //时间 分钟计
    private int timeInterval;
    //图片路径为 pic/01.jsp
    private String pictureSrc;
    //简介
    private String filmIntro;

    public int getFilmId(){
        return this.filmId;
    }
    public String getfilmName(){
        return this.filmName;
    }
    public int getTimeInterval(){
        return this.timeInterval;
    }
    public String getPictureSrc(){
        return this.pictureSrc;
    }
    public String getFilmIntro(){
        return this.filmIntro;
    }

    public Film(){}
    public Film(String filmName, int timeInterval, String pictureSrc,String filmIntro){
        //自生成filmId的构造函数
        this.filmName = filmName;
        this.timeInterval = timeInterval;
        this. pictureSrc = pictureSrc;
        int count = calfilmNum();
        this.filmId = count++;
        this.filmIntro = filmIntro;
    }
    //返回目前film数量
    public int calfilmNum(){
        BufferedReader br = null;
        String line = "";
        int count = 0 ;
        try {
            br = new BufferedReader(new FileReader(FilmInfo));
            while((line = br.readLine())!=null){
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    public void writeFilmInfo(Film film){
        BufferedWriter bw = null;
        String line = "" + film.filmId + "$" + film.filmName + "$"+ film.timeInterval+ "$" + film.pictureSrc + "$"
                +film.filmIntro;
        //debug
        if(Test.Debug)
            System.out.println(line);
        try {
            //追加写 append: true
            bw = new BufferedWriter(new FileWriter(FilmInfo,true));
            bw.write(line);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Film readFilmInfo(String param) {
        //判断传进来的是字符串还是数字,若第一个字符是数字则判断为id
        int numFlag = 0; //0为数字,1为字符串，根据文件中id与name的位置决定
        char firstChar = param.charAt(0);
        if(firstChar>='0' && firstChar <= '9'){
            numFlag = 0;
        }else{
            numFlag = 1;
        }
        if(Test.Debug)
            System.out.println("num flag" + numFlag);

        Film returnFilm = new Film();
        BufferedReader br = null;
        String line = "";
        String lineElement[];
        try {
            br = new BufferedReader(new FileReader(FilmInfo));
            while ((line = br.readLine()) != null) {
                lineElement = line.split("\\$");
                if (lineElement[numFlag].equals(param)) {
                    returnFilm.filmId = Integer.parseInt(lineElement[0]);
                    returnFilm.filmName = lineElement[1];
                    returnFilm.timeInterval = Integer.parseInt(lineElement[2]);
                    returnFilm.pictureSrc = lineElement[3];
                    returnFilm.filmIntro = lineElement[4];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnFilm;
    }

}
