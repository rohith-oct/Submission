package com.page.objects;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;




public class LoginPage {
	

	HttpURLConnection httpconnection = null;
	public WebDriver driver;
	
	SoftAssert sft;
	
	
	
	int responsecode;
	
	public void getBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void launchURL(String URL) 
	{
		driver.get(URL);
		
	}
	
	public int statusCodeforLoginPage(String url) throws Exception {
		
		httpconnection =(HttpURLConnection)(new URL(url).openConnection());
		httpconnection.setRequestMethod("HEAD");
		httpconnection.connect();
		responsecode = httpconnection.getResponseCode();
		
		
		if(responsecode!=200) {
			System.out.println("the URL is "+url);
			System.out.println("The Response Code is "+responsecode);
		}
		else {
			JavascriptExecutor j1 = (JavascriptExecutor)driver;
			
			
			if((Boolean)(j1.executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)"))==true) {
				System.out.println("Angular JS is initialized on the page : "+url);
			}
			else {
				System.out.println("Angular JS is not initialized on the page : "+url);
			}
		}
		return responsecode;
	}
	
	public void verifyAllLinks(String xpath) {
		List<WebElement> links = driver.findElements(By.xpath(xpath));
		System.out.println("no.of links available are "+links.size());
		
		for(int i=0; i<links.size(); i++)
		{
			WebElement link = links.get(i);
			String url = link.getAttribute("href");
			try 
			{
				httpconnection =(HttpURLConnection)(new URL(url).openConnection());
				httpconnection.setRequestMethod("HEAD");
				httpconnection.connect();
				responsecode = httpconnection.getResponseCode();
				if(responsecode!=200) 
				{
					System.out.println("URL : "+url);
					System.out.println("Response Code : "+responsecode);
				}
				else
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					System.out.println("URL : "+url);
					System.out.println("Response Code : "+responsecode);
				    link.click();
				    Thread.sleep(9000);
					Boolean value = (Boolean) js.executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)");
					if(value == true) 
					{
						
						System.out.println("Angular JS is initialized on the page :"+url);
						driver.navigate().back();
						Thread.sleep(9000);
					}
					else 
					{
						try
						{
							
							Assert.assertTrue(value,"Angular JS is not initialized on the page : "+url);
							
					    }
						catch(Exception e)
					    {
							System.out.println("Assertion error. "+e.getMessage());
					    }
					}			
				}
				
			}catch(Exception e) {
				System.out.println("Exception occured is"+e.getMessage());
			}
		}
	}
	
	
	
}
