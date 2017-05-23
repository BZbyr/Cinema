
import java.util.ArrayList;

/**
 * Created by wangchao on 2017/5/20 0020.
 */
public class AdminControl {
    public boolean login(String username,String password){
        AdminIO adminIO = new AdminIO();
        ArrayList<Admin> adminArrayList = adminIO.readAdminInfo();
        Admin inputAdmin = new Admin();
        inputAdmin.setUsername(username);
        inputAdmin.setPassword(password);
        boolean flag = false;
        for(Admin admin:adminArrayList){
//            System.out.println("adminUsername"+inputAdmin.getUsername());
//            System.out.println("adminPW "+ inputAdmin.getPassword());
            if(admin.equals(inputAdmin)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
