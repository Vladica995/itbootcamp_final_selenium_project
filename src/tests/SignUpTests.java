package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheSignupPage() {
		navPage.getSignUpLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Error: Invalid Url.");

	}

	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getSignUpLink().click();
		Assert.assertEquals(signUpPage.getEmailInput().getAttribute("type"), "email",
				"Error: Type should be email in Email input.");
		Assert.assertEquals(signUpPage.getPasswordInput().getAttribute("type"), "password",
				"Error: Type should be password in Password input.");
		Assert.assertEquals(signUpPage.getConfirmPasswordInput().getAttribute("type"), "password",
				"Error: Type should be password in Confirm password.");

	}

	@Test(priority = 30)
	public void displaysErrorsWhenUserAlreadyExists() {
		String name = "Another User";
		String email = "admin@admin.com";
		String password = "12345";
		String confirmPassword = "12345";
		navPage.getSignUpLink().click();
		signUpPage.getNameInput().sendKeys(name);
		signUpPage.getEmailInput().sendKeys(email);
		signUpPage.getPasswordInput().sendKeys(password);
		signUpPage.getConfirmPasswordInput().sendKeys(confirmPassword);
		signUpPage.getSignUpButton().click();
		messagePopUpPage.waitForPopUpError();
		Assert.assertTrue(messagePopUpPage.getMessageFromPopUpError().getText().contains("E-mail already exists"),
				"Error: This e-mail should be busy.");

		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Error: Invalid Url.");
	}

	@Test(priority = 40)
	public void signUp() {
		String name = "Vladica Vladicis";
		String email = "vladica.vladicis@itbootcamp.rs";
		String password = "12345";
		String confirmPassword = "12345";
		navPage.getSignUpLink().click();
		signUpPage.getNameInput().sendKeys(name);
		signUpPage.getEmailInput().sendKeys(email);
		signUpPage.getPasswordInput().sendKeys(password);
		signUpPage.getConfirmPasswordInput().sendKeys(confirmPassword);

		signUpPage.getSignUpButton().click();

		messagePopUpPage.waitForDialogVerifyYourAccount();
		Assert.assertTrue(
				messagePopUpPage.getHeaderFromDialogVerifyYourAccountDialog().getText().contains("Verify your account"),
				"Error: Message for verification must be shown");
		messagePopUpPage.getCloseButtonFromVerifyYourAccountDialog().click();
		navPage.getLogOutButton().click();
	}

}
