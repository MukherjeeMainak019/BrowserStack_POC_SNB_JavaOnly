package com.browserstact.poc;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSTestCases extends IOSBase {


	@Test
	public void tc001() throws MalformedURLException, InterruptedException
	{		
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Text Input']")).sendKeys("Mainak");
		driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='UI Elements'])[1]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Alert']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeImage[@name='nav_webview']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Local Testing']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UI Elements']")).click();
		Assert.assertTrue(true);
	}
	
	@Test(enabled = false) 
	public void tc002() throws MalformedURLException, InterruptedException
	{
		driver.findElement(By.xpath("//XCUIElementTypeImage[@name='nav_webview']")).click();
		int maxSwipe = 5;
		for(int i = 1; i<=maxSwipe; i++)
		{
			verticalSwipe(2, 2, 0.25);
		}
	}
}
