package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceNowReadExcel {

	public static String[][] runServiceNowReadExcel () throws IOException {
	
		
		XSSFWorkbook wBook = new XSSFWorkbook("./Data/ServiceNowINCExcel.xlsx");
		XSSFSheet wSheet = wBook.getSheetAt(0);
		int rowCount = wSheet.getLastRowNum();
		short columnCount = wSheet.getRow(0).getLastCellNum();
		String[][] details = new String[rowCount][columnCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<columnCount;j++) {
				String cellValue = wSheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellValue+" ");
				details[i-1][j]=cellValue;
			}System.out.println();
		}
		
		wBook.close();
		return details;
			
	}
	
}
