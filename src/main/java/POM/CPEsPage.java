package POM;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class CPEsPage extends TestBase{

	
	@FindBy(xpath="//input[@id='PGsearch']")
	WebElement search;
	
	@FindBy(xpath="//img[@class='srchIcn']")
	WebElement searchclick;
	
	
	@FindBy(xpath="//span[contains(text(),'CPEs')]")
	WebElement Pagehead;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;
	
	  @FindBy(xpath="//li[contains(text(),'Online')]")
		WebElement onlinecnt;
	  @FindBy(xpath="//li[contains(text(),'Offline')]")
		WebElement offlinecnt;

	  // Edit
	  @FindBy(xpath="//tr[2]//td[1]//a[1]//span[1]")
		WebElement Editrow;
	  @FindBy(xpath="//div[@class='scrolHorizontal']//tr[2]//td[1]//div[1]//span[1]")
		WebElement Editalias;
	  @FindBy(xpath="//div[@class='scrolHorizontal']//tr[2]//td[1]//div[1]//input[1]")
		WebElement enteralias;
	  
	  @FindBy(xpath="//tr[2]//td[1]//span[@id='openedAlias']")
		WebElement doneali;
	 
	  @FindBy(xpath="//button[contains(text(),'View Templates')]")
		WebElement temp;
	  
	  @FindBy(xpath="//span[contains(text(),'SHOW ALL')]")
			WebElement Showall;
	  
	public CPEsPage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
	public EditCPage clickeditrow()
	{
		Editrow.click();
		return new EditCPage();
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
		return enteralias.getAttribute("value");
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
	
	public TemplatePage gototemp()
	{
		temp.click();
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
	
	
	
	public String Title()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
    {
 	   return logo.isDisplayed();
    }
//	"//td[contains(.,'QoS')]"
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
	
	
	public String getCount(int state) throws InterruptedException
	{
		Thread.sleep(5000);
		String t=null;
		switch (state) {
		case 1:	t=onlinecnt.getText();
		System.out.println("from get cnt for online "+onlinecnt.getText());
			break;
		case 2:t=offlinecnt.getText();
		System.out.println("from get cnt for offline "+offlinecnt.getText());
			break;
		}
	String cnt= t.replaceAll("[^0-9]", "");
	System.out.println(cnt);
		return cnt;
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

}
