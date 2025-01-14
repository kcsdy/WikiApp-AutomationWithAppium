package BaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException, InterruptedException {


			service = new AppiumServiceBuilder()
					.withAppiumJS(new File(
							"C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
			service.start();
			// Desired Capabilities
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability("platformName", "Android"); // Platform
//			caps.setCapability("appium:deviceName", "KuntalPhone"); // Device Name or Serial Number
//			// caps.setCapability("platformVersion", "12"); // Android version (optional)
//			caps.setCapability("appium:automationName", "UIAutomator2");
//			caps.setCapability("appium:appPackage", "org.wikipedia"); // Replace with your app's package name
//			caps.setCapability("appium:appActivity", "org.wikipedia.DefaultIcon"); // Replace with your app's main activity
//			caps.setCapability("appium:noReset", true); // Avoid resetting app state
//
//			// Appium Server URL
//			URL appiumServer = new URL("http://127.0.0.1:4723/");
//
//			// Initialize Driver
//			driver = new AndroidDriver(appiumServer, caps);
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("KuntalPhone");
			options.setChromedriverExecutable(
					"C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			options.setAppPackage("org.wikipedia");
			options.setAppActivity("org.wikipedia.DefaultIcon");
			//options.noReset();

			// AndroidDriver , IOSDriver (Initializing the driver object)
			driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// Confirmation Log
			System.out.println("App launched successfully!");
			
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();

	}

}
