package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheAdminCitiesPageAndListCities() {
		String email = "admin@admin.com";
		String password = "12345";
		navPage.getLoginLink().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromAdminMenu().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), "Error: Invalid Url.");

	}

	@Test(priority = 20)
	public void checksInputTypesForCreateOrEditNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromAdminMenu().click();
		citiesPage.getNewItemButton().click();
		citiesPage.WaitDialogForEditAndNewItem();
		Assert.assertEquals(citiesPage.getCityNameInput().getAttribute("type"), "text",
				"Error: In this type should be text.");

	}

	@Test(priority = 30)
	public void createNewCity() {
		String city = "Vladica Stevanovic's City";
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromAdminMenu().click();
		citiesPage.getNewItemButton().click();
		citiesPage.WaitDialogForEditAndNewItem();
		citiesPage.getCityNameInput().sendKeys(city);
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitForPopUpSuccess();
		Assert.assertTrue(messagePopUpPage.getMessageFromPopUpSuccess().getText().contains("Saved successfully"),
				"Error: In this Pop Up message should be Saved successfully");

	}

	@Test(priority = 40)
	public void editCity() {
		String oldCityName = "Vladica Stevanovic's City";

		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromAdminMenu().click();
		citiesPage.getSearchInput().sendKeys(oldCityName);
		citiesPage.WaitNumbersOfRow(1);

		citiesPage.getEditButtonFromTable(0).click();
		citiesPage.getCityNameInput();

		citiesPage.getCityNameInput().sendKeys(" Edited");
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitForPopUpSuccess();

		Assert.assertTrue(messagePopUpPage.getMessageFromPopUpSuccess().getText().contains("Saved successfully"),
				"Error: In this Pop Up message should be Saved successfully.");

	}

	@Test(priority = 50)
	public void searchCity() {
		String cityName = "Vladica Stevanovic's City Edited";
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromAdminMenu().click();
		citiesPage.getSearchInput().clear();
		citiesPage.getSearchInput().sendKeys(cityName);
		citiesPage.WaitNumbersOfRow(1);

		Assert.assertEquals(citiesPage.getCellFromTable(0, 1).getText(), "Vladica Stevanovic's City Edited",
				"Error: In this cell must be city from the search.");

	}

	@Test(priority = 60)
	public void deleteCity() {
		String cityName = "Vladica Stevanovic's City Edited";
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromAdminMenu().click();
		citiesPage.getSearchInput().sendKeys(cityName);
		citiesPage.WaitNumbersOfRow(1);
		Assert.assertEquals(citiesPage.getCellFromTable(0, 1).getText(), "Vladica Stevanovic's City Edited",
				"Error: In this cell must be city from the search.");
		citiesPage.getDeleteButtonFromTable(0).click();
		citiesPage.WaitDialogForDelete();
		citiesPage.getDeleteButton().click();
		messagePopUpPage.waitForPopUpSuccess();
		Assert.assertTrue(messagePopUpPage.getMessageFromPopUpSuccess().getText().contains("Deleted successfully"),
				"Error: In this message should be Deleted successfully");

	}

}
