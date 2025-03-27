package com.qa.myntra.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	WebDriver driver;
	
	public WebDriver initDriver() {
		ChromeOptions cop = new ChromeOptions();
		cop.addArguments("--disable-notifications");
		driver = new ChromeDriver(cop);
		driver.get("https://www.myntra.com/");
		System.out.println("--Launch the Myntra URL.");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	

}
