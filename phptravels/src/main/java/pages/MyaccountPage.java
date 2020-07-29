package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//This is the class that will deal with Myaccount page that appears after successful registration

public class MyaccountPage extends PageBase {

	// Add Constructors for the pageBase elements 
	public MyaccountPage(WebDriver driver) {
		super(driver);
	}


	//Find the required elements to do actions with

	@FindBy(className= "dropdown-login")
	public WebElement accountMenu;

	@FindBy(xpath= "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[2]")
	public WebElement logoutButton;

	//Create a scenario for user logOut on the page and apply actions in it

	public void logOut() {

		clickButton(accountMenu, new Actions(driver));	
		clickButton(logoutButton, new Actions(driver));
	}
}
