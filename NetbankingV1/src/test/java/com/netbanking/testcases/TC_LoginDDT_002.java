package com.netbanking.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbaning.pageObject.Login;
import com.netbanking.Utilites.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {

	public TC_LoginDDT_002() throws FileNotFoundException {
		super();
		
	}
@Test(dataProvider="LoginData")
public void loginDDT(String user,String pwd) throws InterruptedException
{
	Login l = new Login(driver);

	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//driver.get(url);
	l.setUserName(user);
	logger.info("username entered");
	l.setPassword(pwd);
	logger.info("pwd entered");
	l.clickSubmit();
	Thread.sleep(3000);
	if (isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login failed !!!" );
	}
	
	else
	{
		
		Assert.assertTrue(true);
		logger.info("login passedd @@@");
		Thread.sleep(3000);
		l.clickLogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
	}
}


public boolean isAlertPresent()
{
	try
	{
		driver.switchTo().alert();
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
}

@DataProvider(name="LoginData")
String [][] getData() throws IOException
{
	
	String path = "C:\\Users\\Bharathi\\eclipse-workspace\\NetbankingV1\\src\\test\\java\\com\\netbanking\\TestData\\LoginData.xlsx";
	int rownum= XLUtils.getRowCount(path, "Sheet1");
	int colnum= XLUtils.getCellCount(path, "Sheet1", 1);
	String logindata[][]=new String [rownum][colnum];
	for(int i=1;i<=rownum;i++) 
	{
		for(int j=0;j<colnum;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		}
		
	}
	return logindata;
}

	


}



