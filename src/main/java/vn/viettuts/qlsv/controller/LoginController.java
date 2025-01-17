package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vn.viettuts.qlsv.dao.UserDao;
import vn.viettuts.qlsv.entity.User;
import vn.viettuts.qlsv.view.LoginView;
import vn.viettuts.qlsv.view.ComputerView;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private ComputerView computerView;
    
    public LoginController(LoginView view){
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView(){
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener
     * chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author ql.vn
     */
    class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            User user = loginView.getUser();
            if(userDao.checkUser(user)){
                //nếu đăng nhập thành công, mở màn hình quản lý 
                computerView = new ComputerView();
                ComputerController computerController = new ComputerController(computerView);
                computerController.showComputerView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
