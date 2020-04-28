package POM;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class AllAppPage extends TestBase{

	

	@FindBy(xpath="//input[@id='PGsearch']")
	WebElement search;
	
	@FindBy(xpath="//img[@class='srchIcn']")
	WebElement searchclick;
	
	@FindBy(xpath="//span[@class='titel']")
	WebElement Pagehead;
	
	@FindBy(xpath="//label[contains(text(),'All')]//input")
	WebElement Allselect;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img")
	WebElement logo;
	
	@FindBy(xpath="//p[contains(.,'Showing')]")
	WebElement countmsg;
	  
	public AllAppPage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
	public String pageheding()
	{
		System.out.println(Pagehead.getText());
		return Pagehead.getText();
	}
	
	public boolean pageheding2()
	{
		Topscrol();
		System.out.println(Allselect.isSelected());
		return Allselect.isSelected();
	}
	public String Title()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
    {
 	   return logo.isDisplayed();
    }
	
	public String getCount() throws InterruptedException
	{
		Thread.sleep(3000);
		scrol(countmsg);
	String	t=countmsg.getText();
	String number= t.replaceAll("[^0-9]", "");
	String cnt=number.substring(2);
	System.out.println(cnt);
		return cnt;
	}
	
	public int searchf(String str) throws InterruptedException
    {
		search.clear();
 	   search.sendKeys(str);
 	   searchclick.click();
 	   Thread.sleep(3000);
 		String res="//td[contains(.,'"+str+"')]";
 	List<WebElement> data = driver.findElements(By.xpath(res));
    Thread.sleep(5000);
 	System.out.println(data.size()+" search result count");
 	return data.size();
 	
    }
}
