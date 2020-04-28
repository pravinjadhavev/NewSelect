package POM;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class UDAppPage extends TestBase{

	
	
	@FindBy(xpath="//label[contains(text(),'User-Defined')]//input")
	WebElement UDRselect;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img")
	WebElement logo;
	
	@FindBy(xpath="//p[contains(.,'Showing')]")
	WebElement countmsg;
	
	@FindBy(xpath="//b[contains(text(),'NEXT')]")
	WebElement next;
	
	@FindBy(xpath="//button[@class='btn active-btn linkCta']")
	WebElement manage;
	@FindBy(xpath="//li[contains(text(),'Create')]")
	WebElement create;
	
	@FindBy(xpath="//tr[2]//td[1]//a[1]//span[1]")
	WebElement edit;  

	@FindBy(xpath="//tr[2]//td[2]//a[1]//img[1]")
	WebElement copy;  
	
	@FindBy(xpath="//input[@id='PGsearch']")
	WebElement search;
	
	@FindBy(xpath="//img[@class='srchIcn']")
	WebElement searchclick;
	  
	public UDAppPage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
	public boolean pageheding()
	{
		Topscrol();
		System.out.println(UDRselect.isSelected());
		return UDRselect.isSelected();
	}
	
	public String Title()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
    {
 	   return logo.isDisplayed();
    }
	
	public String getCount()
	{
		scrol(countmsg);
	String	t=countmsg.getText();
	String number= t.replaceAll("[^0-9]", "");
	String cnt=number.substring(2);
	System.out.println(cnt);
		return cnt;
	}
	
	public void searchf(String str) throws InterruptedException
    {
		search.clear();
 	   search.sendKeys(str);
 	   try {
 		  searchclick.click();
	} catch (Exception e) {
		// TODO: handle exception
		jsclick(searchclick);
	}
 	  
 	   Thread.sleep(3000);
    }
	
	public boolean CheckAppname(String str) throws InterruptedException
    {
		try {
			WebElement Newapp=driver.findElement(By.xpath("//tr[2]//td[1]//div[1]//label"));
			String Appname=Newapp.getText();
			
			System.out.println(Appname);
			if(Appname.contains(str))
			{
				System.out.println("found" + str);
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(str+ " Not found in catch");
			return false;
		}
		
    }
	
	public CreateUserdefineAppPage Edit() throws InterruptedException
	{
		Thread.sleep(2000);
		edit.click();
		return new CreateUserdefineAppPage();
	}
	
	public CreateUserdefineAppPage gotocopy() throws InterruptedException
	{
		Thread.sleep(2000);
		copy.click();
		return new CreateUserdefineAppPage();
	}
	
	public CreateUserdefineAppPage gotoform() throws InterruptedException
	{
		Thread.sleep(2000);
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", manage);
		//manage.click();
		Thread.sleep(1000);
		 JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		  executor2.executeScript("arguments[0].click();", create);
		//create.click();
		return new CreateUserdefineAppPage();
	}
	
}
