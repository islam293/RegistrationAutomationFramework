package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

// This is the class that will deal with the registration page

public class RegisterPage extends PageBase{


	// Add Constructors for the pageBase elements 
	public RegisterPage(WebDriver driver) {
		super(driver);
	}


	//Find the required elements to do actions with during registration
	@FindBy(name="firstname")
	WebElement firstName;

	@FindBy(name="lastname")
	WebElement lastName;

	@FindBy(name="phone")
	WebElement mobileNumber;

	@FindBy(name="email")
	WebElement email;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="confirmpassword")
	WebElement confirmPassword;


	@FindBy(className="signupbtn")
	WebElement signupButton;


	//Create a scenario for user registration on the page and apply actions in it

	public void userRegistration(String Firstname,
			String Lastname,String Mobile,String Email,String Password,
			String ConfirmPassword) {

		setText(firstName, Firstname);
		setText(lastName, Lastname);
		setText(mobileNumber, Mobile);
		setText(email, Email);
		setText(password, Password);
		setText(confirmPassword, ConfirmPassword);

		scrollToElement(signupButton);

		clickButton(signupButton,new Actions(driver));
	}

}
