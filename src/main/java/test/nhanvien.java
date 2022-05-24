package test;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
public class nhanvien {
	public String maNV;
	public String hoTen;
	public String ngaySinh;
	public String gioiTinh;
	public String CCCD;
	public String diaChi;
	public String email;
	public String sodienThoai;
	public String chucVu;
	public int row;

	public nhanvien() {

	}

	public nhanvien(XSSFCell MaNV, XSSFCell HoTen, XSSFCell NgaySinh, XSSFCell GioiTinh, XSSFCell CanCuoc, XSSFCell DiaChi,
			XSSFCell Email, XSSFCell SDT, XSSFCell ChucVu, int row) {

		CellType cellType = MaNV.getCellType();
		switch (cellType) {

		case NUMERIC:
			long i = (long) Double.parseDouble(MaNV.toString());
			this.maNV = Long.toString(i);
			break;
		case STRING:
			this.maNV = MaNV.getStringCellValue();
			break;
		}

//		CellType cellType1 = HoTen.getCellType();
//		switch (cellType1) {
//		case NUMERIC:
//			long i = (long) Double.parseDouble(HoTen.toString());
//			this.hoTen = Long.toString(i);
//			break;
//		case STRING:
//			this.hoTen = HoTen.toString();
//			break;
//		}

//		CellType cellType2 = NgaySinh.getCellType();
//		switch (cellType2) {
////		case NUMERIC:
////			long i = (long) Double.parseDouble(NgaySinh.toString());
////			this.ngaySinh = Long.toString(i);
////			break;
//		case STRING:
//			this.ngaySinh = NgaySinh.toString();
//			break;
//		}
//		CellType cellType3 = GioiTinh.getCellType();
//		switch (cellType3) {
//		case NUMERIC:
//			long i = (long) Double.parseDouble(GioiTinh.toString());
//			this.gioiTinh = Long.toString(i);
//			break;
//		case STRING:
//			this.gioiTinh = GioiTinh.toString();
//			break;
//		}

	
	
//
//		CellType cellType4 = CanCuoc.getCellType();
//		switch (cellType4) {
//		case NUMERIC:
//			long i = (long) Double.parseDouble(CanCuoc.toString());
//			this.CCCD = Long.toString(i);
//			break;
//		case STRING:
//			this.CCCD = CanCuoc.toString();
//			break;
//		}
//		CellType cellType5 = DiaChi.getCellType();
//		switch (cellType5) {
//		case NUMERIC:
//			long i = (long) Double.parseDouble(DiaChi.toString());
//			this.diaChi = Long.toString(i);
//			break;
//		case STRING:
//			this.diaChi = DiaChi.toString();
//			break;
//		}
//		CellType cellType6 = Email.getCellType();
//		switch (cellType6) {
//		case NUMERIC:
//			long i = (long) Double.parseDouble(DiaChi.toString());
//			this.email = Long.toString(i);
//			break;
//		case STRING:
//			this.email = Email.toString();
//			break;
//		}
//		CellType cellType7 = SDT.getCellType();
//		switch (cellType7) {
//		case NUMERIC:
//			long i = (long) Double.parseDouble(SDT.toString());
//			this.sodienThoai = Long.toString(i);
//			break;
//		case STRING:
//			this.sodienThoai = SDT.toString();
//			break;
//		}

//		CellType cellType8 = ChucVu.getCellType();
//		switch (cellType8) {
//		case NUMERIC:
//			long i = (long) Double.parseDouble(ChucVu.toString());
//			this.chucVu = Long.toString(i);
//			break;
//		case STRING:
//			this.chucVu = ChucVu.toString();
//			break;
//		}
		
		
		
		this.row = row;
	}
}
