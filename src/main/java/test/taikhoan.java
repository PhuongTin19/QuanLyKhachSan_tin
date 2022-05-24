package test;

import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class taikhoan {
	public String tentaiKhoan;	
    public String matKhau;	
    public String chucVu;	
    public String maNV;
    public int row;
    
    public taikhoan() {
    	
    }
    
    public taikhoan(XSSFCell tk, XSSFCell mk, XSSFCell cv,XSSFCell manv,int row) {
    	
    	
		CellType cellType = tk.getCellType();
		switch (cellType) {
		
		case NUMERIC:
			long i = (long) Double.parseDouble(tk.toString());
			this.tentaiKhoan = Long.toString(i);
			break;
		case STRING:
			this.tentaiKhoan = tk.getStringCellValue();
			break;
		}
		
		
		
		
		
		
		CellType cellType1 = mk.getCellType();
		switch (cellType1) {
		case NUMERIC:
			long i = (long) Double.parseDouble(mk.toString());
			this.matKhau = Long.toString(i);
			break;
		case STRING:
			this.matKhau = mk.toString();
			break;
		}
		
		
		
		
		
		CellType cellType2 = cv.getCellType();
		switch (cellType2) {
		case NUMERIC:
			long i = (long) Double.parseDouble(cv.toString());
			this.chucVu = Long.toString(i);
			break;
		case STRING:
			this.chucVu = cv.toString();
			break;
		}
		
		
		
		
		
		CellType cellType3 = manv.getCellType();
		switch (cellType3) {
		case NUMERIC:
			long i = (long) Double.parseDouble(manv.toString());
			this.maNV = Long.toString(i);
			break;
		case STRING:
			this.maNV = manv.toString();
			break;
		}
		
		
		this.row = row;
	}
	
}
