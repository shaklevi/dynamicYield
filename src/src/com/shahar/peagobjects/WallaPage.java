package com.shahar.peagobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WallaPage extends BasePage{
	
	public WallaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div.nav > ul > li:nth-child(4) > a")
	WebElement tabMoney;
	
	@FindBy(css =  ".css-1mhodj0 > ul > li:nth-child(1) > h3~.rate")
	WebElement dollarTab;
	
	public Double getDollarRate() {
		click(tabMoney);
		String rateStr =  getText(dollarTab);
		return Double.parseDouble(rateStr);
	}
	
	
	
}
