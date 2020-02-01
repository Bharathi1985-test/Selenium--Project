package com.netbanking.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbaning.pageObject.Login;

public class TC_LoginTest001 extends BaseClass{
	
	public TC_LoginTest001() throws FileNotFoundException {
		super();
		
	}

	@Test
	public void loginTest() throws IOException  
	{
		Login lp = new Login(driver);
		
	driver.get(baseurl);
	logger.info("URL opened");
	lp.Sign();
	lp.SetUsername(username);
	logger.info("Entered username");
	lp.Continue();
	lp.SetPassword(password);
	logger.info("Entered password");
	lp.Login1();
	System.out.println(driver.getTitle());
	
	if(driver.getTitle().equalsIgnoreCase("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
	{
		Assert.assertTrue(true);
		logger.info("Test passed");
	}
	
	else
	{
		
		CaptureScreenshot ( driver, "loginTest");
		Assert.assertTrue(false);
		logger.info("Test Failed");
	}
	}
	
		
	}

	


