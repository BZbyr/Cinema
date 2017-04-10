package cinema;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/9 0009.
 */
public class Layout {

    private int LayoutId;
    private int rowNum;
    private int colNum;

    ArrayList<Layout> layoutArr = new ArrayList<Layout>();
    File LayoutInfo = new File("src/texts/LayoutInfo.txt");

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

    public Layout getLayoutById(int LayoutId) {
        System.out.println("LayoutId"+LayoutId);
        this.readLayoutFromFile();
        Layout layout = this.layoutArr.get(LayoutId);
        return layout;
    }

    //boundary
    private void readLayoutFromFile() {
        boolean checkFlag = true;
        BufferedReader br = null;
        String line = "";
        String lineElement[];
        int count = 0;
        try {
            br = new BufferedReader(new FileReader(LayoutInfo));
            while ((line = br.readLine()) != null) {
                //文件分割符
                lineElement = line.split("\\$");
                Layout tempLayout = new Layout();
                tempLayout.setLayoutId(Integer.parseInt(lineElement[0]));
                tempLayout.setRowNum(Integer.parseInt(lineElement[1]));
                tempLayout.setColNum(Integer.parseInt(lineElement[2]));
                layoutArr.add(tempLayout);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
            }
        }
}




