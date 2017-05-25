
import java.io.*;
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/5/20 0020.
 */
public class AdminIO {
    File AdminInfo = new File("src/texts/AdminInfo.txt");

    public ArrayList<Admin> readAdminInfo(){
        ArrayList<Admin> adminArrayList = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String lineElement [];
        try {
            br = new BufferedReader(new FileReader(AdminInfo));

            while((line = br.readLine()) != null){
                System.out.println("line+"+line);
                Admin tempAdmin = new Admin();
                lineElement = line.split("\\$");
                tempAdmin.setUsername(lineElement[0]);
//                System.out.println("setPassword+"+lineElement[1]);
                tempAdmin.setPassword(lineElement[1]);
                adminArrayList.add(tempAdmin);
            }
//            for(int i = 0 ; i<adminArrayList.size();i++){
//                System.out.println("arr"+adminArrayList.get(i).getUsername());
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminArrayList;
    }
}
