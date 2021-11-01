package TestPack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameters;

import BasePack.BaseClass;
import POMPackage.LoginPag;
import POMPackage.OrderPage;
import TestUtils.Utility;


public class VerifyLoginFunctionallity extends BaseClass
{
  private WebDriver driver;
  private LoginPag loginpage;
  private OrderPage orderpage;
  int TestID;
  static ExtentTest test;
  static ExtentHtmlReporter reporter;
	
  @BeforeTest
  @org.testng.annotations.Parameters ("Browser")
  public void launchBrowser(String browser) throws Exception 
  {
	  ((BaseClass) driver). openChromeBrowser();
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");
  }
  public void beforeTest(String Browser) throws InterruptedException
  {
	  if(Browser.equalsIgnoreCase("chrome"))
	  {
		  driver = openChromeBrowser();
	  }
	  if(Browser.equalsIgnoreCase("firefox"))
	  {
		  driver = openFirefoxBrowser();
	  }
	  Thread.sleep(3000);
  }
  
  @BeforeClass
	public void createObject() {
		System.out.println("Before Class");
		loginpage = new LoginPag (driver);
		orderpage = new OrderPage(driver);
	}

	@BeforeMethod
	public void loginToUserAccount() {
		System.out.println("Before Method");
		driver.get("https://kite.zerodha.com/");
		loginpage.LogInPage();
		
	}
  
	@Test
	public void verifydashboard() {
		TestID = 100;
		System.out.println("Test");
		String link = orderpage.verifyKiteHomePageDashboardlink();
		if(link.equals("https://kite.zerodha.com/dashboard"))
		{
			System.out.println("Dashboard link is "+link);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@Test
	public void verifyorder() {
		TestID = 200;
		System.out.println("Test");
		String link = orderpage.verifyKiteHomePageOrderslink();
		if(link.equals("https://kite.zerodha.com/orders"))
		{
			System.out.println("Dashboard link is "+link);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@AfterMethod
	public void logoutAccount(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshot(driver, TestID);
		}
		Thread.sleep(10000);
		System.out.println("After Method");
		orderpage.clickOnKiteHomePageLogout();
		
	}
	
	@AfterClass
	public void clearObjects() {
		System.out.println("After Class");
		orderpage = null;
		loginpage = null;
		
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("After Test");
		driver.quit();
		driver = null;
		System.gc();
	}


  }
  
  
  

