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
    
    protected String position;
    
    public Staff(String username, String password, String address, String phone, String name, String email, int id, String position) {
        super(username, password, address, phone, name, email, id);
        this.position = position;
    }

    public Staff(Staff s) {
        super(s.getUsername(), s.getPassword(), s.getAddress(), s.getPhone(), s.getName(), s.getEmail(), s.getId());
    }

    public Staff() {
    }
    
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
    
}
