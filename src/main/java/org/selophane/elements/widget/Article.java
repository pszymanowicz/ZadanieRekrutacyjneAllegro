package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

/**
 * Typ elementu przechowujący cały przedmiot/artykuł znajdujący się
 * w wyszukiwarce obok filtrów wyszukiwania
 */
@ImplementedBy(ArticleImpl.class)
public interface Article extends Element {

	String getNazwa();

	String getCena();
}
