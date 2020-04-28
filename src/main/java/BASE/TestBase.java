package BASE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public static WebDriver driver;
	
	public static void init()
	{	//ChromeOptions op=new ChromeOptions();
		//op.addArguments("--disable-notifications");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	//	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		 System.setProperty("webdriver.chrome.driver", "../COM.QA.TCLSELECT/exe/chromedrivern.exe");
		 driver= new ChromeDriver(options);
	
		 System.out.println("all set");
    	 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 System.out.println("lounching chrome");
    	 driver.get("http://68.183.83.251:9090/sdwan-select-angular-s3/#/landingPage");
    	 System.out.println( driver.getTitle());
	}
	
	public static void scrol(WebElement ele)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();",ele);
	js.executeScript("window.scrollTo(0, 0);");
	//System.out.println("scrolled");
	}
	
	public static void Topscrol()
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0, 0);");
	//System.out.println("scrolled To Top");
	}
	
	public static void getcss(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object elementAttributes = executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",element);

		System.out.println(elementAttributes.toString());
	}
	
	  public void jsclick(WebElement ele)
	  {
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", ele);
	  }
}