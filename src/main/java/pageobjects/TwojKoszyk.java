package pageobjects;

import base.PageObjectBase;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.widget.Button;
import org.selophane.elements.widget.TextContainer;

public class TwojKoszyk extends PageObjectBase {

	@FindBy(xpath = "//item[1]//offer-title//a[@class='_w7z6o _uj8z7']")
	private Button pierwszyElementNazwa;

	@FindBy(xpath = "//item[1]//price/div")
	private TextContainer pierwszyElementCena;

	public TwojKoszyk() {
		super();
	}

	public String getPierwszyElementNazwa() {
		return pierwszyElementNazwa.getText();
	}

	public String getPierwszyElementCena() {
		return pierwszyElementCena.getText();
	}
}
