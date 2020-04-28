package POM;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BASE.TestBase;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath="//h2[contains(text(),'Dashboard')]")
	WebElement Pagehead;
	
	  @FindBy(xpath="//a[@class='navbar-brand']//img")
	     WebElement logo;
	
	  @FindBy(xpath="//li[@class='headCta nav-item login-link']")
	     WebElement logout;
	  @FindBy(xpath="//span[@class='Logout closeIt']")
	     WebElement signout;
	
	  @FindBy(xpath="//span[contains(text(),'MY DASHBOARD')]")
	     WebElement Dashboard;

	  @FindBy(xpath="//span[contains(text(),'ADMIN')]")
	     WebElement Admin;

	  @FindBy(xpath="//span[contains(text(),'INVENTORY')]")
	     WebElement Inventory;
	
//******	   view all

	  @FindBy(xpath="//div[contains(text(),'Sites')]/..//a")
	     WebElement Siteviewall;
	  
	  @FindBy(xpath="//div[contains(text(),'Sites')]")
	     WebElement totalSite;
	  
	  @FindBy(xpath="//div[contains(text(),'Sites')]/../..//div[@class='item-sacket-tag Online']/..//div[@class='item-sacket-value']")
	     WebElement siteOnline;
	  
	  @FindBy(xpath="//div[contains(text(),'Sites')]/../..//div[@class='item-sacket-tag Offline']/..//div[@class='item-sacket-value']")
	     WebElement siteOffline;
	  
	  @FindBy(xpath="//div[contains(text(),'Sites')]/../..//div[@class='item-sacket-tag Degraded']/..//div[@class='item-sacket-value']")
	     WebElement siteDeg;
	  
	  
	  
//************************ CPES *****************//	  

	  @FindBy(xpath="//div[contains(text(),'CPEs')]/..//a")
	     WebElement Cpesviewall;
	
	  @FindBy(xpath="//div[contains(text(),'CPEs')]")
	     WebElement totalCPEs;
	  
	  @FindBy(xpath="//div[contains(text(),'CPEs')]/../..//div[@class='item-sacket-tag Online']/..//div[@class='item-sacket-value']")
	     WebElement CPEsOnline;
	  
	  @FindBy(xpath="//div[contains(text(),'CPEs')]/../..//div[@class='item-sacket-tag Offline']/..//div[@class='item-sacket-value']")
	     WebElement CPEsOffline;
	  
//******** Application locator	  
	  
	  @FindBy(xpath="//div[contains(text(),'Applications')]/..//a")
	     WebElement appviewall;
	 // @FindBy(xpath="//div[contains(text(),'Applications')]")
	  @FindBy(xpath="//div[contains(text(),'Applications')]") 
	  WebElement valallap;
	  
	
	  		@FindBy(xpath="//div[@class='db-card-sacket'][contains(.,'Built')]//a")
	  		WebElement bappviewall;
	  
	  			@FindBy(xpath="//div[@class='db-card-sacket'][contains(.,'Built')]//div[@class='item-sacket-value']")
	  			WebElement valbapp;
	  
	  		@FindBy(xpath="//div[@class='db-card-sacket'][contains(.,'User')]//a")
	  		WebElement udappviewall;
	  
	  			@FindBy(xpath="//div[@class='db-card-sacket'][contains(.,'User')]//div[@class='item-sacket-value']")
	  			//@FindBy(xpath="//div[contains(text(),'151')]")
	  			WebElement valudapp;
	  
//********** Policy locsator 	  
	  @FindBy(xpath="//div[contains(text(),'Policies')]/..//a")
	     WebElement polviewall;
	
	  @FindBy(xpath="//div[contains(text(),'Policies')]") 
	  WebElement valallpol;
	  		@FindBy(xpath="//div[@class='db-card-sacket'][contains(.,'SDWAN')]//a")
	  		WebElement SDWANpolicyviewall;
	  
	  		@FindBy(xpath="//div[@class='db-card-sacket'][contains(.,'Qos')]//a")
	  		WebElement Qpolicyviewall;
	  		
	  		@FindBy(xpath="//div[contains(text(),'SDWAN Policy')]/..//div[@class='item-sacket-value']")
		     WebElement polSDWAN;
		  
		  @FindBy(xpath="//div[contains(text(),'Qos Policy')]/..//div[@class='item-sacket-value']")
		     WebElement polQos;
	   
	  public HomePage()
	    {
	 	   PageFactory.initElements(driver, this);
	    }
	  
	  public LoginPage logout() throws InterruptedException
	  {
		  Thread.sleep(6000);
		  logout.click();
		  Thread.sleep(5000);
		  signout.click();
		  return new LoginPage();
	  }
//************ Sites Oparations	  
	  public SitelistPage VASites() throws InterruptedException
	  {
		  jsclick(Siteviewall);
		  return new SitelistPage();
	  }
	// get status wise site numbers from dashboard  	  
		  public String sitegetvalofonline() throws InterruptedException
		  {
			  Thread.sleep(5000);
			  String at=siteOnline.getText();
			  System.out.println(at+" value of Online sites from dashboard");
			  return siteOnline.getText();
		  }
		  public String sitegetvalofofonline() throws InterruptedException
		  {
			 // Thread.sleep(10000);
			  
			  System.out.println(siteOffline.getText()+" value of Offline sites from dashboard");
			  
			  return siteOffline.getText();
		  }
		  public String sitegetvalofdeg() throws InterruptedException
		  {
			  //Thread.sleep(10000);
			  System.out.println(siteDeg.getText()+" value of degraded sites from dashboard");
			  return siteDeg.getText();
		  }
	  
		  public String getvalofallsite() throws InterruptedException
		  {
			  Thread.sleep(10000);
			  String at=totalSite.getText();
			  System.out.println(at+" value of All Total app app from dashboard");
			  String number= at.replaceAll("[^0-9]", "");
				 System.out.println(number);
			 return number;

		  }
// ************ CPES Oparations*********	  
	  public CPEsPage VACPEs()
	  {
		  jsclick(Cpesviewall);
		  return new CPEsPage();
	  }
	  
	  public String cpesgetvalofonline() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  String at=CPEsOnline.getText();
		  
		  System.out.println(at+" value of Online CPEs from dashboard");
		  return CPEsOnline.getText();
	  }
	  public String cpesgetvalofofonline() throws InterruptedException
	  {
		  //Thread.sleep(10000);
		  
		  System.out.println(CPEsOffline.getText()+" value of Offline CPEs from dashboard");
		  
		  return CPEsOffline.getText();
	  }
	  
	  public String getvalofallcpes() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  String at=totalCPEs.getText();
		  System.out.println(at+" value of All Total app app from dashboard");
		  String number= at.replaceAll("[^0-9]", "");
			 System.out.println(number);
		 return number;

	  }
//******** Application Oparations	  
	  
	  // click on view all 
	  public AllAppPage VAAllApp()
	  {
		  jsclick(appviewall);
		  return new AllAppPage();
	  }
	   	
	  public BuildInAppPage VAAllbApp()
	  {
		  scrol(bappviewall);
		  jsclick(bappviewall);
		  return new BuildInAppPage();
	  }
	  public UDAppPage VAAlluApp()
	  {
		  scrol(udappviewall);
		  jsclick(udappviewall);
		  return new UDAppPage();
	  }
	  
	// get values from dashboard for All Built in and userdefined apps	  
	  public String getvalofallap() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  String at=valallap.getText();
		  System.out.println(at+" value of All Total app app from dashboard");
		  String number= at.replaceAll("[^0-9]", "");
			 System.out.println(number);
		 return number;

	  }
	  public String getvalofudap() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  System.out.println(valudapp.getText()+" value of user defined app from dashboard");
		 // System.out.println(valbapp.getText()+" value of Built In app from dashboard");
		 return valudapp.getText();
	  }
	  public String getvalofbap() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  System.out.println(valbapp.getText()+" value of Built In app from dashboard");
		 return valbapp.getText();
	  }


//****** Policy Oparations
	  public PoliciesPage VAAllPol()
	  {
		  jsclick(polviewall);
		  return new PoliciesPage();
	  }
	  public polQosPage VAAllQpol()
	  {
		  scrol(Qpolicyviewall);
		  jsclick(Qpolicyviewall);
		  return new polQosPage();
	  }
	  public polSDWANPage VAAllSDpol()
	  {
		  scrol(SDWANpolicyviewall);
		  jsclick(SDWANpolicyviewall);
		  return new polSDWANPage();
	  }
	  public String getvalofallpol() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  String at=valallpol.getText();
		  System.out.println(at+" value of All Total app app from dashboard");
		  Thread.sleep(10000);
		  String number= at.replaceAll("[^0-9]", "");
			 System.out.println(number);
		 return number;

	  }
	  
	  public String polgetvalofsdwan() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  System.out.println(polSDWAN.getText()+" value of SDWAN policy from dashboard");
		  return polSDWAN.getText();
	  }
	  public String polgetvalofqos() throws InterruptedException
	  {
		  Thread.sleep(10000);
		  System.out.println(polQos.getText()+" value of Qos policy from dashboard");
		  return polQos.getText();
	  }
	  
//********* Main Tab Navigations	  
public HomePage Dashboard()
{
	try {
		Dashboard.click();	
	} catch (Exception e) {
		// TODO: handle exception
		jsclick(Dashboard);
	}
	return new HomePage();
}

public AdminPage Admin()
{
	try {
		Admin.click();	
	} catch (Exception e) {
		// TODO: handle exception
		jsclick(Admin);
	}
	return new AdminPage();
}

public InventoryPage Invent()
{
	try {
		Inventory.click();	
	} catch (Exception e) {
		// TODO: handle exception
		jsclick(Inventory);
	}
	return new InventoryPage();
}
	  
// **** Basics methods	
	public String pageheding()
	{
		System.out.println(driver.getCurrentUrl());
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
	
//********** Extra functions	
	  public void jsclick(WebElement ele)
	  {
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", ele);
	  }
	
}
