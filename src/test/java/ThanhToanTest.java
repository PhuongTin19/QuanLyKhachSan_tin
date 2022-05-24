import dao.ThanhToanDAO;
import entity.ThanhToan;

public class ThanhToanTest {
	ThanhToan tt = new ThanhToan();
	ThanhToanDAO ttdao = new ThanhToanDAO();
	//TEST TAO THANH TOÁN
	//TH1 Trống data
//	@Test
//	public void insertThanhToan_Null() {
//		String MaDK=""; 
//		String MaDP=""; 
//		String MaNV="";
//		String MaKH=""; 
//		float ThanhTien=0;
//		ttdao.insert(MaDK, MaDP, MaNV, MaKH, ThanhTien);
//	}
	//TH2 FullData
//		@Test
//		public void insertThanhToan_FullDATA() {
//			String MaDK=""; 
//			String MaDP="DP90"; 
//			String MaNV="NV02";
//			String MaKH="KH06"; 
//			float ThanhTien=600000;
//			ttdao.insert(MaDK, MaDP, MaNV, MaKH, ThanhTien);
//		}
	//TEST TÌM KIẾM THANH TOÁN
	
	//TH1: null mã
//	@Test
//		public void find_Null() {
//		String maTT = "";
//		tt = ttdao.selectPKTT(maTT);
//		Assert.assertTrue(tt!=null);
//	}
//	//TH2: có mã TT
//	@Test
//		public void find_PK() {
//			String maTT = "1";
//			tt = ttdao.selectPKTT(maTT);
//			Assert.assertTrue(tt!=null);
//			System.out.print("Tìm thấy hóa đơn thanh toán này");
//		}
}
