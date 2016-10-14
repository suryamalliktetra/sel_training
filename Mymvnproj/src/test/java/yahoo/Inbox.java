package yahoo;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ATUReportsListener.class,MethodListener.class,ConfigurationListener.class})
public class Inbox 
{
 WebDriver driver;

 {
	 System.setProperty("atu.reporter.config", "d:/atu.properties");
}
 
 public Inbox(WebDriver driver)
 {
	 this.driver=driver;
 }
 public void deletemail()
 {
	 driver.findElement(By.xpath("(//input[@name='mid'])[position()=5]")).click();
	 
 }
}
