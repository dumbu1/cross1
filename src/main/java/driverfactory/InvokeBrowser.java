package driverfactory;

import java.beans.PropertyChangeEvent;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.PropertyReader;


public class InvokeBrowser {
	private static Properties	obj_Propetyvalue ;
	private static	WebDriver obj_WebDriver;
	
	/**
	 * 
	 * @return
	 */
	public WebDriver invokeBrowser() {
		PropertyReader obj_PropertyReader=new PropertyReader();
		obj_Propetyvalue=obj_PropertyReader.propertyReader();
		
		if(obj_Propetyvalue.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			ChromeOptions obj_ChromeOptions=new ChromeOptions();
			obj_ChromeOptions.addArguments("Incognito");
			obj_ChromeOptions.addArguments("start-maximized");
			
			
			WebDriverManager.chromedriver().setup();
			obj_WebDriver=new ChromeDriver(obj_ChromeOptions);


		}
		else if(obj_Propetyvalue.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			obj_WebDriver=new FirefoxDriver();


		}
		else if(obj_Propetyvalue.getProperty("browser").equalsIgnoreCase("opera")) { 
			WebDriverManager.operadriver().setup();
		}
		else {
			System.out.println("no appropiate driver");
		}

		return obj_WebDriver;
	}

}
