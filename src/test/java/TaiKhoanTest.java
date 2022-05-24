import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.NhanVien;
import entity.TaiKhoan;
import excel.ReadWriteTaiKhoan;
import test.taikhoan;
import utils.XDate;

public class TaiKhoanTest {
	
	public Boolean checkLogin(String username, String password) {
 		TaiKhoan tk = dao.selectID(username);
		if (tk == null) {
			System.out.print("Tài khoản không tồn tại\n");
			return false;
		} else {
			if (tk.getMatKhau().equals(password)) {
				return true;
			} else {
				System.out.print("Sai mật khẩu\n");
				return false;
			}
		}
	}
	//Test thêm tài khoản nhân viên
    public Boolean checkAddUser(String username,String password,String chucvu) {
    	if(username.equals(" ") || password.equals(" ") || chucvu.equals(" ")) {
    		return false;
    	}else {
    		return true;
    	}
		
		
	}

    
	public String file = null;
	public List<taikhoan> list;	
	 
	
	  //Test đăng nhập
    @BeforeTest
	public void checkLoginSuccess() {
    		file = "danhsachuser.xlsx";
        	list = ReadWriteTaiKhoan.ReadFileExcell(file);
        	for(taikhoan t : list) {
        		if(checkLogin(t.tentaiKhoan, t.matKhau)==true) {
        			assertTrue(checkLogin(t.tentaiKhoan, t.matKhau));
        			ReadWriteTaiKhoan.Update(file,"Pass", t.row);
				} else {
					ReadWriteTaiKhoan.Update(file,"Failed", t.row);
				}
    		}
	}
	
	
  //Test phần tìm kiếm tài khoản
    TaiKhoanDAO dao = new TaiKhoanDAO(); 
    @Test(priority = 0)
	public void findUserByUserName() {
    	file = "danhsachuser.xlsx";
    	list = ReadWriteTaiKhoan.ReadFileExcell(file);
		for(taikhoan t : list) {
			TaiKhoan user = dao.selectID(t.tentaiKhoan);
			assertTrue(user != null);
		}
	}
       
    @Test(priority = 1)
    public void addUser() {
    	file = "ThemTaiKhoan.xlsx";
    	list = ReadWriteTaiKhoan.ReadFileExcell(file);
    	for(taikhoan t : list) {
    			if (checkAddUser(t.tentaiKhoan,t.matKhau,t.chucVu)) {
        			dao.insert(t.tentaiKhoan ,t.matKhau, t.chucVu, t.maNV);
        			ReadWriteTaiKhoan.Update(file,"Pass", t.row);
        		} 
    			else {		
        			ReadWriteTaiKhoan.Update(file,"Failed", t.row);
        		}
    	}    	
    }
    //Test cập nhật nhân viên
    @Test(priority = 2)
	public void updateUser() {
    	file = "CapNhatTaiKhoan.xlsx";
    	list = ReadWriteTaiKhoan.ReadFileExcell(file);
    	for(taikhoan t : list) {
    		if(checkAddUser(t.tentaiKhoan,t.matKhau,t.chucVu)) {
    			TaiKhoan tk = dao.selectID(t.tentaiKhoan);
        		tk.setChucVu(t.chucVu);
            	tk.setMatKhau(t.matKhau);
            	System.out.print(t.tentaiKhoan);
            	dao.update(tk);
            	ReadWriteTaiKhoan.Update(file,"Pass", t.row);
    		}else {
    			ReadWriteTaiKhoan.Update(file,"Failed", t.row);
    		}
    		
		}
    	
	}
 //Test xóa tài khoản
    @Test(priority = 3)
    public void deleteUser() {
		file = "XoaTaiKhoan.xlsx";
    	list = ReadWriteTaiKhoan.ReadFileExcell(file);
    	for(taikhoan t : list) {
    			dao.delete(t.tentaiKhoan);
    			ReadWriteTaiKhoan.Update(file,"Pass", t.row);
		}
    
    }
   
}
