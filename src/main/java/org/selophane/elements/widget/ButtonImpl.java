package org.selophane.elements.widget;

import org.openqa.selenium.WebElement;
import org.selophane.elements.base.ElementImpl;

public class ButtonImpl extends ElementImpl implements Button {

	public ButtonImpl(WebElement element) {
		super(element);
	}

	@Override
	public void click() {
		getWrappedElement().click();
		jsWait();
	}
}
