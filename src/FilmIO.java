
import java.io.*;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class FilmIO {
    //FilmInfo.txt
    File FilmInfo = new File("src/texts/FilmInfo.txt");


    public Film readFilmInfo(String param) {
        //use firstChar to judge the param
        int numFlag; //0 meansa param is a number 1 stands for string;
        char firstChar = param.charAt(0);
        if(firstChar>='0' && firstChar <= '9'){
            numFlag = 0;
        }else{
            numFlag = 1;
        }
       /*if(Test.Debug)
            System.out.println("num flag" + numFlag);
        */
        Film returnFilm = new Film();
        BufferedReader br = null;
        String line = "";
        String lineElement[];
        try {
            br = new BufferedReader(new FileReader(FilmInfo));
            while ((line = br.readLine()) != null) {
                lineElement = line.split("\\$");
//                System.out.println("lineElement[numFlag] "+lineElement[numFlag]);
//                System.out.println("param"+param);
                if (lineElement[numFlag].equals(param)) {
                    returnFilm.setFilmId(Integer.parseInt(lineElement[0]));
                    returnFilm.setFilmName(lineElement[1]);
                    returnFilm.setTimeInterval(Integer.parseInt(lineElement[2]));
                    returnFilm.setPictureSrc(lineElement[3]);
                    returnFilm.setFilmIntro(lineElement[4]);
                }
            }
            System.out.println("Finnaly : "+returnFilm.getFilmId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnFilm;
    }

    public void writeFilmInfo(Film film){
        BufferedWriter bw = null;
        String line = "" + film.getFilmId() + "$" + film.getfilmName() + "$"+ film.getTimeInterval()+ "$" + film.getPictureSrc() + "$"
                +film.getFilmIntro();
        //debug
       /* if(Test.Debug)
            System.out.println(line);
        */
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
    //return the number of ilm

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
}
