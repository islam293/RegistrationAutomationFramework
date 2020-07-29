package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// This is the Abstract WebPageClass where all the web pages will inherits from
public class PageBase {
	protected WebDriver driver;


	//Create Contractors for the webdriver
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	//Create Click Button method
	protected static void clickButton(WebElement button, Actions actions) {
		actions.moveToElement(button).click().build().perform();
	}

	//Create a method to Enter Text in Text box 
	protected static void setText(WebElement txt , String value) {
		txt.sendKeys(value);
	}

	//Create a method to get the current URL for any webpage
	public String returnURL() {
		return driver.getCurrentUrl();
	}

	//Create a method to can scroll to an elemet in a webpage
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	//Create a method to wait until an element appears before taking other actions
	public void waitForElementPresence(int seconds, By locator) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
