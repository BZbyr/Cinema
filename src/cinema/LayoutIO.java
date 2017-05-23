package cinema;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class LayoutIO {
    File LayoutInfo = new File("src/texts/LayoutInfo.txt");

    public ArrayList<Layout> readLayoutFromFile() {
        ArrayList<Layout> layoutArr = new ArrayList<>();
        boolean checkFlag = true;
        BufferedReader br = null;
        String line = "";
        String lineElement[];
        String elementElement[];
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
                HashSet<Seat> missSeatSet = new HashSet<>();
                for(int i = 3; i < lineElement.length; i++)
                {
                    elementElement = lineElement[i].split("\\,");
                    missSeatSet.add(new Seat(false,Integer.parseInt(elementElement[0]),Integer.parseInt(elementElement[1])));

                }
                tempLayout.setMissSeatSet(missSeatSet);

                layoutArr.add(tempLayout);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layoutArr;
    }

}
