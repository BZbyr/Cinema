import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by wc on 2017/3/21.
 */
public class CinemaInfo {
    private int hallId;
    private int FilmId;
    private int SeatLeft;
    private int[] layout;


    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public int getFilmId() {
        return FilmId;
    }

    public void setFilmId(int filmId) {
        FilmId = filmId;
    }

    public int getSeatLeft() {
        return SeatLeft;
    }

    public void setSeatLeft(int seatLeft) {
        SeatLeft = seatLeft;
    }

    public int[] getLayout() {
        return layout;
    }

    public void setLayout(int[] layout) {
        this.layout = layout;
    }


}
