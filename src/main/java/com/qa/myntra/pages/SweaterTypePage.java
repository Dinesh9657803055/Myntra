package com.qa.myntra.pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SweaterTypePage {
	
	private WebDriver driver;
	public SweaterTypePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By sweaterTitle = By.cssSelector("h1.pdp-title");
	By sweaterDescription = By.cssSelector("h1.pdp-name");
	By sweaterPrice = By.cssSelector("span.pdp-price>strong");
	By sweaterSize = By.xpath("//div[@id='sizeButtonsContainer']//p[text()='M']//parent::button");
	By addToBag = By.xpath("//div[contains(@class,'pdp-action-container')]/div[contains(@class,'pdp-add-to-bag')]");
	By gotoBag = By.xpath("//div[@id='mountRoot']//div[@class='pdp-description-container']//div[contains(@class,'pdp-action-container')]/a");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	
	public Map<String,String> captureProductinfo() {
		Map<String, String> hmap = new HashMap<String, String>();
		String productName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(sweaterTitle))).getText();
		String productDescription = wait.until(ExpectedConditions.visibilityOf(driver.findElement(sweaterDescription))).getText();
		String price = wait.until(ExpectedConditions.visibilityOf(driver.findElement(sweaterPrice))).getText();
		price = price.substring(1);
		
		
		hmap.put("NameofProduct", productName);
		hmap.put("ProductDescription", productDescription);
		hmap.put("ProductPrice", price);
		hmap.put("ProductSize", "M");
		return hmap;
	}
	
	public ShoppingBagPage addToBag() throws InterruptedException {
		
		driver.findElement(sweaterSize).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToBag))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(gotoBag))).click();
		return new ShoppingBagPage(driver);
	}

}
