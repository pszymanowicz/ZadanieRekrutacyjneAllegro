package base;

import driver.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	protected Driver driver;

	public TestBase(){
	}

	@BeforeTest(alwaysRun = true)
	public void setup(){
		driver = new Driver();
		Driver.setDriver(driver);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest(){
		driver.quit();
	}
}
