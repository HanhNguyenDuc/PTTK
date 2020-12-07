/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Staff;
import model.User;

/**
 *
 * @author nguye
 */
public class UserDAO extends DAO{
    public UserDAO(){
        super();
    }
    
    public boolean kiemTraDangNhap(User u){
        boolean result = false;
//        String sql = "SELECT pttk.user.id, pttk.user.name, pttk.user.address, pttk.user.email, pttk.user.phone , pttk.staff.position, pttk.customer.type "
//                + "FROM pttk.user LEFT JOIN pttk.staff "
//                + "ON pttk.user.id = pttk.staff.user_id "
//                + "LEFT JOIN pttk.customer "
//                + "ON pttk.user.id = pttk.customer.user_id "
//                + "WHERE username = ? AND password = ?";
        String sql = "SELECT * From pttk.user "
                + "WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            System.out.println(ps);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setAddress(rs.getString("address"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setRole(rs.getString("role"));
            }
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
