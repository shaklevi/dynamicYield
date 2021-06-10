package com.shahar.peagobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class BasePage {

	protected WebDriver driver;
	JavascriptExecutor js;
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	

	protected void fillText(String cssStr,String strToSend) {
		WebElement el = driver.findElement(By.cssSelector(cssStr));
		highlightElement(el,"Orange");
		el.clear();
		el.sendKeys(strToSend);
	}
	
	protected void fillText(WebElement el,String strToSend) {
		el.clear();
		highlightElement(el,"Orange");
		el.sendKeys(strToSend);
	}
	
	
	protected void click(String cssStr) {
		WebElement el = driver.findElement(By.cssSelector(cssStr));
		highlightElement(el,"Yellow");
		el.click();
	}
	
	protected void click(WebElement el) {
		highlightElement(el,"Orange");
		el.click();
	}
	
	protected String getText(String cssStr) {
		WebElement el = driver.findElement(By.cssSelector(cssStr));
		highlightElement(el,"Orange");
		return el.getText();	
	} 
	
	protected String getText(WebElement el) {
		highlightElement(el,"Orange");
		sleep(1000);
		return el.getText();	
	} 
	
	protected String getTextByIndex(int index,String cssStr) {
		WebElement el = driver.findElements(By.cssSelector(cssStr)).get(index);
		highlightElement(el,"Orange");
		return el.getText();
	} 
	
	protected void fillTextByIndex(int index, String cssStr,String strToSend) {
		WebElement el = driver.findElements(By.cssSelector(cssStr)).get(index);
		highlightElement(el, "Yellow");
		el.clear();
		el.sendKeys(strToSend);
	}
	protected void fillTextByIndex(int index, List<WebElement> elements,String strToSend) {
		WebElement el = elements.get(index);
		highlightElement(el, "Yellow");
		el.clear();
		el.sendKeys(strToSend);
	}
	
	protected void clicksByIndex(int index, String cssStr) {
		WebElement el = driver.findElements(By.cssSelector(cssStr)).get(index);
		highlightElement(el, "Yellow");
		el.click();
	}
	protected void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public List<WebElement> getListOfElements(String cssStr){
		return driver.findElements(By.cssSelector(cssStr));
	}
	
	protected void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();	
	}
	
	
	protected void selectByValue(WebElement el,String value) {
		Select selectEl = new Select(el);
		selectEl.selectByValue(value);
		highlightElement(selectEl.getAllSelectedOptions().get(0),"Yellow");
	}
	
	protected void selectByValue(String cssStr,String value) {
		WebElement el = driver.findElement(By.cssSelector(cssStr));
		Select selectEl = new Select(el);
		selectEl.selectByValue(value);
		highlightElement(selectEl.getAllSelectedOptions().get(0),"Yellow");
	}

	//Call this method with your element and a color like (red,green,orange etc...)
	private void highlightElement(WebElement element, String color) {
			//keep the old style to change it back
			String originalStyle = element.getAttribute("style");
			String newStyle = "border: 1px solid " + color + ";" + originalStyle;
			
			// Change the style 
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
					element);

			// Change the style back after few miliseconds
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
					+ originalStyle + "');},400);", element);

		}
	
}
