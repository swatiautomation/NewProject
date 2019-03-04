package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
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
	
	@Test(priority=2,groups="titley")
	public  void googleTestTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title,"Google","title is not matched");
		
	}
	
	@Test(priority=1,groups="titley")
	public void googleLogoText()
	{
		
		boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
	//	boolean b1 = driver.findElement(By.linkText("GMail']")).isDisplayed();
		//System.out.println(title);
		
		//Assert.assertTrue(b);
		Assert.assertEquals(b, false);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
