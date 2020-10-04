package pageobjects;

import base.PageObjectBase;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.widget.Button;

public class Przedmiot extends PageObjectBase {

	@FindBy(id = "add-to-cart-button")
	private Button dodajDoKoszyka;

	public Przedmiot() {
		super();
	}

	public Button getDodajDoKoszyka() {
		return dodajDoKoszyka;
	}
}
