package testcases;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObjects.OnboardingPage;

public class AddingNewLanguageTest extends BaseClass{

	@Test
	public void addingNewLanguageTest()
	{
		OnboardingPage ob = new OnboardingPage(driver);
		ob.clickOnEditLanguageBtn();
		String new_language = ob.addNewLanguage("Spanish");
		ob.verifyThatNewLanguageIsAdded(new_language);
	}
}
