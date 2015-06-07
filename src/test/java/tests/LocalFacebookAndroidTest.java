package tests;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import annotations.Enviroment;
import annotations.Enviroment.Run;

/**
 * Created by root on 29.5.15.
 */
public class LocalFacebookAndroidTest extends BaseAppiumTest {
	
	@BeforeClass
	@Enviroment(run = Run.LOCALLY)
	public void setUp(){
		File f = new File("./resources/com.facebook.katana-v35.0.0.0.337-10862146-Android-2.3.apk"); 
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("newCommandTimeout", "300000");
		capabilities.setCapability("app", f.getAbsolutePath());
	}

	@Test
	public void example() throws Exception {
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();
	}
}
