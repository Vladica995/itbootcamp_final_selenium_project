package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CitiesPage;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;
import pages.SignUpPage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	protected LoginPage loginPage;
	protected NavPage navPage;
	protected SignUpPage signUpPage;
	protected CitiesPage citiesPage;
	protected MessagePopUpPage messagePopUpPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		navPage = new NavPage(driver);
		signUpPage = new SignUpPage(driver);
		citiesPage = new CitiesPage(driver, wait);
		messagePopUpPage = new MessagePopUpPage(driver, wait);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
