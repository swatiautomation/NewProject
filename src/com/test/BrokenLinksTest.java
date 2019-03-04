package com.test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("chinkisharma");
		driver.findElement(By.name("password")).sendKeys("test@1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		driver.switchTo().frame("mainpanel");
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));
		
		
		System.out.println("size of actual links =" +list.size());
		
		List<WebElement> activelist = new ArrayList<WebElement>();
		
		for (int i=0;i<list.size(); i++)
		{
			if(list.get(i).getAttribute("href")!=null)
			{
				activelist.add(list.get(i));
			}
		}
		
		System.out.println("size of active links and images =" + activelist.size());
		
		//check the href url,with httpconnection API
		
		for (int j=0;j<activelist.size();j++)
		{
			HttpURLConnection connection=(HttpURLConnection) new URL(activelist.get(j).getAttribute("href")).openConnection();
			connection.connect();
			connection.getResponseCode();
		String response=	connection.getResponseMessage();
			connection.disconnect();
			
			System.out.println(activelist.get(j).getAttribute("href")+"---->"+response);
		}
		
		driver.close();	
	}

}
