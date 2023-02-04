package pompackage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrmanagement.BaseClass;

public class POMLogin extends BaseClass {
	// Object Repository
	@FindBy(css = "#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement Username;

	@FindBy(css = "#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")
	WebElement Password;

	@FindBy(css = "#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
	WebElement Loginbtn;

	public POMLogin() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void typeUsername(String uname) {
		Username.sendKeys(uname);
	}

	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}

	public void clickLoginBtn() {
		Loginbtn.click();
	}

	public String verifyTitle() {
		return driver.getTitle();
	}
}
