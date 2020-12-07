/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Server extends Staff implements Serializable{
    
    public Server(String username, String password, String address, String phone, String name, String email, int id) {
        super(username, password, address, phone, name, email, id, "Server");
    }
    

    public Server(Staff s) {
        super(s);
        this.position = "server";
    }

    public Server() {
    }
    
    
    
}
