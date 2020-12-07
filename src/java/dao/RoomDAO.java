/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Room;

/**
 *
 * @author nguye
 */
public class RoomDAO extends DAO{
    public RoomDAO(){
        super();
    }
    
    public Room getRoomById(int id){
        String sql = "SELECT * from pttk.room"
                + " WHERE id=?";
        Room room = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setDesc(rs.getString("desc"));
                room.setPrice(rs.getFloat("price"));
                room.setType(rs.getString("type"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return room;
    }
    public ArrayList<Room> timPhongHatTheoTen(String name){
        String sql = "SELECT * From pttk.room "
                    + "WHERE name like ?";
        ArrayList<Room> roomList = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, name+'%');
            System.out.println(ps);

            ResultSet rs = ps.executeQuery();
            roomList = new ArrayList<Room>();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setDesc(rs.getString("desc"));
                room.setPrice(rs.getFloat("price"));
                room.setType(rs.getString("type"));
                roomList.add(room);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomList;
    }
    
    public int xoaPhongHat(Room room){
        int result = 0;
        String sql = "DELETE From pttk.room "
                    + "WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(ps);
            ps.setInt(1, room.getId());
            System.out.println(ps);

            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public int capNhatPhongHat(Room room){
        int result = -99;
        String sql = "UPDATE pttk.room" +
        "SET type = ?, desc = ?, price = ?" +
        "WHERE id = ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, room.getType());
            ps.setString(2, room.getDesc());
            ps.setFloat(3, room.getPrice());
            ps.setInt(4, room.getId());

            result = ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int themPhongHat(Room room){
        int result = -99;
        String sql = "INSERT INTO `room` (`name`, `desc`, `price`, `type`, `Store_id`) " + 
                "VALUES (?, ?, ?, ?, '1');";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, room.getName());
            ps.setString(2, room.getDesc());
            ps.setFloat(3, room.getPrice());
            ps.setString(4, room.getType());

            result = ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
