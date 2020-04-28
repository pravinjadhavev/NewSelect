package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class EditCPEsPage extends TestBase {
	
	@FindBy(xpath="//input[@id='siteName']")
	WebElement inputal;
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement yes;
	
	public EditCPEsPage()
    {
  	   PageFactory.initElements(driver, this);
     }

	public SitelistPage filldata(String name) throws InterruptedException
	{
		System.out.println("clicking");
		try {
			inputal.click();
		} catch (Exception e) {
			// TODO: handle exception
			jsclick(inputal);
		}
		
		
		System.out.println("clicked");
		inputal.clear();
		Thread.sleep(2000);
		inputal.sendKeys(name);
		Thread.sleep(2000);
		System.out.println("fill name");
		//inputal.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		//Topscrol();
		save.click();
		Thread.sleep(2000);
		yes.click();
		return new SitelistPage();
	}
	
}
