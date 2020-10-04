package allegro;

import base.TestBase;
import org.selophane.elements.widget.Article;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.ArrayList;

public class DodanieElementuDoKoszyka extends TestBase {

	@Test
	public void dodanieElementuDoKoszyka() {
		log.info("Ropoczęcie przypadku testowego: Dodanie produktu do koszyka");
		driver.get("https://www.allegro.pl");

		if (new OknoDrogaKlientkoDrogiKlienci().getZamknij().isDisplayed()) {
			new OknoDrogaKlientkoDrogiKlienci().getZamknij().click();
		}

		log.info("Kliknięcie w przycisk [Elektornia] na stornie startowej");
		new StronaStartowa().getElektronika().click();

		log.info("Kliknięcie w przycisk [Telefony i akcesoria] w dziale [Elektronika]");
		new DzialElektronika().getTelefonyIAkcesoria().click();

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		log.info("Zaznaczenie checkboxu [Używane] w filtrach wyszukiwania przedmiotu");
		FiltryWyszukiwania filtryWyszukiwania = new FiltryWyszukiwania();
		filtryWyszukiwania.getStanUzywane().toggle();

		log.info("Zaznaczenie checkboxu [Kup teraz] w filtrach wyszukiwania przedmiotu");
		filtryWyszukiwania.getRodzajOfertyKupTeraz().toggle();

		if (filtryWyszukiwania.getZamknijOknoNowoscFiltrDostawy().isDisplayed()) {
			log.info("Zamknięcie okna [Nowość w filtrach dostawy]");
			filtryWyszukiwania.getZamknijOknoNowoscFiltrDostawy().click();
		}

		log.info("Wpiosanie wartości 200 w pole [Cena od]");
		filtryWyszukiwania.setCenaOd("200");

		Article przedmiot = filtryWyszukiwania.getPrzedmioty().get(0);
		String nazwaPrzedmiotu = przedmiot.getNazwa();
		String cenaNaLiscie = przedmiot.getCena();

		przedmiot.click();
		log.info("Kliknięcie w przedmiot: " + nazwaPrzedmiotu);

		new Przedmiot().getDodajDoKoszyka().click();
		log.info("Kliknięcie w przycisk [Dodaj do koszyka]");

		new OknoDodalesPrzedmiotDoKoszyka().getPrzejdzDoKoszyka().click();
		log.info("Kliknięcie w przycisk [Przejdź do koszyka]");

		String opisAsercji = "Weryfikacja zgodności nazw przedmiotu który znalazł się w koszyku";
		log.info(opisAsercji);
		Assert.assertEquals(nazwaPrzedmiotu, new TwojKoszyk().getPierwszyElementNazwa(),
				opisAsercji);
		opisAsercji = "Weryfikacja poprawności cen przedmiotu";
		log.info(opisAsercji);
		Assert.assertEquals(cenaNaLiscie, new TwojKoszyk().getPierwszyElementCena(),
				opisAsercji);
	}
}
