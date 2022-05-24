package test;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class phong {
	public String maPhong, tenPhong,  loaiPhong,  tinhTrang,giaPhong, maNV;
	public int row;
	
	public phong() {
		
	}
public phong(XSSFCell mPhong,XSSFCell tPhong,XSSFCell  loPhong,XSSFCell  tTrang,XSSFCell gphong,XSSFCell mNV,int row) {
    	//mã phòng
		CellType cellType = mPhong.getCellType();
		switch (cellType) {
		case NUMERIC:
			long i = (long) Double.parseDouble( mPhong.toString());
			this.maPhong = Long.toString(i);
			break;
		case STRING:
			this.maPhong =  mPhong.getStringCellValue();
			break;
		}
		//  tên phòng
		CellType cellType1 = tPhong.getCellType();
		switch (cellType1) {
		case NUMERIC:
			long i = (long) Double.parseDouble(tPhong.toString());
			this.tenPhong = Long.toString(i);
			break;
		case STRING:
			this.tenPhong = tPhong.toString();
			break;
		}
		// loại phòng
		CellType cellType2 = loPhong.getCellType();
		switch (cellType1) {
		case NUMERIC:
			long i = (long) Double.parseDouble(loPhong.toString());
			this.loaiPhong = Long.toString(i);
			break;
		case STRING:
			this.loaiPhong = loPhong.toString();
			break;
		}
	//  tình trạng
			CellType cellType3 = tTrang.getCellType();
			switch (cellType1) {
			case NUMERIC:
				long i = (long) Double.parseDouble(tTrang.toString());
				this.tinhTrang = Long.toString(i);
				break;
			case STRING:
				this.tinhTrang = tTrang.toString();
				break;
			}
		// giá phòng
		CellType cellType4 = gphong.getCellType();
		switch (cellType1) {
		case NUMERIC:
			long i = (long) Double.parseDouble(gphong.toString());
			this.giaPhong = Long.toString(i);
			break;
		case STRING:
			this.giaPhong = gphong.toString();
			break;
		}
		// mã nv
		CellType cellType5 = mNV.getCellType();
		switch (cellType1) {
		case NUMERIC:
			long i = (long) Double.parseDouble(mNV.toString());
			this.maPhong = Long.toString(i);
			break;
		case STRING:
			this.maPhong = mNV.toString();
			break;
		}
		// 
		this.row = row;
	}
}
