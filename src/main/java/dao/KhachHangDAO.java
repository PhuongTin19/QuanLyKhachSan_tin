/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JDBCHelper;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class KhachHangDAO {

    String INSERT_SQL = "{CALL insert_KhachHang(?,?,?,?,?,?,?,?)}";
//    String UPDATE_SQL = "{CALL update_KhachHang(?,?,?,?,?,?,?,?)}";
    String UPDATE_SQL = "UPDATE KhachHang SET HoTen=?,NgaySinh=?,GioiTinh=?,CCCD=?,DiaChi=?,Email=?,SDT=? WHERE MaKH = ?";
    String DELETE_SQL = "{CALL delete_KhachHang(?)}";
    String SELECT_ALL_SQL = "{CALL List_KhachHang}";
    String SELECT_BY_ID = "{CALL Find_KhachHang(?)}";
    String SELECTBYKEYWORD = "{CALL selectbyKeyWordKhachHang(?,?,?)}";

    public void insert(String maKH, String hoTen, String ngaySinh, boolean gioiTinh, String CCCD, String diaChi, 
            String Email,String sdt) {
        JDBCHelper.update(INSERT_SQL, maKH, hoTen, XDate.toDate(ngaySinh, "dd/MM/yyyy"), gioiTinh, CCCD, diaChi, Email, sdt);
    }

    public void update(String maKH, String hoTen, String ngaySinh, boolean gioiTinh, String CCCD, String diaChi, String Email,
            String sdt) {
        JDBCHelper.update(UPDATE_SQL, hoTen, XDate.toDate(ngaySinh, "dd/MM/yyyy"), gioiTinh, CCCD, diaChi, Email, sdt, maKH);
    }

    public void delete(String key) {
        JDBCHelper.update(DELETE_SQL, key);
    }

    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public KhachHang selectID(String key) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    

    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("MaKH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setCCCD(rs.getString("CCCD"));
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

    public List<KhachHang> selecbyKeyword(String str) {
        return this.selectBySql(SELECTBYKEYWORD, "%" + str + "%", "%" + str + "%", "%" + str + "%");
    }

}
