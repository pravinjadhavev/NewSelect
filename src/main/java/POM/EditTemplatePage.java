package POM;

import java.sql.Time;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BASE.TestBase;
import UTIL.getotp;

public class EditTemplatePage extends TestBase
{

	
	
	@FindBy(xpath="//input[@id='aliasChange']")
	WebElement alias;
	
	@FindBy(xpath="//span[@class='star']")
	WebElement fevstart;
	@FindBy(xpath="//span[contains(text(),'Type :')]//span")
	WebElement policydd;
	@FindBy(xpath="//ul[@class='show']//li[contains(.,'SDWAN')]")
	WebElement selectsd;
	@FindBy(xpath="//ul[@class='show']//li[contains(.,'QoS')]")
	WebElement selectqoc;
	
//	@FindBy(xpath="//li[@id='Rule-COS-4']//div[@class='cd'][contains(.,'Appli')]//label[contains(.,'App')]//span")
//	WebElement Editapp;
//	@FindBy(xpath="//li[@id='Rule-COS-4']//div[@class='cd'][contains(.,'URL')]//label[contains(.,'URL')]//span")
//	WebElement EditURL;
//	@FindBy(xpath="//li[@id='Rule-COS-4']//div[@class='cd'][contains(.,'DSCP')]//label[contains(.,'DSCP')]//span")
//	WebElement EditDSCP;
//	
	@FindBy(xpath="//div[@id='opened']//button[contains(.,'Remove')]")
	WebElement remove;
	@FindBy(xpath="//div[@id='opened']//button[contains(text(),'Add')]")
	WebElement Add;
	
	@FindBy(xpath="//div[@id='checkPopup']//div[@class='pull-right subScreenClose']")
	WebElement close;
	
	@FindBy(xpath="//div[@id='ThrowMsg']//button[@class='btn active-btn subScreenClose'][contains(text(),'close')]")
	WebElement appadclose;
	
	@FindBy(xpath="//div[contains(text(),'applications')]")
	WebElement appadmsg;
	
	
	@FindBy(xpath="//div[@class='titel strong']//span")
	WebElement poptitle;
	
	@FindBy(xpath="//div[@class='ttl strong']//span[contains(text(),'Zones')]")
	WebElement poptitle2;
	
	@FindBy(xpath="//div[@class='ttl strong'][contains(.,'Source')]")
	WebElement poptitle3;
	
	
	
	@FindBy(xpath="//div[@class='selectOption outClose rightSet closeouthis']//span[@class='icon icon-caret-down']")
	WebElement appdd;
	@FindBy(xpath="//ul[@class='show']//li[contains(.,'Built')]")
	WebElement selectbuilt;
	@FindBy(xpath="//ul[@class='show']//li[contains(.,'User')]")
	WebElement selectuser;
	
	
	@FindBy(xpath="//input[@id='sdwanSearchInput']")
	WebElement searchapp;
	
	@FindBy(xpath="//input[@id='pSerchIp1']")
	WebElement searchzone;
	
	@FindBy(xpath="//div[@id='checkPopup']//button[@class='btn active-btn'][contains(text(),'Proceed')]")
	WebElement procbtn;
	
	@FindBy(xpath="//div[@id='popupTp2']//button[@class='btn active-btn'][contains(text(),'Proceed')]")
	WebElement procbtn2;
	
	
	@FindBy(xpath="//div[@id='nocpesAvlbl']//div[@class='subscreenTitel'][contains(text(),'Message')]")
	WebElement nocpmsg;
	@FindBy(xpath="//div[@id='nocpesAvlbl']//div[@class='subscreenTitel'][contains(text(),'Message')]//div")
	WebElement nocpclose;
	
	@FindBy(xpath="//div[contains(text(),'Applications added successfully.')]")
	WebElement succ;
	
	@FindBy(xpath="//div[@id='savesuccess']//button[@class='btn active-btn subScreenClose'][contains(text(),'close')]")
	WebElement scclose;
	
	@FindBy(xpath="//div[@id='loading']")
	WebElement lod;
	
	@FindBy(xpath="//input[@id='pSerchIp1']")
	WebElement search1;
	@FindBy(xpath="//input[@id='pSerchIp2']")
	WebElement search2;

	// Summary 
	
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='maxPacketLoss']")
	WebElement Packet;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='forwardPacketLoss']")
	WebElement FwdPacket;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='reversePacketLoss']")
	WebElement RevPacket;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='jitter']")
	WebElement Jitter;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='mosScore']")
	WebElement MOSScore;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='circuitTransmitUtilization']")
	WebElement CKTTransmit;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='circuitReceiveUtilization']")
	WebElement CKTReceive;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='latency']")
	WebElement Latency;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='recomputeTimer']")
	WebElement Timer;
	
	
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='maxPacketLoss']/..//div")
	WebElement erPacket;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='forwardPacketLoss']/..//div")
	WebElement erFwdPacket;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='reversePacketLoss']/..//div")
	WebElement erRevPacket;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='jitter']/..//div")
	WebElement erJitter;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='mosScore']/..//div")
	WebElement erMOSScore;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='circuitTransmitUtilization']/..//div")
	WebElement erCKTTransmit;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='circuitReceiveUtilization']/..//div")
	WebElement erCKTReceive;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='latency']/..//div")
	WebElement erLatency;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='recomputeTimer']/..//div")
	WebElement erTimer;
	//dd
	
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='slaViolationAction']")
	WebElement Thresholdd;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='encryption']")
	WebElement Encryptiond;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='loadBalance']")
	WebElement LoadBaldd;
	@FindBy(xpath="//div[@id='opened']//input[@formcontrolname='packetReplication']")
	WebElement packetReplication;
	
	@FindBy(xpath="//div[@id='opened']//input[@ssid='pathPriority']")
	WebElement Path_Prioritydd;	
	
	
//	//div[@class='link text-right']
	
	////ul[@class='pathPriority']//li[@class="prioritiesList"

	@FindBy(xpath="//div[@class='link text-right']")
	WebElement addpath;	

	@FindBy(xpath="//ul[@class='pathPriority']//li[@class='prioritiesList']")
	List<WebElement> pathlist;	
	
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	
	
	@FindBy(xpath="//div[@id='confirmationSave']//button[@class='btn active-btn'][contains(text(),'Confirm')]")
	WebElement otpconf;
	@FindBy(xpath="//input[@id='otpvaluesave']")
	WebElement otpbox;
	@FindBy(xpath="//button[@class='btn active-btn'][contains(text(),'PROCEED')]")
	WebElement pros;
	
	@FindBy(xpath="//div[@class='subScreenContent one smallHeight width700wd']//div[@class='subscreenTitel'][contains(text(),'Confirmation')]")
	WebElement cpcnf;
	@FindBy(xpath="//div[@id='MessageDiv'][contains(.,'Template edited successfully.')]")
	WebElement susmsg;
	
	@FindBy(xpath="//button[@class='btn active-btn subScreenClose'][contains(.,'close')]")
	WebElement sclose;
	
	@FindBy(xpath="//div[@id='loading']")
	WebElement Loading;
	
	
	
	public boolean savedata() throws InterruptedException, MessagingException
	{
		Topscrol();
		save.click();
		
		Thread.sleep(10000);
		boolean b=false;
		try {
			Thread.sleep(5000);
			b=pros.isDisplayed();
			System.out.println(b);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("btn not found");
		}
		if(b)
		{
			pros.click();
			Thread.sleep(5000);
		}
		
		WebDriverWait wt=new WebDriverWait(driver, 50);
		wt.until(ExpectedConditions.visibilityOf(otpbox));
		String otp="";
		otp=getotp.MailTestnew();
		if(otp.equalsIgnoreCase(" "))
		{
			Thread.sleep(30000);
			otp=getotp.MailTestnew();
		}
		System.out.println("returned otp is : " + otp);
		
		otpbox.sendKeys(otp);
		otpconf.click();
		
		try {
			WebDriverWait wt1=new WebDriverWait(driver, 180);
			wt1.until(ExpectedConditions.visibilityOf(susmsg));
			Thread.sleep(2000);
			scclose.click();
			System.out.println("close btn clicked");
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in otp or unable to proceed after otp");
			return false;
		}
	
	}
	
	public EditTemplatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkerr(String webel,String data) throws InterruptedException
	{ 
		System.out.println("in checkerr with " + webel +data);
		String ermsg=null;
		if(webel.equalsIgnoreCase("Max Packet Loss"))
		{
			ermsg=errform(Packet,erPacket,data);
		}
		if(webel.equalsIgnoreCase("Max Fwd Packetloss"))
		{
			ermsg=errform(FwdPacket,erFwdPacket,data);
		}
		if(webel.equalsIgnoreCase("Max Rev Packetloss"))
		{
			ermsg=errform(RevPacket,erRevPacket,data);
		}
		
		if(webel.equalsIgnoreCase("Jitter"))
		{
			ermsg=errform(Jitter,erJitter,data);
		}
		if(webel.equalsIgnoreCase("MOS Score"))
		{
			ermsg=errform(MOSScore,erMOSScore,data);
		}
		if(webel.equalsIgnoreCase("CKT Transmit Utilization"))
		{
			ermsg=errform(CKTTransmit,erCKTTransmit,data);
		}
		
		if(webel.equalsIgnoreCase("CKT Receive Utilization"))
		{
			ermsg=errform(CKTReceive,erCKTReceive,data);
		}
		if(webel.equalsIgnoreCase("Max Latency"))
		{
			ermsg=errform(Latency,erLatency,data);
		}
		if(webel.equalsIgnoreCase("Recompute Timer"))
		{
			ermsg=errform(Timer,erTimer,data);
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
		}
		
		return " ";
	}
	
	
	public String summaryform2(String thr,String Enc,String load,String pac,String a,String b,String c,String d,String e,String f,String g,String h,String i) throws InterruptedException
	{
	
		System.out.println("in summary form cross check");
		
		String msg="OK";
		
		if(!Thresholdd.getAttribute("value").equalsIgnoreCase(thr))
		msg=msg+thr+" ";
		if(!Encryptiond.getAttribute("value").equalsIgnoreCase(Enc))
			msg=msg+Enc+" ";
		if(!LoadBaldd.getAttribute("value").equalsIgnoreCase(load))
			msg=msg+load+" ";
		if(!packetReplication.getAttribute("value").equalsIgnoreCase(pac))
			msg=msg+pac+" ";
		if(!Packet.getAttribute("value").equalsIgnoreCase(a))
			msg=msg+a+" ";
		if(!FwdPacket.getAttribute("value").equalsIgnoreCase(b))
			msg=msg+b+" ";
		
		if(!RevPacket.getAttribute("value").equalsIgnoreCase(c))
			msg=msg+c+" ";
			if(!Jitter.getAttribute("value").equalsIgnoreCase(d))
				msg=msg+d+" ";
			if(!MOSScore.getAttribute("value").equalsIgnoreCase(e))
				msg=msg+e+" ";
			if(!CKTTransmit.getAttribute("value").equalsIgnoreCase(f))
				msg=msg+f+" ";
			if(!CKTReceive.getAttribute("value").equalsIgnoreCase(g))
				msg=msg+g+" ";
			if(!Latency.getAttribute("value").equalsIgnoreCase(h))
				msg=msg+h+" ";
			if(!Timer.getAttribute("value").equalsIgnoreCase(i))
				msg=msg+i+" ";			
		
			return msg;
	}
		public void summaryform(String thr,String Enc,String load,String pac,String a,String b,String c,String d,String e,String f,String g,String h,String i) throws InterruptedException
		{
		
			System.out.println("in summary form");
			WebDriverWait wtn=new WebDriverWait(driver, 180);
			wtn.until(ExpectedConditions.visibilityOf(Thresholdd));
			
			scrol(Thresholdd);
			Thresholdd.click();
			Thread.sleep(1000);
			
			clickxp("slaViolationAction",thr);
			Thread.sleep(2000);
			
			Encryptiond.click();
			Thread.sleep(1000);
			clickxp("encryption",Enc);
			Thread.sleep(2000);
			
			LoadBaldd.click();
			Thread.sleep(1000);
			clickxp("loadBalance",load);
			Thread.sleep(2000);
			
					
			if(load.equalsIgnoreCase("per-flow"))
			{
			packetReplication.click();
			Thread.sleep(1000);
			clickxp("packetReplication",pac);
			Thread.sleep(2000);
			}
			
			Packet.clear();
			Packet.sendKeys(a);
			FwdPacket.clear();
			FwdPacket.sendKeys(b);
			RevPacket.clear();
			RevPacket.sendKeys(c);
			Jitter.clear();
			Jitter.sendKeys(d);
			MOSScore.clear();
			MOSScore.sendKeys(e);
			CKTTransmit.clear();
			CKTTransmit.sendKeys(f);
			CKTReceive.clear();
			CKTReceive.sendKeys(g);
			Latency.clear();
			Latency.sendKeys(h);
			Timer.clear();
			Timer.sendKeys(i);			
			
			
			//Packetdd.click();
		}
	
		public void clickxp(String f,String ops)
		{
			System.out.println("in xp for " +  ops);
			String xpp="//div[@id='opened']//input[@formcontrolname='"+f+"']/..//li[contains(.,'"+ops+"')]";
			WebElement dd = driver.findElement(By.xpath(xpp));
			scrol(dd);
			dd.click();
		}
	public void MultiEdit(String poltype,String rulename) throws InterruptedException
	{
		
		WebDriverWait wt=new WebDriverWait(driver, 50);
		wt.until(ExpectedConditions.invisibilityOf(lod));
		Thread.sleep(1000);
		try {
			nocpclose.click();
			System.out.println("NO CPE Msg closed");
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("No CPE Erro msg not present");
		}
		
		// scroled to drop down
		//scrol(policydd);
		//System.out.println("scroled on dd");
		String hxp="//li[@id='"+rulename+"']//span[2]";
		//Thread.sleep(1000);
		jsclick(policydd);
		Thread.sleep(1000);
		if(poltype.equalsIgnoreCase("SDWAN"))
		{
			selectsd.click();
			//System.out.println("dd clicked");
			//scrol(policydd);
			//Thread.sleep(1000);
			WebElement exp = driver.findElement(By.xpath(hxp));
			scrol(exp);
			//System.out.println("scr on sd");
			exp.click();	
			//System.out.println(" sd clicked");
		}
		else 
			if(poltype.equalsIgnoreCase("QoS"))
			{
				selectqoc.click();
				//Thread.sleep(1000);
				WebElement exp = driver.findElement(By.xpath(hxp));
				exp.click();
			}
			else
			{
				System.out.println("Wrong policy type");
			}
		//System.out.println("end multi edit");
	}
	
	public void EditAddress(String  rule,String fet,String op,String appname,String appname2) throws InterruptedException
	{
		
		String EditAgroupxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Address')]//label[contains(.,'Address Groups')]";
		WebElement EditAG=driver.findElement(By.xpath(EditAgroupxp));
				
		String EditAddxp="(//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Add')])[2]//span";
		WebElement EditAdd=driver.findElement(By.xpath(EditAddxp));
//						
//		try {
//			nocpclose.click();
//			System.out.println("NO CPE Msg closed");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("No CPE Erro msg not present");
//		}
		
		//System.out.println("in Edit");
				
		if(fet.equalsIgnoreCase("Address Groups"))
			{
			System.out.println("for Address Groups");
				Addressop(rule,EditAG,op,fet,appname,appname2);
			}
		
		if(fet.equalsIgnoreCase("Address"))
				{
			System.out.println(" for Address");
					Addressop(rule,EditAdd, op,fet,appname,appname2);
				}
		Topscrol();
	}
	
	public String EditAddress2(String  rule,String fet,String op,String appname,String appname2) throws InterruptedException
	{
		
		
		String EditAgroupxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Address')]//label[contains(.,'Address Groups')]";
		WebElement EditAG=driver.findElement(By.xpath(EditAgroupxp));
				
		String EditAddxp="(//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Add')])[2]//span";
		WebElement EditAdd=driver.findElement(By.xpath(EditAddxp));
						
//		try {
//			nocpclose.click();
//			System.out.println("NO CPE Msg closed");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("No CPE Erro msg not present");
//		}
		String msg="OK";
		boolean stt=false;
		//System.out.println("in Edit");
				
		if(fet.equalsIgnoreCase("Address Groups"))
			{
				System.out.println("for Address Groups");
				stt=Addressop2(rule,EditAG,op,fet,appname,appname2);
			}
		
		if(fet.equalsIgnoreCase("Address"))
				{
				System.out.println(" for Address");
				stt=Addressop2(rule,EditAdd, op,fet,appname,appname2);
				}
		
		if(stt)
		{
			//return msg;
		}
		else
		{
			msg=appname +" " +appname2 +" for " + op +" Not Done";
			
		}
		Topscrol();
		return msg;
	}
	
	
	public String Editapp2(String  rule,String fet,String op,String apptype, String appname) throws InterruptedException
	{
	
		WebDriverWait wta=new WebDriverWait(driver, 180);
		wta.until(ExpectedConditions.visibilityOf(Add));
		
		String Editapxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Appli')]//label[contains(.,'App')]//span";
		WebElement Editapp=driver.findElement(By.xpath(Editapxp));
		
		String Editurlxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'URL')]//label[contains(.,'URL')]//span";
		WebElement EditURL=driver.findElement(By.xpath(Editurlxp));
		
		String EditDSCPxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'DSCP')]//label[contains(.,'DSCP')]//span";
		WebElement EditDSCP=driver.findElement(By.xpath(EditDSCPxp));
		
		String Editzonexp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Zones')]//label[contains(.,'Zones')]//span";
		//WebElement Editzone=driver.findElement(By.xpath(Editzonexp));
		
						
		try {
			nocpclose.click();
			System.out.println("NO CPE Msg closed");
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("No CPE Erro msg not present");
		}
		String msg="OK";
		boolean Status=false;
		
		//System.out.println("in Edit");
		if(fet.equalsIgnoreCase("Application"))
		{
			Status=opapp2(rule,Editapp, op,fet,apptype,appname);
		}
		
		if(fet.equalsIgnoreCase("URL"))
			{
			Status=opapp2(rule,EditURL, op,fet,apptype,appname);
			}
		
		if(fet.equalsIgnoreCase("DSCP"))
				{
			Status=opapp2(rule,EditDSCP, op,fet,apptype,appname);
			
				}
		
		if(fet.equalsIgnoreCase("Zones"))
		{
			WebElement Editzone=driver.findElement(By.xpath(Editzonexp));
			Status=neop2(rule,Editzone, op,fet,appname);
			//System.out.println(Status);
		}
		
		if(Status && op.equalsIgnoreCase("ADD"))
		{
			System.out.println(appname+ " App added and checked");
						//return msg;
		}
		else
			if(Status==false && op.equalsIgnoreCase("ADD"))
			{
				System.out.println(appname+ " App Not added and checked");
				msg=appname +" for " + op +" Not Done";
				//return msg;
			}
			
		if(Status && op.equalsIgnoreCase("Remove"))
		{
			System.out.println(appname+ " App Not Removed and checked");
			msg=appname +" for " + op +" Not Done";
			//return msg;
			//System.out.println(appname+ " App Removed and checked");
		}
		else
			if(Status==false && op.equalsIgnoreCase("Remove"))
			{
				//System.out.println(appname+ " App Not Removed and checked");
				System.out.println(appname+ " App Removed and checked");
				//return msg;
			}
		
		Topscrol();
		return msg;
	}
	// 1 Feture ftp as application 2 oparation op as ADD 3 apptype as Built in 4 app name 

	
	
	public void Editapp(String  rule,String fet,String op,String apptype, String appname) throws InterruptedException
	{
		
		System.out.println("in edit app");
		WebDriverWait wt=new WebDriverWait(driver, 180);
		wt.until(ExpectedConditions.invisibilityOf(Loading));
		
		Thread.sleep(2000);
		String Editapxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Appli')]//label[contains(.,'App')]//span";
		WebElement Editapp=driver.findElement(By.xpath(Editapxp));
		
		String Editurlxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'URL')]//label[contains(.,'URL')]//span";
		WebElement EditURL=driver.findElement(By.xpath(Editurlxp));
		
		String EditDSCPxp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'DSCP')]//label[contains(.,'DSCP')]//span";
		WebElement EditDSCP=driver.findElement(By.xpath(EditDSCPxp));
		
		String Editzonexp="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'Zones')]//label[contains(.,'Zones')]//span";
		//WebElement Editzone=driver.findElement(By.xpath(Editzonexp));
		
		
		System.out.println("after wait");
		try {
			nocpclose.click();
			System.out.println("NO CPE Msg closed");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No CPE Erro msg not present");
		}
		
		
		//System.out.println("in Edit");
		if(fet.equalsIgnoreCase("Application"))
		{
			opapp(rule,Editapp, op,fet,apptype,appname);
		}
		
		if(fet.equalsIgnoreCase("URL"))
			{
				opapp(rule,EditURL, op,fet,apptype,appname);
			}
		
		if(fet.equalsIgnoreCase("DSCP"))
				{
					opapp(rule,EditDSCP, op,fet,apptype,appname);
				}
		
		if(fet.equalsIgnoreCase("Zones"))
		{
			WebElement Editzone=driver.findElement(By.xpath(Editzonexp));
			neop(rule,Editzone, op,fet,appname);
		}
		
		Topscrol();
	}
	
	public boolean searchselect(WebElement search,String appname,int d) throws InterruptedException
	{
		search.sendKeys(appname);
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String xp="";
		if(d==1)
		{
			xp="//div[@class='col-sm-6 pp2-body ppr-r-b pb-4']//label[contains(text(),'"+appname+"')]";
		}
		if(d==2)
		{
			xp="//div[@class='col-sm-6 pp2-body  pb-4']//label[contains(text(),'"+appname+"')]";
		}
		
		try {
			WebElement ap=driver.findElement(By.xpath(xp));
			ap.click();
			System.out.println(appname + " is selected");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("App Not Present");
			//close.click();
			return false;
		}
	}
	
	public boolean searchselect2(WebElement search,String appname) throws InterruptedException
	{
		search.sendKeys(appname);
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
			String xp="//label[contains(text(),'"+appname+"')]";
		
		
		try {
			WebElement ap=driver.findElement(By.xpath(xp));
			ap.click();
			System.out.println(appname + " is selected");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("App Not Present");
			//close.click();
			return false;
		}
	}
	
	
	public void Addressop(String rule ,WebElement ele, String pro,String fet,String appname,String appname2) throws InterruptedException
	{
	
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(1000);
	
		scrol(ele);
		//Thread.sleep(2000);
		ele.click();
		
		if(pro.equalsIgnoreCase("ADD"))
		{
			scrol(Add);
			Add.click();
			System.out.println("for add");
		}else
			if(pro.equalsIgnoreCase("Remove"))
			{
				scrol(Add);
				remove.click();
				System.out.println("for remove");
			//return False;
			}
			else
			{
				System.out.println("Please correct oparatopn to perform");
				//return false;
			}
		
		Thread.sleep(1000);
		//String newfet=poptitle3.getText();
		//System.out.println(newfet);
		
//		if(newfet.contains(fet))
//		{
//			System.out.println("same popup opened");
//		}
//		else
//		{
//			System.out.println("Wrong popup opened");
//			//return false;
//		}
		
		boolean status1=false;
//		boolean status2=false;

		if(appname.equalsIgnoreCase(" "))
		{
			
		}
		else
		{
			searchselect(search1, appname,1);
		}
		if(appname2.equalsIgnoreCase(" "))
		{
			
		}
		else
		{
			searchselect(search2, appname2,2);
		}
		procbtn2.click();

		String st="";
		// cross check address
		if(appname.equalsIgnoreCase(" "))
		{
			
		}
		else
		{
			st="//div[@id='cOne']/..//div[@class='col-sm-6 b-r']//div[contains(text(),'"+appname+"')]";
			crosscheck(appname, st);
		}
		if(appname2.equalsIgnoreCase(" "))
		{
			
		}
		else
		{
			st="//div[@id='cOne']/..//div[@class='col-sm-6']//div[contains(text(),'"+appname2+"')]";
			crosscheck(appname2, st);
		}
	}

	public void BuiltinCheck(String rule ,WebElement ele, String pro,String fet,String appname,String appname2) throws InterruptedException
	{
	
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(3000);
	
		scrol(ele);
		Thread.sleep(2000);
		
		// div selected
		ele.click();
		
		boolean status1=false;
		boolean status2=false;
	}
	
	public boolean Addressop2(String rule ,WebElement ele, String pro,String fet,String appname,String appname2) throws InterruptedException
	{
	
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(1000);
	
		scrol(ele);
		//Thread.sleep(2000);
		
		// div selected
		ele.click();
		
		boolean status1=false;
		boolean status2=false;
		
		String st="";
		// cross check address
		if(appname.equalsIgnoreCase(" "))
		{
			status1=true;
			if(pro.equalsIgnoreCase("Remove"))
			{
				status1=false;
			}
			
		}
		else
		{
			System.out.println("sending name1 " + appname);
			st="//div[@id='cOne']/..//div[@class='col-sm-6 b-r']//div[contains(text(),'"+appname+"')]";
			status1=crosscheck(appname, st);
		}
		if(appname2.equalsIgnoreCase(" "))
		{
			status2=true;
			if(pro.equalsIgnoreCase("Remove"))
			{
				status2=false;
			}
		}
		else
		{
			System.out.println("sending name2 " + appname2);
			st="//div[@id='cOne']/..//div[@class='col-sm-6']//div[contains(text(),'"+appname2+"')]";
			status2=crosscheck(appname2, st);
		}
		
		if(pro.equalsIgnoreCase("ADD"))
			{
				if(status1==true && status2==true)
				{
					System.out.println(appname + " " +appname2 +" cross check done add added");
					return true;
				}
				if(status1==false || status2==false)
				{
					System.out.println(appname + " " +appname2 +" cross check done App Not Added");
					return false;
				}
					
			}
		
				if(pro.equalsIgnoreCase("Remove"))
				{
					if(status1==false && status2==false)
					{
						System.out.println(appname + " " +appname2 +" cross check done App removed");
						return true;
					}
					if(status1==true || status2==true)
					{
						System.out.println(appname + " " +appname2 +" App Not Removed and checked");
						return false;
					}
				}
				System.out.println("unable to cross chack");
				return false;
	}

	
	public boolean crosscheck(String appname,String xp2) throws InterruptedException
	{
		//String xp2="//div[@id='cOne']/..//div[contains(text(),'"+appname+"')]";
		try {
			WebElement addedel=driver.findElement(By.xpath(xp2));
			scrol(addedel);
			Thread.sleep(1000);
			String addedap=addedel.getText();
				
			System.out.println(addedap);
			if(appname.equalsIgnoreCase(addedap))
			{
				System.out.println(appname+" App added ");
				return true;
			}
			else
			{
				System.out.println(appname+" App Not added ");
				return false;
			}	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(appname+" App Not added elemet not found");
			return false;
		}
		
	}
	
	public boolean neop(String rule ,WebElement ele, String pro,String fet,String appname) throws InterruptedException
	{
	
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(3000);
	
		scrol(ele);
		Thread.sleep(2000);
		ele.click();
		
		if(pro.equalsIgnoreCase("ADD"))
		{
			scrol(Add);
			Add.click();
			System.out.println("for add");
		}else
			if(pro.equalsIgnoreCase("Remove"))
			{
				scrol(Add);
				remove.click();
				System.out.println("for remove");
			//return False;
			}
			else
			{
				System.out.println("Please correct oparatopn to perform");
				//return false;
			}
		
		Thread.sleep(1000);
//		String newfet=poptitle2.getText();
//		System.out.println(newfet);
//		
//		if(newfet.contains(fet))
//		{
//			System.out.println("same popup opened");
//		}
//		else
//		{
//			System.out.println("Wrong popup opened");
//			//return false;
//		}
	
		boolean status = searchselect2(searchzone, appname);
		
		if(status!=true)
		{
			System.out.println("stop");
			//return false;
		}
		else
		{
		procbtn2.click();
		System.out.println("procide done");
		}
		
		try {

			String xp2="//div[@id='cOne']/..//div[contains(text(),'"+appname+"')]";
			WebElement addedel=driver.findElement(By.xpath(xp2));
			scrol(addedel);
			Thread.sleep(1000);
			String addedap=addedel.getText();
				
			System.out.println(addedap);
			if(appname.equalsIgnoreCase(addedap))
			{
				System.out.println("App added ");
				return true;
			}
			else
			{
				System.out.println("App Not added ");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(appname + " from catch ele not present");
			return false;
		}
		
		
	}

	public boolean neop2(String rule ,WebElement ele, String pro,String fet,String appname) throws InterruptedException
	{
	
		WebDriverWait wt=new WebDriverWait(driver, 180);
		wt.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(3000);
	
		scrol(ele);
		Thread.sleep(2000);
		ele.click();
		
		try {
			String xp2="//div[@id='cOne']/..//div[contains(text(),'"+appname+"')]";
			WebElement addedel=driver.findElement(By.xpath(xp2));
			scrol(addedel);
			Thread.sleep(1000);
			String addedap=addedel.getText();
				
			System.out.println(addedap);
			if(appname.equalsIgnoreCase(addedap))
			{
				System.out.println("App added ");
				return true;
			}
			else
			{
				System.out.println("App Not added ");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found from catch");
			return false;
		}
	}
	public boolean opapp2(String rule ,WebElement ele, String pro,String fet,String apptype,String appname) throws InterruptedException
	{
		
		WebDriverWait wt=new WebDriverWait(driver, 180);
		wt.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(3000);
	
		scrol(ele);
		Thread.sleep(2000);
		ele.click();
		
				
	if(fet.equalsIgnoreCase("DSCP"))
	{
		// dscp flow
		String xp="//label[contains(text(),'"+appname+"')]";
		
		try {
//			WebElement ap=driver.findElement(By.xpath(xp));
//			scrol(ap);
//			ap.click();
//			procbtn.click();
			
			String xp3="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'DSCP')]//div[@class='DSCP-item']";
			
			List<WebElement> DSCPlist = driver.findElements(By.xpath(xp3));
			int cnt=0;
			for (WebElement webele : DSCPlist) {
				if(appname.equalsIgnoreCase(webele.getText()))
						{
							cnt=cnt+1;
						}
			}
			if(cnt==0)
			{
				if(pro.equalsIgnoreCase("ADD"))
				{
					System.out.println(appname + " DSCP Not added");
					return false;
					
				}else
					if(pro.equalsIgnoreCase("Remove"))
					{
						System.out.println(appname + " DSCP Removed");
						//return true;
						return false;
					}
			}
			else
				if(cnt==1)
				{
					if(pro.equalsIgnoreCase("ADD"))
					{
						System.out.println(appname + " DSCP added");
						return true;
					}else
						if(pro.equalsIgnoreCase("Remove"))
						{
							System.out.println(appname + " DSCP Not Removed");
							return true;
						}
				}
				else
				{
					System.out.println(appname + " DSCP added " + cnt +" times");
					return true;
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" App Not Present ");
			//close.click();
			return false;
		}
	}
	else
	{
		//jsclick(policydd);
		//policydd.click();
		
	//	"//li[@id='Rule-COS-4']//div[@class='cd'][contains(.,'DSCP')]//div[@class="DSCP-item"][contains(.,'44')]"
		
		
		
		//cross check
		
		String xp4="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'"+fet+"')]//label[contains(.,'"+apptype+"')]//span";
		try {
		
			WebElement aptyp = driver.findElement(By.xpath(xp4));
			scrol(aptyp);
			Thread.sleep(1000);
			aptyp.click();
			Thread.sleep(1000);
			
			String xp2="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'"+fet+"')]//div[@class='cd-bd-items fixed-Hgt']//div//div[contains(.,'"+appname+"')]";
			WebElement addedel=driver.findElement(By.xpath(xp2));
			scrol(addedel);
			Thread.sleep(1000);
			String addedap=addedel.getText();
				
			System.out.println(addedap);
			
			if(appname.equalsIgnoreCase(addedap))
			{
				System.out.println("App added ");
				return true;
			}
			else
			{
				System.out.println("App Not added ");
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("App Not added element not found");
			return false;
		}
		
		
	}	
		return false;
	}
	
	public boolean opapp(String rule ,WebElement ele, String pro,String fet,String apptype,String appname) throws InterruptedException
	{
		//scrol(ele);
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(3000);
	//	System.out.println("Scroling");
		scrol(ele);
		Thread.sleep(2000);
		ele.click();
		
		if(pro.equalsIgnoreCase("ADD"))
		{
			scrol(Add);
			Add.click();
			System.out.println("for add");
		}else
			if(pro.equalsIgnoreCase("Remove"))
			{
				scrol(Add);
				remove.click();
				System.out.println("for remove");
			//return False;
		}
			else
			{
				System.out.println("Please correct oparatopn to perform");
				//return false;
			}
		
		Thread.sleep(1000);
//		String newfet=poptitle.getText();
//		System.out.println(newfet);
//		
//		if(newfet.contains(fet))
//		{
//			System.out.println("same popup opened");
//		}
//		else
//		{
//			System.out.println("Wrong popup opened");
//			return false;
//		}
		
	if(fet.equalsIgnoreCase("DSCP"))
	{
		// dscp flow
		String xp="//label[contains(text(),'"+appname+"')]";
		
		try {
			WebElement ap=driver.findElement(By.xpath(xp));
			scrol(ap);
			ap.click();
			procbtn.click();
			
			String xp3="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'DSCP')]//div[@class='DSCP-item']";
			
			List<WebElement> DSCPlist = driver.findElements(By.xpath(xp3));
			int cnt=0;
			for (WebElement webele : DSCPlist) {
				if(appname.equalsIgnoreCase(webele.getText()))
						{
							cnt=cnt+1;
						}
			}
			if(cnt==0)
			{
				if(pro.equalsIgnoreCase("ADD"))
				{
					System.out.println(appname + " DSCP Not added");
				}else
					if(pro.equalsIgnoreCase("Remove"))
					{
						System.out.println(appname + " DSCP Removed");
					}
			}
			else
				if(cnt==1)
				{
					if(pro.equalsIgnoreCase("ADD"))
					{
						System.out.println(appname + " DSCP added");
					}else
						if(pro.equalsIgnoreCase("Remove"))
						{
							System.out.println(appname + " DSCP Not Removed");
						}
				}
				else
				{
					System.out.println(appname + " DSCP added " + cnt +" times");
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" App Not Present ");
			//close.click();
			return false;
		}
	}
	else
	{
		//jsclick(policydd);
		//policydd.click();
		Thread.sleep(1000);
		appdd.click();
		Thread.sleep(1000);
		if(apptype.equalsIgnoreCase("Built"))
		{
			selectbuilt.click();
		}else
			if(apptype.equalsIgnoreCase("User"))
			{
				selectuser.click();
			}else
			{
				System.out.println("App type not present");
				return false;
			}
		
		searchapp.sendKeys(appname);
		Thread.sleep(1000);
		searchapp.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String xp="//label[contains(text(),'"+appname+"')]";
		try {
			WebElement ap=driver.findElement(By.xpath(xp));
			ap.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("App Not Present");
			//close.click();
			return false;
		}
	//}	
		procbtn.click();
		System.out.println("procide done");
		
		if(apptype.equalsIgnoreCase("User") && fet.equalsIgnoreCase("Application"))
		{
			Thread.sleep(3000);
			String msg=appadmsg.getText();
			System.out.println(msg);
			
			if(msg.equalsIgnoreCase("Addition of some applications failed, those added successfully shall appear in the list."))
			{
				System.out.println("App adding failed");
			}
			else
			{
				WebDriverWait wt1=new WebDriverWait(driver, 50);
				wt1.until(ExpectedConditions.visibilityOf(succ));
				scclose.click();
			}
		}
		
	//	"//li[@id='Rule-COS-4']//div[@class='cd'][contains(.,'DSCP')]//div[@class="DSCP-item"][contains(.,'44')]"
		
		
		
		//cross check
		
		String xp4="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'"+fet+"')]//label[contains(.,'"+apptype+"')]//span";
		WebElement aptyp = driver.findElement(By.xpath(xp4));
		scrol(aptyp);
		Thread.sleep(1000);
		aptyp.click();
		Thread.sleep(1000);
		
		
		try {

			String xp2="//li[@id='"+rule+"']//div[@class='cd'][contains(.,'"+fet+"')]//div[@class='cd-bd-items fixed-Hgt']//div//div[contains(.,'"+appname+"')]";
			WebElement addedel=driver.findElement(By.xpath(xp2));
			scrol(addedel);
			Thread.sleep(1000);
			String addedap=addedel.getText();
				
			System.out.println(addedap);
			
			if(appname.equalsIgnoreCase(addedap))
			{
				System.out.println("App added ");
			}
			else
			{
				System.out.println("App Not added ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(appname +" in catch Element not found");
		}
		
	}	
		return false;
		
	}
	
	public boolean openpolicy(String polname)
	{
//		policydd.click();
//		Thread.sleep(1000);
//		if(pol.equalsIgnoreCase("Qos"))
//		{
//			selectqoc.click();
//		}
//		else
//			if(pol.equalsIgnoreCase("SDWAN"))
//			{
//				selectsd.click();
//			}else
//			{
//				System.out.println("Enter valid policy");
//			}
		
		// no need to do above code coz from policy tab navigation particular policy get expanded automatically
		
		
		String xp="//li[@id='"+polname+"']//span[2]";
		String clas=driver.findElement(By.xpath(xp)).getAttribute("class");
		
		System.out.println(clas +"is current class");
		
		if(clas.contains("icDown"))
		{
			System.out.println(polname+ "policy not expanded ");
			return false;
			
		}
		else
		{
			return true;
		}
	}
	
	
	
	public boolean EditAlias(String al)
	{
		
		alias.sendKeys(al);
		alias.sendKeys(Keys.TAB);
		String newal=alias.getAttribute("value");
		System.out.println(newal);
		if(al.equalsIgnoreCase(newal))
		{
			System.out.println("alise updated ");
			return true;
		}
		else
		{
			System.out.println("alise Not updated ");
			return false;
		}
	}
	
	
}
