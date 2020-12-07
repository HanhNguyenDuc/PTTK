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
public class Receptionist extends Staff implements Serializable{
    
    public Receptionist(String username, String password, String address, String phone, String name, String email, int id, String position) {
        super(username, password, address, phone, name, email, id, "Receptionist");
    }
    
}
