package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by root on 6.6.15.
 * 
 * @author Sergei_Rudenkov
 */
public class SauceCredentialsService {

	private String name;
	private String key;

	public SauceCredentialsService() {
		fetchPropertyFile();
	}

	public String getName() {
		return name;
	}

	public String getKey() {
		return key;
	}

	private void fetchPropertyFile() {
		Properties prop = new Properties();
		String propFileName = "resources/saucelabs.properties";
		try (InputStream inputStream = new FileInputStream(propFileName)) {
			prop.load(inputStream);
			name = prop.getProperty("SAUCE_USER_NAME");
			key = prop.getProperty("SAUCE_ACCESS_KEY");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
