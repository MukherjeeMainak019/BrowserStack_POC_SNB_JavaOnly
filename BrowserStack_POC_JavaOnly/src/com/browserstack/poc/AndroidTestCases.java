package com.browserstack.poc;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AndroidTestCases extends AndroidBase {

	@Test(enabled = true)
	public void tc_004_wiki() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search Wikipedia']")).click();
		System.out.println(".....Clicked on text " + "Search Wikipedia.....");
		Thread.sleep(5);
		
		driver.findElement(By.id("org.wikipedia.alpha:id/search_src_text")).click();
		System.out.println(".....Clicked on text " + "Search.....");
		Thread.sleep(5);
		
		driver.findElement(By.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(BrowserMob.accessToken);
		System.out.println(".....Entered text " + BrowserMob.accessToken);
		Thread.sleep(5);
	}
	
}

