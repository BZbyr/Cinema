package cinema;

import cinema.ReportIO;

/**
 * Created by wangchao on 2017/5/20 0020.
 */
public class ReportControl {
    public boolean generateReport(){
        ReportIO reportIO = new ReportIO();
        boolean flag = reportIO.generateReport();
        return flag;
    }
}
