package pageobjects;

import base.PageObjectBase;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.widget.Button;

public class DzialElektronika extends PageObjectBase {

	@FindBy(xpath = "//div[@data-box-name='category - Elektronika']//a[text() = 'Telefony i Akcesoria']")
	private Button telefonyIAkcesoria;

	public DzialElektronika() {
		super();
	}

	public Button getTelefonyIAkcesoria() {
		return telefonyIAkcesoria;
	}
}
