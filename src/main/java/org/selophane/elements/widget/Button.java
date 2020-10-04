package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

	@Override
	void click();
}
