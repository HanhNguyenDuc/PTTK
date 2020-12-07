/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Booking implements Serializable{
    private int id;
    private String paymentTypel;
    private Date paymentDate;
    private float total;
    private Customer customer;
    private Receptionist receptionist;
    private ArrayList<BookedRoom> bookedRoom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking(int id, String paymentTypel, Date paymentDate, float total, Customer customer, Receptionist receptionist, ArrayList<BookedRoom> bookedRoom) {
        this.id = id;
        this.paymentTypel = paymentTypel;
        this.paymentDate = paymentDate;
        this.total = total;
        this.customer = customer;
        this.receptionist = receptionist;
        this.bookedRoom = bookedRoom;
    }

    public String getPaymentTypel() {
        return paymentTypel;
    }

    public void setPaymentTypel(String paymentTypel) {
        this.paymentTypel = paymentTypel;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public ArrayList<BookedRoom> getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(ArrayList<BookedRoom> bookedRoom) {
        this.bookedRoom = bookedRoom;
    }
    
}
