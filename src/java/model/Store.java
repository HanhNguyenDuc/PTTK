/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Store implements Serializable{
    private String name, address, description;
    ArrayList<Staff> staff = new ArrayList<Staff>();
    ArrayList<Room> room = new ArrayList<Room>();

    public String getName() {
        return name;
    }

    public Store(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    public ArrayList<Room> getRoom() {
        return room;
    }

    public void setRoom(ArrayList<Room> room) {
        this.room = room;
    }
    
    
}
