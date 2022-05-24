/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import utils.XDate;

/**
 *
 * @author USUS
 */
public class TaiKhoan {
  private String tentaiKhoan;	
    private String matKhau;	
    private String chucVu;	
    private String maNV;

    public String getTentaiKhoan() {
        return tentaiKhoan;
    }

    public void setTentaiKhoan(String tentaiKhoan) {
        this.tentaiKhoan = tentaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
   
}
