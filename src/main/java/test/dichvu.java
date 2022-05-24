package test;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class dichvu {
	public String maDV;	
    public String tenDV;
    public String gia;
    public int row;
    
	public dichvu() {

	}
    
    public dichvu(XSSFCell ma, XSSFCell ten, XSSFCell giaDV,int row) {
    	
    	
		CellType cellType = ma.getCellType();
		switch (cellType) {
		
		case NUMERIC:
			long i = (long) Double.parseDouble(ma.toString());
			this.maDV = Long.toString(i);
			break;
		case STRING:
			this.maDV = ma.getStringCellValue();
			break;
		}
		
		
		
		
		
		
		CellType cellType1 = ten.getCellType();
		switch (cellType1) {
		case NUMERIC:
			long i = (long) Double.parseDouble(tenDV.toString());
			this.tenDV = Long.toString(i);
			break;
		case STRING:
			this.tenDV = ten.toString();
			break;
		}
		
		
		
		
		
		CellType cellType2 = giaDV.getCellType();
		switch (cellType2) {
		case NUMERIC:
			long i = (long)  Double.parseDouble(gia.toString());
			this.gia = Long.toString(i);
			break;
		case STRING:
			this.gia = giaDV.toString();
			break;
		}

		
		this.row = row;
	}
	
}
