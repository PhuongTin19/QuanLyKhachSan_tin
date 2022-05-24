/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Phong;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JDBCHelper;

/**
 *
 * @author USUS
 */
public class PhongDAO {

    String INSERT_SQL = "{CALL insert_PHONG(?,?,?,?,?,?)}";
    //String UPDATE_SQL = "{CALL update_PHONG(?,?,?,?)}";
    String UPDATE_SQL = "UPDATE Phong SET TenPhong=?,LoaiPhong=?,GiaPhong=? WHERE MaPhong = ?";
    String DELETE_SQL = "{CALL delete_PHONG(?)}";
    String SELECT_ALL_SQL = "{CALL List_PHONG}";
    String SELECT_BY_ID = "{CALL Find_PHONG(?)}";
    String selectByKeyWord = "{CALL selectbyKeyWordPhong(?,?,?)}";

    public void insert(String maPhong, String tenPhong, String loaiPhong, String tinhTrang, float giaPhong, String maNV) {
        JDBCHelper.update(INSERT_SQL, maPhong, tenPhong, loaiPhong, tinhTrang, giaPhong, maNV);
    }

    public void update(String maPhong, String tenPhong, String loaiPhong, String tinhTrang, float giaPhong, String maNV) {
        JDBCHelper.update(UPDATE_SQL, tenPhong, loaiPhong, giaPhong, maPhong);
    }
    public void update(Phong p) {
        JDBCHelper.update(UPDATE_SQL,p.getTenPhong(),p.getLoaiPhong(),p.getGiaPhong(),p.getMaPhong());
    }
    public void delete(String key) {
        JDBCHelper.update(DELETE_SQL, key);
    }

    public List<Phong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public Phong selectID(String key) {
        List<Phong> list = this.selectBySql(SELECT_BY_ID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<Phong>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Phong entity = new Phong();
                
                entity.setTenPhong(rs.getString("TenPhong"));
                entity.setMaPhong(rs.getString("MaPhong"));
                entity.setLoaiPhong(rs.getString("LoaiPhong"));
                entity.setTinhTrang(rs.getString("TinhTrang"));
                entity.setGiaPhong(rs.getFloat("GiaPhong"));
                entity.setMaNV(rs.getString("MaNV"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;

        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        return null;
    }

    protected List<Phong> selectBySqlPhongTrong(String sql, Object... args) {
        List<Phong> list = new ArrayList<Phong>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Phong entity = new Phong();
                entity.setGiaPhong(rs.getFloat("GiaPhong"));
                entity.setLoaiPhong(rs.getString("LoaiPhong"));
                entity.setMaPhong(rs.getString("MaPhong"));
                entity.setTenPhong(rs.getString("TenPhong"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<Phong> selectBySql_GiaPhong(String sql, Object... args) {
        List<Phong> list = new ArrayList<Phong>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Phong entity = new Phong();
                entity.setGiaPhong(rs.getFloat("GiaPhong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Phong> selectByPhongTrong(String tinhtrang) {
        String sql = "{CALL List_PHONGTRONG(?)}";
        return this.selectBySqlPhongTrong(sql, tinhtrang);
    }
    public List<Phong> selectByPhongTrongTimkiem(String tinhtrang) {
        String sql = "{CALL Find_PHONG_PhongTrong(?)}";
        return this.selectBySqlPhongTrong(sql, tinhtrang);
    }
    public List<Phong> selectbyKeyword(String str) {
        return this.selectBySql(selectByKeyWord, "%" + str + "%", "%" + str + "%", "%" + str + "%");
    }
    public List<Phong> SelectGiaPhongByMaDP(String maDP){
        String sql = "{CALL SelectGiaPhongByMaDP(?)}";
        return this.selectBySql_GiaPhong(sql, maDP);
    }
}
