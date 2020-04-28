package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import BASE.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//a[@class='nav-link withIn']")
    WebElement loginlink;
	
	 @FindBy(xpath="//input[@placeholder='Enter email ID']")
     WebElement username;
     
     @FindBy(xpath="//input[@placeholder='Enter Password']")
     WebElement psw;
     
     @FindBy(xpath="//button[contains(text(),'Login')]")
     WebElement login;
     
     @FindBy(xpath="//button[contains(text(),'Reset')]")
     WebElement Forgotpass;
     
     // card
     @FindBy(xpath="//h5[@class='card-title']")
     WebElement cardtitle;
          
     @FindBy(xpath="//p[@class='card-text']")
     WebElement cardtext;
     
     @FindBy(xpath="//span[@class='error-message']")
     WebElement errormsg;
     
     @FindBy(xpath="//a[@class='navbar-brand']//img")
     WebElement logo;
      
     @FindBy(xpath="//h2[@class='page-title']")
     WebElement logpgtxt;
      
     
     
     boolean rs=false; 
     
     public LoginPage()
     {
  	   PageFactory.initElements(driver, this);
     }
     
     public String Logintxt()
     {
    	 return logpgtxt.getText();
     }
     
     public String LoginTitle()
     {
    	 System.out.println("in logintitle");
    	 System.out.println("Title is   "+driver.getTitle());
    	 return driver.getTitle();
     }
     
     public boolean verifyLogo()
     {
  	   return logo.isDisplayed();
     }
     
     public HomePage login()  throws InterruptedException
     {
    	 try {
    		 loginlink.click();
		} catch (Exception e) {
			// TODO: handle exception
			driver.navigate().refresh();
			loginlink.click();
		}
  	   
  	   Thread.sleep(1000);
  	 //  username.sendKeys("pradeep.modak@evolutionco.com");
  	  username.sendKeys("pravin.jadhav@evolutionco.com");
  	   Thread.sleep(1000);
  	   psw.sendKeys("Password@123");
  	   Thread.sleep(2000);
  	   login.click();
  	   return new HomePage();  
     }
     
     public String EmailIDtest(String un, String pass)  throws InterruptedException
     {
  	   loginlink.click();
  	   Thread.sleep(1000);
  	   username.sendKeys(un);
  	   Thread.sleep(1000);
  	 psw.sendKeys(pass);
  	 boolean res=false;
  	   try {
  		   res=errormsg.isDisplayed();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("erro not showing or valid email id");
	}
  	   if(res)
  	   {
  		   return errormsg.getText();
  	   }
  	   else
  	   {
  		   System.out.println("btn click");
  		   //Thread.sleep(1000);
  		   login.click();
  		   
  	 	 boolean res2=false;
    	   try {
    		   res2=errormsg.isDisplayed();
  	} catch (Exception e) {
  		// TODO: handle exception
  		System.out.println("erro not showing or valid password");
  	}
    	   if(res2)
    	   {
    		   return errormsg.getText();
    	   }
    	   else
    	   {
    		   System.out.println("all input ok");
    		   String v="Valid";
    		   return v;
    	   }
  	   }
     }
     
     public String Testlogin(String un, String pass)  throws InterruptedException
     {
  	   loginlink.click();
  	   Thread.sleep(1000);
  	   username.sendKeys(un);
  	   Thread.sleep(1000);
  	   psw.sendKeys(pass);
  	 Thread.sleep(1000);
  	
  	 
boolean  	 rs1=checkerrmsg();
  	 
  	   if(rs1)
  	   {
  		   System.out.println("in erro 1 loop");
  		 return errormsg.getText();
  	   }
  	     	   
  	   //psw.sendKeys(pass);
  	   System.out.println("clicking");
  	   Thread.sleep(1000);
  	   login.click();
  	   System.out.println("login clicked");
  	   Thread.sleep(2000);
  	 boolean  	 rs2=checkerrmsg();
  	 
	   if(rs2)
	   {
 	   
  		System.out.println("in erro 2 loop");
 		 return errormsg.getText();
 	   }
  	  
  	  String s="All inputs OK";
  	  
  	  return s;
//  	   return new HomePage();  
     }
	   

     public boolean checkerrmsg()
     {
      	 try {
      		
       		boolean rs=errormsg.isDisplayed();
       		
     	} catch (Exception e) {
     		System.out.println("valid email ");
     	}
      	return rs;
     }
}
