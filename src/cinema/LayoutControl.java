package cinema;

import cinema.Layout;
import cinema.LayoutIO;

import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class LayoutControl {
    public Layout getLayoutById(int LayoutId) {
        System.out.println("LayoutId"+LayoutId);

        ArrayList<Layout> layoutArr = new ArrayList<Layout>();

        layoutArr = (new LayoutIO()).readLayoutFromFile();
        Layout layout = layoutArr.get(LayoutId);
        return layout;
    }
}
