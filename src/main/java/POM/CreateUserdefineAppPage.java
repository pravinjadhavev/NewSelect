package POM;

import java.awt.AWTException;
import java.awt.Robot;

import javax.mail.MessagingException;

import org.apache.commons.math3.geometry.enclosing.WelzlEncloser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Key;

import BASE.TestBase;
import UTIL.getotp;

public class CreateUserdefineAppPage extends TestBase {

	  @FindBy(xpath="//input[@placeholder='Application Name*']")
		WebElement Appname;
	  
	  @FindBy(xpath="//div[@class='mCtitel']//div[@class='error']")
		WebElement erroAppname;
	  
	  @FindBy(xpath="//input[@formcontrolname='PrecedenceTag']")
		WebElement ptag;
	  @FindBy(xpath="//label[contains(text(),'Precedence')]/../..//div[@class='error']")
		WebElement errptag;
	  
	  @FindBy(xpath="//input[@name='category']/..//span")
		WebElement catspan;
	  @FindBy(xpath="//li//label[contains(.,'non business')]")
		WebElement Category;
	  @FindBy(xpath="//input[@name='category']")
		WebElement catinput;
	  
	  @FindBy(xpath="//input[@name='risk']/..//span")
		WebElement riskspan;
	  @FindBy(xpath="//li//label[contains(.,'Very Low')]")
		WebElement riskele;
	  @FindBy(xpath="//input[@name='risk']")
		WebElement riskinput;
	  
	  @FindBy(xpath="//textarea[@formcontrolname='description']")
		WebElement dec;
	  @FindBy(xpath="//label[contains(text(),'Description')]/../..//div[@class='error']")
		WebElement errdec;
	  

	  @FindBy(xpath="//div[@formgroupname='sourceIp']//input[@formcontrolname='octa1']")
		WebElement sip1;
	  @FindBy(xpath="//div[@formgroupname='sourceIp']//input[@formcontrolname='octa2']")
		WebElement sip2;
	  @FindBy(xpath="//div[@formgroupname='sourceIp']//input[@formcontrolname='octa3']")
		WebElement sip3;
	  @FindBy(xpath="//div[@formgroupname='sourceIp']//input[@formcontrolname='octa4']")
		WebElement sip4;
	  @FindBy(xpath="//div[@formgroupname='sourceIp']//input[@formcontrolname='Subnetmask']")
		WebElement sip5;
	  
	  @FindBy(xpath="//label[contains(text(),'Source IP')]/../..//div[@class='GropupError']")
		WebElement errsip;
	  
	  
	  
	  @FindBy(xpath="//div[@formgroupname='destinationIp']//input[@formcontrolname='octa1']")
		WebElement dip1;
	  @FindBy(xpath="//div[@formgroupname='destinationIp']//input[@formcontrolname='octa2']")
		WebElement dip2;
	  @FindBy(xpath="//div[@formgroupname='destinationIp']//input[@formcontrolname='octa3']")
		WebElement dip3;
	  @FindBy(xpath="//div[@formgroupname='destinationIp']//input[@formcontrolname='octa4']")
		WebElement dip4;
	  @FindBy(xpath="//div[@formgroupname='destinationIp']//input[@formcontrolname='Subnetmask']")
		WebElement dip5;
	  
	  @FindBy(xpath="//label[contains(text(),'Destination IP')]/../..//div[@class='GropupError']")
		WebElement errdip;
	  
	  @FindBy(xpath="//div[@formgroupname='sourcePort']//input[@formcontrolname='StartPort']")
		WebElement sport;
	  @FindBy(xpath="//div[@formgroupname='sourcePort']//input[@formcontrolname='EndPort']")
		WebElement sportrang;
	  @FindBy(xpath="//label[contains(text(),'Source Port')]/../..//div[@class='portmsgs']")
		WebElement errsport;
	  
	  
	  @FindBy(xpath="//div[@formgroupname='destinationPort']//input[@formcontrolname='StartPort']")
		WebElement dport;
	  @FindBy(xpath="//div[@formgroupname='destinationPort']//input[@formcontrolname='EndPort']")
		WebElement dportrang;
	
	  @FindBy(xpath="//label[contains(text(),'Destination Port')]/../..//div[@class='portmsgs']")
		WebElement errdport;

	  @FindBy(xpath="//input[@formcontrolname='hostPattern']")
		WebElement hostp;
	  @FindBy(xpath="//label[contains(text(),'Host Pattern')]/../..//div[@class='error']")
		WebElement errhostp;
	  
	  @FindBy(xpath="//input[@formcontrolname='protocolValue']")
		WebElement proto;
	  @FindBy(xpath="//label[contains(text(),'Protocol Value')]/../..//div[@class='error']")
		WebElement errproto;
	
	  @FindBy(xpath="//button[contains(text(),'Save')]")
			WebElement savebtn;
	  @FindBy(xpath="//button[contains(text(),'Cancel')]")
		WebElement backbtn;  
	  
	  @FindBy(xpath="//button[contains(text(),'Confirm')]")
		WebElement confbtn;
@FindBy(xpath="//button[contains(text(),'Resend')]")
	WebElement resend;  

@FindBy(xpath="//input[@id='otpvalue']")
WebElement otp;  

@FindBy(xpath="//div[contains(text(),'Application edited successfully.')]")
WebElement appadmsg;
@FindBy(xpath="//div[contains(text(),'Application created successfully.')]")
WebElement appadmsg2; 

@FindBy(xpath="//div[contains(text(),'Name already exists')]")
WebElement appadmsg3; 


@FindBy(xpath="//div[contains(text(),'Application edited successfully.')]/../../../..//button[contains(text(),'close')]")
WebElement clsbtn;  


@FindBy(xpath="//button[@class='btn active-btn subScreenClose']")
WebElement  cls;

@FindBy(xpath="//div[@id='errorOtpapp']")
WebElement otperr;  


	  
	  
	  
	public CreateUserdefineAppPage()
  {
	   PageFactory.initElements(driver, this);
  }

	public String checkerr(String webel,String data) throws InterruptedException
	{ 
		String ermsg=null;
		if(webel.equalsIgnoreCase("Application Name"))
		{
			ermsg=errform(Appname,erroAppname,data);
		}
		if(webel.equalsIgnoreCase("Precedence"))
		{
			ermsg=errform(ptag,errptag,data);
		}
		if(webel.equalsIgnoreCase("Description"))
		{
			dec.clear();
			dec.sendKeys(data);
			dec.clear();
			dec.sendKeys("0");
			dec.sendKeys(Keys.BACK_SPACE);
			dec.sendKeys(Keys.TAB);
			
			if(errdec.isDisplayed())
			{
				System.out.println(errdec.getText());
				ermsg=errdec.getText();
			}
			else
			{
				ermsg=" ";
			}
			
		}
		if(webel.equalsIgnoreCase("Source ip"))
		{
			String[] ips = getips(data);
			fillsip(ips);
			
			boolean res=false;
			try {
				res=errsip.isDisplayed();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Its a Valid Input");
			}
			
			if(res)
			{
				System.out.println(errsip.getText());
				ermsg= errsip.getText();
			}else
			{
				return " ";	
			}
		}
		if(webel.equalsIgnoreCase("Destination ip"))
		{
			String[] ips = getips(data);
			filldip(ips);
			boolean res=false;
			try {
				res=errdip.isDisplayed();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Its a Valid Input");
			}
			
			if(res)
			{
				System.out.println(errdip.getText());
				ermsg= errdip.getText();
			}else
			{
				return " ";	
			}
		}

		
		
		if(webel.equalsIgnoreCase("Source Port"))
		{
			sport.clear();
			sport.sendKeys("0");
			sport.sendKeys(Keys.BACK_SPACE);
			sport.sendKeys(Keys.TAB);
			
			try {
				sportrang.clear();
				sportrang.sendKeys("0");
				sportrang.sendKeys(Keys.BACK_SPACE);
				sportrang.sendKeys(Keys.TAB);
				
			} catch (Exception e) {
			}
			System.out.println("cleard");
			
			String[] Sp = data.split("[,]");
			//System.out.println( Sp[0]+" and " +Sp[1]);
			
			if(Sp[0].equalsIgnoreCase("-"))
			{			
			 System.out.println("0 send");
				sport.sendKeys("0");
			}
			else
			{
				sport.sendKeys(Sp[0]);
			}
			sport.sendKeys(Keys.TAB);
			
			if(Sp.length>1 && !Sp[1].equalsIgnoreCase("-"))
			{
				sportrang.sendKeys(Sp[1]);
				sportrang.sendKeys(Keys.TAB);
			} 
		 
			if(Sp[0].equalsIgnoreCase("-"))
			{			
				sport.click();
				sport.sendKeys(Keys.BACK_SPACE);
				sport.sendKeys(Keys.TAB);
				System.out.println("clear box");
			}
			
				Thread.sleep(1000);
				if(errsport.isDisplayed())
				{
					System.out.println(errsport.getText());
					ermsg=errsport.getText();
				}else
				{
				ermsg=" ";
				}
			}
		
		if(webel.equalsIgnoreCase("Destination Port"))
		{
			dport.clear();
			dport.sendKeys("0");
			dport.sendKeys(Keys.BACK_SPACE);
			dport.sendKeys(Keys.TAB);
			
			try {
				dportrang.clear();
				dportrang.sendKeys("0");
				dportrang.sendKeys(Keys.BACK_SPACE);
				dportrang.sendKeys(Keys.TAB);
				
			} catch (Exception e) {
			}
			//System.out.println("cleard");
			
			String[] Sp = data.split("[,]");
			System.out.println( Sp[0]+" and " +Sp[1]);
			
			if(Sp[0].equalsIgnoreCase("-"))
			{			
			 //System.out.println("0 send");
				dport.sendKeys("0");
			}
			else
			{
				dport.sendKeys(Sp[0]);
			}
			dport.sendKeys(Keys.TAB);
			if(!Sp[1].equalsIgnoreCase("-"))
			{
				dportrang.sendKeys(Sp[1]);
				dportrang.sendKeys(Keys.TAB);
			} 
		 
			if(Sp[0].equalsIgnoreCase("-"))
			{			
				dport.click();
				dport.sendKeys(Keys.BACK_SPACE);
				dport.sendKeys(Keys.TAB);
				//System.out.println("clear box");
			}
			
				Thread.sleep(1000);
				if(errdport.isDisplayed())
				{
					System.out.println(errdport.getText());
					ermsg=errdport.getText();
				}else
				{
				ermsg=" ";
				}
			}
			
		if(webel.equalsIgnoreCase("Host Pattern"))
		{
			ermsg=errform(hostp,errhostp,data);
		}
		if(webel.equalsIgnoreCase("Protocol Value"))
		{
			ermsg=errform(proto,errproto,data);
		}
		
		return ermsg;		
	}
	
	public String errform(WebElement ele,WebElement err,String data) throws InterruptedException
	{
		scrol(ele);
		ele.clear();
		ele.sendKeys(data);
		ele.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		if(err.isDisplayed())
		{
			System.out.println(err.getText());
			return err.getText();
		}else
		{System.out.println("no err msg");}
		
		return " ";
	}

	public boolean editname(String Name) throws InterruptedException
	{
		//Appname.clear();
		Appname.sendKeys(Name);
		//System.out.println("name done");
		Thread.sleep(2000);
	if(Appname.getAttribute("value").equalsIgnoreCase(Name))
	{
		System.out.println("Name Edited");
		return false;
	}else
	{
		System.out.println("Name Not Edited");
		return true;
	}
	}
	
	public boolean getName(String name) throws InterruptedException
	{
		if(Appname.getAttribute("value").equals(name))
		{
			return true;
		}
		return false;
		
		
	}
	
	public boolean copysave(String name) throws InterruptedException
	{
		
		if(Appname.getAttribute("value").equals("") || Appname.getAttribute("value").equals(null))
		{}else{
			
			System.out.println("Name having :"+Appname.getAttribute("value"));
			System.out.println("after name");
		String	msg2=Appname.getAttribute("value")+" Name present in appliaction name for copy"+" err";
		System.out.println(msg2);
		return false;
		}
		
		Appname.sendKeys(name);
		Appname.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		if(Appname.getAttribute("value").equalsIgnoreCase(name))
		{
			System.out.println("Name Edited");
			Thread.sleep(2000);
			savebtn.click();
			return true;
		}else
		{
			System.out.println("Name Not Edited");
			return false;
		}
	}
	
	public boolean editsave(WebElement ele,WebElement errel,String data) throws InterruptedException
	{
		ele.clear();
		ele.sendKeys(data);
		ele.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		boolean b=false;
		
		try {
			b=errel.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro msg not locate");
			//return false;
		}
		
		if(b)
		{
			System.out.println("Error in ptag");
			return false;
		}
		else
		{		
			if(ele.getAttribute("value").equalsIgnoreCase(data))
			{
				System.out.println("ptag Edited");
				Thread.sleep(2000);
				//savebtn.click();
				return true;
			}else
			{
				System.out.println("ptag Not Edited");
				return false;
			}
		}
	}
	
	public String copy2(String q,String catinputdata ,String  ptagdata,String riskinputdata,String  decdata,String  Sipdata,String Dipdata,String  sportdata,String  dportdata,String  hostpdata,String  protodata ) throws InterruptedException
	{
		//System.out.println(ptagdata+" is old");
		Thread.sleep(5000);
		String msg2=null;
		if(q.equalsIgnoreCase("copy"))
		{
			System.out.println("in copy2");
			if(Appname.getAttribute("value").equals("") || Appname.getAttribute("value").equals(null))
			{}else{
				
				System.out.println("Name having :"+Appname.getAttribute("value"));
				System.out.println("after name");
				msg2=Appname.getAttribute("value")+" Name present in appliaction name for copy"+" err";
			}
		}
		if(q.equalsIgnoreCase("edit"))
		{
			if(Appname.getAttribute("value").equals(" ") || Appname.getAttribute("value").equals(null))
			{
				System.out.println("Name having :"+Appname.getAttribute("value"));
				msg2=Appname.getAttribute("value")+" Name Not present in appliaction name for Edit"+" err";
			}
		}
		msg2=msg2+copy(catinputdata,ptagdata,riskinputdata,decdata,sportdata,dportdata,hostpdata,protodata,Sipdata,Dipdata);
		return msg2;
	}
	public String copy(String catinputdata ,String  ptagdata,String riskinputdata,String  decdata,String  sportdata,String  dportdata,String  hostpdata,String  protodata,String  Sipdata,String Dipdata) throws InterruptedException
	{
		
		String msg=null;
//		if(Appname.getAttribute("value").equals(" ") || Appname.getAttribute("value").equals(null))
//		{}else{
//			System.out.println("Name having :"+Appname.getAttribute("value"));
//			msg=Appname.getAttribute("value")+" Name present in appliaction name"+" err";
//		}
		
		msg=msg+comp(catinput,catinputdata," Category ");
		msg=msg+comp(ptag,ptagdata," Precedence Tag ");
		msg=msg+comp(riskinput,riskinputdata," Risk ");
		msg=msg+comp(dec,decdata," Description ");
		msg=msg+comp(sport,sportdata," Source Port ");
		msg=msg+comp(dport,dportdata," Destination Port ");
		msg=msg+comp(hostp,hostpdata," Host Pattern ");
		msg=msg+comp(proto,protodata," Protocol Value ");

//		String str=elem; 
//		switch (str) {
//		
//		case "Category":
//			msg=msg+comp(catinput,data," Category ");
//			break;
//		case "Precedence Tag":
//			msg=msg+comp(ptag,data," Precedence Tag ");
//			break;
//		case "Risk":
//			msg=msg+comp(riskinput,data," Risk ");
//			break;
//		case "Description":
//			msg=msg+comp(dec,data," Description ");
//			break;
//		case "Source IP":
//			String	SourceIP=sip1.getAttribute("value")+"."+sip2.getAttribute("value")+"."+sip3.getAttribute("value")+"."+sip4.getAttribute("value")+"/"+sip5.getAttribute("value");
//			if(SourceIP.equalsIgnoreCase(data))
//			{}else
//			{
//				msg=msg+" Source Ip err";
//			}
//			
//			break;
//		case "Destination IP":
//			String	destIP=dip1.getAttribute("value")+"."+dip2.getAttribute("value")+"."+dip3.getAttribute("value")+"."+dip4.getAttribute("value")+"/"+dip5.getAttribute("value");
//			if(destIP.equalsIgnoreCase(data))
//			{}else
//			{
//				msg=msg+" Destination Ip err ";
//			}	
//			
//			break;
//		case "Source Port":
//			msg=msg+comp(sport,data," Source Port ");
//			break;
//		case "Destination Port":
//			msg=msg+comp(dport,data," Destination Port ");
//			break;
//		case "Host Pattern":
//			msg=msg+comp(hostp,data," Host Pattern ");
//			break;
//		case "Protocol Value":
//			msg=msg+comp(proto,data," Protocol Value ");
//			break;
//			
//		}
		
		String	SourceIP=sip1.getAttribute("value")+"."+sip2.getAttribute("value")+"."+sip3.getAttribute("value")+"."+sip4.getAttribute("value")+"/"+sip5.getAttribute("value");
		String	destIP=dip1.getAttribute("value")+"."+dip2.getAttribute("value")+"."+dip3.getAttribute("value")+"."+dip4.getAttribute("value")+"/"+dip5.getAttribute("value");
		System.out.println(SourceIP + " "+ destIP );
		
		if(SourceIP.equalsIgnoreCase(Sipdata))
		{}else
		{
			msg=msg+" Source Ip err";
		}
		if(destIP.equalsIgnoreCase(Dipdata))
		{}else
		{
			msg=msg+" Destination Ip err ";
		}
		return msg;
	}
		
	public String comp(WebElement ele2,String str,String elename)
	{
		String abc=ele2.getAttribute("value");
		if(abc.equalsIgnoreCase(str))
		{
			System.out.println(elename+" same");
			return "";
		}
		else
		{
			System.out.println(abc+" & "+str);
			return "err at"+elename+" old data "+ str+" current data "+ abc + " ";
			//System.out.println(ele.getText()+" & "+str);
			
		}
			
	}
	
	public boolean Editoldapp(String elem,String data) throws InterruptedException
	{
		boolean msg=false;
		String str=elem; 
		switch (str) {
		
		case "Category":

			Actions as=new Actions(driver);
			  as.moveToElement(catspan).click().perform();
			//  catspan.click();
			  System.out.println("catspan clicked");
			  Thread.sleep(1000);
			  String nxp="//li//label[contains(.,'"+data+"')]";
			  System.out.println(nxp);
			  WebElement Category1 =driver.findElement(By.xpath(nxp));
			  Thread.sleep(1000);
			  Category1.click();
			  System.out.println("cat selected");
			  msg=true;
			break;
		case "Precedence Tag":
			msg=editsave(ptag, errptag, data);
			break;
		case "Risk":
			Actions as1=new Actions(driver);
			  as1.moveToElement(riskspan).click().perform();
			//  riskspan.click();
			  System.out.println("riskspan clicked");
			  Thread.sleep(1000);
			  String nxp1="//li//label[contains(.,'"+data+"')]";
			  System.out.println(nxp1);
			  WebElement Category2 =driver.findElement(By.xpath(nxp1));
			  Thread.sleep(1000);
			  Category2.click();
			  System.out.println("risk selected");
			msg=true;
			break;
		case "Description":
			msg=editsave(dec, errdec, data);
			break;
		case "Source IP":
			String[] ips = getips(data);
			fillsip(ips);
			try {
				if(errsip.isDisplayed())
				{
					System.out.println(errsip.getText());
					msg=false;
				}
				else
				{
					msg=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("sip error not found");
				msg=true;
			}
			
			
			break;
		case "Destination IP":
			ips = getips(data);
			filldip(ips);
			try {
				if(errdip.isDisplayed())
				{
					System.out.println(errdip.getText());
					msg=false;
				}
				else
				{
					msg=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("sip error not found");
				msg=true;
			}
			break;
		case "Source Port":
			msg=editsave(sport, errsport, data);
			break;
		case "Destination Port":
			msg=editsave(dport, errdport, data);
			break;
		case "Host Pattern":
			msg=editsave(hostp, errhostp, data);
			break;
		case "Protocol Value":
			msg=editsave(proto, errproto, data);
			break;
		}
	return msg;
	}
	
	
	public void saveclick(){	
	try {
		
		if(savebtn.isDisplayed())
		{
			Topscrol();
			savebtn.click();
			System.out.println("save clicked");
		}
		else
		{
			System.out.println("form error present");
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("save not found");
	}
}
	
	public boolean savedata(int d) throws InterruptedException, MessagingException
	{
		
		Topscrol();
		
		Thread.sleep(10000);
				
		WebDriverWait wt=new WebDriverWait(driver, 50);
		wt.until(ExpectedConditions.visibilityOf(otp));
		String otpdata="";
		otpdata=getotp.MailTestnew();
		if(otpdata.equalsIgnoreCase(" "))
		{
			Thread.sleep(30000);
			otpdata=getotp.MailTestnew();
		}
		System.out.println("returned otp is : " + otpdata);
		
		otp.sendKeys(otpdata);
		confbtn.click();
		
	//	try {
			
		switch (d) {
		case 1:
			WebDriverWait wt1=new WebDriverWait(driver, 180);
			wt1.until(ExpectedConditions.visibilityOf(appadmsg2));
			break;
		case 2:
			
			WebDriverWait wt2=new WebDriverWait(driver, 180);
			wt2.until(ExpectedConditions.visibilityOf(appadmsg));
			System.out.println(appadmsg.getText());
		break;	
		case 3:
			WebDriverWait wt3=new WebDriverWait(driver, 180);
			wt3.until(ExpectedConditions.visibilityOf(appadmsg3));
			break;
		}
		
		Thread.sleep(2000);
		System.out.println(cls.getText());
		try {
			cls.click();	
			System.out.println("simple click");
			return true;	
		} catch (Exception e) {
			// TODO: handle exception
			jsclick(cls);
			System.out.println("js click");
			return true;
		}
		//}
		//catch (Exception e) {
			// TODO: handle exception
			//System.out.println("Different err msg found");
			//return false;
		//}
	
		
	}
	
	public void fillform(String AppName,String Categorydata,String ptagdata,String riskdata,String Description,String Sip,String Dip,String sportdata,String dportdata,String hostdata,String protodata) throws InterruptedException
	{
		System.out.println("in form "+ AppName);
		Appname.sendKeys(AppName);
		System.out.println("name done");
		ptag.clear();
		  ptag.sendKeys(ptagdata);
		  System.out.println("name done");  
		  
		  Actions as=new Actions(driver);
		  as.moveToElement(catspan).click().perform();
		//  catspan.click();
		  System.out.println("catspan clicked");
		  Thread.sleep(1000);
		  String nxp="//li//label[contains(.,'"+Categorydata+"')]";
		  System.out.println(nxp);
		  WebElement Category1 =driver.findElement(By.xpath(nxp));
		  Thread.sleep(1000);
		  Category1.click();
		  System.out.println("cat selected");
		  Thread.sleep(1000);
		  as.moveToElement(riskspan).click().perform();
		//  riskspan.click();
		  System.out.println("risk clicked");
		  Thread.sleep(1000);

		  WebElement riskele=driver.findElement(By.xpath("//li//label[contains(.,'"+riskdata+"')]"));
		  riskele.click();
		  System.out.println("risk selected");
		  Thread.sleep(1000);
		  dec.clear();
	dec.sendKeys(Description);
	
	String[] ips = getips(Sip);
	fillsip(ips);
	Thread.sleep(1000);
	ips = getips(Dip);
	filldip(ips);

	  Thread.sleep(1000);
	sport.sendKeys(sportdata);
	dport.sendKeys(dportdata);
	hostp.sendKeys(hostdata);
	proto.sendKeys(protodata);
	//proto.sendKeys(Keys.TAB);
	try {
	
		if(savebtn.isDisplayed())
		{
			Topscrol();
			savebtn.click();
			System.out.println("save clicked");
		}
		else
		{
			System.out.println("form error present");
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("save not found");
	}
	
}
	
	public void fillsip(String[] ips) throws InterruptedException
	{
		sip1.clear();
		sip2.clear();
		sip3.clear();
		sip4.clear();
		sip5.clear();
		Thread.sleep(1000);
		sip1.sendKeys(ips[0]);
		sip2.sendKeys(ips[1]);
		sip3.sendKeys(ips[2]);
		sip4.sendKeys(ips[3]);
		sip5.sendKeys(ips[4]);
	}
	public void filldip(String[] ips) throws InterruptedException
	{
		dip1.clear();
		dip2.clear();
		dip3.clear();
		dip4.clear();
		dip5.clear();
		Thread.sleep(1000);
		dip1.sendKeys(ips[0]);
		dip2.sendKeys(ips[1]);
		dip3.sendKeys(ips[2]);
		dip4.sendKeys(ips[3]);
		dip5.sendKeys(ips[4]);
	}
	
	 public String[] getips(String str) 
	    { 
	        String[] ips = str.split("[./]"); 
	        for (String a : ips)
	        {
	            System.out.println("from for "+a);
	        }
	        return ips;
	    } 
	  public void jsclick(WebElement ele)
	  {
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", ele);
	  }
}
