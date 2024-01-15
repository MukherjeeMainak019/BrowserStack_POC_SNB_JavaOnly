package com.browserstact.poc;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSBase {
	
	public static AppiumDriver driver;
	public XCUITestOptions options;
	

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		String userName = "mainakmukherjee_Qk5gaU";
		String accessKey= "xptzyxhTpgWqRzWZFZvX";

		

		options = new XCUITestOptions();
		options.setCapability("platformName", "ios");
		options.setCapability("deviceName", "iPhone 14 Pro Max");
		options.setCapability("os_version", "16");
		options.setCapability("project", "iOS Project");
		options.setCapability("build", "iOS");
		options.setCapability("name", "Bstack-[Java] Sample iOS Test");
		options.setCapability("browserstack.debug", true);
		options.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d"); //bs://sample.app
		driver = new IOSDriver(
				new URL("https://"+userName+ ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), options);

		System.out.println("Driver launched successfully");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		System.out.println("Driver quit successfully");
	}

	//Reusbale Android Gestures

	public void assertValues(boolean value1, boolean value2)
	{

		try
		{
			Assert.assertEquals(value1, value2);
			System.out.println("Values Match : Test case passed");
		}
		catch(Exception e)
		{
			System.out.println("Values Match : Test case failed");
		}

	}

	
	public void verticalSwipe(int divX, int divY, double multX)
	{
		Dimension size = driver.manage().window().getSize(); 
		
		int startX = size.getWidth() / 2;
		System.out.println(startX);
		
		int startY = size.getHeight() / 2;
		System.out.println(startY);
		
		int endX = startX;
		System.out.println(endX);
		
		int endY = (int) (size.getHeight() * 0.25);
		System.out.println(endY);
		
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(sequence));
	}


}
