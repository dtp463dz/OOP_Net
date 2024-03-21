package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vn.viettuts.qlsv.dao.ComputerDao;
import vn.viettuts.qlsv.entity.Computer;
import vn.viettuts.qlsv.view.ComputerView;

public class ComputerController {
    private ComputerDao computerDao;
    private ComputerView computerView;
    
    public ComputerController(ComputerView view){
        this.computerView = view;
        computerDao = new ComputerDao();
        
        view.addAddComputerListener(new AddComputerListener());
        view.addEditComputerListener(new EditComputerListener());
        view.addDeleteComputerListener(new DeleteComputerListener());
        view.addClearListener(new ClearComputerListener());
        view.addSortComputerMoneyListener(new SortComputerMoneyListener());
        view.addSortComputerPointListener(new SortComputerPointListener());
        view.addSortComputerTimeListener(new SortComputerTimeListener());
        
        view.addListComputerSelectionListener(new ListComputerSelectionListener());
        view.addSearchAccListener(new SearchAccComputerListener());
        view.addSearchNameListener(new SearchNameComputerListener());
    }
    
    public void showComputerView(){
        List<Computer> computerList = computerDao.getListComputers();
        computerView.setVisible(true);
        computerView.showListComputers(computerList);
    }
    
    /**
     * 
     * @author ql.vn
     */
    class AddComputerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Computer computer = computerView.getComputerInfo();
            if(computer != null){
                computerDao.add(computer);
                computerView.showComputer(computer);
                computerView.showListComputers(computerDao.getListComputers());
                computerView.showMessage("Thêm thành công!");
            }
        }
    }
    
    /**
     * 
     * @author ql.vn
     */
    class EditComputerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Computer computer = computerView.getComputerInfo();
            if(computer != null){
                computerDao.edit(computer);
                computerView.showComputer(computer);
                computerView.showListComputers(computerDao.getListComputers());
                computerView.showMessage("Cập nhật thành công!");
            }
        }
    }
    
    /**
     * 
     * @author ql.vn
     */
    class DeleteComputerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Computer computer = computerView.getComputerInfo();
            if(computer != null){
                computerDao.delete(computer);
                computerView.clearComputerInfo();
                computerView.showListComputers(computerDao.getListComputers());
                computerView.showMessage("Xóa thành công !");
            }
        }
    }
    
    /**
     * 
     * @author ql.vn
     */
    class ClearComputerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            computerView.clearComputerInfo();
        }
    }
    /**
     * 
     * @author ql.vn
     */
    
    
    /**
     * Lớp SortComputerMoneyListener
     * chứa cài đặt cho sự kiện click button "Sort By Money"
     * 
     * @author ql.vn
     */
    
    class SortComputerMoneyListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            computerDao.sortComputerByMoney();
            computerView.showListComputers(computerDao.getListComputers());
        }
    }
    
    /**
     * Lớp SortComputerPointListener
     * 
     * @author ql.vn
     */
    class SortComputerPointListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            computerDao.sortComputerByPoint();
            computerView.showListComputers(computerDao.getListComputers());
        }
    }
    
    /**
     * Lớp SortComputerTimeListener
     * @author ql.vn
     */
    class SortComputerTimeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            computerDao.sortComputerByTime();
            computerView.showListComputers(computerDao.getListComputers());
        }
    }
    
    
    
    /**
     * Tìm kiếm
     * @author ql.vn
     */
    private void searchAccComputers(String searchParam, boolean searchByAccount){
        List<Computer> listComputer;
        if(searchByAccount){
            listComputer = computerDao.getComputerByAccount(searchParam);
        }else{
            listComputer = computerDao.getComputerByAccount(searchParam);
        }
        if(listComputer != null && !listComputer.isEmpty()){
            computerView.clearComputerInfo();
            computerView.showListComputers(listComputer);
            computerView.showMessage("Tìm kiếm tài khoản thành công!");
        }else{
            if(searchByAccount){
                computerView.showMessage("Không tìm thấy tài khoản: " + searchParam);
            }else {
                computerView.showMessage("Không tìm thấy!" + searchParam);
            }
        }
    }
    
    private void searchNameComputers(String searchParam, boolean searchByName){
        List<Computer> listComputer;
        if(searchByName){
            listComputer = computerDao.getComputerByName(searchParam);
        }else{
            listComputer = computerDao.getComputerByName(searchParam);
        }
        if(listComputer != null && !listComputer.isEmpty()){
            computerView.clearComputerInfo();
            computerView.showListComputers(listComputer);
            computerView.showMessage("Tìm kiếm thành công tên máy!");
        }else{
            if(searchByName){
                computerView.showMessage("Không tìm thấy tên máy: " + searchParam);
            }else {
                computerView.showMessage("Không tìm thấy!" + searchParam);
            }
        }
    }
    
    
    
    class SearchAccComputerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = computerView.getComputerSearchID();
            String account = computerView.getComputerSearchAccount();

            if (account != null && !account.isEmpty()) {
                searchAccComputers(account, true);
            } else if(id != null && !id.isEmpty()){
                searchAccComputers(id, true);
            }
        }
    }
    
    class SearchNameComputerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String id = computerView.getComputerSearchID();
            String name = computerView.getComputerSearchName();
            
            if(name != null && !name.isEmpty()){
                searchNameComputers(name, true);
            }else if(id != null && !id.isEmpty()){
                searchAccComputers(id, true);
            }
        }
    }
    /**
     * Lớp ListComputerSelectionListener
     * 
     * @author ql.vn
     */
    class ListComputerSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            computerView.fillComputerFromSelectedRow();
        }
    }
    
    
    
    
}
