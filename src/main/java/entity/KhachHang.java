/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author USUS
 */
public class KhachHang {
    private String maKH;	
    private String hoTen;	
    private Date ngaySinh;
    private boolean gioiTinh;
    private String CCCD;	
    private String diaChi;	
    private String email;	
    private String sodienThoai;	
    //trả về mã khách hàng và họ tên trong form đăng ký dịch vụ
    @Override
    public  String toString(){
        return maKH+hoTen;
    }
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienThoai() {
        return sodienThoai;
    }

    public void setSodienThoai(String sodienThoai) {
        this.sodienThoai = sodienThoai;
    }

   
}
