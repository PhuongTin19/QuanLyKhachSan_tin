package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

    //Chuyển từ chuỗi sang date
    public static Date toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
  
    
    
     public static String toString(Date date){
        try {
            formater.applyPattern("dd/MM/yyyy");
            return formater.format(date);
        } catch (Exception e) {
            return null;
        } 
        
    }
    //
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
    
    
    
}
