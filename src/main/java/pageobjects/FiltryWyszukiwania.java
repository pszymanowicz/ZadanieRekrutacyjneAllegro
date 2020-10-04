package pageobjects;

import base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selophane.elements.widget.Article;
import org.selophane.elements.widget.Button;
import org.selophane.elements.widget.CheckBox;
import org.selophane.elements.widget.TextInput;

import java.util.List;

public class FiltryWyszukiwania extends PageObjectBase {

	@FindBy(xpath = "//input[@type = 'checkbox']/following-sibling::label/span[text()='używane']/..")
	private CheckBox stanUzywane;

	@FindBy(xpath = "//input[@type = 'checkbox']/following-sibling::label/span[text()='kup teraz']/..")
	private CheckBox rodzajOfertyKupTeraz;

	@FindBy(id = "price_from")
	private TextInput cenaOd;

	@FindBy(xpath = "//div[@class='opbox-listing-filters']//button[text() = 'zamknij']")
	private Button zamknijOknoNowoscFiltrDostawy;

	@FindBy(xpath = "//article")
	private List<Article> przedmioty;

	public FiltryWyszukiwania() {
		super();
	}

	public CheckBox getStanUzywane() {
		return stanUzywane;
	}

	public CheckBox getRodzajOfertyKupTeraz() {
		return rodzajOfertyKupTeraz;
	}

	/**
	 * Metoda wprowadza wymagany tekst do elementu [Cena od]
	 * Metoda dodatkowo klika w element oraz dodaje przycisk ENTER po wpisaniu teksu
	 * i czeka na przeładowanie się listy wyników
	 *
	 * @param cena
	 */
	public void setCenaOd(String cena) {
		cenaOd.click();
		cenaOd.sendKeys(cena);
		cenaOd.getWrappedElement().sendKeys(Keys.ENTER);
		waitToReloadList();
	}

	public Button getZamknijOknoNowoscFiltrDostawy() {
		return zamknijOknoNowoscFiltrDostawy;
	}

	public List<Article> getPrzedmioty() {
		return przedmioty;
	}

	/**
	 * Metoda czeka na przeładowanie się listy elementów po zmianie filtrów wyszukiwania
	 */
	public void waitToReloadList() {
		By reload = By.xpath("//div[@class = '_e219d_19-zf']");
		new WebDriverWait(this.driver, 5).until(ExpectedConditions.presenceOfElementLocated(reload));
		new WebDriverWait(this.driver, 5).until(ExpectedConditions.invisibilityOfElementLocated(reload));
	}
}
