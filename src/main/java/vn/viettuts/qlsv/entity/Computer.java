package vn.viettuts.qlsv.entity;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "computer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Computer implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String status;
    private String account;
    private String password;
    // số tiền
    private String money;
    // ngày giờ đăng kí
    private String dateOf;
    // số điểm
    private int point;
    // số giờ chơi
    private int time;
    
    public Computer(){
    }
    
    public Computer(int id, String name, String status ,String account, String password, String money, String dateOf ,int point, int time){
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.account = account;
        this.password = password;
        this.money = money;
        this.dateOf = dateOf;
        this.point = point;
        this.time = time;
    }
    
    
    public int getId(){return id;}
    public String getName(){return name;}
    public String getStatus(){return status;}
    public String getAccount(){return account;}
    public String getPassword(){return password;}
    public String getMoney(){return money;}
    public String getDateOf(){return dateOf;}
    public int getPoint(){return point;}
    public int getTime(){return time;}
    
    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setStatus(String status){this.status = status;}
    public void setAccount(String account){this.account = account;}
    public void setPassword(String password){this.password = password;}
    public void setMoney(String money){this.money = money;}
    public void setDateOf(String dateOf){this.dateOf = dateOf;}
    public void setPoint(int point){this.point = point;}
    public void setTime(int time){this.time = time;}
    
    
}
