/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DKDichVu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JDBCHelper;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class DKDichVuDAO {
    String Insert = "{CALL Insert_dangkydichvu(?,?,?,?,?)}";
    String SelectByID = "{CALL Find_DKDichVu(?)}";
    String selectByKeyWord = "{CALL selectbyKeyWordDKDichVu(?,?,?)}";
    String selectType="{CALL List_Find_DKDichVu(?,?,?,?)}";
    String selectBYMAKH="{CALL CheckDKDV(?)}";
    public void insert(String maDK,String maDV,String maKH,float gia,int SLDichVu) {
        JDBCHelper.update(Insert,maDK,maDV,maKH,gia,SLDichVu);
    } 
    public List<DKDichVu> selectListType(int listtype,String keyword){
        return this.selectBySql(selectType,listtype,"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%");
    }
    public DKDichVu selectID(String key) {
        List<DKDichVu> list = this.selectBySql(SelectByID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public DKDichVu selectmaKH(String key) {
        List<DKDichVu> list = this.selectBySql(selectBYMAKH, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<DKDichVu> selectBySql(String sql, Object... args) {
        List<DKDichVu> list = new ArrayList<DKDichVu>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DKDichVu entity = new DKDichVu();
                entity.setMaDK(rs.getString("MaDK"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setMaDV(rs.getString("MaDV"));
                entity.setSoluongDV(rs.getInt("SLDichVu"));
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
        public List<DKDichVu> selectBySql_MaDK(String sql, Object... args) {
        List<DKDichVu> list = new ArrayList<DKDichVu>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DKDichVu entity = new DKDichVu();
                entity.setMaDK(rs.getString("MaDK"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
         public List<DKDichVu> selectBySql_TienDV(String sql, Object... args) {
        List<DKDichVu> list = new ArrayList<DKDichVu>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DKDichVu entity = new DKDichVu();
                entity.setGia(rs.getFloat("Gia"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
       
    public List<DKDichVu> selecbyKeyword(String str) {
        return this.selectBySql(selectByKeyWord, "%" + str + "%", "%" + str + "%", "%" + str + "%");
    }
    public List<DKDichVu> selectMaDKByMaKH(String maKH){
        String sql = "{CALL selectMaDKByMaKH(?)}";
        return this.selectBySql_MaDK(sql, maKH);
    }
    public List<DKDichVu> selectTienDVByMaKH(String maKH){
        String sql = "{CALL selectTienDVByMaKH(?)}";
        return this.selectBySql_TienDV(sql, maKH);
    }
}
