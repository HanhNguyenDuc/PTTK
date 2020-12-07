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
public class Shift implements Serializable{
    private int id;

    public Shift(int id, Date timeTable, Date week) {
        this.id = id;
        this.timeTable = timeTable;
        this.week = week;
    }

    public Shift() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Date timeTable) {
        this.timeTable = timeTable;
    }

    public Date getWeek() {
        return week;
    }

    public void setWeek(Date week) {
        this.week = week;
    }
    private Date timeTable;
    private Date week;
}
