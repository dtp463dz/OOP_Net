package vn.viettuts.qlsv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.viettuts.qlsv.entity.Computer;
import vn.viettuts.qlsv.entity.ComputerXML;
import vn.viettuts.qlsv.utils.FileUtils;


public class ComputerDao {
    private static final String COMPUTER_FILE_NAME = "computer.xml";
    private List<Computer> listComputers;
    
    public ComputerDao(){
        this.listComputers = readListComputers();
        if(listComputers == null){
            listComputers = new ArrayList<Computer>();
        }
    }
    
    /**
     * Lưu các đối tượng computer vào file computer.xml
     * 
     * @param computer
     */
    public void writeListComputers(List<Computer> computers){
        ComputerXML computerXML = new ComputerXML();
        computerXML.setComputer(computers);
        FileUtils.writeXMLtoFile(COMPUTER_FILE_NAME, computerXML);
    }
    /**
     * Đọc các đối tượng computer từ file computer.xml
     * @return list computer
     */
    
    public List<Computer> readListComputers(){
        List<Computer> list = new ArrayList<Computer>();
        ComputerXML computerXML = (ComputerXML) FileUtils.readXMLFile(COMPUTER_FILE_NAME, ComputerXML.class);
        if(computerXML != null){
            list = computerXML.getComputer();
        }
        return list;
    }
    
    /**
     * thêm vào list và lưu list vào file
     * @param computer
     */
    public void add(Computer computer){
        int id = 1;
        if(listComputers != null && listComputers.size() > 0){
            id = listComputers.size() +1;
        }
        computer.setId(id);
        listComputers.add(computer);
        writeListComputers(listComputers);
    }
    /**
     * 
     * @param computer
     */
    public void edit(Computer computer){
        int size = listComputers.size();
        for(int i = 0; i < size; i++){
            if(listComputers.get(i).getId() == computer.getId()){
                listComputers.get(i).setAccount(computer.getAccount());
                listComputers.get(i).setPassword(computer.getPassword());
                
                listComputers.get(i).setMoney(computer.getMoney());
                listComputers.get(i).setPoint(computer.getPoint());
                listComputers.get(i).setTime(computer.getTime());
                
                writeListComputers(listComputers);
                break;
            }
        }
    }
    
    /**
     * 
     * @param computer
     */
    public boolean delete(Computer computer){
        boolean isFound = false;
        int size = listComputers.size();
        for(int i = 0; i < size; i++){
            if(listComputers.get(i).getId() == computer.getId()){
                computer = listComputers.get(i);
                isFound = true;
                break;
            }
        }
        if(isFound){
            listComputers.remove(computer);
            writeListComputers(listComputers);
            return true;
        }
        return false;
    }
        
    
    /**
     * sapxep
     */
    public void sortComputerByMoney(){
        Collections.sort(listComputers, new Comparator<Computer>() {
            public int compare(Computer computer1, Computer computer2) {
                Double money1 = Double.parseDouble(computer1.getMoney().replaceAll(",", ""));
                Double money2 = Double.parseDouble(computer2.getMoney().replaceAll(",", ""));
                return Double.compare(money1, money2);
            }
        });  
    }
    
    public void sortComputerByPoint(){
        Collections.sort(listComputers, new Comparator<Computer>() {
            public int compare(Computer computer1, Computer computer2) {
                if (computer1.getPoint()> computer2.getPoint()) {
                    return 1;
                }
                return -1;
            }
        });  
    }
    
    public void sortComputerByTime(){
        Collections.sort(listComputers, new Comparator<Computer>() {
            public int compare(Computer computer1, Computer computer2) {
                if (computer1.getTime()> computer2.getTime()) {
                    return 1;
                }
                return -1;
            }
        });  
    }
    
    public List<Computer> getComputerByAccount(String account){
        List<Computer>listComputer = new ArrayList<>();
        if(account == null || account.isEmpty()){
            return listComputer;
        }
        for(Computer computer : listComputers){
            if(computer.getAccount().equalsIgnoreCase(account)){
                listComputer.add(computer);
            }
        }
        return listComputer;
    }
    
    public List<Computer> getComputerByName(String name){
        List<Computer>listComputer = new ArrayList<>();
        if(name == null || name.isEmpty()){
            return listComputer;
        }
        for(Computer computer : listComputers){
            if(computer.getName().equalsIgnoreCase(name)){
                listComputer.add(computer);
            }
        }
        return listComputer;
    }
    
    
    
    public List<Computer> getListComputers(){
        return listComputers;
    }
    
    public void setListComputers(List<Computer> listComputers){
        this.listComputers = listComputers;
    }
}