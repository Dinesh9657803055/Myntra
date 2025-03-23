package com.qa.myntra.pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingBagPage {

	private WebDriver driver;

	public ShoppingBagPage(WebDriver driver) {
		this.driver = driver;
	}

	By productBrand = By.xpath(
			"//div[@id='cartItemsList']//div[@class='itemContainer-base-details']//div[@class='itemContainer-base-brand']");
	By productTypeDescription = By.xpath(
			"//div[@id='cartItemsList']//div[@class='itemContainer-base-details']//a[@class='itemContainer-base-itemLink']");
	By productSize = By.xpath(
			"//div[@id='cartItemsList']//div[@class='itemContainer-base-details']//div[@class='itemComponents-base-size']//span");
	By productPrice = By.xpath(
			"//div[@id='cartItemsList']//div[@class='itemContainer-base-details']//div[contains(@class,'itemComponents-base-price')]/div");

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public Map<String, String> getShoppingBagProductData() {
		Map<String, String> hmap = new HashMap<String, String>();

		String brand = wait.until(ExpectedConditions.visibilityOf(driver.findElement(productBrand))).getText();
		String description = wait.until(ExpectedConditions.visibilityOf(driver.findElement(productTypeDescription)))
				.getText();
		String size = wait.until(ExpectedConditions.visibilityOf(driver.findElement(productSize))).getText();
		System.out.println(size);
		String price = wait.until(ExpectedConditions.visibilityOf(driver.findElement(productPrice))).getText();
		hmap.put("Brand", brand);
		hmap.put("Description", description);
		hmap.put("Size", size);
		hmap.put("Price", price);
		return hmap;

	}

}
