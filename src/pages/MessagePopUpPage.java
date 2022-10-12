package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
	}

	public void waitForPopUpError() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class = 'v-snack__wrapper v-sheet theme--dark error']")));
	}

	public void waitForPopUpSuccess() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class = 'v-snack__wrapper v-sheet theme--dark success']")));
	}

	public WebElement getMessageFromPopUpError() {
		return driver.findElement(By.xpath("//*[@class = 'v-snack__content']"));

	}

	public WebElement getMessageFromPopUpSuccess() {
		return driver.findElement(By.xpath("//*[@class = 'v-snack__wrapper v-sheet theme--dark success']"));
	}

	public WebElement getCloseButton() {
		return driver.findElement(By.xpath("//*[@class = 'v-snack__content']/button"));
	}

	public void waitForDialogVerifyYourAccount() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'v-card v-sheet theme--light']")));

	}

	public WebElement getHeaderFromDialogVerifyYourAccountDialog() {
		return driver.findElement(
				By.xpath("//*[@class = 'v-card__title headline grey lighten-2 black--text dlgVerifyAccount']"));
	}

	public WebElement getCloseButtonFromVerifyYourAccountDialog() {
		return driver.findElement(
				By.xpath("//*[@class = 'btnClose v-btn v-btn--text theme--light v-size--default primary--text']"));
	}

}
