package TESTS;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BASE.TestBase;
import POM.CPEsPage;
import POM.HomePage;
import POM.LoginPage;
import POM.PoliciesPage;
import POM.SitelistPage;

public class PolicyTest extends TestBase{

	HomePage Hp;
	LoginPage Lp;
	PoliciesPage Pp;
	
	public PolicyTest()
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
	public void seach() throws InterruptedException
	{
		Hp=Lp.login();
		Thread.sleep(15000);
		int SDWAN=Integer.valueOf(Hp.polgetvalofsdwan());
		int Qos=Integer.valueOf(Hp.polgetvalofqos());
	
		
		Pp=Hp.VAAllPol();
		Thread.sleep(10000);
		String sdata="QoS";		
		int cnt=Pp.searchf(sdata);
		searchhelp(cnt, Qos);
		
		sdata="Offline";		
		cnt=Pp.searchf(sdata);
		searchhelp(cnt, SDWAN);
				
	}
	public void searchhelp(int cnt,int sitedata)
	{
		assertEquals(cnt,sitedata,"search count missmatch");
	}
	@AfterMethod
	public void end()
	{
		driver.close();
	}
}
