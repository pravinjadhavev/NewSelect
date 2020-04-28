package POM;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class SitelistPage extends TestBase{

	
	
	@FindBy(xpath="//input[@id='PGsearch']")
	WebElement search;
	
	@FindBy(xpath="//img[@class='srchIcn']")
	WebElement searchclick;
	
	
	
	@FindBy(xpath="//li[contains(text(),'Degraded')]")
	WebElement Pagehead;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;
	
	  @FindBy(xpath="//span[contains(text(),'ADMIN')]")
	     WebElement Admin;

	  @FindBy(xpath="//p[contains(.,'Showing')]")
		WebElement countmsg;

	  @FindBy(xpath="//li[contains(text(),'Online')]")
		WebElement onlinecnt;
	  @FindBy(xpath="//li[contains(text(),'Offline')]")
		WebElement offlinecnt;
	  @FindBy(xpath="//li[contains(text(),'Degraded')]")
		WebElement degcnt;
	  
	  @FindBy(xpath="//tr[2]//td[1]//a[1]//span[1]")
		WebElement Editrow;
	  @FindBy(xpath="//div[@class='scrolHorizontal']//tr[2]//td[1]//div[1]//span[1]")
		WebElement Editalias;
	  
	  @FindBy(xpath="//tr[2]//td[1]//span[@id='openedAlias']")
		WebElement doneali;
	  
	  @FindBy(xpath="//div[@class='scrolHorizontal']//tr[2]//td[1]//div[1]//input[1]")
		WebElement enteralias;
	  
	  @FindBy(xpath="//tr[2]//td[1]//div[1]//span[2]")
		WebElement Editalbtn;
	  
	  @FindBy(xpath="//button[contains(text(),'View CPEs')]")
		WebElement cpe;
	  @FindBy(xpath="//button[contains(text(),'View Templates')]")
		WebElement temp;
//	  @FindBy(xpath="//tr[4]//td[1]//div[1]//label[1]//span[1]")
//		WebElement select;	

		public CPEsPage gotocpe()
		{
			cpe.click();
			return new CPEsPage();
		}
		public CPEsPage gotocpe(String n) throws InterruptedException
		{
			String xp="//label[contains(text(),'"+n+"')]//span";
			Thread.sleep(2000);
			driver.findElement(By.xpath(xp)).click();
			Thread.sleep(2000);
			cpe.click();
			return new CPEsPage();
		}
		public TemplatePage gototemp() throws InterruptedException
		{ Thread.sleep(3000);
			//temp.click();
			jsclick(temp);
			return new TemplatePage();
		}
		public TemplatePage gototemp(String n) throws InterruptedException
		{
			String xp="//label[contains(text(),'"+n+"')]//span";
			Thread.sleep(2000);
			driver.findElement(By.xpath(xp)).click();
			Thread.sleep(2000);
			temp.click();
			return new TemplatePage();
		}
	  
	public SitelistPage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
	public EditCPEsPage clickeditrow()
	{
		Editrow.click();
		return new EditCPEsPage();
	}
	
	public boolean changealias(String Name) throws InterruptedException
	{
		
		//Editalbtn.click();
		Editalias.click();
		enteralias.clear();
		enteralias.sendKeys(Name);
		doneali.click();
		//Thread.sleep(1000);
		//enteralias.sendKeys(Keys.TAB);
		//Thread.sleep(2000);
		System.out.println(enteralias.getAttribute("value"));
		if(enteralias.getAttribute("value").equalsIgnoreCase(Name))
		{
			System.out.println("alis change");
			return true;
		}
		else
		{
			System.out.println("alis Not change");
			return false;
		}
	}
	
	public String getalisname()
	{
		//System.out.println(enteralias.getAttribute("value") + "alise from row edit");
		return enteralias.getAttribute("value");
	}
	
	public String pageheding()
	{
		//System.out.println(Pagehead.getText());
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
 	   String res="//span[@class='"+str+" slitesDots']";
 	List<WebElement> data = driver.findElements(By.xpath(res));
 	System.out.println(data.size()+" search result count");
 	return data.size();
    }
	
	public int searchdata(String str) throws InterruptedException
    {
		search.clear();
 	   search.sendKeys(str);
 	   searchclick.click();
 	   Thread.sleep(3000);
 	   String res="//td[contains(text(),'"+str+"')]";
 	List<WebElement> data = driver.findElements(By.xpath(res));
 	System.out.println(data.size()+" search result count");
 	return data.size();
    }
	
	
	public String getCount(int state) throws InterruptedException
	{
		//Thread.sleep(5000);
		String t=null;
		switch (state) {
		case 1:	t=onlinecnt.getText();
		System.out.println("from get cnt for online "+onlinecnt.getText());
			break;
		case 2:t=offlinecnt.getText();
		System.out.println("from get cnt for offline "+offlinecnt.getText());
			break;
		case 3:t=degcnt.getText();
		System.out.println("from get cnt for Deg "+degcnt.getText());
		break;
		}
	String cnt= t.replaceAll("[^0-9]", "");
	System.out.println(cnt);
		return cnt;
	}
}
