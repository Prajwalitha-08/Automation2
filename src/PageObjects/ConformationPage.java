package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Component.AbstractComponent;

public class ConformationPage extends AbstractComponent {
	WebDriver driver;

	public ConformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement hero;

	public void orders() {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-550)", "");
		waitforWebElementToAppear(hero);
		String ConformMessage = hero.getText();
		System.out.println(ConformMessage);
	}
}
