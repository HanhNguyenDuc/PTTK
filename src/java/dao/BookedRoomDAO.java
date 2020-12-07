/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import model.BookedRoom;
import model.BookedRoomServing;
import model.Server;
import model.ServerShift;
import model.Shift;
import model.Staff;

/**
 *
 * @author nguye
 */
public class BookedRoomDAO extends DAO{
    public BookedRoomDAO(){
        super();
    }
    
    public ArrayList<BookedRoom> timPhongHatDangDungTheoTen(String roomName){
        ArrayList<BookedRoom> abr = new ArrayList<BookedRoom>();
        try{
            RoomDAO rd = new RoomDAO();
            String sql = "Select * from bookedroom left join room on room.id = bookedroom.room_id \n"
                + "WHERE (bookedroom.receiveDate <= ? AND bookedroom.returnDate >= ?) \n"
                + "OR(bookedroom.receiveDate < ? AND bookedroom.returnDate >= ?)\n"
                + "OR(bookedroom.receiveDate >= ? AND bookedroom.returnDate <= ?)"
                    + " AND(room.name like ?)\n";
            String sql_bookedRoomServing = "Select * from bookedroomserving"
                    + " WHERE tblBookedRoomid=?";
            String sql_servershift = "Select * from servershift"
                    + " WHERE id=?";
            String sql_shift = "Select * from shift"
                    + " Where id=?";
            String sql_staff = "Select * from staff left join user on staff.user_id = user.id"
                    + " Where id=?";
            
            
            PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            ps.setDate(1, date);
            ps.setDate(2, date);
            ps.setDate(3, date);
            ps.setDate(4, date);
            ps.setDate(5, date);
            ps.setDate(6, date);
            ps.setString(7, roomName+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                BookedRoom br = new BookedRoom();
                br.setId(rs.getInt("id"));
                br.setReceiveTime(rs.getDate("receiveDate"));
                br.setPrice(rs.getFloat("price"));
                br.setBookedRoomServing(new ArrayList<BookedRoomServing>());
                // Get room
                br.setRoom(rd.getRoomById(rs.getInt("Room_id")));
                ps = conn.prepareStatement(sql_bookedRoomServing);
                ps.setInt(1, br.getId());
                ResultSet rsBookedRoomServing = ps.executeQuery();
                
                while (rsBookedRoomServing.next()){
                    BookedRoomServing brs = new BookedRoomServing();
                    brs.setId(rs.getInt("id"));
                    // get ServerShift
                    ps = conn.prepareStatement(sql_servershift);
                    ps.setInt(1, rsBookedRoomServing.getInt("tblservershiftid"));
                    ResultSet rsServerShift = ps.executeQuery();
                    if (rsServerShift.next()){
                        ServerShift ss = new ServerShift();
                        ss.setId(rsServerShift.getInt("id"));
                        // get Shift
                        ps = conn.prepareStatement(sql_shift);
                        ps.setInt(1, rsServerShift.getInt("tblshiftid"));
                        ResultSet rsShift = ps.executeQuery();
                        if (rsShift.next()){
                            Shift s = new Shift();
                            s.setId(rsShift.getInt("id"));
                            s.setTimeTable(rsShift.getInt("timeTable"));
                            s.setWeek(rsShift.getDate("week"));
                            ss.setShift(s);
                        }
                        // get Staff
                        ps = conn.prepareStatement(sql_staff);
                        ps.setInt(1, rsServerShift.getInt("tblserverid"));
                        ResultSet rsStaff = ps.executeQuery();
                        if (rsStaff.next()){
                            Staff s = new Staff();
                            s.setId(rsStaff.getInt("user.id"));
                            s.setName(rsStaff.getString("user.name"));
                            ss.setServer(new Server(s));
                        }
                        brs.setServerShift(ss);
                        
                    }
                    br.getBookedRoomServing().add(brs);
                }
                abr.add(br);
                
                
                
                
                
                
                
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(abr);
        return abr;
    }
}
