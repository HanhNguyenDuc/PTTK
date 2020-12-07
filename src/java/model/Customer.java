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
public class Customer extends User{
    private String type;

    public Customer(String username, String password, String address, String phone, String name, String email, int id, String type) {
        super(username, password, address, phone, name, email, id);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

    
}
