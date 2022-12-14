package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Component.AbstractComponent;

public class Productcatlog extends AbstractComponent {

	WebDriver driver;

	public Productcatlog(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void Catalog() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\bongoni.prajwalitha\\eclipse-workspace\\Automation2\\src\\page\\resources\\GlobalData.properties");
		prop.load(file);
		String[] itemsNeeded = prop.get("it").toString().split("#");
		String formattedname = itemsNeeded[0].trim();
		if (formattedname.length() == 0) {
			System.out.println(" total no .of products in the property file " + formattedname.length());

			System.out.println("No products in the property file");
			System.exit(0);
		}

		else if (formattedname.length() > 0) {
			int j = 0;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']//h5")));
			List<WebElement> products = driver
					.findElements(By.xpath("//div[@class='container']//div[@class='row']//h5"));

			for (int i = 0; i < products.size(); i++) {
				String[] name = products.get(i).getText().split("-");
				String formattedName = name[0].trim();
				List itemsNeedlist = Arrays.asList(itemsNeeded);

				if (itemsNeedlist.contains(formattedName)) {
					j++;
					driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
					wait.until(ExpectedConditions
							.invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));

					if (j == itemsNeeded.length) {
						System.out.println(" ZARA COAT 3 IS ADDED SUCESSFULLY");
						System.out.println(" ADIDAS ORIGINAL IS ADDED SUCESSFULLY");
						System.out.println(" IPHONE 13 PRO IS ADDED SUCESSFULLY");
						break;
					}

				}
			}

		}
	}
}
