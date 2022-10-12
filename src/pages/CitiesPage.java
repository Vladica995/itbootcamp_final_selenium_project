package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.xpath(
				"//*[@class ='btnNewItem v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary']"));
	}

	public WebElement getCityNameInput() {
		return driver.findElement(By.xpath("//*[@id = 'name']"));
	}

	public WebElement getSearchInput() {
		return driver.findElement(By.xpath("//*[@id = 'search']"));
	}

	public void WaitDialogForEditAndNewItem() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'v-card v-sheet theme--light']")));
	}

	public void WaitDialogForDelete() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class = 'v-card__text body-1 text-body-1 py-3']")));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnSave')]"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(
				By.xpath("//*[@class = 'v-btn v-btn--text theme--light v-size--default red--text text--lighten3']"));
	}

	public void WaitNumbersOfRow(int row) {
		List<WebElement> lists = driver.findElements(By.xpath("//*[@class = 'v-data-table__wrapper']/table/tbody/tr"));

		wait.until(ExpectedConditions.visibilityOfAllElements(lists.get(row)));
	}

	public WebElement getCellFromTable(int row, int cell) {
		List<WebElement> lists = driver.findElements(By.xpath("//*[@class = 'v-data-table__wrapper']/table/tbody/tr"));
		return lists.get(row).findElements(By.tagName("td")).get(cell);

	}

	public WebElement getEditButtonFromTable(int row) {
		List<WebElement> lists = driver.findElements(By.xpath("//*[@id = 'edit']"));
		return lists.get(row);

	}

	public WebElement getDeleteButtonFromTable(int row) {
		List<WebElement> lists = driver.findElements(By.xpath("//*[@id = 'delete']"));
		return lists.get(row);
	}

	public void ActionforEdit() {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.BACK_SPACE);

	}

}
