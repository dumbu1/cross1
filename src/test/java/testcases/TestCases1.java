package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverfactory.InvokeBrowser;
import util.PropertyReader;
import util.ReusableMethods;

public class TestCases1 {

	private static  Properties	value;
	private static	 WebDriver driver ;
	//private static FileOutputStream fos;

	@Test
	@Parameters({"browser"})
	public void testcase1(String testngBrowserValue){
		
		ReusableMethods obj_ReusableMethods=new ReusableMethods();
		obj_ReusableMethods.modifyPropertyFile(System.getProperty("user.dir")+"/config/config.properties", "browser", testngBrowserValue);
		
		
		PropertyReader obj_PropetyReader=new PropertyReader();
		value =obj_PropetyReader.propertyReader();

		InvokeBrowser obj_InvokeBrowser=new InvokeBrowser();
		driver  =obj_InvokeBrowser.invokeBrowser();
		
		driver.get(value.getProperty("url"));
		
		/*
		// changing the brwser in property file
		
		//ReusableMethods obj_ReusableMethods=new ReusableMethods();
		obj_ReusableMethods.modifyPropertyFile(System.getProperty("user.dir")+"/config/config.properties", "browser", "firefox");
		
		// open url in firefox
		
		InvokeBrowser obj_InvokeBrowser_firefox=new InvokeBrowser();
		
		driver =obj_InvokeBrowser_firefox.invokeBrowser();
		driver.get(value.getProperty("url"));*/

	}

}
