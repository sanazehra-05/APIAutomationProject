package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "userData")
	public Object[][] getUserData() throws IOException {
		ExcelReader reader = new ExcelReader();
		XSSFSheet sheet = reader.readExcelFile("user");
		int rowCount = reader.getRowCount(sheet);
		int colCount = reader.getcolCount(sheet);
		Object[][] userData = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				userData[i - 1][j] = reader.getCellData(sheet, i, j);
			}
		}

		return userData;

	}

	@DataProvider(name = "userName")
	public Object[][] userName() throws IOException {
		ExcelReader reader = new ExcelReader();
		XSSFSheet sheet = reader.readExcelFile("user");
		int rowCount = reader.getRowCount(sheet);
		int colCount = reader.getcolCount(sheet);
		Object[][] userData = new Object[rowCount][1];
		int usernameCellNumber=0;

		for (int j = 0; j < colCount; j++) {
			String colName = reader.getCellData(sheet, 0, j);
			if (colName.equals("username")) {
				usernameCellNumber = j;
				break;
			}
		}

		for (int i = 1; i <= rowCount; i++) {
			userData[i-1][0] = reader.getCellData(sheet, i, usernameCellNumber);
		}

		return userData;

	}

}
