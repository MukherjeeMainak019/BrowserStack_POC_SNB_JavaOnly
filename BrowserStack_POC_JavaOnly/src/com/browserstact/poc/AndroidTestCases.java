package com.browserstact.poc;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AndroidTestCases extends AndroidBase {

	@Test(enabled = true)
	public void tc_001()
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		scrollToElementUisngText("WebView");
		boolean flag = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='WebView']")).isDisplayed();
		assertValues(flag, true);

	}

	@Test(enabled = false)
	public void tc_002() throws InterruptedException
	{
		{
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			int maxSwipe = 5;
			for(int i = 1; i<=maxSwipe; i++)
			{
				verticalSwipe(2, 2, 0.25);
			}
			boolean flag = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='WebView']")).isDisplayed();
			assertValues(flag, true);
			
		}
		

	}
	@Test(enabled = false)
	public void tc_003() throws InterruptedException
	{
		{
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
			
			int maxSwipe = 5;
			for(int i = 1; i<=maxSwipe; i++)
			{
				horizontalSwipe(2, 6, 0.28);
			}
			assertValues(true, true);
			
		}
		

	}
	@Test(enabled = false)
	public void tc_004_wiki() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search Wikipedia']")).click();
		Thread.sleep(3);
		driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@text='Search…']")).click();
		Thread.sleep(3);
		driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@text='Search…']")).sendKeys("Saudi National Bank");
		Thread.sleep(3);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Saudi National Bank']")).click();
		Thread.sleep(3);
	}
	
}

