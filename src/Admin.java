
/**
 * Created by wangchao on 2017/5/20 0020.
 */
public class Admin {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean equals(Admin admin){
        if(admin.getUsername().equals(this.getUsername())&&
                admin.getPassword().equals(this.getPassword())){
            return true;
        }
        else
            return false;
    }
}
