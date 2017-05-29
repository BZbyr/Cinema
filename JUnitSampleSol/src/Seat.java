
/**
 * Created by wangchao on 2017/4/7 0007.
 */
public class Seat {
    //true means the seat was taken;
    private boolean takenFlag=false;
    private int colNum;
    private int rowNum;

    public boolean isTakenFlag() {
        return takenFlag;
    }

    public void setTakenFlag(boolean takenFlag) {
        this.takenFlag = takenFlag;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public Seat(){

    }

    public Seat(boolean takenFlag, int rowNum, int colNum){
        this.takenFlag = takenFlag;
        this.colNum = colNum;
        this.rowNum = rowNum;

    }
    @Override
    public boolean equals(Object o) {
        Seat seat = (Seat) o;
        if(seat.getColNum()==this.getColNum()&&seat.getRowNum()==this.getRowNum()){
//            System.out.println("Has");
//            System.out.println("COL"+seat.getColNum());
            return true;
        }else{
//            System.out.println("NONE");
//            System.out.println("ROW"+seat.getRowNum());
            return false;

        }
    }

    @Override
    public int hashCode() {
        int result = this.getColNum()+this.getRowNum();
        return result;
    }
}
