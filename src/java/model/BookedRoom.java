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
public class BookedRoom implements Serializable{
    private int id;
    private Date receiveTime;
    private Date returnTime;
    private float price;
    private Room room;
    private ArrayList<BookedRoomServing> bookedRoomServing;

    public BookedRoom() {
    
    }

    public int getId() {
        return id;
    }

    public BookedRoom(int id, Date receiveTime, Date returnTime, float price, Room room, ArrayList<BookedRoomServing> bookedRoomServing) {
        this.id = id;
        this.receiveTime = receiveTime;
        this.returnTime = returnTime;
        this.price = price;
        this.room = room;
        this.bookedRoomServing = bookedRoomServing;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ArrayList<BookedRoomServing> getBookedRoomServing() {
        return bookedRoomServing;
    }

    public void setBookedRoomServing(ArrayList<BookedRoomServing> bookedRoomServing) {
        this.bookedRoomServing = bookedRoomServing;
    }
    
    
}
