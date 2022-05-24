

import java.util.List;

import org.testng.annotations.Test;

import dao.DichVuDAO;
import entity.DichVu;
import excel.ReadWriteDichVu;
import test.dichvu;
import test.nhanvien;

public class DichVuTest {
	 //Test phần tìm kiếm
    DichVuDAO dao = new DichVuDAO(); 

    public String file = null;
   	public List<dichvu> list;
    //Test thêm dịch vụ
    public Boolean checkAddDV(String maDV,String tenDV,String gia) {
    	if(maDV.equals(" ") || tenDV.equals(" ") || gia.equals(" ") ) {
    		return false;
    	}else {
    		return true;
    	}
    }
	
//    @Test
//    public void addDV() {
//    	file = "DichVuTest.xlsx";
//    	list = ReadWriteDichVu.ReadFileExcell(file);
//    	for(dichvu t : list) {
//			if (checkAddDV( t.maDV, t.tenDV ,t.gia)){
//    			dao.insert(t.maDV , t.tenDV ,Float.parseFloat(t.gia));
//    			ReadWriteDichVu.Update(file,"Pass", t.row);
//    		} 
//			else {		
//    			ReadWriteDichVu.Update(file,"Failed", t.row);
//    		}
//	}    
//    }
  //Test cập nhật dịch vụ
    @Test
	public void updateDV() {
    	file = "CapNhatDichVu.xlsx";
  		list = ReadWriteDichVu.ReadFileExcell(file);
  		for(dichvu t : list) {
  		DichVu dv = dao.selectID(t.maDV);
      	dv.setTenDV(t.tenDV);
      	dao.update(dv);
		}
    }
//
////    //Test xóa dịch vụ
//    @Test
//    public void deleteDV() {
//		file = "XoaDichVu.xlsx";
//		list = ReadWriteDichVu.ReadFileExcell(file);
//		for(dichvu t : list) {
//		dao.delete(t.maDV);
//		
//		}
//    }
}
