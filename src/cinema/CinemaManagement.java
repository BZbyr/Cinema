import java.util.Scanner;

/**
 * Created by wangchao on 2017/3/23.
 */
public class CinemaManagement {
    public static void main(String args[]){
        CinemaManagement main = new CinemaManagement();
        boolean flag = true;
        while(flag) {
            System.out.println("1----User" );
            System.out.println("2----Administrator");
            System.out.println("3----Exit");
            //键盘输入流
            Scanner sc = new Scanner(System.in);
            int chooseIdentity = Integer.parseInt(sc.nextLine());
            if (chooseIdentity == 1) {
                main.enterUser();
                flag = true;
            } else if (chooseIdentity == 2) {
                main.enterAdmin();
                flag = true;
            } else if (chooseIdentity == 3){
                System.out.println("Bye Bye");
                flag = false;
            }else {
                System.out.println("Error! Please enter again");
                flag = true;
            }
        }
    }
    public void enterUser(){
        UserInterface ui = new UserInterface();
        System.out.println("User interface");
        boolean UserFlag = true;
        while(UserFlag){
            System.out.println("1----Buy ticket");
            System.out.println("2----Refund");
            System.out.println("3----Return to Main Menu");
            Scanner scUser = new Scanner(System.in);
            int userChoose = Integer.parseInt(scUser.nextLine());
            switch (userChoose){
                case 1:
                    ui.buyTicket();
                case 2:
                    ui.refund();
                case 3:
                    UserFlag = false;
            }

        }
    }
    public void enterAdmin(){
        AdminInterface ai = new AdminInterface();
        Scanner sc = new Scanner(System.in);
        System.out.println("Admin interface");
        boolean loginFlag = true;
        while(loginFlag) {
            System.out.println("Please enter your username");
            String username = sc.nextLine();
            System.out.println("Please enter your password");
            String password = sc.nextLine();
            String loginReturn = null;
            loginReturn = ai.login(username, password);
            //登陆成功返回用户名（可选功能：记录管理员登陆时间、操作）
            if (loginReturn != null) {
                System.out.println("Welcome!" + loginReturn);
                loginFlag = false;
            } else {
                System.out.println("Wrong password or Wrong username, please Enter again");
            }
        }
    }
}
