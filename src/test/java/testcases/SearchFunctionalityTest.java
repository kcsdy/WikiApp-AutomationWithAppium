package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObjects.HomePage;
import PageObjects.OnboardingPage;
import PageObjects.ResultPage;
import PageObjects.SearchResultPage;

public class SearchFunctionalityTest extends BaseClass {

	@Test
	public void searchfunctionalityTest() {
		
		OnboardingPage obp = new OnboardingPage(driver);
		obp.clickSkipButton();

		HomePage homepage = new HomePage(driver);
		homepage.searchSomething("India");

		SearchResultPage searchresultpage = new SearchResultPage(driver);
		String actual_desc = searchresultpage.getSearchResultsDesc("Indian Premier League",
				"Franchise T20 cricket league annually held in India");
		
		ResultPage resultpage = new ResultPage(driver);
		resultpage.verifySearchPageDescription(actual_desc);

	}
}
