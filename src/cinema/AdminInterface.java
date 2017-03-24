import java.io.*;

/**
 * Created by wangchao on 2017/3/24.
 */
public class AdminInterface {
    File AdminInfo = new File("texts/AdminInfo.txt");
    public void changePassword(){

    }
    public String login(String username, String password){
        String loginFlag = null;
    //文件中读取用户名密码信息
        BufferedReader br = null;
        String line = "";
        String lineElement [];
        try {
            br = new BufferedReader(new FileReader(AdminInfo));
            while((line = br.readLine())!=null){
                //文件分割符
                lineElement = line.split("\\$");
                if(lineElement[0].equals(username)&&lineElement[1].equals(password)){
                    //用户名密码匹配成功
                    loginFlag = lineElement[0];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginFlag;
    }
}
