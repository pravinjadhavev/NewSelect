package TESTS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.mail.MessagingException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BASE.TestBase;
import POM.AllAppPage;
import POM.CPEsPage;
import POM.CreateUserdefineAppPage;
import POM.HomePage;
import POM.LoginPage;
import POM.SitelistPage;
import POM.UDAppPage;
import UTIL.ExcelProgram;
import UTIL.getotp;
import bsh.util.Util;

@Listeners(LISTENERS.ResList.class)
public class AppsTest extends TestBase{

	HomePage Hp;
	LoginPage Lp;
	AllAppPage Aap;
	UDAppPage UDap;
	CreateUserdefineAppPage uform;
	
	String Mainmsg="Failed for ";
	
	boolean flg=true;
	
	public AppsTest()
	{
		super();
	}
	
	//@BeforeClass(alwaysRun = true)
	public void startforerrmsg() throws InterruptedException
	{
		init();
		Lp=new LoginPage();
		Hp=Lp.login();
		Thread.sleep(5000);
		UDap=Hp.VAAlluApp();
		Thread.sleep(3000);
		uform=UDap.gotoform();
	}
	
	@BeforeMethod(alwaysRun = true)
		public void start() throws InterruptedException
		{
			init();
			Lp=new LoginPage();
		}
	
	// seach application
	// Exl Done
	@Test
	public void ApplicationPage_Count_Check() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Hp=Lp.login();
		Thread.sleep(15000);
		int userdefined=Integer.valueOf(Hp.getvalofudap());
		int builtin=Integer.valueOf(Hp.getvalofbap());
		String passmsg="";
		Aap=Hp.VAAllApp();
		Thread.sleep(10000);
		String sdata="Built-In";		
		int cnt=Aap.searchf(sdata);
		searchhelp(cnt, builtin);
		passmsg="Built In "+Integer.toString(builtin);
		sdata="User-Defined";		
		cnt=Aap.searchf(sdata);
		searchhelp(cnt, userdefined);
		System.out.println(cnt +" from userdefined");
		passmsg=passmsg+" userdefined "+Integer.toString(userdefined);
		System.out.println("saving xl");
		UTIL.ExcelProgram.updateResult("pass","ApplicationPage_Count_Check",passmsg, "Passed", "");
		
	}
	
	public void searchhelp(int cnt,int sitedata)
	{
		assertEquals(cnt,sitedata,"search count missmatch");
		
	}

	//create new user defined application
	//Exl Done
	@Test(priority=1)
	public void ApplicationPage_Creat_UserDefined_App() throws InterruptedException, MessagingException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Hp=Lp.login();
		Thread.sleep(5000);
		UDap=Hp.VAAlluApp();
		Thread.sleep(3000);
		uform=UDap.gotoform();
		Thread.sleep(3000);
		String Appname="";
		String passmsg="Data For Create Application are ";
		ArrayList<Object[]> myob1 = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "CreateApp");
		
		 for (Object[] ob: myob1) {
			 Appname=ob[0].toString();
			 System.out.println(Appname + "is name");
		uform.fillform(ob[0].toString(),ob[1].toString(),ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString());
		
		for(int i=0;i<=10;i++)
		{
			passmsg=passmsg+ob[i].toString()+" ";
		}
		 }
		Thread.sleep(4000);
		
	boolean rs	=uform.savedata(1);
	
	if(rs)
	{
		UDap.searchf(Appname);
		boolean aprs1 = UDap.CheckAppname(Appname);
		if(aprs1)
		{
			UTIL.ExcelProgram.updateResult("pass","ApplicationPage_Creat_UserDefined_App",passmsg, "Passed", "");
		}
		else
		{
			UTIL.ExcelProgram.updateResult("error","ApplicationPage_Creat_UserDefined_App",passmsg +" App unable to save", "Failed", "");
		}
		
	}else
	{
		UTIL.ExcelProgram.updateResult("error","ApplicationPage_Creat_UserDefined_App",passmsg +" App unable to save", "Failed", "");
	}
	
	assertEquals(rs,true," Error In Creating application ");
	}
	
	// Edit Name of User defined Application (Condition Name can not be edited)
	// Exl Done
	//@Test
	@Test(priority=2,dependsOnMethods="ApplicationPage_Creat_UserDefined_App")
	public void ApplicationPage_NameCanNotEdit_Test() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String Name="ChangedGmailTest";
		Hp=Lp.login();
		Thread.sleep(5000);
		UDap=Hp.VAAlluApp();
		Thread.sleep(3000);
		uform=UDap.Edit();
		Thread.sleep(3000);
		boolean t = uform.editname(Name);
		if(t)
		{
			UTIL.ExcelProgram.updateResult("pass","ApplicationPage_NameEdit_Test",Name +" Unable to Edited", "Passed", "");
		}else
		{
			UTIL.ExcelProgram.updateResult("error","ApplicationPage_NameEdit_Test",Name + " Edited", "Failed", "");
		}	
		assertEquals(t, true,"Name Edited");
	}
	
	// Edit of User defined Application (except Name)
	//Exl Done
	//@Test
			@Test(priority=8,dependsOnMethods="ApplicationPage_Creat_UserDefined_App")
			public void ApplicationPage_EditAll_ExceptName() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, MessagingException
			{
				Hp=Lp.login();
				Thread.sleep(5000);
				UDap=Hp.VAAlluApp();
				Thread.sleep(3000);
				boolean f=true;
				String passmsg="";
				ArrayList<Object[]> myob1 = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "CreateApp");
				
				for (Object[] ob: myob1) {
				
				UDap.searchf(ob[0].toString());
				uform=UDap.Edit();
				Thread.sleep(10000);
		
					 passmsg=uform.copy2("edit",ob[1].toString(),ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString());
				 }
				System.out.println(passmsg+" return msg");
				
				if(passmsg.contains("err"))
				{
					f=false;	
				}
				assertEquals(f,true,passmsg);
				String Editmsg="";
				System.out.println("Old Data is correct");
				boolean f2=true;
				ArrayList<Object[]> myob2 = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "EditApp");
				
				for (Object[] ob: myob2) {
					
					f=uform.Editoldapp(ob[0].toString(),ob[1].toString());
					Editmsg=Editmsg+" for "+ob[0].toString()+" data is "+ob[1].toString()+" ";
					System.out.println(f);
					if(!f)
					{
						System.out.println("Unable to update " + ob[0]);
						f2=false;
					}
				}
				assertEquals(f2,true,"Erro in updating");
				uform.saveclick();
				boolean s=uform.savedata(2);
				Thread.sleep(5000);
				if(s)
				{
					for (Object[] ob: myob1) {
						
						UDap.searchf(ob[0].toString());
						uform=UDap.Edit();
						Thread.sleep(10000);
				
							 passmsg=uform.copy2("edit",ob[1].toString(),ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString());
						 }
						System.out.println(passmsg+" return msg");
						
						if(passmsg.contains("err"))
						{
							System.out.println("passed see error msg");
							UTIL.ExcelProgram.updateResult("pass","ApplicationPage_EditAll_ExceptName",Editmsg, "Passed", "");
						}
						else
						{
							System.out.println("failed NO changes made");	
							UTIL.ExcelProgram.updateResult("error","ApplicationPage_EditAll_ExceptName",Editmsg, "Failed", "");
						}
				}
			}
			
	// copy of User defined Application (only name not fateched can edit all)
	// Exl Done
	@Test(priority=7,dependsOnMethods="ApplicationPage_Creat_UserDefined_App")
	public void ApplicationPage_Copy_NameChange() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, MessagingException
	{
		Hp=Lp.login();
		Thread.sleep(5000);
		UDap=Hp.VAAlluApp();
		Thread.sleep(3000);
		boolean f=true;
		String passmsg="chrome";
		String Newname="";
		ArrayList<Object[]> myob1 = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "CreateApp");
		
		for (Object[] ob: myob1) {
		Newname=ob[0].toString()+"Copy";
		UDap.searchf(ob[0].toString());
		
		uform=UDap.gotocopy();
		Thread.sleep(10000);

			 passmsg=uform.copy2("edit",ob[1].toString(),ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString());
		 }
		System.out.println(passmsg+" return msg");
		
		if(passmsg.contains("err"))
		{
			f=false;	
		}
		assertEquals(f,true,passmsg);
		String Editmsg="";
		System.out.println("Old Data is correct");
		boolean f2=false;
		boolean s=false;
		String Appname=Newname;
		f2=uform.copysave(Appname);
		if(f2)
		{
		uform.saveclick();
		s=uform.savedata(1);
		Thread.sleep(5000);
		}
		
		if(s)
		{
			UDap.searchf(Appname);
			boolean aprs1 = UDap.CheckAppname(Appname);
			if(aprs1)
			{
				UTIL.ExcelProgram.updateResult("pass","ApplicationPage_Copy_NameChange",Appname +" created from copy", "Passed", "");
			}
			else
			{
				UTIL.ExcelProgram.updateResult("error","ApplicationPage_Copy_NameChange",Appname +" unable create from Copy", "Failed", "");
			}
			
		}else
		{
			UTIL.ExcelProgram.updateResult("error","ApplicationPage_Copy_NameChange",passmsg +" App unable create from Copy", "Failed", "");
		}
		
		assertEquals(s,true," Error In Creating application ");
		}

	//@DataProvider
	public Iterator<Object[]> getdata() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
	ArrayList<Object[]> myd = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Sport");
	return myd.iterator();
	
	}
	
	
	// Validation checks for create user defined application
	//@Test(dataProvider="getdata",groups={"errform"})
	// Done
	@Test
	public void ApplicationPage_errmsgTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Hp=Lp.login();
		Thread.sleep(5000);
		UDap=Hp.VAAlluApp();
		Thread.sleep(3000);
		uform=UDap.gotoform();
		ArrayList<Object[]> myd = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Sport");
		//ArrayList<Object[]> myd = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Applicationerr");
		for (Object[] ob : myd) 
		{
			
			String webel=ob[0].toString();
			String data=ob[1].toString();
			String msg=ob[2].toString();
			
		String md="";
		Thread.sleep(1000);
//		String webel="Source ip";
//		String data="192.168.1.128/32";
//		String msg=" ";
		
		String ermsg=uform.checkerr(webel, data);
		
		if(ermsg.equalsIgnoreCase(msg))
		{
			String passmsg="Passed for ";
			passmsg=passmsg+webel +" "+ data + " Error message is " + msg ;
			System.out.println(webel +" "+ data + " " + msg + "&" +ermsg  +"are same");
			UTIL.ExcelProgram.updateResult("pass","App_errmsgTest",passmsg, "Passed", "");
			
		}
		else
		{
			String failmsg=" Error For ";
			md="** "+webel +" "+ data + " " + msg + "&" +ermsg  +"are Not same";
			System.out.println(md);
			flg=false;
			failmsg=failmsg+" "+webel+" "+data + " Error message is " + ermsg;
			UTIL.ExcelProgram.updateResult("error","App_errmsgTest",failmsg, "Failed", " Data Not Match");
		}
		}
		//Thread.sleep(3000);
		assertEquals(flg, true,Mainmsg);
	}
	
	@Test
	public void ApplicationPage_errmsg_SourcePortTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Hp=Lp.login();
		Thread.sleep(5000);
		UDap=Hp.VAAlluApp();
		Thread.sleep(3000);
		uform=UDap.gotoform();
		//ArrayList<Object[]> myd = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Sport");
		ArrayList<Object[]> myd = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Applicationerr");
		for (Object[] ob : myd) 
		{
			
			String webel=ob[0].toString();
			String data=ob[1].toString();
			String msg=ob[2].toString();
			
		String md="";
		Thread.sleep(1000);
//		String webel="Source ip";
//		String data="192.168.1.128/32";
//		String msg=" ";
		
		String ermsg=uform.checkerr(webel, data);
		
		if(ermsg.equalsIgnoreCase(msg))
		{
			String passmsg="Passed for ";
			passmsg=passmsg+webel +" "+ data + " Error message is " + msg ;
			System.out.println(webel +" "+ data + " " + msg + "&" +ermsg  +"are same");
			UTIL.ExcelProgram.updateResult("pass","App_errmsgTest",passmsg, "Passed", "");
			
		}
		else
		{
			String failmsg=" Error For ";
			md="** "+webel +" "+ data + " " + msg + "&" +ermsg  +"are Not same";
			System.out.println(md);
			flg=false;
			failmsg=failmsg+" "+webel+" "+data + " Error message is " + ermsg;
			UTIL.ExcelProgram.updateResult("error","App_errmsgTest",failmsg, "Failed", " Data Not Match");
		}
		}
		//Thread.sleep(3000);
		assertEquals(flg, true,Mainmsg);
	}
	@AfterMethod
	public void end()
	{
		driver.close();
	}
}
