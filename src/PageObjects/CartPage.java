package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Component.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartbtn;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;

	public void CartProducts() throws InterruptedException {
		// driver.close();
		cartbtn.click();
		Thread.sleep(2000);
		WebElement checkOut = driver.findElement(By.xpath("//button[text()='Checkout']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkOut);
		waitforWebElementToAppear(checkout);
		Thread.sleep(2000);
		checkout.click();
	}

}
