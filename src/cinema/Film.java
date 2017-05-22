package cinema;

import cinema.FilmIO;

import java.io.*;

/**
 * Created by wangchao on 2017/3/29.
 */
public class Film {
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

    public void setFilmInfo(File filmInfo) {
        filmInfo = filmInfo;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public void setPictureSrc(String pictureSrc) {
        this.pictureSrc = pictureSrc;
    }

    public void setFilmIntro(String filmIntro) {
        this.filmIntro = filmIntro;
    }

    public Film(){}
    public Film(String filmName, int timeInterval, String pictureSrc,String filmIntro){
        //自生成filmId的构造函数
        this.filmName = filmName;
        this.timeInterval = timeInterval;
        this. pictureSrc = pictureSrc;
        FilmIO fi = new FilmIO();

        int count = fi.calfilmNum();
        this.filmId = count++;
        this.filmIntro = filmIntro;
    }





}
