package TestObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObjects.CartPage;
import PageObjects.CheckOut;
import PageObjects.ConformationPage;
import PageObjects.LoginPage;
import PageObjects.Productcatlog;

public class EcommercePage {
public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver;
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\bongoni.prajwalitha\\Downloads\\edgedriver_win64 (4)\\msedgedriver.exe");
	driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		LoginPage loginpage= new LoginPage(driver);
		loginpage.goTo();
		loginpage.LoginApplication();
		Productcatlog prod  =new Productcatlog(driver);
		prod.Catalog();
		CartPage cart = new CartPage(driver);
		cart.CartProducts();
		CheckOut check = new CheckOut(driver);
		check.shippingDetails();
		ConformationPage conform = new ConformationPage(driver);
		conform.orders();
}
}
