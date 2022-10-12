package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheLoginPage() {
		navPage.getLanguageButton().click();
		navPage.getEngLanguageButton().click();

		navPage.getLoginLink().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Error: Invalid Url.");

	}

	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getLoginLink().click();
		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email",
				"Error: Invalid Attribute from email.");
		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
				"Error: Invalid Atrribute from password.");
	}

	@Test(priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {
		String email = "non-existing-user@gmal.com";
		String password = "password123";
		navPage.getLoginLink().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpError();
		Assert.assertTrue(messagePopUpPage.getMessageFromPopUpError().getText().contains("User does not exists"),
				"Error: Invalid message for user in Pop Up.");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Error : Invalid Url");
	}

	@Test(priority = 40)
	public void displaysErrorsWhenPasswordIsWrong() {
		String email = "admin@admin.com";
		String password = "password123";
		navPage.getLoginLink().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpError();
		Assert.assertTrue(messagePopUpPage.getMessageFromPopUpError().getText().contains("Wrong password"),
				"Error: Invalid message for password in Pop Up.");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Error : Invalid Url.");

	}

	@Test(priority = 50)
	public void login() {
		String email = "admin@admin.com";
		String password = "12345";
		navPage.getLoginLink().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "Error : Invalid Url.");
	}

	@Test(priority = 60)
	public void logout() {
		Assert.assertTrue(navPage.getLogOutButton().isDisplayed(), "Error: Log out button should be displayed.");
		navPage.getLogOutButton().click();

	}
}
