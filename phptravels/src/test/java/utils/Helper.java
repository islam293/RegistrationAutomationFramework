package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//This method is to help in capture screenshoots after failure of any test case
public class Helper {

	public static void capturescreenshoot(WebDriver driver, 
			String screenshootName) {
		System.out.println(driver + screenshootName);

		//Save the path and the name of the screenshoots
		Path dest = Paths.get("./screenshoots/screenshoot-"+screenshootName+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out= new FileOutputStream( dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while taking screenshoots"+e.getMessage());
		}
	}
}
