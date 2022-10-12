package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

	@Test(priority = 10)
	public void SetLocaleToEs() {
		navPage.getLanguageButton().click();
		navPage.getEsLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderLink().getText(), "Página de aterrizaje",
				"Error: This message should be displayed in Header.");
	}

	@Test(priority = 20)
	public void SetLocaleToEn() {
		navPage.getLanguageButton().click();
		navPage.getEngLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderLink().getText(), "Landing",
				"Error: This message should be displayed in Header.");
	}

	@Test(priority = 30)
	public void SetLocaleToCn() {
		navPage.getLanguageButton().click();
		navPage.getCnLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderLink().getText(), "首页",
				"Error: This message should be displayed in Header.");

	}

	@Test(priority = 40)
	public void SetLocaleToFr() {
		navPage.getLanguageButton().click();
		navPage.getFrLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderLink().getText(), "Page d'atterrissage",
				"Error: This message should be displayed in Header.");

	}

}