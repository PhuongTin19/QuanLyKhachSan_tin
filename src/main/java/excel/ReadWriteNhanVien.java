package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import test.nhanvien;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteNhanVien {
	public static List<nhanvien> ReadFileExcell(String file) {
		List<nhanvien> list = new ArrayList<nhanvien>();
		try {
			File src = new File(file);
			// Lay file excel
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// Chọn Sheet
			XSSFSheet sh1 = wb.getSheetAt(0);
			int dem = 0;
			while(true) {
				if(sh1.getRow(dem) == null) {
					break;
				}
				dem++;
			}
			for (int i = 1; i < dem; i++) {
				if (sh1.getRow(i).getCell(0).getStringCellValue() == "") {
					break ;
				}
				
				nhanvien u = new nhanvien(sh1.getRow(i).getCell(0),sh1.getRow(i).getCell(1),sh1.getRow(i).getCell(2),sh1.getRow(i).getCell(3),sh1.getRow(i).getCell(4),sh1.getRow(i).getCell(5),sh1.getRow(i).getCell(6),sh1.getRow(i).getCell(7),sh1.getRow(i).getCell(8),i);
				list.add(u);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	//ghi 
	public static void Update(String file,String kq ,int row1) {
		try {
			File src = new File(file);
			// Lay file excel
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// Chọn Sheet
			Sheet sheet = wb.getSheetAt(0);
			// Chọn hang
			Row row = sheet.getRow(row1);
			// Tao moi o tinh
			Cell cell = row.createCell(9);
			XSSFCellStyle centerStyle = wb.createCellStyle();
			centerStyle.setAlignment(HorizontalAlignment.CENTER);
			centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			centerStyle.setBorderBottom(BorderStyle.DOTTED);
			centerStyle.setBottomBorderColor(IndexedColors.RED.getIndex());

			centerStyle.setBorderLeft(BorderStyle.DOTTED);
			centerStyle.setLeftBorderColor(IndexedColors.RED.getIndex());

			centerStyle.setBorderRight(BorderStyle.DOTTED);
			centerStyle.setRightBorderColor(IndexedColors.RED.getIndex());

			centerStyle.setBorderTop(BorderStyle.DOTTED);
			centerStyle.setTopBorderColor(IndexedColors.RED.getIndex());

			cell.setCellStyle(centerStyle);
			// Nhap gia tri vao o tinh
			cell.setCellValue(kq);
			OutputStream os = new FileOutputStream(src);
			wb.write(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Cập nhật
		public static void Update2(String file,String kq ,int row1) {
			try {
				File src = new File(file);
				// Lay file excel
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				// Chọn Sheet
				Sheet sheet = wb.getSheetAt(0);
				// Chọn hang
				Row row = sheet.getRow(row1);
				// Tao moi o tinh
				Cell cell = row.createCell(2);
				XSSFCellStyle centerStyle = wb.createCellStyle();
				centerStyle.setAlignment(HorizontalAlignment.CENTER);
				centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
				centerStyle.setBorderBottom(BorderStyle.DOTTED);
				centerStyle.setBottomBorderColor(IndexedColors.RED.getIndex());

				centerStyle.setBorderLeft(BorderStyle.DOTTED);
				centerStyle.setLeftBorderColor(IndexedColors.RED.getIndex());

				centerStyle.setBorderRight(BorderStyle.DOTTED);
				centerStyle.setRightBorderColor(IndexedColors.RED.getIndex());

				centerStyle.setBorderTop(BorderStyle.DOTTED);
				centerStyle.setTopBorderColor(IndexedColors.RED.getIndex());

				cell.setCellStyle(centerStyle);
				// Nhap gia tri vao o tinh
				cell.setCellValue(kq);
				OutputStream os = new FileOutputStream(src);
				wb.write(os);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Xóa
		public static void Update3(String file,String kq ,int row1) {
			try {
				File src = new File(file);
				// Lay file excel
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				// Chọn Sheet
				Sheet sheet = wb.getSheetAt(0);
				// Chọn hang
				Row row = sheet.getRow(row1);
				// Tao moi o tinh
				Cell cell = row.createCell(1);
				XSSFCellStyle centerStyle = wb.createCellStyle();
				centerStyle.setAlignment(HorizontalAlignment.CENTER);
				centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
				centerStyle.setBorderBottom(BorderStyle.DOTTED);
				centerStyle.setBottomBorderColor(IndexedColors.RED.getIndex());

				centerStyle.setBorderLeft(BorderStyle.DOTTED);
				centerStyle.setLeftBorderColor(IndexedColors.RED.getIndex());

				centerStyle.setBorderRight(BorderStyle.DOTTED);
				centerStyle.setRightBorderColor(IndexedColors.RED.getIndex());

				centerStyle.setBorderTop(BorderStyle.DOTTED);
				centerStyle.setTopBorderColor(IndexedColors.RED.getIndex());

				cell.setCellStyle(centerStyle);
				// Nhap gia tri vao o tinh
				cell.setCellValue(kq);
				OutputStream os = new FileOutputStream(src);
				wb.write(os);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
