
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import dao.PhongDAO;
import entity.Phong;
import excel.ReadWritePhong;
import dao.DatPhongDAO;
import dao.PhongDAO;
import entity.DatPhong;

import net.sf.jasperreports.engine.util.JRStyledText.Run;
import test.phong;
public class PhongTest {
	 //Test phần tìm kiếm phòng
	PhongDAO dao = new PhongDAO(); 
	
//	@Test
//	public void getNhanvien() {
//		file = "updatePhong.xlsx";
////		file = "danhsachuser.xlsx";
//		list = ReadWritePhong.ReadFileExcell(file);
//		for(phong t : list) {
//			System.out.println(t.tenPhong);
//		}
//	}
	
//	




	
	public String file = null;
	public List<phong> list;
	public Boolean checkAddDP(String map,String tenphong,String loaiphong,String tinhtrang,String giaphong) {
    	if(map.equals(" ")) {
    		return false;
    	}else {
    		return true;
    	}
	}
		@Test(priority = 0)
	    public void addUser() {
	    	file = "addPhong.xlsx";
	    	list = ReadWritePhong.ReadFileExcell(file);
	    	for(phong p : list) {
	    			if (checkAddDP(p.maPhong,p.tenPhong,p.loaiPhong,p.tinhTrang,p.giaPhong)) {
	    				
	        			dao.insert(p.maPhong,p.tenPhong,p.loaiPhong,p.tinhTrang,Float.valueOf(p.giaPhong),p.maNV);
	        			ReadWritePhong.Update(file,"Pass", p.row);
	        		} 
	    			else {		
	    				ReadWritePhong.Update(file,"Failed", p.row);
	        		}
	    	}    	
	    }
	
	
//Test cập nhật phòng
	    @Test(priority = 1)
		public void updateRoom() {
	    	file = "updatePhong.xlsx";
	    	list = ReadWritePhong.ReadFileExcell(file);
	    	for(phong p : list) {
	    		if(checkAddDP(p.tenPhong,p.loaiPhong,p.tinhTrang,p.giaPhong,p.maNV)==true) {
	    			entity.Phong phong = dao.selectID(p.maPhong);
		        	phong.setTenPhong(p.tenPhong);
		        	phong.setLoaiPhong(p.loaiPhong);
		        	phong.setGiaPhong(Float.valueOf(p.giaPhong));
		        	dao.update(phong);
	    			ReadWritePhong.Update(file,"Pass", p.row);
	    		} 
				else {		
					ReadWritePhong.Update(file,"Failed", p.row);
	    		}
	    	}
	    }
////Test xóa phòng

	    @Test(priority = 2)
	    public void deleteRoom() {
			file = "deletePhong.xlsx";
	    	list = ReadWritePhong.ReadFileExcell(file);
	    	for(phong p : list) {
	    		dao.delete(p.maPhong);
    			ReadWritePhong.Update(file,"Pass", p.row);
			}
	    }

	    
}

