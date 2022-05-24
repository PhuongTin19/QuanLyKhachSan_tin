/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NhanVien;
import entity.ThanhToan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JDBCHelper;
import utils.MsgBox;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class ThanhToanDAO {

    String Insert = "{CALL insert_ThanhToan(?,?,?,?,?)}";
    String SelectByID = "{CALL checkTT(?)}";
    String SelectAll = "{CALL List_ThanhToan}";
    String selectbyKeyWord = "{CALL List_Find_ThanhToan(?,?)}";

    public void insert(String MaDK, String MaDP, String MaNV, String MaKH, float ThanhTien) {
        JDBCHelper.update(Insert, MaDK, MaDP, MaNV, MaKH, ThanhTien);
    }

    public List<ThanhToan> checkMaDP(String maDP) {
        String sql = "{CALL checkTT(?)}";
        return selectBySql(sql, maDP);
    }

    public List<ThanhToan> selectAll() {
        return this.selectBySql(SelectAll);
    }

    public List<ThanhToan> selectBySql_DP(String sql, Object... args) {
        List<ThanhToan> list = new ArrayList<ThanhToan>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                if (rs == null) {
                    MsgBox.alert(null, "Chưa thanh toán");
                } else {
                    ThanhToan entity = new ThanhToan();
                    entity.setMadatPhong(rs.getString("MaDP"));
                    list.add(entity);
                }
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public ThanhToan selectID(String key) {
        List<ThanhToan> list = this.selectBySql(SelectByID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
//public List<NhanVien> selectsql(String sql, Object... args) {
//        List<NhanVien>list=new ArrayList<NhanVien>();
//        try {
//            ResultSet rs=JDBCHelper.query(sql, args);
//            while(rs.next()){
//                NhanVien entity=new NhanVien();
//                entity.setMaNV(rs.getString("MaNV"));
//                entity.setHoTen(rs.getString("HoTen"));
//                entity.setNgaySinh(rs.getDate("NgaySinh"));
//                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
//                entity.setCCCD(rs.getString("CCCD"));
//                entity.setChucVu(rs.getString("ChucVu"));
//                entity.setEmail(rs.getString("Email"));
//                entity.setSoDienThoai(rs.getString("SDT"));
//                entity.setDiaChi(rs.getString("DiaChi"));
//                list.add(entity);
//            }
//            rs.getStatement().getConnection().close();
//            return list;
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//    }

    public List<ThanhToan> selectBySql(String sql, Object... args) {
        List<ThanhToan> list = new ArrayList<ThanhToan>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                ThanhToan entity = new ThanhToan();
                entity.setMaDK(rs.getString("MaDK"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMadatPhong(rs.getString("MaDP"));
                entity.setMathanhToan(rs.getInt("MaTT"));
                entity.setThanhTien(rs.getFloat("ThanhTien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Float> thanhtien(String makh) {
        String sql = "{CALL ThanhTienHD(?)}";
        List<Float> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, makh);
            while (rs.next()) {
                list.add(rs.getFloat("ThanhTien"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<ThanhToan> selecttype(int selecttype,String key) {
        return this.selectBySql(selectbyKeyWord, selecttype, key);
    }
}
