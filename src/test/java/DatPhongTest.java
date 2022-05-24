import org.junit.Test;

import dao.DatPhongDAO;
import entity.DatPhong;

public class DatPhongTest {
	DatPhong dp = new DatPhong();
	DatPhongDAO dpdao = new DatPhongDAO();
	//TEST INSERT
	//TH1:Trống 
//	@Test
//	public void checkAddRoom_NullData()
//			String MaDP=""; 
//			String ngayDat=""; 
//			String ngayTra="";
//			String maNV="";
//			String maPhong="";
//			String maKH="";
//			float tienCoc1=0;
//		dpdao.insert(MaDP, ngayDat, ngayTra, maNV, maPhong, maKH, tienCoc);
//	}
//			TH2: FULL DATA
//			@Test
//			public void checkAddRoom_FullData() {
//				String MaDP="DP90"; 
//				String ngayDat="7/4/2022"; 
//				String ngayTra="11/4/2022";
//				String maNV="NV02";
//				String maPhong="P80";
//				String maKH="KH06";
//				float tienCoc1=200000;
//				dpdao.insert(MaDP, ngayDat, ngayTra, maNV, maPhong, maKH, tienCoc1);
//	}
	//TEST UPDATE
//	TH1:Trống khóa chính
//	    @Test
//		public void checkUpdateRomm_NullPK() {
//	    	String maDP = "";	
//	    	dp = dpdao.selectID(maDP);
//	    	dpdao.update(null,null,2,null);
//	    }
		
//		//TH2:Có khóa chính
//	@Test
//	public void checkUpdateRoom_FullDT_PK() {
//		String maDP = "DP90";	
//    	dp = dpdao.selectID(maDP);
//    	dpdao.update("7/4/2022","11/4/2022",450000,maDP);
//	}
	//TEST DELETE
	    //TH1:Trống khóa chính
//	    @Test
//	    public void deleteRoom_NullPK() {
//	    	String maDP = "";
//	    	dp = dpdao.selectID(maDP);
//			dpdao.delete(maDP);
//	    }
//	}
		//TH2 : Có khóa chính
//			@Test
//			public void deleteRoom_PK() {
//			String maDP = "DP90";
//			dp = dpdao.selectID(maDP);
//			dpdao.delete(maDP);
//}
		//TEST LISTPHONGDADAT
//	@Test
//	public void checkListPhongDD() {
//		String MaDP="DP90"; 
//		String ngayDat="7/4/2022"; 
//		String ngayTra="11/4/2022";
//		String maNV="NV02";
//		String maPhong="P80";
//		String maKH="KH06";
//		float tienCoc1=200000;
//		dpdao.insert(MaDP, ngayDat, ngayTra, maNV, maPhong, maKH, tienCoc1);
//		System.out.print("Đã thay đổi trạng thái thành phòng đã đặt trước");
//	}
	//TEST NHẬN PHÒNG_LISTPHONGDANGTHUE
//	@Test
//	public void checkNP_ListPhongDT() {
//		String maP="P80";
//		dpdao.updateTT(maP, 0);
//		System.out.print("Nhận phòng thành công!Đã thay đổi trạng thái từ phòng đã đặt sang đang thuê");
//	}
	//TEST TRẢ PHÒNG-->ListPHONGTRONG()
//	@Test
//	public void checkTP_ListPhongTrong() {
//		String maP="P80";
//		dpdao.updateTT(maP, 1);
//		System.out.print("Trả phòng thành công!Đã thay đổi trạng thái từ phòng đang thuê sang phòng trống");
//	}
}
