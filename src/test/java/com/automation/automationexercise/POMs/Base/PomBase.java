package com.automation.automationexercise.POMs.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class PomBase implements Pom {
    private final WebDriver _driver;

    public PomBase(WebDriver driver) {
        _driver = driver;
    }

    @Override
    public void open() {
        _driver.get(getPageUrl());
    }

    protected void clickElement(By element) {
        _driver.findElement(element).click();
    }

    protected String getElementText(By element) {
        return _driver.findElement(element).getText();
    }

    protected void setElementText(By element, String text) {
        _driver.findElement(element).sendKeys(text);
    }

    protected void setDropDownOption(By element, By option) {
        WebElement dropdown = _driver.findElement(element);
        dropdown.click();
        dropdown.findElement(option).click();
    }

    protected List<WebElement> getIterableElements(By element) {
        return _driver.findElements(element);
    }

    protected abstract String getPageUrl();
}
