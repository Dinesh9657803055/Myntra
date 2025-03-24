package com.qa.myntra.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.myntra.factory.DriverFactory;
import com.qa.myntra.pages.HomePage;
import com.qa.myntra.pages.ShoppingBagPage;
import com.qa.myntra.pages.SweaterTypePage;
import com.qa.myntra.pages.SweaterProductPage;

public class ShoppingBagTests {

	WebDriver driver;
	DriverFactory df;
	private HomePage hp;
	private SweaterProductPage spp;
	private SweaterTypePage sstp;
	private ShoppingBagPage sbp;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.initDriver();
		hp = new HomePage(driver);
		spp = new SweaterProductPage(driver);
		sstp = new SweaterTypePage(driver);
		sbp = new ShoppingBagPage(driver);
		
		//my test
	}

	@Test
	public void verifyData() {
		try {
			Map<String, String> productDetailsMap = new HashMap<String, String>();
			Map<String, String> productDetailsMapinShoppingBag = new HashMap<String, String>();
			hp.selectMenSweaterProduct();
			spp.selectShowoffSweatertype();
			productDetailsMap = sstp.captureProductinfo();
			productDetailsMap.forEach((k, v) -> System.out.println("Product Details Data:" + k + ":" + v));

			sstp.addToBag();

			productDetailsMapinShoppingBag = sbp.getShoppingBagProductData();
			productDetailsMapinShoppingBag
					.forEach((k, v) -> System.out.println("Product Details in Shopping Bag Data:" + k + ":" + v));

			assertEquals(productDetailsMapinShoppingBag.get("Brand"), productDetailsMap.get("NameofProduct"));
			assertEquals(productDetailsMapinShoppingBag.get("Description"),
					productDetailsMap.get("ProductDescription"));
			String price = productDetailsMapinShoppingBag.get("Price");
			price = price.replace(",", "");
			assertEquals(price, productDetailsMap.get("ProductPrice"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void teardown() {
		// driver.quit();

	}

}
