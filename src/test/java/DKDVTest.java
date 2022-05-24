import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.DKDichVuDAO;
import entity.DKDichVu;

public class DKDVTest {
	 //Test phần tìm kiếm
	   DKDichVuDAO dao = new DKDichVuDAO(); 
	    // tìm kiếm theo mã
	    @Test
		public void findUserByID() {
			String id = "DK06";
			DKDichVu dv = dao.selectID(id);
			assertTrue(dv != null);
		}
	
	    //Test thêm DKDV
	    @Test
	    public void addUser() {
	    	String Madk = "DK99";	
	        int sldv = 1;
	        String Madv = "DV05" ;
	        String MaKH = "KH01";
	        float gia = 500000;
	        dao.insert(Madk, Madv, MaKH, gia,sldv);
	    }
}
