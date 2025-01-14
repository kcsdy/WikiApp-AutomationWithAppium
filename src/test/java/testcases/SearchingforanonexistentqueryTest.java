package testcases;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObjects.HomePage;
import PageObjects.OnboardingPage;
import PageObjects.SearchResultPage;

public class SearchingforanonexistentqueryTest extends BaseClass{

	@Test
	public void searchfornonexistquery() {
		OnboardingPage obp = new OnboardingPage(driver);
		obp.clickSkipButton();

		HomePage homepage = new HomePage(driver);
		homepage.searchSomething("yuiwkb,askh");
		
		SearchResultPage srp = new SearchResultPage(driver);
		srp.verifynoresults();
		
	}

}
