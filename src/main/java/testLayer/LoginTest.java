package testLayer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hrmanagement.BaseClass;
import pompackage.POMLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseClass {

	POMLogin logObj;

	public LoginTest() {
		super();// Calling parent class constructor
	}

	@BeforeMethod
	public void initsetup() {
		initiate();
		logObj = new POMLogin();
		takeScreenshot("Login");
	}

	@Test(priority = 1)
	public void title() {
		String actual = logObj.verifyTitle();
		Assert.assertEquals(actual, "OrangeHRM");
	}

	@DataProvider
	public Object[][] sheetData() {
		Object result[][] = ExcelSheet.readData("Sheet1");
		return result;
	}

	@Test(priority = 2, dataProvider = "sheetData")
	public void Login(String uname, String password) {
		logObj.typeUsername(uname);
		logObj.typePassword(password);
		// logObj.clickLoginBtn();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
