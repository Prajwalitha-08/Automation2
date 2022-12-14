package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Component.AbstractComponent;

public class CheckOut extends AbstractComponent {
	WebDriver driver;

	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
	WebElement country;
	@FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
	WebElement Select;
	@FindBy(xpath = "//button[@type='button'][1]")
	WebElement SelectCountry;
	// @FindBy(css=".btnn.action__submit.ng-star-inserted")
	// @FindBy(xpath = "//a[contains(text(),'Place Order')]")
	// WebElement Placeorder;

	public void shippingDetails() throws IOException, InterruptedException {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-350)", "");
		Thread.sleep(2000);
		country.click();
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\bongoni.prajwalitha\\eclipse-workspace\\Automation1\\src\\page\\resources\\GlobalData.properties");
		prop.load(file);
		String place = prop.getProperty("place");
		Select.sendKeys(place);
		Thread.sleep(2000);
		SelectCountry.click();
		WebElement placeOrder = driver.findElement(By.partialLinkText("PLACE ORDER"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true)", placeOrder);
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("PLACE ORDER")).click();
	}

}
