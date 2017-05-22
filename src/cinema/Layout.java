package cinema;

import java.util.*;

/**
 * Created by wangchao on 2017/4/9 0009.
 */
public class Layout {

    private int LayoutId;
    private int rowNum;
    private int colNum;


    private HashSet<Seat> missSeatSet;

    public int getLayoutId() {
        return LayoutId;
    }

    public void setLayoutId(int lyoutId) {
        LayoutId = lyoutId;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public HashSet<Seat> getMissSeatSet() {
        return missSeatSet;
    }

    public void setMissSeatSet(HashSet<Seat> missSeatSet) {
        this.missSeatSet = missSeatSet;
    }
}




