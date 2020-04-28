package TESTS;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BASE.TestBase;
import POM.AdminPage;
import POM.AllAppPage;
import POM.BuildInAppPage;
import POM.CPEsPage;
import POM.HomePage;
import POM.InventoryPage;
import POM.LoginPage;
import POM.PoliciesPage;
import POM.SitelistPage;
import POM.UDAppPage;
import POM.polQosPage;
import POM.polSDWANPage;

@Listeners(LISTENERS.ResList.class)
public class DashboardTest extends TestBase {

	HomePage Hp;
	LoginPage Lp;
	AdminPage Ap;
	InventoryPage Ip;
	SitelistPage Sp;
	
	CPEsPage Cp;
	
	AllAppPage Alp;
	UDAppPage UDAp;
	BuildInAppPage BAp;
	
	PoliciesPage Pp;
	polQosPage PQp;
	polSDWANPage PSp;
	
	
	
	public DashboardTest()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void start()
	{
		init();
		Lp=new LoginPage();
	}

	@Test(groups={"logout"},priority=1)
		public void DashboardPage_Logout() throws InterruptedException
		{
			System.out.println("LogOut Test Running");
			Hp=Lp.login();
			Thread.sleep(3000);
			Lp=Hp.logout();
			Thread.sleep(3000);
			//System.out.println(Lp.Logintxt());
			assertEquals(Lp.Logintxt(), "Let's start configuring your service!"); 
		}

	//**************** MAIN TABS NAVIGATIONS *****************//
	// Navigate to Dashboard
	@Test(groups={"NAV"},priority=2)
	public void DashboardPage_gotoDashboard() throws InterruptedException
	{
		System.out.println("Dashboard Navigation Test Running");
		Hp=Lp.login();
		Thread.sleep(3000);
		String	pgh=Hp.pageheding();
		assertEquals(pgh, "Dashboard");
	}
	
	// Navigate to Admin
	@Test(groups={"NAV"},priority=3)
	public void DashboardPage_gotoAdmin() throws InterruptedException
	{
		System.out.println("Admin Navigation Test Running");
		Hp=Lp.login();
		Thread.sleep(3000);
		Ap=Hp.Admin();
		String	pgh=Ap.pageheding();
		assertEquals(pgh, "Internal StakeHolder");
	}
	
	// Navigate to Inventory
	@Test(groups={"NAV"},priority=4)
	public void DashboardPage_gotoInventory() throws InterruptedException
	{
		System.out.println("Inventory Navigation Test Running");
		Hp=Lp.login();
		Thread.sleep(3000);
		Ip=Hp.Invent();
		String	pgh=Ip.pageheding();
		assertEquals(pgh, "View & Manage your Inventory");
	}
	
	
//**********view all*************// 
	
	// for sites landing from view all
	@Test(groups={"VA","sites"},priority=5)
	public void DashboardPage_Site_viewall() throws InterruptedException
	{
		System.out.println("Site view All and count check Test Running");
		boolean f2=false;
		Hp=Lp.login();
		Thread.sleep(15000);
		System.out.println("on dashboard");
		String online=Hp.sitegetvalofonline();
		String ofline=Hp.sitegetvalofofonline();
		String deg=Hp.sitegetvalofdeg();
		
		int total=Integer.valueOf(Hp.getvalofallsite());
		System.out.println(total + " is the site total");
		int On=Integer.valueOf(online);
		int Of=Integer.valueOf(ofline);
		int D=Integer.valueOf(deg);
		int newtotal=On+Of+D;
		System.out.println("new total is " + newtotal);
		assertEquals(total, newtotal, "total at site missmatch");
		System.out.println("done");
		Sp=Hp.VASites();
		Thread.sleep(3000);
		String st=Sp.pageheding();
		if(Sp.pageheding().contains("Degraded"))
		{
			f2=true;
		}
		assertEquals(f2,true,"not navigated on sitelist page ");
		Thread.sleep(5000);
		
		boolean f=true;
		String msg="site count missmatch at :- ";
	
//		System.out.println(Sp.getCount(1) +" "+ online);
//		System.out.println(Sp.getCount(2) +" "+ ofline);
//		System.out.println(Sp.getCount(3) +" "+ deg);
		
		if(!Sp.getCount(1).equalsIgnoreCase(online))
		{
			 msg=msg+" Online";
			 f=false;
			 System.out.println(msg);
		}
		if(!Sp.getCount(2).equalsIgnoreCase(ofline))
		{
			msg=msg+" Offline";
			f=false;
			System.out.println(msg);
		}	
		if(!Sp.getCount(3).equalsIgnoreCase(deg))
		{
			msg=msg+" Degrade";
			f=false;
			System.out.println(msg);
		}
		assertEquals(true, f,msg);
	}
	
	
	
	
	// for CPEs landing from view all 
		@Test(groups={"VA","cpes"},priority=6)
		public void DashboardPage_CPEs_viewall() throws InterruptedException
		{
			System.out.println("CPEs view All and count check Test Running");
			boolean f=false;
			Hp=Lp.login();
			Thread.sleep(10000);
			System.out.println("on dashboard");
			int total=Integer.valueOf(Hp.getvalofallcpes());
			
			String online=Hp.cpesgetvalofonline();
			String ofline=Hp.cpesgetvalofofonline();
			int On=Integer.valueOf(online);
			int Of=Integer.valueOf(ofline);
			int newtotal=On+Of;
			System.out.println("new total is "+newtotal);
			
			assertEquals(total, newtotal, "total at site missmatch");
			System.out.println("done");
			
			Cp=Hp.VACPEs();
			if(Cp.pageheding().contains("CPEs"))
			{
				f=true;
			}
			assertEquals(f,true,"not navigated on sitelist page ");
			Thread.sleep(5000);
			//boolean f=true;
			String msg="CPEs count missmatch at :- ";
		
//			System.out.println(Cp.getCount(1) +" "+ online);
//			System.out.println(Cp.getCount(2) +" "+ ofline);
			
			if(!Cp.getCount(1).equalsIgnoreCase(online))
			{
				 msg=msg+" Online";
				 f=false;
				 System.out.println(msg);
			}
			if(!Cp.getCount(2).equalsIgnoreCase(ofline))
			{
				msg=msg+" Offline";
				f=false;
				System.out.println(msg);
			}	
			assertEquals(true, f,msg);		
		}

		
//***** Application 3 view all with landing and count check		
//1		 for App landing from view all 
		@Test(groups={"VA","app"},priority=7)
		public void DashboardPage_App_viewall() throws InterruptedException
		{
			System.out.println("Application view All and count check Test Running");
			boolean f=false;
			Hp=Lp.login();
			Thread.sleep(15000);
			String cntfromhomepage=Hp.getvalofallap();
			String ud=Hp.getvalofudap();
			String bd=Hp.getvalofbap();
			int total=Integer.valueOf(cntfromhomepage);
			int On=Integer.valueOf(ud);
			int Of=Integer.valueOf(bd);
			int newtotal=On+Of;
			System.out.println("new total is "+newtotal);
			
			assertEquals(total, newtotal, "total at Application missmatch");
			System.out.println("done");
			
			Alp=Hp.VAAllApp();
			if(Alp.pageheding().contains("Select Application Type"))
			{
				f=true;
			}
			assertEquals(f,true,"not navigated on sitelist page ");

			// to check number of count and confirm from dashboard
						String cntfromdetailpg=Alp.getCount();
						assertEquals(cntfromdetailpg, cntfromhomepage,"All application count mismatch");
		}
		
//2 							//App user defined view all click
								@Test(groups={"VA","app"},priority=8)
								public void DashboardPage_App_UserDefined_viewall() throws InterruptedException
								{
									System.out.println("User defined Application view All and count check Test Running");
									Hp=Lp.login();
									Thread.sleep(15000);
									String cntfromhomepage=Hp.getvalofudap();
									UDAp=Hp.VAAlluApp();	
									assertEquals(UDAp.pageheding(),true,"not navigated on sitelist page ");
									
									// to check number of count and confirm from dashboard
									String cntfromdetailpg=UDAp.getCount();
									assertEquals(cntfromdetailpg, cntfromhomepage,"User defined application count mismatch");
								
								}
						
//3						//App Built in view all click
						@Test(groups={"VA","app"},priority=9)
						public void DashboardPage_App_BuiltIn_viewall() throws InterruptedException
						{
							System.out.println("Built In Application view All and count check Test Running");
							Hp=Lp.login();
							Thread.sleep(15000);
							String cntfromhomepage=Hp.getvalofbap();
							BAp=Hp.VAAllbApp();	
							assertEquals(BAp.pageheding(),true,"not navigated on sitelist page ");
							
							// to check number of count and confirm from dashboard
										String cntfromdetailpg=BAp.getCount();
										assertEquals(cntfromdetailpg, cntfromhomepage,"Built in application count mismatch");
										
										//go to al
										BAp.allclick();
						}

		//App All view all click no need this method
		//@Test(groups={"VA","app"},priority=10)
		public void DashboardPage_App_AllApp_viewall() throws InterruptedException
		{
			Hp=Lp.login();
			Thread.sleep(15000);
			String cntfromhomepage=Hp.getvalofbap();
			Alp=Hp.VAAllApp();	
			assertEquals(Alp.pageheding2(),true,"not navigated on sitelist page ");
		}

		
		// for Policies
				@Test(groups={"VA","pol"},priority=10)
				public void DashboardPage_Policy_viewall() throws InterruptedException
				{
					System.out.println("Policy view All and count check Test Running");
					boolean f=false;
					Hp=Lp.login();
					Thread.sleep(15000);
					String cntfromhomepage=Hp.getvalofallpol();
					String ud=Hp.polgetvalofqos();
					String bd=Hp.polgetvalofsdwan();
					int total=Integer.valueOf(cntfromhomepage);
					int On=Integer.valueOf(ud);
					int Of=Integer.valueOf(bd);
					int newtotal=On+Of;
					System.out.println("new total is "+newtotal);
					
					assertEquals(total, newtotal, "total at Policy missmatch");
					System.out.println("done");
					
					Pp=Hp.VAAllPol();
					if(Pp.pageheding().contains("Select Policy Type"))
					{
						f=true;
					}
					
					assertEquals(f,true,"not navigated on sitelist page ");
				}
				
				//******** QOS viewall
				@Test(groups={"VA","pol"},priority=11)
				public void DashboardPage_Policy_QoS_viewall() throws InterruptedException
				{
					System.out.println("Qos Policy view All and count check Test Running");
					Hp=Lp.login();
					Thread.sleep(15000);
					String cntfromhomepage=Hp.polgetvalofqos();
					PQp=Hp.VAAllQpol();	
					assertEquals(PQp.pageheding(),true,"not navigated on sitelist page ");
					
					// to check number of count and confirm from dashboard
								String cntfromdetailpg=PQp.getCount();
								assertEquals(cntfromdetailpg, cntfromhomepage,"Qos policy count mismatch");
				}		
				
				//SDAWN view all
				@Test(groups={"VA","pol"},priority=12)
				public void DashboardPage_Policy_SDWAN_viewall() throws InterruptedException
				{
					System.out.println("SDWAN Policy view All and count check Test Running");
					Hp=Lp.login();
					Thread.sleep(15000);
					String cntfromhomepage=Hp.polgetvalofsdwan();
					PSp=Hp.VAAllSDpol();	
					assertEquals(PSp.pageheding(),true,"not navigated on SDWAN policy page ");
					
					// to check number of count and confirm from dashboard
								
								if(!cntfromhomepage.equalsIgnoreCase("0"))
								{
									String cntfromdetailpg=PSp.getCount();
									assertEquals(cntfromdetailpg, cntfromhomepage,"SDWAN policy count mismatch");
								}
								else{System.out.println("in else");}

				}		

@AfterMethod
public void end()
{
	driver.close();
	}
}

