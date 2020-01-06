package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis=null;
	public FileInputStream getFileInputStream()
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx";
		File srcFile=new File(filePath);
		try {
			fis =new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. terminating Process !! check file path of TestData ");
			System.exit(0);
		}
		return fis;
	}
	public Object [][]getExcelData() throws IOException
	{
		fis=getFileInputStream();
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int TotalNumberofRows=(sheet.getLastRowNum()+1);
		int TotalNumberofCols=4;
		
		String [][] arrayExcelData=new String [TotalNumberofRows][TotalNumberofCols];
		
		for (int i = 0; i < TotalNumberofRows; i++) 
		{
			
			for (int j = 0; j <TotalNumberofCols; j++)
			{
				XSSFRow row=sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
				
			}
			
		}
		wb.close();
		return arrayExcelData;
		
	}

}
