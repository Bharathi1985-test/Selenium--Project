package com.netbanking.Utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig() throws FileNotFoundException
	{
	try {
		prop= new Properties();
		
		FileInputStream f = new FileInputStream("C:\\Users\\Bharathi\\eclipse-workspace\\NetbankingV1\\Configuration\\demo.properties");
		prop.load(f);
	} catch (Exception e) {
		
		System.out.println("exceptional message"+e.getMessage());
	}
    
}
	public String browserName()
	{
		String br = prop.getProperty("browser");
		return br;
	}
	public String getApplicationURL()
	{
		String url = prop.getProperty("BaseUrl");
		return url;
	}
	
	public String getUsername()
	{
		String name = prop.getProperty("Username");
		return name;
	}
	
	public String getPassword()
	{
		String pwd = prop.getProperty("Password");
		return pwd;
	}
	
	
}
