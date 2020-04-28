package TESTS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BASE.TestBase;
import POM.CPEsPage;
import POM.EditCPEsPage;
import POM.HomePage;
import POM.LoginPage;
import POM.SitelistPage;
import POM.TemplatePage;

@Listeners(LISTENERS.ResList.class)
public class siteTest extends TestBase{

	HomePage Hp;
	LoginPage Lp;
	SitelistPage Sp;
	EditCPEsPage ECPE;
	CPEsPage Cp;
	TemplatePage Tp;
	
	public siteTest()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void start()
	{
		init();
		Lp=new LoginPage();
		
	}
// Navigations
	@Test(priority=7)
		public void Goto_Template_Navigation() throws InterruptedException
		{
			Hp=Lp.login();
			Thread.sleep(15000);
			Sp=Hp.VASites();
			Thread.sleep(10000);
			Tp=Sp.gototemp();
			Thread.sleep(5000);
			assertEquals(Tp.pageheding(),"TEMPLATES","Not Land on CPE Page");
			assertEquals(Tp.showall(),"disable","Show all Button is Active ");
		}
		
	@Test(priority=8)
		public void Goto_selected_Template_Navigation() throws InterruptedException
		{
			String data="cpe";
			Hp=Lp.login();
			Thread.sleep(15000);
			Sp=Hp.VASites();
			Thread.sleep(10000);
			Tp=Sp.gototemp(data);
			Thread.sleep(5000);
			String exp="("+data.toUpperCase()+")";
			System.out.println(Tp.pageheding2(data));
			assertEquals(Tp.pageheding2(data),exp,"Not Land on CPE Page");
			
			assertEquals(Tp.showall(),"enable","Show all Button is Not Active ");			
		}
	
	@Test(priority=5)
	public void Goto_CPE_Navigation() throws InterruptedException
	{
		Hp=Lp.login();
		Thread.sleep(15000);
		Sp=Hp.VASites();
		Thread.sleep(10000);
		Cp=Sp.gotocpe();
		Thread.sleep(5000);
		assertEquals(Cp.pageheding(),"CPEs","Not Land on CPE Page");
		assertEquals(Cp.showall(),"disable","Show all Button is Active ");
	}
	
	@Test(priority=6)
	public void Goto_selected_CPE_Navigation() throws InterruptedException
	{
		String data="cpe";
		Hp=Lp.login();
		Thread.sleep(15000);
		Sp=Hp.VASites();
		Thread.sleep(10000);
		Cp=Sp.gotocpe(data);
		Thread.sleep(5000);
		String exp="("+data.toUpperCase()+")";
		assertEquals(Cp.pageheding2(data),exp,"Not Land on CPE Page");
	assertEquals(Cp.showall(),"enable","Show all Button is Not Active ");
		
	}
	
	//Alias Operations 
	@Test(priority=1)
	public void SitePage_Edit_Site_Alis() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String Name="cpe";
		String Alname="newCPE";
		Hp=Lp.login();
		Thread.sleep(15000);
		Sp=Hp.VASites();
		Thread.sleep(10000);
		int searchcnt=Sp.searchdata(Name);
		boolean rs=false;
		if(searchcnt>0)
		{
			
			rs=Sp.changealias(Alname);
			System.out.println(rs);
			if(rs)
			{
			UTIL.ExcelProgram.updateResult("pass","SitePage_Edit_Site_Alis",Name + " change as alias ", "Passed", "");
			}
			else
			{
				UTIL.ExcelProgram.updateResult("error","SitePage_Edit_Site_Alis",Name + " unable to change as alias ", "Failed", "");
			}
		}
		else
		{
			
			UTIL.ExcelProgram.updateResult("error","SitePage_Edit_Site_Alis",Name + " unable to change as alias ", "Failed", "");
			assertEquals(true, false,"app not found");
		}
		
	}

	@Test(priority=2)
	public void Row_Edit_Site_Alis() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		String Name="cpe";
		String Alname="newCPEs";
		Hp=Lp.login();
		Thread.sleep(15000);
		Sp=Hp.VASites();
		Thread.sleep(10000);
		int searchcnt=Sp.searchdata(Name);
		boolean rs=false;
		if(searchcnt>0)
		{
			ECPE=Sp.clickeditrow();
			Thread.sleep(5000);
			Sp=ECPE.filldata(Alname);
			Thread.sleep(10000);
			Sp.searchdata(Alname);
			Thread.sleep(1000);
			String rss=Sp.getalisname();
			
			if(rss.equalsIgnoreCase(Alname))
			{
				System.out.println(rss + "from site");
				UTIL.ExcelProgram.updateResult("pass","SitePage_Edit_Site_Alis",Alname + " change as alias ", "Passed", "");
			}else
			{
				UTIL.ExcelProgram.updateResult("error","SitePage_Edit_Site_Alis",Alname + " unable to change as alias ", "Failed", "");
			}
			
		}
		else
		{
			UTIL.ExcelProgram.updateResult("error","SitePage_Edit_Site_Alis",Alname + " unable to change as alias ", "Failed", "");
			assertEquals(true, false,"app not found");
		}
	}

	
	@Test(priority=3)
	public void sitePage_count() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String passmsg=""; 
		Hp=Lp.login();
		Thread.sleep(15000);
		int online=Integer.valueOf(Hp.sitegetvalofonline());
		int ofline=Integer.valueOf(Hp.sitegetvalofofonline());
		int deg=Integer.valueOf(Hp.sitegetvalofdeg());
		
		Sp=Hp.VASites();
		Thread.sleep(10000);
		String sdata="Online";		
		int cnt=Sp.searchf(sdata);
		searchhelp(cnt, online);
		
		sdata="Offline";		
		cnt=Sp.searchf(sdata);
		searchhelp(cnt, ofline);
		
		sdata="Degraded";		
		cnt=Sp.searchf(sdata);
		searchhelp(cnt, deg);
		
		passmsg=passmsg+" online "+Integer.toString(online)+" ofline "+Integer.toString(ofline)+" degreded "+Integer.toString(deg);
		System.out.println("saving xl");
		UTIL.ExcelProgram.updateResult("pass","sitePage_count",passmsg, "Passed", "");
	}
	
	public void searchhelp(int cnt,int sitedata)
	{
		assertEquals(cnt,sitedata,"search count missmatch");
	}
	
	@Test(priority=4)
	public void Search_Test() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String str="india"; 
		Hp=Lp.login();
		Thread.sleep(15000);
		Sp=Hp.VASites();
		Thread.sleep(10000);
		int ans = Sp.searchdata(str);
		boolean rs=true;
		if(ans>0)
		{
			System.out.println(str +" found " + ans + " times");
		}
		else
		{
			System.out.println(str + " Not found");
			rs=false;
		}
		assertEquals(rs	, true,"search result not found");
		UTIL.ExcelProgram.updateResult("pass","Search_Test "," India searched", "Passed", "");
	}
	
	@AfterMethod
	public void end()
	{
		driver.close();	
	}
}