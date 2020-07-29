package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import data.ExcelReader;

import pages.LoginPage;
import pages.MyaccountPage;
import pages.RegisterPage;


//create the method that will have the steps for all test cases in the suite
@Test
public class RegisterTest extends TestBase {

	//call and declare the webpage that will be used
	RegisterPage registerObject;
	MyaccountPage myAccountObject;
	LoginPage loginObject;
	
	//create variables to help me with the assertion of the test case
	
	//variable to check if i still logged in or no
	boolean loginFlag;
	
	//variables to save the current and the required URL anytime with
	String actual;
	String expected;

	//call the data from the excel file 
	//this data will represent the required test case data
	@DataProvider(name= "excelData")
	public Object [][] userRegisterData() throws IOException{
		ExcelReader ER = new ExcelReader();
		 return ER.getExcelData();
	}
	
    //start the test case
	@Test(alwaysRun=true, dataProvider="excelData")
	public void registration(String firstname, String lastname,
			String mobile, String mail, String password, 
			String confirmpassword, String result ) throws InterruptedException {

        //initialize the variables with the test data & start execution
		registerObject = new RegisterPage(driver);
		registerObject.userRegistration(firstname, lastname, mobile, mail,
				password, confirmpassword);

       //wait until the registration finish and open the next page if the test case passed	
		try {
			registerObject.waitForElementPresence(10, By.id("wishlist"));
		} catch (Exception NoSuchElementException) {
			actual=registerObject.returnURL().toString();
		}


		actual=registerObject.returnURL().toString();
	    loginFlag= false;
		
		if (actual.equals("https://www.phptravels.net/account/") ) 
		{ loginFlag= true;}

		//check if the registration completed or not
		if (result.equals("pass")) {
		expected= "https://www.phptravels.net/account/";}
		else {expected= "https://www.phptravels.net/register";}
		Assert.assertEquals(actual, expected);

		//Verify that the user can login again after register
		if (loginFlag =true && result.equals("pass")) {
		
		myAccountObject =new MyaccountPage(driver);
		myAccountObject.logOut();
		myAccountObject.waitForElementPresence(10, By.id("loginfrm"));
		 
		actual= myAccountObject.returnURL().toString();
		expected= "https://www.phptravels.net/login";
		Assert.assertEquals(actual, expected);
		loginFlag= false;
		
		loginObject =new LoginPage(driver);
		loginObject.userLogin(mail, password);
		loginObject.waitForElementPresence(10, By.id("wishlist"));
		
		//Check the url with the suggested one to know if
		//the test case is passed or failed 
		
		actual=loginObject.returnURL().toString();
		expected= "https://www.phptravels.net/account/";
		Assert.assertEquals(actual, expected);
		loginFlag=true;
		}

	}

	
//@Test(dependsOnMethods="registration")
	
	//logout after passed test case to clean, navigate and start another test case
	@AfterMethod
	public void logout() {
		//		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		if (loginFlag =true)
		myAccountObject =new MyaccountPage(driver);
		myAccountObject.logOut();

	}


}
