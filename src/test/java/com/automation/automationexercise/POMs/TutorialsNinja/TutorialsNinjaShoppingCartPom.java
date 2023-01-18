package com.automation.automationexercise.POMs.TutorialsNinja;

import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaStoreItem;
import com.automation.automationexercise.POMs.Base.PomBase;
import com.automation.automationexercise.POMs.Base.ShoppingCartPom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TutorialsNinjaShoppingCartPom extends PomBase implements ShoppingCartPom<TutorialsNinjaStoreItem> {
    private static final int ItemQuantityCell = 4;
    private static final int ItemUnitPriceCell = 5;
    private static final int ItemTotalPriceCell = 6;

    private final By _totalCartPrice;

    public TutorialsNinjaShoppingCartPom(WebDriver driver) {
        super(driver);
        _totalCartPrice = By.cssSelector("#content > div.row > div > table > tbody > tr:nth-child(4) > td:nth-child(2)");
    }

    @Override
    public void validate() {
    }

    @Override
    protected String getPageUrl() {
        return "http://tutorialsninja.com/demo/index.php?route=checkout/cart";
    }

    @Override
    public int getItemQuantity(TutorialsNinjaStoreItem item) {
        var cellElement = getItemCartCell(item, ItemQuantityCell).findElement(By.xpath("./div/input"));
        return Integer.parseInt(cellElement.getAttribute("value"));
    }

    @Override
    public String getItemUnitPrice(TutorialsNinjaStoreItem item) {
        var cellElement = getItemCartCell(item, ItemUnitPriceCell);
        return cellElement.getText();
    }

    @Override
    public String getItemTotalPrice(TutorialsNinjaStoreItem item) {
        var cellElement = getItemCartCell(item, ItemTotalPriceCell);
        return cellElement.getText();
    }

    @Override
    public String getCartTotalPrice() {
        return getElementText(_totalCartPrice);
    }

    private WebElement getItemCartCell(TutorialsNinjaStoreItem item, int cellNumber) {
        var rowSelector = By.linkText(item.toString());
        return getRowCell(rowSelector, cellNumber);
    }
}
