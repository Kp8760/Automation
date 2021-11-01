package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	public static String getExcellData (int row,int col) throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		String kp = "C:\\Users\\kp876\\Desktop\\Password.xlsx";
		
		FileInputStream File = new FileInputStream(kp);
		
		Sheet s = WorkbookFactory.create(File).getSheet("Credentials");
				
			String value =	s.getRow(row).getCell(col).getStringCellValue();
			
			File.close();
			return value;
	}
	
	public static void takeScreenshot(WebDriver driver,int testID)throws IOException {
		
		
		LocalDateTime d= LocalDateTime.now();
		System.out.println(d);
		String FileName = d.toString().replace(":", "").replace(" ", "") + ".jpg";
		
		  
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		File dest = new File ("C:\\Users\\kp876\\OneDrive\\Desktop\\New folder\\BankingProject-master\\BankingProject-master"+FileName+".jpg");
		FileHandler.copy(source, dest);
}
}
