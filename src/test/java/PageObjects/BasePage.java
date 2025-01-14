package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.google.common.collect.ImmutableMap;

import BaseTest.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class BasePage extends BaseClass{
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    
    public void hideKeyboard() {
    	driver.hideKeyboard();
    }
    
    public void scrollGesture(int n,int x,int y) {
		// Java
		
		for(int i=0;i<=n;i++) {
			boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", x, "top", y, "width", 200, "height", 300, 
							"direction", "down", 
							"percent", 1.0));
		 }
		}
    
    
}

