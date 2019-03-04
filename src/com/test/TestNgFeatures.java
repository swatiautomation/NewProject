package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgFeatures {
	WebDriver  driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
				
	}
	
/*	@Test
	public void loginTest()
	{
		boolean b1 = driver.findElement(By.linkText("GMail']")).isDisplayed();
	}
	
	@Test(dependsOnMethods="loginTest")
	public void HomepageTest()
	{
		boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
	}*/
	
	@Test(invocationCount=5)
	public void SerchpageTest()
	{
	System.out.print("hello");	
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
