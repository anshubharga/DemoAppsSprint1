package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String fetchDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("E:\\Selenium\\Selenium\\TestData\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}
	public String fetchDataFromExcelSheet(String sheetName, int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("E:\\Selenium\\Selenium\\TestData\\TestData.xlsx");
	//	return WorkbookFactory.create(fis).getSheet(sheetName).getCell(cellNo).getStringCellValue
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	public double fetchNumericDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("E:\\Selenium\\Selenium\\TestData\\TestData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
}
