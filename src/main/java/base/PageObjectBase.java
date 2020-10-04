package base;

import driver.Driver;
import org.selophane.elements.factory.api.ElementFactory;

/**
 * Klasa bazowa dla każdego PageObjectu
 */
public class PageObjectBase {

	protected Driver driver;

	public PageObjectBase() {
		this.driver = Driver.getDriver();
		ElementFactory.initElements(driver.getWrappedDriver(), this);
	}
}
