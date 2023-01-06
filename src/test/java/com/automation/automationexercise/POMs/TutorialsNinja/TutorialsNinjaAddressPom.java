package com.automation.automationexercise.POMs.TutorialsNinja;

import com.automation.automationexercise.POMs.Base.AddressPom;
import com.automation.automationexercise.POMs.Base.PomBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TutorialsNinjaAddressPom extends PomBase implements AddressPom {
    private final By _addressesTableCells;
    private final By _deleteButtons;

    public TutorialsNinjaAddressPom(WebDriver driver) {
        super(driver);
        _addressesTableCells = By.className("text-left");
        _deleteButtons = By.cssSelector(".btn.btn-danger");
    }

    public String getLastAddressHTML() {
        List<WebElement> addresses_list = getIterableElements(_addressesTableCells);
        return addresses_list.get(addresses_list.size() - 1).getAttribute("innerHTML");
    }

    @Override
    public void deleteLastAddress() {
        List<WebElement> delete_buttons_list = getIterableElements(_deleteButtons);
        delete_buttons_list.get(delete_buttons_list.size() - 1).click();
    }

    @Override
    public void validate() {

    }

    @Override
    protected String getPageUrl() {
        return "http://tutorialsninja.com/demo/index.php?route=account/address";
    }
}
