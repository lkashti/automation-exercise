package com.automation.automationexercise.POMs.TutorialsNinja;

import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaStoreItem;
import com.automation.automationexercise.POMs.Base.PomBase;
import com.automation.automationexercise.POMs.Base.StorePom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TutorialsNinjaMainStorePom extends PomBase implements StorePom<TutorialsNinjaStoreItem> {
    private static final int ItemElementIndex = 0;
    private static final int PriceTextElementIndex = 1;

    private static final int AddToCartButtonElementIndex = 2;
    private static final int AddToWishListButtonElementIndex = 3;


    private final By _titleElement;
    private final By _macbookItem, _iphoneItem, _appleCinema30Item, _canonEos5DItem;
    private final By _macbookPriceText, _iphonePriceText, _appleCinemaPriceText, _canonEos5DPriceText;
    private final By _macbookAddToCartButton, _iphoneAddToCartButton, _appleCinema30AddToCartButton, _canonEos5DAddToCartButton;
    private final By _macbookAddToWishListButton, _iphoneAddToWishListButton, _appleCinema30AddToWishListButton, _canonEos5DAddToWishListButton;


    public TutorialsNinjaMainStorePom(WebDriver driver) {
        super(driver);
        _titleElement = By.cssSelector("#content > h3");

        _macbookItem = By.cssSelector("#content > div.row > div:nth-child(1) > div > div.caption > h4 > a");
        _iphoneItem = By.cssSelector("#content > div.row > div:nth-child(2) > div > div.caption > h4 > a");
        _appleCinema30Item = By.cssSelector("#content > div.row > div:nth-child(3) > div > div.caption > h4 > a");
        _canonEos5DItem = By.cssSelector("#content > div.row > div:nth-child(4) > div > div.caption > h4 > a");

        _macbookPriceText = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/p[2]/text()");
        _iphonePriceText = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/p[2]/text()");
        _appleCinemaPriceText = By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/p[2]/span[1]");
        _canonEos5DPriceText = By.xpath("//*[@id=\"content\"]/div[2]/div[4]/div/div[2]/p[2]/span[1]");

        _macbookAddToCartButton = By.cssSelector("#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(1)");
        _iphoneAddToCartButton = By.cssSelector("#content > div.row > div:nth-child(2) > div > div.button-group > button:nth-child(1)");
        _appleCinema30AddToCartButton = By.cssSelector("#content > div.row > div:nth-child(3) > div > div.button-group > button:nth-child(1)");
        _canonEos5DAddToCartButton = By.cssSelector("#content > div.row > div:nth-child(4) > div > div.button-group > button:nth-child(1)");

        _macbookAddToWishListButton = By.cssSelector("#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(2)");
        _iphoneAddToWishListButton = By.cssSelector("#content > div.row > div:nth-child(2) > div > div.button-group > button:nth-child(2)");
        _appleCinema30AddToWishListButton = By.cssSelector("#content > div.row > div:nth-child(3) > div > div.button-group > button:nth-child(2)");
        _canonEos5DAddToWishListButton = By.cssSelector("#content > div.row > div:nth-child(4) > div > div.button-group > button:nth-child(2) > i");
    }

    @Override
    public void validate() {
        assertThat(getElementText(_titleElement)).isEqualTo("Featured");
    }

    @Override
    protected String getPageUrl() {
        return "http://tutorialsninja.com/demo/index.php?route=common/home";
    }

    @Override
    public void addToCart(TutorialsNinjaStoreItem item) {
        var addToCartButton = getElementsByItem(item).get(AddToCartButtonElementIndex);
        clickElement(addToCartButton);
    }

    @Override
    public void addToWishList(TutorialsNinjaStoreItem item) {
        var addToWishListButton = getElementsByItem(item).get(AddToWishListButtonElementIndex);
        clickElement(addToWishListButton);
    }

    @Override
    public String getPriceText(TutorialsNinjaStoreItem item) {
        var priceTextElement = getElementsByItem(item).get(PriceTextElementIndex);
        return getElementText(priceTextElement);
    }

    private List<By> getElementsByItem(TutorialsNinjaStoreItem item) {
        switch (item) {
            case MacBook -> {
                return initializeItemElements(_macbookItem, _macbookPriceText, _macbookAddToCartButton, _macbookAddToWishListButton);
            }
            case iPhone -> {
                return initializeItemElements(_iphoneItem, _iphonePriceText, _iphoneAddToCartButton, _iphoneAddToWishListButton);
            }
            case AppleCinema30 -> {
                return initializeItemElements(_appleCinema30Item, _appleCinemaPriceText, _appleCinema30AddToCartButton, _appleCinema30AddToWishListButton);
            }
            case CanonEos5D -> {
                return initializeItemElements(_canonEos5DItem, _canonEos5DPriceText, _canonEos5DAddToCartButton, _canonEos5DAddToWishListButton);
            }
            default -> throw new IllegalStateException("Unexpected TutorialsNinja store item: " + item);
        }
    }

    private List<By> initializeItemElements(By itemElement, By priceTextElement, By addToCartButtonElement, By addToWishListButtonElement) {
        var output = new LinkedList<By>();

        output.add(ItemElementIndex, itemElement);
        output.add(PriceTextElementIndex, priceTextElement);
        output.add(AddToCartButtonElementIndex, addToCartButtonElement);
        output.add(AddToWishListButtonElementIndex, addToWishListButtonElement);

        return output;
    }
}
