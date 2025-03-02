package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File; 

public class ExcelReader {

	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	public XSSFSheet readExcelFile(String sheetName) throws IOException {

		String path = System.getProperty("user.dir") + "\\testdata\\TestData.xlsx";
		File file = new File(path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		return sheet;

	}


	public int getRowCount(XSSFSheet sheet) {

		return sheet.getLastRowNum();

	}

	public int getcolCount(XSSFSheet sheet) {

		XSSFRow row = sheet.getRow(0);
		return row.getLastCellNum();

	}
	
	public String getCellData(XSSFSheet sheet, int rowCount, int colCount) {
		
		for(int i=1; i<= rowCount; i++) {
			
		}
		String celldata = null;
		XSSFRow row = sheet.getRow(rowCount);
		XSSFCell cell = row.getCell(colCount);
		
		if(cell.getCellType() != CellType.BLANK) {
			if(cell.getCellType() == CellType.NUMERIC) {
				celldata = String.valueOf(cell.getNumericCellValue());
			}else if(cell.getCellType() == CellType.STRING) {
				celldata = cell.getStringCellValue();
			}
			
		}
		return celldata;
		
	}

}
