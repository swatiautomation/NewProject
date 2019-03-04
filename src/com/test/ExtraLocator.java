package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;

public class ExtraLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		//driver.findElement(By.name("username")).sendKeys("chinkisharma");
		driver.findElement(new ByAll(By.name("username1"),By.xpath("//input[@class='form-control')"))).sendKeys("chinkisharma");
		driver.findElement(new ByIdOrName("username")).sendKeys("chinkisharma");
		//driver.findElement(new ByChained(By.name("username"),By.id(),By.xpath(());

	}

}
