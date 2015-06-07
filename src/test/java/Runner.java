import java.util.ArrayList;
import java.util.List;

import listeners.EnvListener;

import org.testng.TestNG;

/**
 * Created by root on 28.5.15.
 */
public class Runner {
	public static void main(String[] arg) {
		List<String> file = new ArrayList<String>();
		file.add("testng.xml");
		TestNG testNG = new TestNG();
		testNG.setTestSuites(file);
		testNG.addInvokedMethodListener(new EnvListener());
		testNG.run();
	}
}
