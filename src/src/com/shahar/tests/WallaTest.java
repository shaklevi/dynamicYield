package com.shahar.tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shahar.peagobjects.WallaPage;


public class WallaTest {
	
	WebDriver driver;
	
	@BeforeClass
	protected void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.walla.co.il/");
	}
	
	
	@Test(description = "Verify dollar current change rate")
	public void tc01_verifyDollarChangeRate() {
		double expectedRate = 3.244;
		WallaPage wallaPageObj = new WallaPage(driver);
		double rate = wallaPageObj.getDollarRate();
		assertEquals(rate, expectedRate);
	}
	
	

}
