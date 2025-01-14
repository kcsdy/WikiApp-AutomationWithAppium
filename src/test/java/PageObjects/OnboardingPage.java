package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import waitUtils.explicitWait;

public class OnboardingPage extends BasePage {

	private By skipBtn = By.id("org.wikipedia:id/fragment_onboarding_skip_button");
	private By primaryText = By.id("org.wikipedia:id/primaryTextView");
	private By continueBtn = By.id("org.wikipedia:id/fragment_onboarding_forward_button");
	private By edit_addnewlanguage = By.id("org.wikipedia:id/addLanguageButton");
	private By get_started_btn = By.id("org.wikipedia:id/fragment_onboarding_done_button");
	private By addnewlanguage = By.xpath(
			"//android.widget.TextView[@resource-id=\"org.wikipedia:id/wiki_language_title\" and @text=\"Add language\"]");
	private By searchlanguageBtn = By.id("org.wikipedia:id/menu_search_language");
	private By search_txt_box = By.id("org.wikipedia:id/search_src_text");
	private By lang_search_result = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/language_subtitle\"]");
	private By wiki_lang = By.xpath("//android.widget.TextView[@text=\"Wikipedia languages\"]");
	private By wiki_lang_list = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/wiki_language_title\"]");
	
	public OnboardingPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void clickSkipButton() {
		clickElement(skipBtn);
	}
	
	public void verifyOnboardingPageText(String expected_text) {
		//System.out.println(driver.findElement(primaryText).getText());
		Assert.assertEquals(expected_text, driver.findElement(primaryText).getText());
	}
	
	public void clickOnGetStartedBtn() {
		clickElement(get_started_btn);
	}
	
	public void clickOnContinueBtn() {
		clickElement(continueBtn);
	}

	public void clickOnEditLanguageBtn() {

		clickElement(edit_addnewlanguage);
	}

	public String addNewLanguage(String new_lang) {
		clickElement(addnewlanguage);
		clickElement(searchlanguageBtn);
		enterText(search_txt_box,new_lang);
		String new_added_lang=null;
		List<WebElement> lang_res = driver.findElements(lang_search_result);
		for(int i=0;i<lang_res.size();i++)
		{
			if(lang_res.get(i).getText().equalsIgnoreCase(new_lang))
			{
				new_added_lang = lang_res.get(i).getText();
				lang_res.get(i).click();
				break;
			}
		}
		return new_added_lang;
	}
	
	public void verifyThatNewLanguageIsAdded(String new_lang) {
		explicitWait.waitForVisibilityOfElementLocated(driver,wiki_lang , 5);
		
		List<WebElement> lang_list = driver.findElements(wiki_lang_list);
		for(int i=0;i<lang_list.size();i++)
		{
			if(lang_list.get(i).getText().equalsIgnoreCase(new_lang))
			{
				Assert.assertEquals(lang_list.get(i).getText(), new_lang);
				lang_list.get(i).click();
				break;
			}
		}
	}

}
