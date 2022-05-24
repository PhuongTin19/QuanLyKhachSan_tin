import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import dao.KhachHangDAO;
import entity.KhachHang;
import utils.XDate;

public class KhachHangTest {
	KhachHangDAO dao=new KhachHangDAO();
	//Tìm kiếm khachhang
//		@Test
//		public void find() {
//			String maKH = "KH02";
//			KhachHang user = dao.selectID(maKH);
//			assertTrue(user != null);
//		}
	//Thêm khách hàng
//		@Test
//		public void addKhachHang() {
//			String maNV = "KH09";
//			String hoTen = "Nguyễn Văn Tài";
//			Date ngaySinh = XDate.toDate("19/06/2002", "dd/MM/yyyy");
//			boolean gioiTinh = true;
//			String cccd = "079109092191";
//			String diaChi = "Quận Bình Tân,TP.Hồ Chí Minh";
//			String email = "tin63712@gmail.com";
//			String SDT = "0901129085";
//		
//			dao.insert(maNV, hoTen, XDate.toString(ngaySinh), gioiTinh, cccd, diaChi, email, SDT);
//		}
//		
//		//Cập nhật khách hàng
//			@Test
//			public void updateKhachHang() {
//				String maKH = "KH09";
//				String hoTen = "Nguyễn Văn Tài";
//				Date ngaySinh = XDate.toDate("19/06/2002", "dd/MM/yyyy");
//				boolean gioiTinh = true;
//				String cccd = "079109092197";
//				String diaChi = "Quận Bình Tân,SG";
//				String email = "tin63712@gmail.com";
//				String SDT = "0901129084";
//				dao.update(maKH, hoTen, XDate.toString(ngaySinh), gioiTinh, cccd, diaChi, email, SDT);
//			}
//		//Xóa khách hàng
//		@Test
//		public void deleteKhachHang() {
//			String maKH = "KH09";
//			dao.delete(maKH);
//		}
}
