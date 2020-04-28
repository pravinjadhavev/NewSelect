package TESTS;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BASE.TestBase;
import POM.HomePage;
import POM.LoginPage;
import UTIL.ExcelProgram;
import bsh.util.Util;

@Listeners(LISTENERS.ResList.class)
public class LoginTest extends TestBase {

	HomePage Hp;
	LoginPage Lp;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void start()
	{
		init();
		Lp=new LoginPage();	
	}
	
	//@DataProvider
	public Iterator<Object[]> getdata() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
	ArrayList<Object[]> myd = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Logindata");
	return myd.iterator();
	
	}
	
	//@Test(dataProvider="getdata")
	public void LoginDataTest(String un,String psw,String exp) throws InterruptedException
	{
		//System.out.println(un + "   "+ psw);
		String st=Lp.EmailIDtest(un,psw);
		System.out.println(st);
		assertEquals(st,exp);
	}
	
	//Title Test
	@Test
	public void loginPage_TitleTest()
	{
		Lp=new LoginPage();	
		System.out.println("running title test");
		String Title = Lp.LoginTitle();
		assertEquals(Title, "Tata Communications");
	}
	
	// Logo Test
	@Test
	public void LoginPage_logoTest()
	{
		boolean logo = Lp.verifyLogo();
		assertEquals(logo, true);		
	}
	
	// Valid Login
	@Test
	public void Login() throws InterruptedException
	{
//		Hp=Lp.login("pravin.jadhav@evolutionco.com", "Password@123");
		Hp=Lp.login();
		Thread.sleep(3000);
	//	System.out.println(driver.getCurrentUrl());
		assertEquals(Hp.pageheding(),"Dashboard","Login Navigation missmatch");
		System.out.println("Login succesfully done");
	}
	@AfterMethod
	public void end()
	{
		driver.close();
	}
}
