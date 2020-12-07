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
public class Staff extends User{
    
    private String position;
    
    public Staff(String username, String password, String address, String phone, String name, String email, int id, String position) {
        super(username, password, address, phone, name, email, id);
        this.position = position;
    }

    public Staff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
    
}
