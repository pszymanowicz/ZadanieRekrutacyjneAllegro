package pageobjects;

import base.PageObjectBase;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.widget.Button;

public class StronaStartowa extends PageObjectBase {

	@FindBy(xpath = "//div[@data-box-name='departments']//a[text() = 'Elektronika']")
	private Button elektronika;

	public StronaStartowa() {
		super();
	}

	public Button getElektronika() {
		return elektronika;
	}
}
