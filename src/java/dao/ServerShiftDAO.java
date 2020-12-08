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
import java.util.Date;
import model.BookedRoomServing;
import model.Server;
import model.ServerShift;
import model.ServingHourStat;
import model.Shift;

/**
 *
 * @author nguye
 */
public class ServerShiftDAO extends DAO{
    public ServerShiftDAO(){
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
    
    public ArrayList<ServerShift> getCaLamViecCaNhan(ServingHourStat shs, Date startDate, Date endDate){
        java.sql.Date startDateSql = new java.sql.Date(startDate.getTime());
        java.sql.Date endDateSql = new java.sql.Date(endDate.getTime());
        
        ArrayList<ServerShift> ass = new ArrayList<ServerShift>();
        
        String sql = "select * from servershift "
                + "left join shift on servershift.tblshiftid = shift.id "
                + "where (date_add(shift.week, INTERVAL shift.dayInWeek day) "
                + "between ? and ?) and servershift.tblserverid = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, startDateSql);
            ps.setDate(2, endDateSql);
            ps.setInt(3, shs.getId());
            
            Server server = new Server();
            server.setId(shs.getId());
            server.setName(shs.getName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Shift shift = new Shift();
                shift.setWeek(rs.getDate("shift.week"));
                shift.setDayOfWeek(rs.getInt("shift.dayInWeek"));
                shift.setTimeTable(rs.getInt("shift.timeTable"));
                
                ServerShift ss = new ServerShift();
                ss.setId(rs.getInt("servershift.id"));
                ss.setServer(server);
                ss.setShift(shift);
                ass.add(ss);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ass;
    }
    
    
    public ArrayList<ServerShift> getdsNhanVienDangLam(){
        ArrayList<ServerShift> ass = new ArrayList<ServerShift>();
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
        Shift curShift = new Shift();
        curShift.setWeek(firstDayOfWeek);
        curShift.setDayOfWeek(dayOfWeek);
        curShift.setTimeTable(timeTable);
        
        // sql
        String sql = "SELECT * FROM ServerShift "
                + "LEFT JOIN Shift ON servershift.tblshiftid = shift.id "
                + "LEFT JOIN Staff ON servershift.tblserverid = staff.user_id "
                + "LEFT JOIN User ON staff.user_id = user.id "
                + "WHERE shift.week > ? AND shift.dayInWeek = ? AND shift.timeTable = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, firstDayOfWeek);
            ps.setInt(2, dayOfWeek);
            ps.setInt(3, timeTable);
            
            System.out.println(ps);
            
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()){
                Server server = new Server();
                server.setId(rs.getInt("staff.user_id"));
                server.setName(rs.getString("user.name"));
                ServerShift ss = new ServerShift();
                ss.setId(rs.getInt("servershift.id"));
                ss.setServer(server);
                ss.setShift(curShift);
                ass.add(ss);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ass;
    }
}
