package com.automation.automationexercise.Tests.TutorialsNinja.Store;

import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaCurrency;
import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaStoreItem;
import com.automation.automationexercise.POMs.Base.StorePom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaMainStorePom;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class TutorialsNinjaStoreTests {


    private final WebDriver _driver;
    private final StorePom<TutorialsNinjaStoreItem> _storePom;

    public TutorialsNinjaStoreTests() {
        _driver = new ChromeDriver();
        _storePom = new TutorialsNinjaMainStorePom(_driver);
    }

    @Before
    public void setUp() {
        _driver.manage().window().setSize(new Dimension(1720, 1217));
        _storePom.open();
    }

    @Test
    public void StorePage_UserSetsCurrencyToDollar_ShouldUpdateStoreItemsPriceAccordingly() {
        // Act
        _storePom.setCurrency(TutorialsNinjaCurrency.Dollar);

        // Assert
        var macbookPrice = _storePom.getPriceText(TutorialsNinjaStoreItem.MacBook);
        assertThat(macbookPrice).startsWith("$602.00");

        var iphonePrice = _storePom.getPriceText(TutorialsNinjaStoreItem.iPhone);
        assertThat(iphonePrice).startsWith("$123.20");

        var appleCinema30Price = _storePom.getPriceText(TutorialsNinjaStoreItem.AppleCinema30);
        assertThat(appleCinema30Price).startsWith("$110.00");

        var canonEos5DPrice = _storePom.getPriceText(TutorialsNinjaStoreItem.CanonEos5D);
        assertThat(canonEos5DPrice).startsWith("$98.00");
    }

    @Test
    public void StorePage_UserSetsCurrencyToEuro_ShouldUpdateStoreItemsPriceAccordingly() {
        // Act
        _storePom.setCurrency(TutorialsNinjaCurrency.Euro);

        // Assert
        var macbookPrice = _storePom.getPriceText(TutorialsNinjaStoreItem.MacBook);
        assertThat(macbookPrice).startsWith("472.33€");

        var iphonePrice = _storePom.getPriceText(TutorialsNinjaStoreItem.iPhone);
        assertThat(iphonePrice).startsWith("96.66€");

        var appleCinema30Price = _storePom.getPriceText(TutorialsNinjaStoreItem.AppleCinema30);
        assertThat(appleCinema30Price).startsWith("86.31€");

        var canonEos5DPrice = _storePom.getPriceText(TutorialsNinjaStoreItem.CanonEos5D);
        assertThat(canonEos5DPrice).startsWith("76.89€");
    }


    @Test
    public void StorePage_UserSetsCurrencyToPound_ShouldUpdateStoreItemsPriceAccordingly() {
        // Act
        _storePom.setCurrency(TutorialsNinjaCurrency.Pound);

        // Assert
        var macbookPrice = _storePom.getPriceText(TutorialsNinjaStoreItem.MacBook);
        assertThat(macbookPrice).startsWith("£368.73");

        var iphonePrice = _storePom.getPriceText(TutorialsNinjaStoreItem.iPhone);
        assertThat(iphonePrice).startsWith("£75.46");

        var appleCinema30Price = _storePom.getPriceText(TutorialsNinjaStoreItem.AppleCinema30);
        assertThat(appleCinema30Price).startsWith("£67.38");

        var canonEos5DPrice = _storePom.getPriceText(TutorialsNinjaStoreItem.CanonEos5D);
        assertThat(canonEos5DPrice).startsWith("£60.03");
    }
}
