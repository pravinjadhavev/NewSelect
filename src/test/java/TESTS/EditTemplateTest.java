package TESTS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BASE.TestBase;
import POM.EditTemplatePage;
import POM.HomePage;
import POM.LoginPage;
import POM.PoliciesPage;
import UTIL.ExcelProgram;

@Listeners(LISTENERS.ResList.class)
public class EditTemplateTest extends TestBase{

	HomePage Hp;
	LoginPage Lp;
	PoliciesPage Pp;
	EditTemplatePage TEp;
	
	public EditTemplateTest()
	{
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void start() throws InterruptedException
	{
		init();
		Lp=new LoginPage();
		
	}

	// Template Edit from Policy
	//@Test
	public void Edittemp() throws InterruptedException
	{
		Hp=Lp.login();
		Thread.sleep(5000);
		 Pp = Hp.VAAllPol();
		 Thread.sleep(5000);
		 TEp=Pp.searchfortemp("Rule-COS-4");
		 Thread.sleep(2000);
		// TEp.Editapp("Rule-COS-4","Application", "ADD","Built","24H");
		 
		 //TEp.Editapp("Rule-COS-4","Application", "ADD","User","MyFacebook");
		 
		// TEp.Editapp("Rule-COS-4","URL", "ADD","Built","legal");
		 
		 //TEp.Editapp("Rule-COS-4","URL", "ADD","User","AWS");
		
		 
		 TEp.Editapp("Rule-COS-4","DSCP", "ADD"," ","07");
		 TEp.Editapp("Rule-COS-4","DSCP", "Remove"," ","07");	
		 
	}
	
	@Test 
	public void EditTemplate_FromPolicy_Test() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, MessagingException
	{

		Hp=Lp.login();
		Thread.sleep(5000);
		 Pp = Hp.VAAllPol();
		 Thread.sleep(5000);
		// TEp=Pp.searchfortemp("Rule-COS-4");
		// Thread.sleep(2000);
		 
		System.out.println("filling summary for");	
		 ArrayList<Object[]> myob1 = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "summary","ind_single_1wan");
		
		 for (Object[] ob: myob1) {
			 TEp=Pp.searchfortemp(ob[2].toString());
			 Thread.sleep(2000);
			// TEp.MultiEdit(ob[1].toString(), ob[2].toString());
//			 System.out.println("after policy open");
			 TEp.summaryform(ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString(),ob[7].toString(),ob[8].toString(),ob[9].toString(),ob[10].toString(),ob[11].toString(),ob[12].toString(),ob[13].toString(),ob[14].toString(),ob[15].toString());
			}
//		 
		 System.out.println("summary form fill start othere");
	 
		   ArrayList<Object[]> myob = ExcelProgram.readTemplateData("../COM.QA.TCLSELECT/exe/logindata.xlsx", "policytemplate","ind_single_1wan");
			 
				 for (Object[] ob: myob) {
					// TEp.MultiEdit(ob[1].toString(), ob[2].toString());
					 if(ob[3].toString().equalsIgnoreCase("Address Groups") || ob[3].toString().equalsIgnoreCase("Address"))
					 {
						 TEp.EditAddress(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
					 }
						 else
					 {
						 TEp.Editapp(ob[2].toString(),ob[3].toString(),ob[4].toString(),ob[5].toString(),ob[6].toString());
					 }
					}
				 boolean f=TEp.savedata();
				 System.out.println(f);
				 if(f)
				 {
					 Thread.sleep(2000);
					 String ms="";
					 String ermsg="";
					 boolean fg=true;
						 for (Object[] ob: myob) {
							// TEp.MultiEdit(ob[1].toString(), ob[2].toString());
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
							UTIL.ExcelProgram.updateResult("pass","EditTemplate_FromPolicy_Test","Check policytemplate sheet for input", "Passed", "");
						 }
						 else
						 {
							 UTIL.ExcelProgram.updateResult("error","EditTemplate_FromPolicy_Test","Check policytemplate sheet for input", "Failed", ermsg);
						 }
						assertEquals(fg,true , ermsg);
				 		}
						 else
						 {
							 System.out.println("data not saved ");
							 UTIL.ExcelProgram.updateResult("error","TemplateEditPage_EditTemplateTest","Check Template sheet for input", "Failed", "Data Not saved");
							 
						 }
				 }
	@AfterMethod
	public void end()
	{
		driver.close();
	}	
}