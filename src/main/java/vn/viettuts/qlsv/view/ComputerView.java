package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlsv.entity.Computer;


/**
 *
 * @author Admin
 */
public class ComputerView extends JFrame implements ActionListener, ListSelectionListener{
    
    public static final long serialVersionUID = 1L;
    
    private JTabbedPane jTabbedPane;
    // Thông tin máy 
    private JLabel nameLabel, statusLabel;
    private JTextField nameField;
    private JComboBox<String> statusComboBox;
    
//    private ArrayList<Computer> computerList;
    
    // Thông tin khách
    private JButton addComputerBtn;
    private JButton editComputerBtn;
    private JButton deleteComputerBtn;
    private JButton clearBtn;
    
    private JButton searchNameBtn;
    private JButton searchAccBtn;
    
    private JButton sortComputerTimeBtn;
    private JButton sortComputerMoneyBtn;
    private JButton sortComputerPointBtn;
    
    private JScrollPane jScrollPaneComputerTable;
    private JScrollPane jScrollPaneAccount;
    private JTable computerTable;
    
    private JLabel idLabel;
    private JLabel accountLabel;
    private JLabel passwordLabel;
    private JLabel moneyLabel;
    private JLabel dateLabel;
    private JLabel pointLabel;
    private JLabel timeLabel;
    
    private JTextField idField;
    private JTextField accountField;
    private JTextField passwordField;
    private JTextField moneyField;
    private JTextField dateField;
    private JTextField pointField;
    private JTextField timeField;
    
    private JTextField searchAccField;
    private JTextField searchNameField;
    
    // định nghĩa các cột của bảng computer
    private String[] columnNames = new String[]{"ID", "Name", "Status" ,"Account", "Password", "Money", "Local Time" ,"Point" ,"Time(Hour)"};
    // định nghĩa dữ liệu mặc định của bảng computer là rỗng
    private Object data = new Object [][]{};
    
    
    private Timer t;
    
    
    public ComputerView(){
        initComponents();
    }
    
    
    
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // máy
        
        nameLabel = new JLabel("Computer Name");
        statusLabel = new JLabel("Status");
        
        nameField = new JTextField(15);
        String[] statusOptions = {"In use", "Not in use"};
        statusComboBox = new JComboBox<String>(statusOptions);
        
        
        // khởi tạo các phím chức năng
        addComputerBtn = new JButton("Add");
        addComputerBtn.setPreferredSize(new Dimension(100, 25));
        editComputerBtn = new JButton("Edit");
        editComputerBtn.setPreferredSize(new Dimension(100, 25));
        deleteComputerBtn = new JButton("Delete");
        deleteComputerBtn.setPreferredSize(new Dimension(100, 25));
        clearBtn = new JButton("Clear");
        clearBtn.setPreferredSize(new Dimension(100, 25));
        
        searchAccBtn = new JButton("Search Account");
        searchNameBtn = new JButton("Search Computer Name");
        
        sortComputerTimeBtn = new JButton("Sort By Time");
        sortComputerMoneyBtn = new JButton("Sort By Money");
        sortComputerPointBtn = new JButton("Sort By Point");
        // khởi tạo bảng computer
        jScrollPaneComputerTable = new JScrollPane();
        computerTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("Id");
        accountLabel = new JLabel("Account");
        passwordLabel = new JLabel("Password");
        moneyLabel = new JLabel("Money");
        dateLabel = new JLabel("Local Time");
        pointLabel = new JLabel("Score");
        timeLabel = new JLabel("Time(Hour)");
        
        // khởi tạo các trường nhập dữ liệu cho computer
        idField = new JTextField(6);
        idField.setEditable(false);
        accountField = new JTextField(15);
        jScrollPaneAccount = new JScrollPane();
        jScrollPaneAccount.setViewportView(accountField);
        passwordField = new JTextField(15);
        moneyField = new JTextField(15);
        dateField = new JTextField(15);
        pointField = new JTextField(15);
        timeField = new JTextField(15);
        searchAccField = new JTextField(15);
        searchNameField = new JTextField(15);
        
        /*
        searchAccField.setBounds(300, 330, 100, 20);
        searchAccBtn.setBounds(420, 330, 80, 20);
        */
        searchAccField.setBounds(500, 530, 200, 30);
        searchAccBtn.setBounds(620, 530, 100, 30);
        
        searchNameField.setBounds(500, 530, 200, 30);
        searchNameBtn.setBounds(620, 530, 100, 30);
        
        // cài đặt các cột và data cho bảng student
        computerTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneComputerTable.setViewportView(computerTable);
        jScrollPaneComputerTable.setPreferredSize(new Dimension(800, 400));
        
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        
        JPanel panel = new JPanel();
        panel.setSize(1000, 820);
        panel.setLayout(layout);
        panel.add(jScrollPaneComputerTable);
        
        panel.add(addComputerBtn);
        panel.add(editComputerBtn);
        panel.add(deleteComputerBtn);
        panel.add(clearBtn);
        panel.add(searchAccBtn);
        panel.add(searchNameBtn);
        panel.add(sortComputerMoneyBtn);
        panel.add(sortComputerPointBtn);
        panel.add(sortComputerTimeBtn);
        
        panel.add(idLabel);
        
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(statusLabel);
        panel.add(statusComboBox);
                
        
        panel.add(accountLabel);
        panel.add(passwordLabel);
        panel.add(moneyLabel);
        panel.add(dateLabel);
        panel.add(pointLabel);
        panel.add(timeLabel);
        
        panel.add(idField);
        panel.add(accountField);
        panel.add(passwordField);
        panel.add(moneyField);
        panel.add(dateField);
        panel.add(pointField);
        panel.add(timeField);
        panel.add(searchAccField);
        panel.add(searchNameField);
        // laybel
        layout.putConstraint(SpringLayout.WEST, idLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 40, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, nameLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 90, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, statusLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, statusLabel, 140, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, accountLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, accountLabel, 190, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, passwordLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 240, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, moneyLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, moneyLabel, 290, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, dateLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 340, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, pointLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pointLabel, 390, SpringLayout.NORTH, panel); 
        
        layout.putConstraint(SpringLayout.WEST, timeLabel, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, timeLabel, 440, SpringLayout.NORTH, panel);
        
        //field
        layout.putConstraint(SpringLayout.WEST, idField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 40, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, nameField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 90, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, statusComboBox, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, statusComboBox, 140, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, accountField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, accountField, 190, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, passwordField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 240, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, moneyField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, moneyField, 290, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, dateField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateField, 340, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, pointField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pointField, 390, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, timeField, 140, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, timeField, 440, SpringLayout.NORTH, panel);
        // table
        layout.putConstraint(SpringLayout.WEST, jScrollPaneComputerTable, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneComputerTable, 35, SpringLayout.NORTH, panel);
        //Btn
        layout.putConstraint(SpringLayout.WEST, addComputerBtn, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addComputerBtn, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editComputerBtn, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editComputerBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteComputerBtn, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteComputerBtn, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 320, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, searchAccBtn, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchAccBtn, 500, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchAccField, 675, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchAccField, 505, SpringLayout.NORTH, panel);
        
        
        layout.putConstraint(SpringLayout.WEST, searchNameBtn, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchNameBtn, 540, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchNameField, 675, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchNameField, 545, SpringLayout.NORTH, panel);
        // sort 
        layout.putConstraint(SpringLayout.WEST, sortComputerMoneyBtn, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortComputerMoneyBtn, 460, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortComputerPointBtn, 650, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortComputerPointBtn, 460, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortComputerTimeBtn, 800, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortComputerTimeBtn, 460, SpringLayout.NORTH, panel);
    
        editComputerBtn.setEnabled(false);
        deleteComputerBtn.setEnabled(false);
        addComputerBtn.setEnabled(true);
        
        this.add(panel);
        this.pack();
        this.setTitle("Computer User Information");
        this.setSize(1320, 720);
        this.setVisible(true);
        
    }
    
    
    
    public static javax.swing.JLabel LabelTime;
    private javax.swing.JLabel LabelDate;
    
    public void runTime(){
         
        t = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            
            String currentTime = sdf.format(new java.util.Date());
            String currentDate = dFormat.format(new java.util.Date());
            dateField.setText(currentTime + " " + currentDate);
        }
    });
        
        t.start();
    }

    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
    /**
     * 
     * @param list
     */
    
    public void showListComputers(List<Computer> list){
        int size = list.size();
        Object[][] computers = new Object[size][9];
        for(int i = 0; i < size; i++){
            computers[i][0] = list.get(i).getId();
            computers[i][1] = list.get(i).getName();
            computers[i][2] = list.get(i).getStatus();
            computers[i][3] = list.get(i).getAccount();
            computers[i][4] = list.get(i).getPassword();
            computers[i][5] = list.get(i).getMoney();
            computers[i][6] = list.get(i).getDateOf();
            computers[i][7] = list.get(i).getPoint();
            computers[i][8] = list.get(i).getTime();
        }
        computerTable.setModel(new DefaultTableModel(computers, columnNames));
    }
    
    /**
     * 
     * 
     */
    
    public void fillComputerFromSelectedRow(){
        int row = computerTable.getSelectedRow();
        if(row >= 0){
            idField.setText(computerTable.getModel().getValueAt(row, 0).toString());
            
            nameField.setText(computerTable.getModel().getValueAt(row, 1).toString());
            statusComboBox.setSelectedItem(computerTable.getModel().getValueAt(row, 2).toString());
            
            accountField.setText(computerTable.getModel().getValueAt(row, 3).toString());
            passwordField.setText(computerTable.getModel().getValueAt(row, 4).toString());
            moneyField.setText(computerTable.getModel().getValueAt(row, 5).toString());
            dateField.setText(computerTable.getModel().getValueAt(row, 6).toString());
            pointField.setText(computerTable.getModel().getValueAt(row, 7).toString());
            timeField.setText(computerTable.getModel().getValueAt(row, 8).toString());
            
            editComputerBtn.setEnabled(true);
            deleteComputerBtn.setEnabled(true);
            searchAccBtn.setEnabled(true);
            searchNameBtn.setEnabled(true);
            addComputerBtn.setEnabled(false);
        }
    }
    
    public void clearComputerInfo(){
        idField.setText("");
        nameField.setText("");
        statusComboBox.setSelectedIndex(0);
        accountField.setText("");
        passwordField.setText("");
        moneyField.setText("");
        dateField.setText("");
        pointField.setText("");
        timeField.setText("");
        
        editComputerBtn.setEnabled(false);
        deleteComputerBtn.setEnabled(false);
        addComputerBtn.setEnabled(true);
    }
    
    /**
     * @param computer
     */
    
    public void showComputer(Computer computer){
        idField.setText(""+computer.getId());
        nameField.setText(computer.getName());
        boolean isUsing = false;
        if (computer.getStatus().equals("in_use")) {
            isUsing = true;
        }
    
        if (isUsing) {
            statusComboBox.setSelectedItem("In use");
        } else {
            statusComboBox.setSelectedItem("Not use");
        }
        
        accountField.setText(computer.getAccount());
        passwordField.setText(computer.getPassword());
        moneyField.setText(""+computer.getMoney());
        
        runTime();
        pointField.setText(""+computer.getPoint());
        timeField.setText(""+computer.getTime());
        
        editComputerBtn.setEnabled(true);
        deleteComputerBtn.setEnabled(true);
        addComputerBtn.setEnabled(false);
        
    }
    /**
     * @return
     */
    
    public Computer getComputerInfo(){
        if(!validateName() ||!validateAccount() || !validatePassword() || !validateMoney() || !validateDateOfTime() || !validatePoint() || !validateTime()){
            return null;
        }
        try{
            Computer computer = new Computer();
            if(idField.getText() != null && !"".equals(idField.getText())){
                computer.setId(Integer.parseInt(idField.getText()));
            }
            computer.setName(nameField.getText().trim());
            computer.setStatus((String) statusComboBox.getSelectedItem());
            computer.setAccount(accountField.getText().trim());
            computer.setPassword(passwordField.getText().trim());
            
            String moneyStr = moneyField.getText().trim();
            moneyStr = moneyStr.replace(",", ""); // Xóa dấu phân cách hàng nghìn hiện tại
            DecimalFormat formatter = new DecimalFormat("#,###");
            moneyStr = formatter.format(Double.parseDouble(moneyStr));

            computer.setMoney(moneyStr);
            computer.setDateOf(dateField.getText().trim());
            computer.setPoint(Integer.parseInt(pointField.getText().trim()));
            computer.setTime(Integer.parseInt(timeField.getText().trim()));
            return computer;
        } catch (NumberFormatException e) {
            showMessage("Lỗi chuyển đổi kiểu dữ liệu: " + e.getMessage());
        } catch (Exception e) {
            showMessage("Lỗi: " + e.getMessage());
        }
        return null;
    }
    
    private boolean validateAccount(){
        String account = accountField.getText();
        if(account == null || "".equals(account.trim())){
            accountField.requestFocus();
            showMessage("Account không được trống.");
            return false;
        }
        return true;
    }
    private boolean validateName(){
        String name = nameField.getText();
        if(name == null || "".equals(name.trim())){
            accountField.requestFocus();
            showMessage("Tên máy không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validatePassword(){
        String password = passwordField.getText();
        if(password == null || "".equals(password.trim())){
            accountField.requestFocus();
            showMessage("Password không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateMoney(){
        try {
            String moneyStr = moneyField.getText().trim().replace(".", "").replace(",", ".");
            if(Double.parseDouble(moneyStr) < 0){
                moneyField.requestFocus();
                showMessage("Số tiền không hợp lệ!");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            moneyField.requestFocus();
            showMessage("Không hợp lệ !");
            return false;
        }
    }
    
    
    private boolean validateDateOfTime(){
        String dateOf = dateField.getText();
        if(dateOf == null || "".equals(dateOf.trim())){
            dateField.requestFocus();
            showMessage("Thời gian đăng kí không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validatePoint(){
        try {
            Byte point = Byte.parseByte(pointField.getText().trim());
            if(point < 0){
                moneyField.requestFocus();
                showMessage("Số điểm không hợp lệ!");
                return false;
            }
        } catch (Exception e) {
            moneyField.requestFocus();
            showMessage("Không hợp lệ !");
            return false;
        }
        return true;
    }
    
    private boolean validateTime(){
        try {
            Byte time = Byte.parseByte(timeField.getText().trim());
            if(time < 0){
                moneyField.requestFocus();
                showMessage("Thời gian không hợp lệ!");
                return false;
            }
        } catch (Exception e) {
            moneyField.requestFocus();
            showMessage("Không hợp lệ !");
            return false;
        }
        return true;
    }
    
    public String getComputerSearchAccount(){
        return searchAccField.getText();
    }
    public String getComputerSearchID(){
        return searchAccField.getText();
    }
    public String getComputerSearchName(){
        return searchNameField.getText();
    }
    
    
    
    public void actionPerformed(ActionEvent e){}
    public void valueChanged(ListSelectionEvent e){}
    public void addAddComputerListener(ActionListener listener){
        addComputerBtn.addActionListener(listener);
    }
    public void addEditComputerListener(ActionListener listener){
        editComputerBtn.addActionListener(listener);
    }
    public void addDeleteComputerListener(ActionListener listener){
        deleteComputerBtn.addActionListener(listener);
    }
    public void addClearListener(ActionListener listener){
        clearBtn.addActionListener(listener);
    }
    
    public void addSearchAccListener(ActionListener listener){
        searchAccBtn.addActionListener(listener);
    }
    public void addSearchNameListener(ActionListener listener){
        searchNameBtn.addActionListener(listener);
    }
    
    public void addSortComputerMoneyListener(ActionListener listener){
        sortComputerMoneyBtn.addActionListener(listener);
    }
    public void addSortComputerPointListener(ActionListener listener){
        sortComputerPointBtn.addActionListener(listener);
    }
    public void addSortComputerTimeListener(ActionListener listener){
        sortComputerTimeBtn.addActionListener(listener);
    }
    
    public void addListComputerSelectionListener(ListSelectionListener listener){
        computerTable.getSelectionModel().addListSelectionListener(listener);
    }
}
