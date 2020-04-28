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
import POM.EditCPage;
import POM.HomePage;
import POM.LoginPage;
import POM.SitelistPage;
import POM.TemplatePage;

@Listeners(LISTENERS.ResList.class)
public class CPEsTest extends TestBase{

	HomePage Hp;
	LoginPage Lp;
	CPEsPage Cp;
	EditCPage C;
	TemplatePage Tp;
	EditCPage CPE;
	
	public CPEsTest()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void start()
	{
		init();
		Lp=new LoginPage();
	}

			@Test
			public void CPE_Goto_Template_Navigation() throws InterruptedException
			{
				Hp=Lp.login();
				Thread.sleep(15000);
				Cp=Hp.VACPEs();
				Thread.sleep(10000);
				Tp=Cp.gototemp();
				Thread.sleep(5000);
				assertEquals(Tp.pageheding(),"TEMPLATES","Not Land on CPE Page");
				System.out.println("Land On Template ");
			}
			
		@Test
			public void CPE_Goto_selected_Template_Navigation() throws InterruptedException
			{
				String data="5G-Dell";
				Hp=Lp.login();
				Thread.sleep(15000);
				Cp=Hp.VACPEs();
				Thread.sleep(10000);
				Tp=Cp.gototemp(data);
				Thread.sleep(5000);
				String exp="("+data.toUpperCase()+")";
				assertEquals(Tp.pageheding2(data),exp,"Not Land on CPE Page");
				System.out.println("Land On Template " + data);
								
			}
	
			
		
			@Test(priority=1)
			public void CPEPage_Edit_Alis() throws InterruptedException, EncryptedDocumentException, IOException
			{
				String Name="cpe";
				String Alname="newCPEone";
				Hp=Lp.login();
				Thread.sleep(15000);
				Cp=Hp.VACPEs();
				Thread.sleep(10000);
				int searchcnt=Cp.searchdata(Name);
				boolean rs=false;
				if(searchcnt>0)
				{
					
					rs=Cp.changealias(Alname);
					System.out.println(rs);
					if(rs)
					{
					UTIL.ExcelProgram.updateResult("pass","CPEPage_Edit_Alis",Alname + " change as alias ", "Passed", "");
					}
					else
					{
						UTIL.ExcelProgram.updateResult("error","CPEPage_Edit_Alis",Alname + " unable to change as alias ", "Failed", "");
					}
				}
				else
				{
					
					UTIL.ExcelProgram.updateResult("error","CPEPage_Edit_Alis",Alname + " unable to change as alias ", "Failed", "");
					assertEquals(true, false,"app not found");
				}
				
			}

			@Test(priority=2)
			public void CPEPage_Row_Edit_Alis() throws InterruptedException, EncryptedDocumentException, IOException
			{
				
				String Name="cpe";
				String Alname="newCPEs";
				Hp=Lp.login();
				Thread.sleep(15000);
				Cp=Hp.VACPEs();
				Thread.sleep(10000);
				int searchcnt=Cp.searchdata(Name);
				boolean rs=false;
				if(searchcnt>0)
				{
					CPE=Cp.clickeditrow();
					Thread.sleep(5000);
					Cp=CPE.filldata(Alname);
					Thread.sleep(10000);
					Cp.searchdata(Alname);
					Thread.sleep(1000);
					String rss=Cp.getalisname();
					
					if(rss.equalsIgnoreCase(Alname))
					{
						System.out.println(rss + "from site");
						UTIL.ExcelProgram.updateResult("pass","CPEPage_Row_Edit_Alis",Alname + " change as alias ", "Passed", "");
					}else
					{
						UTIL.ExcelProgram.updateResult("error","CPEPage_Row_Edit_Alis",Alname + " unable to change as alias ", "Failed", "");
					}
					
				}
				else
				{
					UTIL.ExcelProgram.updateResult("error","CPEPage_Row_Edit_Alis",Alname + " unable to change as alias ", "Failed", "");
					assertEquals(true, false,"app not found");
				}
			}


	
	@Test
	public void CPE_Count() throws InterruptedException
	{
		Hp=Lp.login();
		Thread.sleep(15000);
		int online=Integer.valueOf(Hp.cpesgetvalofonline());
		int ofline=Integer.valueOf(Hp.cpesgetvalofofonline());
		
		Cp=Hp.VACPEs();
		Thread.sleep(10000);
		String sdata="Online";		
		int cnt=Cp.searchf(sdata);
		searchhelp(cnt, online);
		
		sdata="Offline";		
		cnt=Cp.searchf(sdata);
		searchhelp(cnt, ofline);
	}
	
	public void searchhelp(int cnt,int sitedata)
	{
		assertEquals(cnt,sitedata,"search count missmatch");
	}
	
	@Test
	public void CPE_search() throws InterruptedException
	{
		String str="india"; 
		Hp=Lp.login();
		Thread.sleep(15000);
		Cp=Hp.VACPEs();
		Thread.sleep(10000);
		int ans = Cp.searchdata(str);
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
	}
	@AfterMethod
	public void end()
	{
		driver.close();
	}
}
