/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Calendar;
import model.BookedRoomServing;

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
    
    
    
    public ArrayList<BookedRoomServing> timKiemNhanVienDangRanh(){
        ArrayList<BookedRoomServing> abrs = new ArrayList<BookedRoomServing>();
        Calendar today = getToday();
        
    }
}
