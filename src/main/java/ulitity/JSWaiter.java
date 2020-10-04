package ulitity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Skorzystano z https://www.swtestacademy.com/selenium-wait-javascript-angular-ajax/
 */
public class JSWaiter {

	private final WebDriver jsWaitDriver;
	private final WebDriverWait jsWait;
	private final JavascriptExecutor jsExec;

	public JSWaiter(WebDriver webDriver) {
		jsWaitDriver = webDriver;
		jsWait = new WebDriverWait(jsWaitDriver, 10);
		jsExec = (JavascriptExecutor) jsWaitDriver;
	}

	//Wait for JQuery Load
	public void waitForJQueryLoad() {
		//Wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.jsWaitDriver)
				.executeScript("return jQuery.active") == 0);

		//Get JQuery is Ready
		boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

		//Wait JQuery until it is Ready!
		if (!jqueryReady) {
			System.out.println("JQuery is NOT Ready!");
			//Wait for jQuery to load
			jsWait.until(jQueryLoad);
		} else {
			System.out.println("JQuery is Ready!");
		}
	}

	//Wait for Angular Load
	public void waitForAngularLoad() {
		WebDriverWait wait = new WebDriverWait(this.jsWaitDriver, 15);
		JavascriptExecutor jsExec = (JavascriptExecutor) this.jsWaitDriver;

		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		//Wait for ANGULAR to load
		ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
				.executeScript(angularReadyScript).toString());

		//Get Angular is Ready
		boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

		//Wait ANGULAR until it is Ready!
		if (!angularReady) {
			System.out.println("ANGULAR is NOT Ready!");
			//Wait for Angular to load
			wait.until(angularLoad);
		} else {
			System.out.println("ANGULAR is Ready!");
		}
	}

	//Wait Until JS Ready
	public void waitUntilJSReady() {
		WebDriverWait wait = new WebDriverWait(this.jsWaitDriver, 15);
		JavascriptExecutor jsExec = (JavascriptExecutor) this.jsWaitDriver;

		//Wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) jsWaitDriver)
				.executeScript("return document.readyState").toString().equals("complete");

		//Get JS is Ready
		boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

		//Wait Javascript until it is Ready!
		if (!jsReady) {
			//Wait for Javascript to load
			wait.until(jsLoad);
		}
	}

	//Wait Until JQuery and JS Ready
	public void waitUntilJQueryReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) this.jsWaitDriver;

		//First check that JQuery is defined on the page. If it is, then wait AJAX
		Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined == true) {
			//Pre Wait for stability (Optional)
			sleep(20);

			//Wait JQuery Load
			waitForJQueryLoad();

			//Wait JS Load
			waitUntilJSReady();

			//Post Wait for stability (Optional)
			sleep(20);
		} else {
			System.out.println("jQuery is not defined on this site!");
		}
	}

	//Wait Until Angular and JS Ready
	public void waitUntilAngularReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) this.jsWaitDriver;

		//First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
		Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
		if (!angularUnDefined) {
			Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
			if (!angularInjectorUnDefined) {
				//Pre Wait for stability (Optional)
				sleep(20);

				//Wait Angular Load
				waitForAngularLoad();

				//Wait JS Load
				waitUntilJSReady();

				//Post Wait for stability (Optional)
				sleep(20);
			} else {
				System.out.println("Angular injector is not defined on this site!");
			}
		} else {
			System.out.println("Angular is not defined on this site!");
		}
	}

	//Wait Until JQuery Angular and JS is ready
	public void waitJQueryAngular() {
		waitUntilJQueryReady();
		waitUntilAngularReady();
	}

	public static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
