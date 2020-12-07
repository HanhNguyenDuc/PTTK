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
public class Manager extends Staff implements Serializable{
    
    public Manager(String username, String password, String address, String phone, String name, String email, int id, String position) {
        super(username, password, address, phone, name, email, id, "Manager");
    }
    
}
