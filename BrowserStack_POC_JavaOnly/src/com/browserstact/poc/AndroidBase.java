package com.browserstact.poc;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidBase {

	public static AppiumDriver driver;
	public UiAutomator2Options options;
	public HashMap<String, Object> browserstackOptions;

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		String userName = "mainakmukherjee_Qk5gaU";
		String accessKey= "xptzyxhTpgWqRzWZFZvX";

		

		options = new UiAutomator2Options();
		options.setCapability("platformName", "android");
		options.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
		options.setCapability("os_version", "12");
		options.setCapability("project", "Android Project");
		options.setCapability("build", "Android");
		options.setCapability("name", "Bstack-[Java] Sample Test Android");
		options.setCapability("browserstack.debug", true);
		options.setCapability("interactiveDebugging", true);
//		options.setCapability("app", "bs://4c232d3347c3b3cb1c05663d9cc1004130a70a4c");//wiki app - network logs
		options.setCapability("app", "bs://30a4d280756c5db63f0d5be6fffe4c72de1c1d10"); // API Demo App
//		capabilities.setCapability("app", "bs://a3bfc2babf21d31209673df37986e9f2df8cc884"); //General Store App
//		capabilities.setCapability("app", "bs://sample.app"); //B_Stack Demo App

		driver = new AndroidDriver(
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


	public void scrollToElementUisngText(String text)
	{
		//this is given by Google
		//recommended to use as we can specifically pass the element the element for scrolling

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		
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
	
	public void horizontalSwipe(int divX, int divY, double multX)
	{

		Dimension size = driver.manage().window().getSize(); 
		
		int startX = size.getWidth() / divX;
		System.out.println("startX is " + startX);
		
		int startY = size.getHeight() / divY;
		System.out.println("startY is " + startY);
		
		int endX = (int) (size.getWidth() * multX);
		System.out.println("endX is " + endX);
		
		int endY = startY;
		System.out.println("endY is " + endY);
		
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






