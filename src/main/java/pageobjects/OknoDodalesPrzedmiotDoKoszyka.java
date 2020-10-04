package pageobjects;

import base.PageObjectBase;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.widget.Button;

public class OknoDodalesPrzedmiotDoKoszyka extends PageObjectBase {

	@FindBy(xpath = "//a[@class = '_13q9y _8tsq7 munh_56_s'][text() = 'przejdź do koszyka']")
	private Button przejdzDoKoszyka;

	public OknoDodalesPrzedmiotDoKoszyka() {
		super();
	}

	public Button getPrzejdzDoKoszyka() {
		return przejdzDoKoszyka;
	}
}
