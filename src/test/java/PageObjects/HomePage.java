package PageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import waitUtils.explicitWait;

public class HomePage extends BasePage{

	private By searchcontainer = By.id("org.wikipedia:id/search_container");
	private By searchtextbox = By.id("org.wikipedia:id/search_src_text");
	
	public HomePage(AndroidDriver driver) {
		super(driver);
	}
	
	public void searchSomething(String searchTxt) {
		
		explicitWait.waitForElementToBeClickable(driver,searchcontainer,10).click();
		hideKeyboard();
		explicitWait.waitForVisibilityOfElementLocated(driver, searchtextbox, 10).sendKeys(searchTxt);
	}
}
