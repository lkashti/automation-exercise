package com.automation.automationexercise.POMs.Base;

import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaCurrency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class PomBase implements Pom {
    private final WebDriver _driver;
    private final By _openCurrencyMenuButton;
    private final By _setDollarCurrencyButton, _setEuroCurrencyButton, _setPoundCurrencyButton;

    public PomBase(WebDriver driver) {
        _driver = driver;
        _openCurrencyMenuButton = By.cssSelector("#form-currency > div > button");
        _setEuroCurrencyButton = By.cssSelector("#form-currency > div > ul > li:nth-child(1) > button");
        _setPoundCurrencyButton = By.cssSelector("#form-currency > div > ul > li:nth-child(2) > button");
        _setDollarCurrencyButton = By.cssSelector("#form-currency > div > ul > li:nth-child(3) > button");
    }

    @Override
    public void open() {
        _driver.get(getPageUrl());
    }

    @Override
    public void setCurrency(TutorialsNinjaCurrency currency) {
        var currencySetButton = getCurrencySetButton(currency);
        clickElement(_openCurrencyMenuButton);
        clickElement(currencySetButton);
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

    protected WebElement getRowCell(By rowSelector, int cellNum) {
        var rowElement = _driver.findElement(rowSelector);
        var cellSelector = String.format("../../td[%d]", cellNum);
        return rowElement.findElement(By.xpath(cellSelector));
    }

    protected abstract String getPageUrl();

    private By getCurrencySetButton(TutorialsNinjaCurrency currency) {
        switch (currency) {
            case Dollar -> {
                return _setDollarCurrencyButton;
            }
            case Euro -> {
                return _setEuroCurrencyButton;
            }
            case Pound -> {
                return _setPoundCurrencyButton;
            }
            default -> throw new IllegalStateException("Unexpected TutorialsNinja currency: " + currency);
        }
    }
}
