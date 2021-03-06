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
import model.BookedRoomServing;
import model.Server;
import model.ServerShift;
import model.Shift;

/**
 *
 * @author nguye
 */
public class BookedRoomServingDAO extends DAO{
    public BookedRoomServingDAO(){
        super();
    }
    
    public Calendar getToday(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        return cal;
    }
    
    public int capNhatPhanCongNhanVien(BookedRoomServing brs, int bookedroomId){
        int result = -99;
        String sql = "INSERT INTO bookedroomserving (tblservershiftid, tblbookedroomid)"
                + "VALUES (?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, brs.getServerShift().getId());
            ps.setInt(2, bookedroomId);
            
            result = ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    
    
    public ArrayList<BookedRoomServing> getdsNhanVienDangPhucVu(){
        ArrayList<BookedRoomServing> abrs = new ArrayList<BookedRoomServing>();
        // get first day of week
        Calendar cal = getToday();
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        java.sql.Date firstDayOfWeek = new java.sql.Date(cal.getTime().getTime());
        // get current hour
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        // get day of week
        int dayOfWeek = rightNow.get(Calendar.DAY_OF_WEEK);
        int timeTable = Math.round(((float)hour / 24) * 3);
        
        // sql
        String sql = "SELECT * FROM BookedRoomServing "
                + "LEFT JOIN ServerShift ON servershift.id = bookedroomserving.tblservershiftid "
                + "LEFT JOIN Shift ON servershift.tblshiftid = shift.id "
                + "LEFT JOIN Staff ON servershift.tblserverid = staff.user_id "
                + "LEFT JOIN User ON staff.user_id = user.id "
                + "WHERE shift.week > ? AND shift.dayInWeek = ? AND shift.timeTable = ?";
        
        Shift curShift = new Shift();
        curShift.setWeek(firstDayOfWeek);
        curShift.setDayOfWeek(dayOfWeek);
        curShift.setTimeTable(timeTable);
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, firstDayOfWeek);
            ps.setInt(2, dayOfWeek);
            ps.setInt(3, timeTable);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                BookedRoomServing brs = new BookedRoomServing();
                brs.setId(rs.getInt("bookedroomserving.id"));
                // create servershift
                Server server = new Server();
                server.setId(rs.getInt("staff.user_id"));
                server.setName(rs.getString("user.name"));
                ServerShift ss = new ServerShift();
                ss.setId(rs.getInt("servershift.id"));
                ss.setServer(server);
                ss.setShift(curShift);
                brs.setServerShift(ss);
                abrs.add(brs);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return abrs;
    }
}
