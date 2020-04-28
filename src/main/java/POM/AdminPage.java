package POM;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class AdminPage extends TestBase{

	
	
	@FindBy(xpath="//h2[contains(text(),'Internal StakeHolder')]")
	WebElement Pagehead;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;
	
	  
	public AdminPage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
	public String pageheding()
	{
		System.out.println(Pagehead.getText());
		return Pagehead.getText();
	}
	
	public String Title()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
    {
 	   return logo.isDisplayed();
    }
}
