package cinema;

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
            if(admin.equals(inputAdmin)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
