/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguye
 */
public class ServingHourStat extends Server{
    private int totalHourServing;

    public int getTotalHourServing() {
        return totalHourServing;
    }

    public void setTotalHourServing(int totalHourServing) {
        this.totalHourServing = totalHourServing;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ServingHourStat() {
    }
    
    public ServingHourStat(Staff s){
        this.id = s.getId();
        this.name = s.getName();
    }
    
}
