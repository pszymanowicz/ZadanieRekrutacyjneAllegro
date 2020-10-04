package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

@ImplementedBy(TextContainerImpl.class)
public interface TextContainer extends Element {

	@Override
	String getText();
}
