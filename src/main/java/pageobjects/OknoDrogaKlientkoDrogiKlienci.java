package pageobjects;

import base.PageObjectBase;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.widget.Button;

public class OknoDrogaKlientkoDrogiKlienci extends PageObjectBase {

	@FindBy(xpath = "//img[@class='mjyo_6x mse2_40 meqh_en msa3_z4 m0s5_e6 mg9e_4 mvrt_4 mj7a_4 mh36_4 isflp mupj_5k']" +
			"[@alt = 'zamknij']")
	private Button zamknij;

	public OknoDrogaKlientkoDrogiKlienci() {
		super();
	}

	public Button getZamknij() {
		return zamknij;
	}
}
