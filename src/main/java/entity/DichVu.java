/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author USUS
 */
public class DichVu {
    private String maDV;	
    private String tenDV;
    private float gia;
    //Trả về mã dịch vụ  và tên dịch vụ trong form đăng ký dịch vụ
    @Override
    public String toString(){
        return maDV + tenDV;
    }
    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

   
}
