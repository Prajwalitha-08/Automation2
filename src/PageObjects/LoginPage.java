package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Component.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement Email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	public void LoginApplication() throws IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\bongoni.prajwalitha\\eclipse-workspace\\Automation2\\src\\page\\resources\\GlobalData.properties");
		prop.load(file);
		String email = prop.getProperty("email");
		Email.sendKeys(email);
		String Password = prop.getProperty("password");
		password.sendKeys(Password);
		submit.click();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
