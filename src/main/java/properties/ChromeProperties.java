package properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeProperties {

	private ChromeProperties() {
	}

	/**
	 * Method returns configuration to ChromeDriver
	 *
	 * @return ChromeOptions with configuration
	 */
	public static ChromeOptions getChromeProperties() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--test-type");
		options.addArguments("--disable-infobars");
		options.addArguments("--window-size=1280,1024");
		options.addArguments("--disable-browser-side-navigation");
		return options;
	}

}
