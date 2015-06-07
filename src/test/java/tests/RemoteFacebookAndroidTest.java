package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import annotations.Enviroment;
import annotations.Enviroment.Run;

/**
 * Created by root on 29.5.15.
 */
public class RemoteFacebookAndroidTest extends BaseAppiumTest {

	@BeforeClass
	@Enviroment(run = Run.REMOTELY)
	public void setUp() {
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app", "http://appium.s3.amazonaws.com/TestApp6.0.app.zip");// we should download facebook .apk somewhere
	}

	@Test
	public void example() throws Exception {
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();
	}
}
