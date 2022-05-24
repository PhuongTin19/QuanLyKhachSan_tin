/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.Auth;
import utils.JDBCHelper;
import utils.MsgBox;

/**
 *
 * @author USUS
 */
public class TaiKhoanDAO{

//    String INSERT_SQL = "INSERT INTO TaiKhoan(TenTK,MatKhau,ChucVu,MaNV) VALUES (?,?,?,?)";
//    String UPDATE_SQL = "UPDATE TaiKhoan SET MatKhau=?,ChucVu=?,MaNV=? WHERE TenTK = ?";
//    String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
//    String SELECT_BY_ID = "SELECT * FROM TaiKhoan Where TenTK = ?";
        String Insert = "{CALL insert_TaiKhoan(?,?,?,?)}";
        String Update = "UPDATE TaiKhoan SET MatKhau=?,ChucVu=?,MaNV=? WHERE TenTK = ?";
        String Delete = "{CALL Delete_TaiKhoan(?)}";
        String SelectByID = "{CALL Find_TaiKhoan(?)}";
        String SelectAll = "{CALL List_TaiKhoan}";
        String selectbyKeyWord="{CALL selectbyKeyWordTaiKhoan(?)}";
        String selectbyMANV="{CALL CheckTK(?)}";
        

    public void insert(String tenTK,String matKhau,String chucVu,String manv) {
        JDBCHelper.update(Insert,tenTK,matKhau,chucVu,manv);
    }


    public void update(String tenTK,String matkhau,String chucVu) {
        JDBCHelper.update(Update,tenTK,matkhau,chucVu);
    }
     public void update(TaiKhoan tk) {
        JDBCHelper.update(Update, tk.getMatKhau(),tk.getChucVu(),tk.getMaNV(),tk.getTentaiKhoan());
    }

    public void delete(String key) {
        JDBCHelper.update(Delete,key);
    }


    public List<TaiKhoan> selectAll() {
        return this.selectBySql(SelectAll);
    }


    public TaiKhoan selectID(String key) {
        List<TaiKhoan> list = this.selectBySql(SelectByID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
     public TaiKhoan selectBYMaNV(String key) {
        List<TaiKhoan> list = this.selectBySql(selectbyMANV, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                TaiKhoan entity = new TaiKhoan();
                entity.setTentaiKhoan(rs.getString("TenTK"));
                entity.setChucVu(rs.getString("ChucVu"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return null;
    }
     public List<TaiKhoan> selecbyKeyword(String str) {
        return this.selectBySql(selectbyKeyWord, "%"+str+"%");
    }
 	
}
