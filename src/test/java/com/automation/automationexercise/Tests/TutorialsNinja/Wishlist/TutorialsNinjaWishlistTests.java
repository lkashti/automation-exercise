package com.automation.automationexercise.Tests.TutorialsNinja.Wishlist;

import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaStoreItem;
import com.automation.automationexercise.POMs.Base.AccountPom;
import com.automation.automationexercise.POMs.Base.LoginPom;
import com.automation.automationexercise.POMs.Base.StorePom;
import com.automation.automationexercise.POMs.Base.WishlistPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaAccountPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaLoginPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaMainStorePom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaWishlistPom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TutorialsNinjaWishlistTests {
    private final WebDriver _driver;
    private final LoginPom _loginPom;
    private final WishlistPom _wishlistPom;
    private final StorePom<TutorialsNinjaStoreItem> _storePom;

    public TutorialsNinjaWishlistTests() {
        _driver = new ChromeDriver();
        _loginPom = new TutorialsNinjaLoginPom(_driver);
        _wishlistPom = new TutorialsNinjaWishlistPom(_driver);
        _storePom = new TutorialsNinjaMainStorePom(_driver);
    }

    @Before
    public void setUp() {
        _driver.manage().window().setSize(new Dimension(1720, 1217));
        _loginPom.open();
        _loginPom.enterUser("username12479@gmail.com");
        _loginPom.enterPassword("123456");
        _loginPom.clickLogin();
    }

    @After
    public void tearDown() {
        _wishlistPom.deleteLastWishlistItem();
        _driver.close();
    }

    @Test
    public void StorePage_AddItemToWishList_ShouldUpdateWishlistAccordingly() {
        _storePom.open();
        _storePom.addToWishList(TutorialsNinjaStoreItem.MacBook);
        _wishlistPom.open();
        assertThat(_wishlistPom.getLastItemHTML()).isEqualTo("Product 16");
    }
}
