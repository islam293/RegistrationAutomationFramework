
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//This is the class that will deal with the login page that appears after logout
public class LoginPage extends PageBase{

	// Add Constructors for the pageBase elements 
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//Find the required elements to do actions with
	@FindBy(name="username")
	WebElement email;

	@FindBy(name="password")
	WebElement password;

	@FindBy(className= "loginbtn")
	WebElement loginButton;

	//Create a scenario for user logOut on the page and apply actions in it
	public void userLogin(String Email, String Password) {
		setText(email, Email);
		setText(password, Password);
		clickButton(loginButton,new Actions(driver));
	}

}
