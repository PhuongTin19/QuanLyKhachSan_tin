/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JDBCHelper;

/**
 *
 * @author USUS
 */
public class ThongKeDAO {
    public List<Object[]>getListOfArray(String sql,String[]cols,Object...args)  {
        List<Object[]>list=new ArrayList<>();
        try {
            ResultSet rs=JDBCHelper.query(sql, args);
            while(rs.next()){
                Object[]vals=new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);;
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 

    }
    
    
    public List<Object[]>getDoanhThu(int selecttype,int year,int month,int day){
        String sql="{CALL TK_DoanhThu(?,?,?,?)}";
        String[]cols={"SoHD","TenPhong","DoanhThu","HDCaoNhat","HDThapNhat","HDTrungBinh"};
        List<Object[]> list= this.getListOfArray(sql, cols,selecttype,year,month,day);
       // List<Object[]> list = this.getListOfArray(sql, cols, nam);
        for (Object[] os : list) {
            os[2] = String.format("%.1f", os[2]);
            os[3] = String.format("%.1f", os[3]);
            os[4] = String.format("%.1f", os[4]);
            os[5] = String.format("%.1f", os[5]);
        }
        return list;
       } 
   
}
