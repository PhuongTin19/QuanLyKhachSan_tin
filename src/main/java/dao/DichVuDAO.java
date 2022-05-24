/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DKDichVu;
import entity.DichVu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.JDBCHelper;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class DichVuDAO {

    String Insert = "{CALL Insert_dichvu(?,?,?)}";
//    String Update = "{CALL Update_dichvu(?,?,?)}";
    String Update = "UPDATE DichVu SET TenDV=?,Gia=? WHERE MaDV=?";
    String Delete = "{CALL Delete_dichvu(?)}";
    String SelectByID = "{CALL Find_DichVu(?)}";
    String SelectAll = "{CALL List_DichVu}";
    String selectByKeyWord = "{CALL selectbyKeyWordDichVu(?,?)}";

    public void insert(String maDV, String tenDV, float gia) {
        JDBCHelper.update(Insert, maDV, tenDV, gia);
    }

    public void update(String tenDV, float gia,String maDV) {
        JDBCHelper.update(Update,tenDV,gia,maDV );
    }

    public void update(DichVu dv) {
        JDBCHelper.update(Update,dv.getTenDV(),dv.getGia(),dv.getMaDV() );
    }
    
    public void delete(String key) {
        JDBCHelper.update(Delete, key);
    }

    public List<DichVu> selectAll() {
        return this.selectBySql(SelectAll);
    }

    public DichVu selectID(String key) {
        List<DichVu> list = this.selectBySql(SelectByID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<DichVu>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DichVu entity = new DichVu();
                entity.setMaDV(rs.getString(1));
                entity.setTenDV(rs.getString(2));
                entity.setGia(rs.getFloat(3));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
 }
        public List<DichVu> selectBySqlGia(String sql, Object... args) {
        List<DichVu> list = new ArrayList<DichVu>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DichVu entity = new DichVu();
                entity.setGia(rs.getFloat("Gia"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DichVu> selecbyKeyword(String str) {
        return this.selectBySql(selectByKeyWord, "%" + str + "%", "%" + str + "%");
    }


      public List<DichVu> SelectGiaByDV(String madv){
        String sql = "{CALL SelectGiaByDV(?)}";
        return this.selectBySqlGia(sql, madv);   
    }
}
