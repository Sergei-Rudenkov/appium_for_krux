package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import annotations.Enviroment;
import annotations.Enviroment.Run;


public abstract class BaseAppiumTest {
	
	public static WebDriver driver;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();

	@Enviroment(run = Run.REMOTELY)
	abstract public void setUp();
}
