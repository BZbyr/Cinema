
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/4/17 0017.
 */
public class LayoutControl {
    ArrayList<Layout> layoutArr = new ArrayList<>();
    public Layout getLayoutById(int LayoutId) {
//        System.out.println("LayoutId"+LayoutId);

        layoutArr = (new LayoutIO()).readLayoutFromFile();
        Layout layout = layoutArr.get(LayoutId);
        return layout;
    }
}
