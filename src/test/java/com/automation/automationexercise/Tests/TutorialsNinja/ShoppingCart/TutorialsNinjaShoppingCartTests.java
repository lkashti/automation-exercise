package com.automation.automationexercise.Tests.TutorialsNinja.ShoppingCart;

import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaCurrency;
import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaStoreItem;
import com.automation.automationexercise.POMs.Base.ShoppingCartPom;
import com.automation.automationexercise.POMs.Base.StorePom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaMainStorePom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaShoppingCartPom;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class TutorialsNinjaShoppingCartTests {

    private final WebDriver _driver;
    private final StorePom<TutorialsNinjaStoreItem> _storePom;
    private final ShoppingCartPom<TutorialsNinjaStoreItem> _shoppingCartPom;

    public TutorialsNinjaShoppingCartTests() {
        _driver = new ChromeDriver();
        _storePom = new TutorialsNinjaMainStorePom(_driver);
        _shoppingCartPom = new TutorialsNinjaShoppingCartPom(_driver);
    }

    @Before
    public void setUp() {
        _driver.manage().window().setSize(new Dimension(1720, 1217));
        _storePom.open();
    }

    @Test
    public void StorePage_AddSingleIphoneToCart_ShouldUpdateCartAccordingly() {
        // Act
        _storePom.open();
        _storePom.addToCart(TutorialsNinjaStoreItem.iPhone);

        // Assert
        _shoppingCartPom.open();
        assertCartItemQuantity(TutorialsNinjaStoreItem.iPhone, 1);

        _shoppingCartPom.setCurrency(TutorialsNinjaCurrency.Dollar);
        assertCartItemPrices(TutorialsNinjaStoreItem.iPhone, "$123.20", "$123.20");
        assertCartTotalPrice("$123.20");

        _shoppingCartPom.setCurrency(TutorialsNinjaCurrency.Euro);
        assertCartItemPrices(TutorialsNinjaStoreItem.iPhone, "96.66€", "96.66€");
        assertCartTotalPrice("96.66€");

        _shoppingCartPom.setCurrency(TutorialsNinjaCurrency.Pound);
        assertCartItemPrices(TutorialsNinjaStoreItem.iPhone, "£75.46", "£75.46");
        assertCartTotalPrice("£75.46");
    }

    @Test
    public void StorePage_AddMultipleValidItemsToCart_ShouldUpdateCartAccordingly() {
        // Act
        _storePom.open();
        _storePom.addToCart(TutorialsNinjaStoreItem.iPhone);
        _storePom.addToCart(TutorialsNinjaStoreItem.iPhone);
        _storePom.addToCart(TutorialsNinjaStoreItem.iPhone);
        _storePom.addToCart(TutorialsNinjaStoreItem.MacBook);
        _storePom.addToCart(TutorialsNinjaStoreItem.MacBook);

        // Assert
        _shoppingCartPom.open();
        assertCartItemQuantity(TutorialsNinjaStoreItem.iPhone, 3);
        assertCartItemQuantity(TutorialsNinjaStoreItem.MacBook, 2);

        _shoppingCartPom.setCurrency(TutorialsNinjaCurrency.Dollar);
        assertCartItemPrices(TutorialsNinjaStoreItem.iPhone, "$123.20", "$369.60");
        assertCartItemPrices(TutorialsNinjaStoreItem.MacBook, "$602.00", "$1,204.00");
        assertCartTotalPrice("$1,573.60");

        _shoppingCartPom.setCurrency(TutorialsNinjaCurrency.Euro);
        assertCartItemPrices(TutorialsNinjaStoreItem.iPhone, "96.66€", "289.99€");
        assertCartItemPrices(TutorialsNinjaStoreItem.MacBook, "472.33€", "944.66€");
        assertCartTotalPrice("1,234.65€");

        _shoppingCartPom.setCurrency(TutorialsNinjaCurrency.Pound);
        assertCartItemPrices(TutorialsNinjaStoreItem.iPhone, "£75.46", "£226.38");
        assertCartItemPrices(TutorialsNinjaStoreItem.MacBook, "£368.73", "£737.45");
        assertCartTotalPrice("£963.83");
    }

    private void assertCartItemQuantity(TutorialsNinjaStoreItem item, int expectedQuantity) {
        var iphoneItemQuantity = _shoppingCartPom.getItemQuantity(item);
        assertThat(iphoneItemQuantity).isEqualTo(expectedQuantity);
    }

    private void assertCartItemPrices(TutorialsNinjaStoreItem item, String expectedUnitPrice, String expectedTotalPrice) {
        var unitPrice = _shoppingCartPom.getItemUnitPrice(item);
        var totalPrice = _shoppingCartPom.getItemTotalPrice(item);

        assertThat(unitPrice).isEqualTo(expectedUnitPrice);
        assertThat(totalPrice).isEqualTo(expectedTotalPrice);
    }

    private void assertCartTotalPrice(String expectedTotalPrice) {
        var totalPrice = _shoppingCartPom.getCartTotalPrice();
        assertThat(totalPrice).isEqualTo(expectedTotalPrice);
    }
}
