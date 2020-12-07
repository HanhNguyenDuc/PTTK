/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author nguye
 */
public class ServerShift implements Serializable{
    private Shift shift;
    private Server server;
    private int id;
    private Date servingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getServingTime() {
        return servingTime;
    }

    public void setServingTime(Date servingTime) {
        this.servingTime = servingTime;
    }

    public ServerShift(Shift shift, Server server) {
        this.shift = shift;
        this.server = server;
    }

    public ServerShift() {
        }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
    
    
}
