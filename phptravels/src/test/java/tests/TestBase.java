package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import utils.Helper;

//This is the Abstract TestClass where all test suites will inherits from
public class TestBase {
	//Declare the Driver
	public static WebDriver driver;
	static int i=0;


	//Set Options for the used webdriver (Chrome is the default)
	//& open the driver to access the pages with
	@BeforeSuite
	@org.testng.annotations.Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browsername) {

		String path = "";
		if (browsername.equalsIgnoreCase("chrome")) {	
			path= System.getProperty("user.dir")+
					"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",path );
			driver = new ChromeDriver();
		}else if (browsername.equalsIgnoreCase("firefox")) {
			path= System.getProperty("user.dir")+
					"\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",path );
			driver = new FirefoxDriver();
		}else if (browsername.equalsIgnoreCase("ie")) {
			path= System.getProperty("user.dir")+
					"\\drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",path );
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
	}

	//open the required page for registration before any test cases to make sure 
	// that the steps are the same for every test case
	@BeforeMethod
	public void navigateToURL() {
		String url= "https://www.phptravels.net/register";
		driver.navigate().to(url);
		//Set implicit time for the driver to wait after opening the driver to allow 
		//the page to be fully loaded
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
	}



	//Create the method that will take screenshoots from any failed test case
	@AfterMethod
	public void screenshootOnFailure(ITestResult result) {
		i++;
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking ScreenShoot...");
			Helper.capturescreenshoot(driver, result.getName()+i);
		}
	}

	//Close the webdriver by the end of all testcases
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}






}
