package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NavPage {
	private WebDriver driver;

	public NavPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getHomeLink() {
		return driver.findElement(By.xpath("//*[@class = 'v-toolbar__items']/a[1]"));
	}

	public WebElement getAboutLink() {
		return driver.findElement(By.xpath("//*[@class = 'v-toolbar__items']/a[2]"));
	}

	public WebElement getLoginLink() {
		return driver.findElement(By.xpath("//*[@class = 'v-toolbar__items']/a[3]"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(
				By.xpath("//*[@class = 'btnAdmin hidden-sm-and-down v-btn v-btn--text theme--light v-size--default']"));
	}

	public WebElement getMyProfileLink() {
		return driver.findElement(By.xpath("//*[@class = 'v-toolbar__items']/a[3]"));
	}

	public WebElement getCitiesLinkFromAdminMenu() {
		return driver
				.findElement(By.xpath("//*[@class = 'v-menu__content theme--light menuable__content__active']/div/a"));

	}

	public WebElement getUserLinkFromAdminMenu() {
		return driver.findElement(
				By.xpath("//*[@class = 'v-menu__content theme--light menuable__content__active']/div/a[2]"));
	}

	public WebElement getSignUpLink() {
		return driver.findElement(By.xpath("//*[@class = 'v-toolbar__items']/a[4]"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@type = 'submit']"));
	}

	public WebElement getLogOutButton() {
		return driver.findElement(By.xpath("//*[@class = 'v-toolbar__items']/button[2]"));
	}

	public WebElement getLanguageButton() {
		return driver.findElement(
				By.xpath("//*[@class = 'btnLocaleActivation v-btn v-btn--text theme--light v-size--default']"));
	}

	public WebElement getEngLanguageButton() {

		return driver.findElement(By.xpath("//*[contains(@class, 'btnEN')]"));

	}

	public WebElement getEsLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnES')]"));

	}

	public WebElement getFrLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnFR')]"));
	}

	public WebElement getCnLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnCN')]"));
	}

	public WebElement getHeaderLink() {
		return driver.findElement(By.xpath("//*[@class = 'display-2 font-weight-bold']"));
	}

}
