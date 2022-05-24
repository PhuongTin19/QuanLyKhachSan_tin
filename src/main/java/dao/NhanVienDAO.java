/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NhanVien;
import entity.TaiKhoan;

import java.util.ArrayList;
import java.util.List;


import utils.JDBCHelper;
import java.sql.*;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class NhanVienDAO {

    String Insert = "{CALL insert_NhanVien(?,?,?,?,?,?,?,?,?)}";
//    String Update = "{CALL Update_NhanVien(?,?,?,?,?,?,?,?,?)}";
    String Update = "UPDATE NhanVien SET HoTen=?,NgaySinh=?,GioiTinh=?,CCCD=?,DiaChi=?,Email=?,SDT=?,ChucVu=? WHERE MaNV = ?";

    String Delete = "{CALL Delete_NhanVien(?)}";
    String SelectByID = "{CALL Find_NhanVienByID(?)}";
    String SelectAll = "{CALL List_NhanVien}";
    String selectByKeyWord = "{CALL selectbyKw(?,?,?,?)}";

    public void insert(String manv, String hoten, String ngaySinh, boolean gioitinh, String cccd, String diachi, String email
            , String sdt, String chucvu) {
        JDBCHelper.update(Insert, manv, hoten, XDate.toDate(ngaySinh, "dd/MM/yyyy"), gioitinh, cccd, diachi, email, sdt, chucvu);
    }
  

    public void update(String manv, String hoten, String ngaySinh, boolean gioitinh, String cccd, String diachi
            , String email, String sdt,String chucvu) {
        JDBCHelper.update(Update, hoten, XDate.toDate(ngaySinh, "dd/MM/yyyy"), gioitinh, cccd, diachi, email, sdt, chucvu, manv);
    }
    public void update(NhanVien nv) {
        JDBCHelper.update(Update,nv.getHoTen(),nv.getNgaySinh(),nv.getGioiTinh(),nv.getCCCD(),nv.getDiaChi(),nv.getEmail(),nv.getSodienThoai(),nv.getChucVu(),nv.getMaNV());
    }
   
    
    public void delete(String key) {
        JDBCHelper.update(Delete, key);
    }

    public List<NhanVien> selectAll() {
        return this.selectBySql(SelectAll);
    }

    public NhanVien selectID(String key) {
        List<NhanVien> list = this.selectBySql(SelectByID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setCCCD(rs.getString("CCCD"));
                entity.setChucVu(rs.getString("ChucVu"));
                entity.setEmail(rs.getString("Email"));
                entity.setSodienThoai(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DiaChi"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<NhanVien> selecbyKeyword(String str) {
        return this.selectBySql(selectByKeyWord, "%" + str + "%", "%" + str + "%", "%" + str + "%","%"+str+"%");
    }
    
   
}
