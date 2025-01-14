package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import waitUtils.explicitWait;

public class ResultPage extends BasePage{

	private By search_page_desc= By.xpath("//android.widget.TextView[@resource-id=\"pcs-edit-section-title-description\"]");
	
	public ResultPage(AndroidDriver driver)
	{
		super(driver);
	}
	
	public void verifySearchPageDescription(String expected_result) {
		
		scrollGesture(3,500,1600);
		
		String search_result_desc = explicitWait.waitForVisibilityOfElementLocated(driver,search_page_desc , 10).getText();
		
		Assert.assertEquals(search_result_desc, expected_result);
	}
	
}
