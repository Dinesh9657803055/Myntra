package com.qa.myntra.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	
		System.out.println("Dinesh bhau"); //new changes 
		System.out.println("Dhruval Patel");
		System.out.println("Dinesh Kadam");
		System.out.println("Iam commting form Dhruval Account");
	}
	
	By menCategoryLink = By.xpath("//header[@id='desktop-header-cnt']//nav//div[contains(@class,'navContent')]//a[@data-group='men']");
	By sweaterProductLink = By.xpath("//div[@data-group='men']//ul/li//a[text()='Sweaters']");
	
	
	public SweaterProductPage selectMenSweaterProduct() {
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//act.moveToElement(wait.until(ExpectedConditions.visibilityOf(driver.findElement(menCategoryLink)))).build().perform();
		act.moveToElement(driver.findElement(menCategoryLink)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(sweaterProductLink))).click();
		return new SweaterProductPage(driver);
	
		
	}
}
