package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BASE.TestBase;

public class TemplatePage extends TestBase{


	@FindBy(xpath="//span[contains(text(),'TEMPLATES')]")
	WebElement Pagehead;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;
	
		
		@FindBy(xpath="//input[@id='PGsearch']")
		WebElement search;
		
		@FindBy(xpath="//img[@class='srchIcn']")
		WebElement searchclick;
		
		@FindBy(xpath="//tr[2]//td[1]//a[1]//span[1]")
		WebElement Editsearchtemp;
	  
		@FindBy(xpath="//div[@id='loading']")
		WebElement lod;
	
		  @FindBy(xpath="//span[contains(text(),'SHOW ALL')]")
				WebElement Showall;
		  
		
		
	public TemplatePage()
    {
 	   PageFactory.initElements(driver, this);
    }
	
	
	public EditTemplatePage searchf(String str) throws InterruptedException
    {
		System.out.println("in seach temp method");
		//WebDriverWait wt=new WebDriverWait(driver, 80);
		//wt.until(ExpectedConditions.visibilityOf(Editsearchtemp));
		Thread.sleep(10000);
		search.clear();
 	   search.sendKeys(str);
 	   searchclick.click();
 	   Thread.sleep(1000);
 	  Editsearchtemp.click();
 	 //Thread.sleep(1000);
 	 return new EditTemplatePage();
    }
	public String pageheding()
	{
		System.out.println(Pagehead.getText());
		return Pagehead.getText();
	}
	
	public String pageheding2(String n)
	{
		String xp="//span[contains(text(),'"+n+"')]";
		return driver.findElement(By.xpath(xp)).getText();
	}
	public String showall()
	{
		String str=Showall.getAttribute("class");
		System.out.println(str);
		if(str.contains("diabled"))
		{
			return "disable";
		}
		else
		{
			Showall.click();
			return "enable";			
		}
	}
}
