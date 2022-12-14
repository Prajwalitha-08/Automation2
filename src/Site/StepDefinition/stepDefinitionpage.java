package Site.StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObjects.CartPage;
import PageObjects.CheckOut;
import PageObjects.ConformationPage;
import PageObjects.LoginPage;
import PageObjects.Productcatlog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefinitionpage {
	WebDriver driver;

	@Given("I landed on  Ecommerce page")
	public void logged_in_with_username_and_password(){
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\bongoni.prajwalitha\\Downloads\\edgedriver_win64 (4)\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTo();
		

	}
	@Given("login with username and password")
	public void add() throws  IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.LoginApplication();
	}

	@And("Adding products to cart page")
	public void adding_prod()throws  IOException, InterruptedException {
		Productcatlog prod = new Productcatlog(driver);
		prod.Catalog();
		
	}

	@When("checking out")
	public void checkout() throws InterruptedException, IOException {
		CartPage cart = new CartPage(driver);
		cart.CartProducts();
	
	}
	
	@And("Filling details and placing order")
	public void placingorder()throws  IOException, InterruptedException {
		CheckOut check = new CheckOut(driver);
		check.shippingDetails();
	}
		

	@Then("conformation message")
	public void message() {
		ConformationPage conform = new ConformationPage(driver);
		conform.orders();
	}
}
