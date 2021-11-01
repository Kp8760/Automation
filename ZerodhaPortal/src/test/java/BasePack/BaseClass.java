package BasePack;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kp876\\OneDrive\\Desktop\\New folder\\New folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","src" + File.separator + "test" + File.separator + "resources" + File.separator + "browsers" + File.separator + "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
