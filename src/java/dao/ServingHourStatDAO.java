/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.ServingHourStat;
import model.Staff;

/**
 *
 * @author nguye
 */
public class ServingHourStatDAO extends DAO{
    public ServingHourStatDAO(){
        super();
    }
    
    public ArrayList<ServingHourStat> getServingHourStat(Date startDate, Date endDate){
        java.sql.Date startDateSql = new java.sql.Date(startDate.getTime());
        java.sql.Date endDateSql = new java.sql.Date(endDate.getTime());
        ArrayList<ServingHourStat> ashs = new ArrayList<ServingHourStat>();
        String sql = "select *, count(*) as count_servershift from servershift "
                + "left join shift on servershift.tblshiftid = shift.id "
                + "left join staff on servershift.tblserverid = staff.user_id "
                + "left join user on staff.user_id = user.id "
                + "WHERE date_add(shift.week, INTERVAL shift.dayInWeek day) "
                + "between ? and ? group by staff.user_id";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, startDateSql);
            ps.setDate(2, endDateSql);
            System.out.println("Query: " + ps);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Staff s = new Staff();
                s.setId(rs.getInt("staff.user_id"));
                s.setName(rs.getString("user.name"));
                int hourServing = rs.getInt("count_servershift") * 6;
                
                ServingHourStat shs = new ServingHourStat(s);
                shs.setTotalHourServing(hourServing);
                ashs.add(shs);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return ashs;
    }
    
}
