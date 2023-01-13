package com.automation.automationexercise.POMs.TutorialsNinja;

import com.automation.automationexercise.POMs.Base.AddressPom;
import com.automation.automationexercise.POMs.Base.PomBase;
import com.automation.automationexercise.POMs.Base.WishlistPom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TutorialsNinjaWishlistPom extends PomBase implements WishlistPom {
    private final By _wishlistItemsTableCells;
    private final By _deleteButtons;

    public TutorialsNinjaWishlistPom(WebDriver driver) {
        super(driver);
        _wishlistItemsTableCells = By.className("text-left");
        _deleteButtons = By.cssSelector(".btn.btn-danger");
    }

    @Override
    public String getLastItemHTML() {
        List<WebElement> wishlistitems = getIterableElements(_wishlistItemsTableCells);
        return wishlistitems.get(wishlistitems.size() - 1).getAttribute("innerHTML");
    }

    @Override
    public void deleteLastWishlistItem() {
        List<WebElement> delete_buttons_list = getIterableElements(_deleteButtons);
        delete_buttons_list.get(delete_buttons_list.size() - 1).click();
    }

    @Override
    public void validate() {

    }

    @Override
    protected String getPageUrl() {
        return "http://tutorialsninja.com/demo/index.php?route=account/wishlist";
    }
}
