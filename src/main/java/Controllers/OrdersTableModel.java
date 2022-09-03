package Controllers;

import java.sql.Date;
import java.sql.Time;

public class OrdersTableModel {
    private String vendorName;
    private String userName;
    private String location;
    private int id;
    private int momoNum;
    private int qty;
    private Float price;
    private Date date;
    private Time time;
    private Float totalAmount;


    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMomoNum() {
        return momoNum;
    }

    public void setMomoNum(int momoNum) {
        this.momoNum = momoNum;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrdersTableModel(int id, String location, String userName, String vendorName, int qty, int momoNum,
                            Float price, Float totalAmount, Time time, Date date){
        this.vendorName = vendorName;
        this.userName = userName;
        this.location = location;
        this.id = id;
        this.momoNum = momoNum;
        this.qty = qty;
        this.price = price;
        this.date = date;
        this.time = time;
        this.totalAmount = totalAmount;

    }
}
