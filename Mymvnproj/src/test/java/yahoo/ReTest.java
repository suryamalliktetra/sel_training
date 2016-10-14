package yahoo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ATUReportsListener.class,MethodListener.class,ConfigurationListener.class})
public class ReTest 
{
    WebDriver driver;
       
    {
		 System.setProperty("atu.reporter.config", "d:/atu.properties");
    }
    
	@Test
	@Parameters({"browser"})
	public void retesting(String br) throws Exception
	{
    	if(br.matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(br.matches("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","d:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		Home h=new Home(driver);
		h.validate_links();
		h.login();
		
		Inbox i=new Inbox(driver);
		i.deletemail();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.signout();
	}
}
