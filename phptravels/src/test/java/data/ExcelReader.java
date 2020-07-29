package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Create The class that will help us to get the required parameters
//through .xlxs file
public class ExcelReader {

	//initialize element for the inputstream method
	static FileInputStream fis = null;

	// A method to find the required file for the input parameters
	//& assign it to the inputstream element
	public FileInputStream getFileInputStream() {

		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserTestData.xlsx";
		File srcFile = new File(filePath);

		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("  Test Data File not Found. terminatting proccess !! Check File Path of Test Data");
			System.exit(0);
		}
		return fis;
	}

	//read the data from the required file
	public Object[][] getExcelData() throws IOException{

		fis = getFileInputStream(); 
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int totalRowsNumber =(sheet.getLastRowNum());
		int totalCoulmnsNumber = 7;

		//put the data in a 2 dimensional array
		String[][] arrayExcelData = new String [totalRowsNumber][totalCoulmnsNumber];

		for (int i = 0; i < totalRowsNumber; i++) {
			for (int j = 0; j < totalCoulmnsNumber; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		workbook.close();
		return arrayExcelData;
	}
}
