package testcases;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObjects.OnboardingPage;

public class VerifyOnboardingFlow extends BaseClass {

	@Test
	public void verifyOnboardingFlow() {
		OnboardingPage obp = new OnboardingPage(driver);
		obp.verifyOnboardingPageText("The Free Encyclopedia\n…in over 300 languages");
		obp.clickOnContinueBtn();
		obp.verifyOnboardingPageText("New ways to explore");
		obp.clickOnContinueBtn();
		obp.verifyOnboardingPageText("Reading lists with sync");
		obp.clickOnContinueBtn();
		obp.verifyOnboardingPageText("Data & Privacy");
		obp.clickOnGetStartedBtn();
	}
}
