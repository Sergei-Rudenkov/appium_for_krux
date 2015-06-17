package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import services.SauceCredentialsService;

/**
 * Remote Test Krux android app.
 * TODO: refactoring, add sauce tunnel 
 * @author Sergei_Rudenkov
 */
public class FirstKruxRemoteTest extends BaseAppiumTest {

	SauceCredentialsService sauceCredentialsService = new SauceCredentialsService();

	@BeforeClass
	public void setUp() {
		capabilities.setCapability("appiumVersion", "1.4.0");
		capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("browserName", "");
		capabilities.setCapability("platformVersion", "4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "Selendroid");
		capabilities.setCapability("app", "http://webtest.krux.com/android_krux_sdk_apk/app-debug.apk");
		capabilities.setCapability("newCommandTimeout", "300000");
		capabilities.setCapability("appActivity", "com.krux.androidsdk.testapp.EventActivity");
		capabilities.setCapability("appPackage", "androidsdk.krux.com.krux_android_sdk_test_app");

		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub",
					sauceCredentialsService.getName(), sauceCredentialsService.getKey())), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void example() throws Exception {
		WebElement button = driver.findElement(By.xpath("//*[@value='Fire Event']"));
		button.click();
	}
}

