package cinema;

import java.util.Random;

/**
 * Created by wangchao on 2017/3/29.
 */
public class Film {
    private String filmId;
    private String filmName;
    //时间格式为 H:M 如 1:53 指代一小时五十三秒
    private String lastTime;
    //图片路径为 pic/01.jsp
    private String pictureSrc;

    public Film(String filmId, String filmName, String lastTime, String pictureSrc){
        //自定义filmId的构造函数
        this.filmId = filmId;
        this.filmName = filmName;
        this.lastTime = lastTime;
        this. pictureSrc = pictureSrc;
    }
    public Film(String filmName, String lastTime, String pictureSrc){
        //随机生成filmId的构造函数
        this.filmName = filmName;
        this.lastTime = lastTime;
        this. pictureSrc = pictureSrc;
        Random random = new Random();
        //参照ticket
    }

}
