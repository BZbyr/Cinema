package cinema;

import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * Created by wangchao on 2017/5/14 0014.
 */
public class Utility {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
    public final static Color c = new Color(140,180,210);
    public final static Font f = new Font("Arial",Font.PLAIN, 30);

    public static int charToInt(char character){
        //ASCII for A is 65 stands for int 0
        int charInt = (int)character;
        int returnInt = charInt - 65;
        return returnInt;
    }
    public static char intToChar(int integer){
        //ASCII for A is 65 stands for int 0
        char returnChar = (char)(integer+65);
        return returnChar;
    }
}
