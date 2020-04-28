package UTIL;

import javax.mail.MessagingException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



import BASE.TestBase;

public class OTPTest extends TestBase{

	@Test
	public void forto() throws MessagingException, InterruptedException
	{
		System.out.println("in ot");
		String otp=" ";
		otp=getotp.MailTestnew();
		if(otp.equalsIgnoreCase(" "))
		{
			Thread.sleep(30000);
			otp=getotp.MailTestnew();
		}
		System.out.println("returned otp is : " + otp);
	}
}
