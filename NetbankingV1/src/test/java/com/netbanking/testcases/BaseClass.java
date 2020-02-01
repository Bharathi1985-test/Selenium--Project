package com.netbanking.testcases;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.netbanking.Utilites.ReadConfig;

public class BaseClass extends ReadConfig {

public BaseClass() throws FileNotFoundException {
		super();
		
	}

ReadConfig rc = new ReadConfig();
public String baseurl= rc.getApplicationURL();
public String username = rc.getUsername();
public String password = rc.getPassword();
public String browser = rc.browserName();

public String url ="http://demo.guru99.com/v4/index.php";
public String user ="mngr243188";
public String pwd ="pYpUjYv";
    
	public static WebDriver driver;
	public static Logger logger;
	

	
@BeforeClass
public void setUp()
{
if(browser.equalsIgnoreCase("Chrome"))
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Bharathi\\eclipse-workspace\\NetbankingV1\\Drivers\\chromedriver.exe");
	driver =new ChromeDriver();	
}
else if (browser.equalsIgnoreCase("FireFox"))
{
	System.out.println("no browser found");
}
	
	 logger= Logger.getLogger("NetbankingV1");
	PropertyConfigurator.configure("Log4j.properties");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(url);
	
}
@AfterClass

	public void tearDown()
	{
		driver.quit();
	}




public void CaptureScreenshot (WebDriver driver, String tname) throws IOException

{
	TakesScreenshot ts =(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File("C:\\Users\\Bharathi\\eclipse-workspace\\NetbankingV1\\Screenshots" + tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
	
	
	}
}
	

