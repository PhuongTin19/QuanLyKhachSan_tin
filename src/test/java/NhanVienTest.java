

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.testng.annotations.Test;

import test.nhanvien;
import dao.NhanVienDAO;
import entity.NhanVien;
import excel.ReadWriteNhanVien;
import utils.XDate;
import java.util.*;
public class NhanVienTest {

	 //Test phần tìm kiếm nhân viên
    NhanVienDAO dao = new NhanVienDAO();
    @Test(priority = 0)
	public void findUserByUserName() {
		String maNV = "NV01";
		NhanVien user = dao.selectID(maNV);
		assertTrue(user != null);
	}
    
    public String file = null;
   	public List<nhanvien> list;	
    public Boolean checkAddUser(String MaNV,String HoTen) {
    	if(MaNV.equals(" ") || HoTen.equals(" ") ) {
    		return false;
    	}else {
    		return true;
    	}
	}
    public Boolean checkAddUser(String MaNV,String HoTen,String NgaySinh,String GioiTinh,String CCCD,String DiaChi,String Email,String SDT,String ChucVu) {
    	if(MaNV.equals(" ") || HoTen.equals(" ") ) {
    		return false;
    	}else {
    		return true;
    	}
		
		
	}
    //Test thêm tài khoản nhân viên
    @Test(priority = 1)
    public void addUser() {
    	file = "ThemNhanVien.xlsx";
    	list = ReadWriteNhanVien.ReadFileExcell(file);
    	
    	for(nhanvien t : list) {
    		try {
    			if (checkAddUser(t.maNV,t.hoTen,t.ngaySinh,t.gioiTinh,t.CCCD,t.diaChi,t.email,t.sodienThoai,t.chucVu)) {
        			dao.insert(t.maNV ,t.hoTen,t.ngaySinh,Boolean.parseBoolean(t.gioiTinh),t.CCCD,t.diaChi,t.email,t.sodienThoai,t.chucVu);
        			
        			ReadWriteNhanVien.Update(file,"Pass", t.row);
        		} 
    			else {		
        			ReadWriteNhanVien.Update(file,"Failed", t.row);
        		}
			} catch (Exception e) {
				ReadWriteNhanVien.Update(file,"Failed", t.row);
			}
    			
    	}    	
    }
    
    
    //Test cập nhật nhân viên
    @Test(priority = 2)
    public void updateUser() {
       	file = "CapNhatNhanVien.xlsx";
       	list = ReadWriteNhanVien.ReadFileExcell(file);
       	
       	for(nhanvien t : list) {

       			if (checkAddUser(t.maNV,t.hoTen)) {
           			NhanVien nhanvien=dao.selectID(t.maNV);
           			nhanvien.setHoTen(t.hoTen);
           			dao.update(nhanvien);
           			ReadWriteNhanVien.Update2(file,"Pass", t.row);
           		} 
       			else {		
           			ReadWriteNhanVien.Update2(file,"Failed", t.row);
           		}
			
       			
       	}    	
       }
    //Test xóa nhân viên
    @Test(priority = 3)
    public void delete() {
    	file = "XoaNhanVien.xlsx";
    	list = ReadWriteNhanVien.ReadFileExcell(file);
		for(nhanvien t : list) {
			dao.delete(t.maNV);
			ReadWriteNhanVien.Update3(file,"Pass", t.row);		
	}    	
    }

    
}  
