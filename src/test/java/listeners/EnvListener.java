package listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import services.SauceCredentialsService;
import tests.BaseAppiumTest;
import annotations.Enviroment;

public class EnvListener implements IInvokedMethodListener {
	
	SauceCredentialsService sauceCredentials = new SauceCredentialsService();

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		if(arg0.getTestMethod().getMethod().getAnnotation(Enviroment.class) != null){
			Enviroment enviroment = arg0.getTestMethod().getMethod().getAnnotation(Enviroment.class);
			if (Enviroment.Run.LOCALLY == enviroment.run()){
				try {
					BaseAppiumTest.driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), BaseAppiumTest.capabilities);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}else if(Enviroment.Run.REMOTELY == enviroment.run()){
				try {
					BaseAppiumTest.driver = new RemoteWebDriver
							(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceCredentials.getName(),
									sauceCredentials.getKey())), BaseAppiumTest.capabilities);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
	}

}
