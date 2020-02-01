package com.netbaning.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	

	WebDriver ldriver ;
	
public Login(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="nav-link-accountList")
	WebElement signin;
	
	@FindBy(name="email")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	
	@FindBy(css="#continue")
	WebElement btncontinue;
	@FindBy(css="#signInSubmit")
	WebElement btnLogin;
	public void SetUsername(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	
	public void SetPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	
	public void Continue()
	{
		btncontinue.click();
	}
	public void Login1()
	{
		btnLogin.click();
	}

	public void Sign()
	{
		signin.click();
	}
	//demogurulogin
	
	@FindBy(name="uid")
	
	WebElement ttUserName;
	
	@FindBy(name="password")
	
	WebElement ttPassword;
	
	@FindBy(name="btnLogin")
	
	WebElement bnLogin;
	
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	
	WebElement lnkLogout;
	
	
	
	public void setUserName(String uname)
	{
		ttUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		ttPassword.sendKeys(pwd);
	}
	
	
	public void clickSubmit()
	{
		bnLogin.click();
	}	
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
