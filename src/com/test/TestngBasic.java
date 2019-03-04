package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasic {
	
	@BeforeSuite
	public void Setup()
	{
		
	}

	@BeforeClass
	public void LaunchBrowser()
	{
		
	}
	
	@BeforeMethod
	public void enterUrl()
	{
		
	}
	
	@BeforeTest
	public void login()
	{
		
	}
	
	@Test
	public void googleTitle()
	{
		
	}
	
	@AfterMethod
	public void logOut()
	{
		
	}
	
	@AfterTest
	public void deleteAllCookies()
	{
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		
	}
	
	@AfterSuite
	public void generateTestReport()
	{
		
	}
}
