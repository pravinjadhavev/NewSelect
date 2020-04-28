package POM;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class PoliciesPage extends TestBase{

	

	@FindBy(xpath="//input[@id='PGsearch']")
	WebElement search;
	
	@FindBy(xpath="//img[@class='srchIcn']")
	WebElement searchclick;
	
	
	@FindBy(xpath="//span[@class='titel']")
	WebElement Pagehead;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;

	  @FindBy(xpath="//span[contains(text(),'ind_single_1wan')]")
	     WebElement Tempname;
	  
	  
	  
	public PoliciesPage()
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
	
	public int searchf(String str) throws InterruptedException
    {
		search.clear();
 	   search.sendKeys(str);
 	   searchclick.click();
 	   Thread.sleep(3000);
 		String res="//td[contains(.,'"+str+"')]";
 	List<WebElement> data = driver.findElements(By.xpath(res));
 	System.out.println(data.size()+" search result count");
 	return data.size();
 	
    }
	
	public EditTemplatePage searchfortemp(String str) throws InterruptedException
    {
		Thread.sleep(5000);
		//"Rule-COS11"
		search.clear();
 	   	search.sendKeys(str);
 	   Thread.sleep(1000);
 	   	searchclick.click();
 	   	Thread.sleep(3000);
 	   	Tempname.click();
 	   	return new EditTemplatePage();
 	   
    }
}
