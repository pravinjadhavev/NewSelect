package POM;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BASE.TestBase;

public class polQosPage extends TestBase{

	
	
	@FindBy(xpath="//label[contains(text(),'QoS')]//input")
	WebElement Qselect;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img")
	WebElement logo;
	
	@FindBy(xpath="//p[contains(.,'Showing')]")
	WebElement countmsg;
	
	@FindBy(xpath="//b[contains(text(),'NEXT')]")
	WebElement next;
	
	
	  
	public polQosPage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
	public boolean pageheding()
	{
		Topscrol();
		System.out.println(Qselect.isSelected());
		return Qselect.isSelected();
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
	
	
}
