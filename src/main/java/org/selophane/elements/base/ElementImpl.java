package org.selophane.elements.base;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * An implementation of the Element interface. Delegates its work to an underlying WebElement instance for
 * custom functionality.
 */
public class ElementImpl implements Element {

    private final WebElement element;
    private final Driver driver = Driver.getDriver();
    protected WebDriverWait wait;

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public ElementImpl(final WebElement element) {
        this.element = element;
        wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitUntilVisible(){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilClickable(){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void jsFocusElement(){
        driver.getJsExecutor().executeScript("arguments[0].focus()", element);
    }

    public void jsBlurElement(){
        driver.getJsExecutor().executeScript("arguments[0].blur()", element);
    }

    public void jsWait(){
        driver.jsWait();
    }

    @Override
    public void click() {
        waitUntilClickable().click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        throw new UnsupportedOperationException("getRect() not yet implemented");
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return waitUntilVisible().isDisplayed();
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) element).getCoordinates();
    }

    @Override
    public boolean elementWired() {
        return (element != null);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        throw new UnsupportedOperationException("getScreenshotAs() not yet implemented");
    }
}
