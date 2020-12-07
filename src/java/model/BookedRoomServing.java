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
public class BookedRoomServing implements Serializable{
    private int id;
    private Date servingTime;
    private ServerShift serverShift;

    public BookedRoomServing(int id, Date servingTime, ServerShift serverShift) {
        this.id = id;
        this.servingTime = servingTime;
        this.serverShift = serverShift;
    }

    public BookedRoomServing() {
        }

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

    public ServerShift getServerShift() {
        return serverShift;
    }

    public void setServerShift(ServerShift serverShift) {
        this.serverShift = serverShift;
    }
    
    
}
