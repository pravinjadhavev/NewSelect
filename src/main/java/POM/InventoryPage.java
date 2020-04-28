package POM;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class InventoryPage extends TestBase{

	
	
	@FindBy(xpath="//h2[contains(text(),'View & Manage your Inventory')]")
	WebElement Pagehead;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;
	

	  @FindBy(xpath="//span[contains(text(),'INVENTORY')]")
	     WebElement Inventory;
	
	  
	public InventoryPage()
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
