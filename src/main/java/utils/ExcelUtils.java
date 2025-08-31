package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static void setUpExcel(String filePath, String sheetName) throws IOException , FileNotFoundException{
		FileInputStream fis = new FileInputStream(filePath);
		w = new XSSFWorkbook(fis);
		s = w.getSheet(sheetName);
		
	}
	
	public static String getCellData(int row, int col) {
		String data = s.getRow(row).getCell(col).toString();
		return data;
	}
	
	public static int getRowCount() {
		int count = s.getPhysicalNumberOfRows();
		return count;
	}
	
}
