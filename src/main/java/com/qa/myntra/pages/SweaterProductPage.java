package com.qa.myntra.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SweaterProductPage {
	private WebDriver driver;
	public SweaterProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By showoffSweaterType = By.xpath("//li[@class='product-base'][1]");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public SweaterTypePage selectShowoffSweatertype() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(showoffSweaterType))).click();
		
		Object[] windowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window((String)windowHandles[1]);
		return new SweaterTypePage(driver);
	}
	
	

	

}
