package testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] readData(String sheetName){
		FileInputStream file = null;
		//Read from Excel File
		try {
			file = new FileInputStream("D:\\Installed\\Softwares\\Workspaces\\LiveProject\\src\\main\\java\\testdata\\details.xlsx");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
		
		try {
			book = WorkbookFactory.create(file);
			
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
