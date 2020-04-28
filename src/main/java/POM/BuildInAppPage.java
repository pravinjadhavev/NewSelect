package POM;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class BuildInAppPage extends TestBase{

	
	
	@FindBy(xpath="//label[contains(text(),'Built-In')]//input")
	WebElement Bselect;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;
	
	  @FindBy(xpath="//p[contains(.,'Showing')]")
		WebElement countmsg;
	  
	  @FindBy(xpath="//label[contains(text(),'All')]")
		WebElement All;
	  
	  
	  
	public BuildInAppPage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
	public boolean pageheding()
	{
		Topscrol();
		System.out.println(Bselect.isSelected());
		return Bselect.isSelected();
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
	
	public void allclick()
	{
		All.click();
	}
}
