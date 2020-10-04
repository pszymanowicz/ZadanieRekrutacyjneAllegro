package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import properties.ChromeProperties;
import ulitity.JSWaiter;

import java.util.List;
import java.util.Set;

public class Driver implements WebDriver, WrapsDriver {

	private static ThreadLocal<Driver> threadLocalDriver = new ThreadLocal<>();
	private final WebDriver webDriver;
	private ChromeDriverService driverService;
	private final JSWaiter jsWaiter;
	private final JavascriptExecutor jsExecutor;

	public Driver() {
		WebDriverManager.chromedriver().setup();
		driverService = ChromeDriverService.createDefaultService();
		webDriver = new ChromeDriver(driverService, ChromeProperties.getChromeProperties());
		jsWaiter = new JSWaiter(webDriver);
		jsExecutor = (JavascriptExecutor) webDriver;
	}

	public void jsWait() {
		jsWaiter.waitUntilJSReady();
	}

	public void get(String s) {
		webDriver.get(s);
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return webDriver.findElements(by);
	}

	public WebElement findElement(By by) {
		return webDriver.findElement(by);
	}

	public String getPageSource() {
		return webDriver.getPageSource();
	}

	public void close() {
		webDriver.manage().deleteAllCookies();
		webDriver.close();
	}

	public void quit() {
		webDriver.manage().deleteAllCookies();
		webDriver.quit();
	}

	public JavascriptExecutor getJsExecutor() {
		return jsExecutor;
	}

	public static Driver getDriver() {
		return threadLocalDriver.get();
	}

	public static void removeDriver() {
		threadLocalDriver.remove();
	}

	public static void setDriver(Driver driver) {
		threadLocalDriver.set(driver);
	}

	public Set<String> getWindowHandles() {
		return webDriver.getWindowHandles();
	}

	public String getWindowHandle() {
		return webDriver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return webDriver.switchTo();
	}

	public Navigation navigate() {
		return webDriver.navigate();
	}

	public Options manage() {
		return webDriver.manage();
	}

	public WebDriver getWrappedDriver() {
		return webDriver;
	}
}
