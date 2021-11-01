package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPag 

{
	
	@FindBy (xpath = "//input[@id='userid']")
	private WebElement user;
	
	@FindBy (xpath = "//input[@id='password']")
	private WebElement Password;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement SignIn;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement pin;
	
	@FindBy (xpath = "//button[@class='button-orange wide']")
	private WebElement Continue;
	
	
	public LoginPag  (WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	
	public  void LogInPage()
	{
		user.sendKeys("CRX063");
		Password.sendKeys("Kp@87604561");
		SignIn.click();
		pin.sendKeys("456123");
		Continue.click();
	}
}
