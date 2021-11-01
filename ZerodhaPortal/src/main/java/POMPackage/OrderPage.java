package POMPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage 
{
   @FindBy (xpath = "//span[text()='Dashboard']")
   private WebElement dashboard;
   
   @FindBy (xpath = "//span[text()='Orders']")
   private WebElement orders;
   
   @FindBy (xpath = "//span[text()='Holdings']")
   private WebElement holdings;
   
   @FindBy (xpath = "Positions - //span[text()='Positions']")
   private WebElement positions;
   
   @FindBy (xpath = "//span[text()='Funds']")
   private WebElement funds;
   
   @FindBy (xpath = "Apps - //span[text()='Apps']")
   private WebElement apps;
   
   @FindBy (xpath = "//span[@class='user-id']")
   private WebElement useracc;
   
   @FindBy (xpath = "//a[@target='_self']")
   private WebElement logout;

private WebDriver driver;

  
   
   public OrderPage (WebDriver driver)
   {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
   
   public String VerifyDashboardTab ()
   {
	   dashboard.click();
	   return driver.getCurrentUrl();
   }
   
   public String verifyKiteHomePageOrderslink() 
   {
	   orders.click();
	   return driver.getCurrentUrl();
   }
   
   public String VerifyHoldingTab()
   {
	   holdings.click();
	   return driver.getCurrentUrl();
   }
   
   public String VerifyPositionsTab()
   {
	   positions.click();
	   return driver.getCurrentUrl();
   }
   
   public String VerifyFundsTab()
   {
	   funds.click();
	   return driver.getCurrentUrl();
   }
   
   public String VerifyAppsTab()
   {
	   apps.click();
	   return driver.getCurrentUrl();
   }
   
   public String VerifyUserAccTab()
   {
	   useracc.click();
	   return driver.getCurrentUrl();
   }
   
   public void clickOnKiteHomePageLogout() throws InterruptedException
   {
		useracc.click();
		Thread.sleep(2000);
		By ele = By.xpath("//a[@target='_self']");
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		logout.click();		
   }

	public String verifyKiteHomePageDashboardlink()
	{
		dashboard.click();
		return driver.getCurrentUrl();
	}
}