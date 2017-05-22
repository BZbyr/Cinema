package cinema;

import Test.Test;
import cinema.Film;
import cinema.FilmIO;

import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class FilmControl {
    public void addFilm(Film film){

    }
    public void deleteFilm(Film film){

    }

    public Film getFilmByName(String filmName){
        Film film = (new FilmIO()).readFilmInfo(filmName);
        return film;
    }
    public ArrayList<Film> listFilm(){
        ArrayList<Film> filmArrayList = new ArrayList<Film>();
        if(Test.Debug) {
            System.out.println("list film");
        }
        Film film = new Film();
        FilmIO fileIO = new FilmIO();
        int filmNum = fileIO.calfilmNum();
        for(int i = 0 ; i< filmNum ; i++) {
            Film tmpFilm = fileIO.readFilmInfo(i + "");
            filmArrayList.add(tmpFilm);
            if (Test.Debug) {
                System.out.print("ID: " + (tmpFilm.getFilmId() + 1));
                System.out.println("Name: " + tmpFilm.getfilmName());
                System.out.println(" Intro: " + tmpFilm.getFilmIntro());
            }
        }
        return filmArrayList;
    }


}
