package TESTS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import POM.EditTemplatePage;
import POM.HomePage;
import POM.LoginPage;
import POM.PoliciesPage;
import POM.SitelistPage;
import POM.TemplatePage;
import UTIL.ExcelProgram;
import UTIL.getotp;
import bsh.util.Util;


@Listeners(LISTENERS.ResList.class)
public class MultyEditTemplateTest extends TestBase{

	HomePage Hp;
	LoginPage Lp;
	SitelistPage Sp;
	TemplatePage Tp;
	//PoliciesPage Pp;
	EditTemplatePage TEp;
	
	public MultyEditTemplateTest()
	{
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void start() throws InterruptedException
	{
		init();
		Lp=new LoginPage();
		
		Hp=Lp.login();
		Thread.sleep(5000);
		 Sp = Hp.VASites();
		 Thread.sleep(5000);
		 Tp=Sp.gototemp();
		 Thread.sleep(5000);
		 // get template name from data provider
		 TEp=Tp.searchf("ind_single_1wan");		 
		 Thread.sleep(5000);
		 
	}

		
	//@Test(dataProvider="getdata")
	@Test
	public void TemplateEditPage_summaryForm_ErrormsgTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
		{
		
		 TEp.MultiEdit("SDWAN", "Rule-Test5");
			//System.out.println("in sumary" + webel);
			boolean flg=true;
			String Mainmsg="Failed for ";
			
			
			 ArrayList<Object[]> myob3 = ExcelProgram.readData2("../COM.QA.TCLSELECT/exe/logindata.xlsx", "summaryerr");
				
			 for (Object[] ob: myob3) {	
			String ermsg=TEp.checkerr(ob[0].toString(), ob[1].toString());
			System.out.println(ermsg);
		String msd=	ob[0].toString() +" "+ ob[1].toString() + " " + ob[2].toString();
			if(ermsg.equalsIgnoreCase(ob[2].toString()))
			{
				System.out.println(msd + " & " +ermsg  +"are same ");
			}
			else
			{
				System.out.println("** "+msd+ " & " +ermsg  +" are Not same");
				flg=false;
				Mainmsg=Mainmsg+msd+" are Not same ";
			}
			 }
			 System.out.println(Mainmsg);
			 if(flg)
			 {
				 UTIL.ExcelProgram.updateResult("pass","TemplateEditPage_summaryForm_ErrormsgTest","Check Summaryerr sheet for input", "Passed", "");
			 }
			 else
			 {
				 UTIL.ExcelProgram.updateResult("error","TemplateEditPage_summaryForm_ErrormsgTest","Check Summaryerr sheet for input", "Failed", Mainmsg);
			 }
			assertEquals(flg, true,Mainmsg);
			 
		}
	
	//summary edit and check
	@Test
	public void TemplateEditPage_Fill_summaryTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, MessagingException
	{

		System.out.println("filling summary for");	
		 ArrayList<Object[]> myob1 = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "summary","ind_single_1wan");
		
		 for (Object[] ob: myob1) {
			 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
			 System.out.println("after policy open");
			 TEp.summaryform(ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString(),ob[11].toString(),ob[12].toString(),ob[13].toString(),ob[14].toString(),ob[15].toString());
			}
		 
		 System.out.println("summary form fill start othere");
		 
		 TEp.savedata();
		 Thread.sleep(2000);
		 String ms1="";
		 for (Object[] ob: myob1) {
			 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
			 //System.out.println("after policy open");
			 ms1=TEp.summaryform2(ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString(),ob[11].toString(),ob[12].toString(),ob[13].toString(),ob[14].toString(),ob[15].toString());
			 System.out.println(ms1);
			 if(!ms1.equals("OK"))
			 {
				 UTIL.ExcelProgram.updateResult("error","TemplateEditPage_Fill_summaryTest","Check Summary sheet for input", "Failed", ms1);
			 }
			 else
			 {
				 UTIL.ExcelProgram.updateResult("pass","TemplateEditPage_Fill_summaryTest","Check Summary sheet for input", "Passed", "");
			 }
			 assertEquals(ms1, "OK",ms1);
			}		 
	}
	
	//edit template by excel
	//EXl done
	@Test
	public void TemplateEditPage_EditTemplateTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, MessagingException
	{

		System.out.println("filling summary for");	
		 ArrayList<Object[]> myob1 = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "summary","ind_single_1wan");
		
		 for (Object[] ob: myob1) {
			 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
			 TEp.summaryform(ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString(),ob[11].toString(),ob[12].toString(),ob[13].toString(),ob[14].toString(),ob[15].toString());
			}
		 
		 System.out.println("summary form fill start othere");
		 
		   ArrayList<Object[]> myob = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Template","ind_single_1wan");
			 
				 for (Object[] ob: myob) {
					 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
					 if(ob[3].toString().equalsIgnoreCase("Address Groups") || ob[3].toString().equalsIgnoreCase("Address"))
					 {
						 TEp.EditAddress(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
					 }else
					 {
						 TEp.Editapp(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
					 }
					}
				 TEp.savedata();
				 Thread.sleep(2000);
		   String ms="";
		   String ermsg="";
		   boolean fg=true;
				 for (Object[] ob: myob) {
					 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
					 if(ob[3].toString().equalsIgnoreCase("Address Groups") || ob[3].toString().equalsIgnoreCase("Address"))
					 {
						  ms = TEp.EditAddress2(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
						 
					 }else
					 {
						 ms = TEp.Editapp2(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
						 
					 }
					 if(!ms.equals("OK"))
					 {
						 ermsg=ermsg+ms+" ";
						 fg=false;
					 }
					 System.out.println(ms);
					}
				 if(fg)
				 {
					UTIL.ExcelProgram.updateResult("pass","TemplateEditPage_EditTemplateTest","Check Template sheet for input", "Passed", "");
				 }
				 else
				 {
					 UTIL.ExcelProgram.updateResult("error","TemplateEditPage_EditTemplateTest","Check Template sheet for input", "Failed", ermsg);
				 }
				assertEquals(fg,true , ermsg);
	}
	
	
	
	//@Test
	public void EditTemplate_FromPolicy_Test() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, MessagingException
	{

		System.out.println("filling summary for");	
		 ArrayList<Object[]> myob1 = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "summary","ind_single_1wan");
		
		 for (Object[] ob: myob1) {
			 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
			 System.out.println("after policy open");
			 TEp.summaryform(ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString(),ob[11].toString(),ob[12].toString(),ob[13].toString(),ob[14].toString(),ob[15].toString());
			}
		 
		 System.out.println("summary form fill start othere");
	 
		   ArrayList<Object[]> myob = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Sheet9","ind_single_1wan");
			 
				 for (Object[] ob: myob) {
					 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
					 if(ob[3].toString().equalsIgnoreCase("Address Groups") || ob[3].toString().equalsIgnoreCase("Address"))
					 {
						 TEp.EditAddress2(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
					 }
						 else
					 {
						 TEp.Editapp2(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
					 }
					}
				 TEp.savedata();
				 Thread.sleep(2000);
				   String ms="";
				   String ermsg="";
				   boolean fg=true;
						 for (Object[] ob: myob) {
							 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
							 if(ob[3].toString().equalsIgnoreCase("Address Groups") || ob[3].toString().equalsIgnoreCase("Address"))
							 {
								  ms = TEp.EditAddress2(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
								 
							 }else
							 {
								 ms = TEp.Editapp2(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
								 
							 }
							 if(!ms.equals("OK"))
							 {
								 ermsg=ermsg+ms+" ";
								 fg=false;
							 }
							 System.out.println(ms);
							}
						 if(fg)
						 {
							UTIL.ExcelProgram.updateResult("pass","TemplateEditPage_EditTemplateTest","Check Template sheet for input", "Passed", "");
						 }
						 else
						 {
							 UTIL.ExcelProgram.updateResult("error","TemplateEditPage_EditTemplateTest","Check Template sheet for input", "Failed", ermsg);
						 }
						assertEquals(fg,true , ermsg);
	}
	
	@AfterMethod
	public void end()
	{
		driver.close();
	}
	
	
	// Template Edit from Policy
	//@Test
	public void Edittemp() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
//		Hp=Lp.login();
//		Thread.sleep(5000);
//		 Sp = Hp.VASites();
//		 Thread.sleep(5000);
//		 Tp=Sp.gototemp();
//		 Thread.sleep(5000);
//		 // get template name from data provider
//		 TEp=Tp.searchf("ind_single_1wan");
//		 		 
//		 Thread.sleep(5000);
		 
		   ArrayList<Object[]> myob = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "Sheet5","ind_single_1wan");
			 
		   
			 for (Object[] ob: myob) {
				 if(ob[1].toString().equalsIgnoreCase("Qos"))
				 {
				 TEp.MultiEdit(ob[1].toString(), ob[2].toString());
				 
				 TEp.Editapp(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
				}
			 }
			
//		 TEp.MultiEdit("QoS", "Rule-COS-4");
		 
		 // provide template name and get its rule and data from xl code
		 
		 
	//	 TEp.Editapp("Rule-COS-4","Application", "ADD","Built","24H");
		 
		 //TEp.Editapp("Application", "ADD","User","MyFacebook");
		// TEp.MultiEdit("QoS", "Rule-COS-3");
		 //TEp.Editapp("Rule-COS-3","Application", "ADD","Built","11ST");
		 
		 //TEp.MultiEdit("QoS", "Rule-COS-5");
		 //TEp.Editapp("Rule-COS-5","Application", "ADD","Built","17U");
		 
	//	 TEp.Editapp("Rule-COS-4","URL", "ADD","User","AWS");
		 
		// TEp.Editapp("Rule-COS-4","DSCP", "ADD"," ","09");
		 
		 //TEp.Editapp("Rule-COS-4","DSCP", "Remove"," ","09");		 
	}
	
	}