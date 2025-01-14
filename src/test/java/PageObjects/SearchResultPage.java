package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import waitUtils.explicitWait;

public class SearchResultPage extends BasePage {

	private By search_results = By.id("org.wikipedia:id/results_text");
	private By search_results_titles = By
			.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']");

	private By search_results_description = By
			.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description']");

	public SearchResultPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void verifynoresults() {
		String no_res = explicitWait.waitForVisibilityOfElementLocated(driver, search_results, 5).getText();
		Assert.assertEquals(no_res, "No results");
	}

	public String getSearchResultsDesc(String expected_title,String expected_description) {
		
		explicitWait.waitForVisibilityOfElementLocated(driver, search_results_titles, 10);

		List<WebElement> search_result_title = driver.findElements(search_results_titles);

		List<WebElement> search_result_description = driver.findElements(search_results_description);

		String actual_description = null;

		for (int i = 0; i < search_result_title.size(); i++) {
			if (search_result_title.get(i).getText().equalsIgnoreCase(expected_title)
					&& search_result_description.get(i).getText()
							.equalsIgnoreCase(expected_description)) {
				actual_description = search_result_description.get(i).getText();
				search_result_title.get(i).click();
				break;
				
			}

		}
		return actual_description;
	}
}
