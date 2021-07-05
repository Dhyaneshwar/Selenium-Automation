package core.home.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static FileInputStream ExcelInputStreamFile;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	static DataFormatter formatter;

	public static Object[][] loadExcel(String FilePath, String SheetName) throws Exception {

		File file = new File(FilePath);
		ExcelInputStreamFile = new FileInputStream(file);
		ExcelWBook = new XSSFWorkbook(ExcelInputStreamFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		ExcelWBook.close();

		formatter = new DataFormatter();
		int lastRowNum = ExcelWSheet.getLastRowNum();
		int lastCellNum = ExcelWSheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRowNum][1];
		
		for (int i = 0; i < lastRowNum; i++) {
			Map<String, String> datamap = new HashMap<String, String>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put(formatter.formatCellValue(ExcelWSheet.getRow(0).getCell(j)),
						formatter.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j)));
			}
			obj[i][0] = datamap;
		}
		return obj;
	}
}
