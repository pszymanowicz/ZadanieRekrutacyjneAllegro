package org.selophane.elements.widget;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selophane.elements.base.ElementImpl;

public class TextContainerImpl extends ElementImpl implements TextContainer {

	public TextContainerImpl(WebElement element) {
		super(element);
	}

	@Override
	public String getText() {
		wait.until(ExpectedConditions.visibilityOf(getWrappedElement()));
		jsWait();
		return getWrappedElement().getText();
	}
}
