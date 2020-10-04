package org.selophane.elements.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selophane.elements.base.ElementImpl;

public class ArticleImpl extends ElementImpl implements Article {

	public ArticleImpl(WebElement element) {
		super(element);
	}

	public String getNazwa() {
		return getWrappedElement().findElement(By.xpath("//a[@title='']")).getText();
	}

	public String getCena() {
		return getWrappedElement().findElement(By.xpath("//span[@class= '_1svub _lf05o']")).getText();
	}
}
