package com.automation.automationexercise.POMs.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    protected abstract String getPageUrl();
}
