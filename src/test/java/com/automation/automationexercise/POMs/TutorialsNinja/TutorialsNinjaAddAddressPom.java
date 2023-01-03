package com.automation.automationexercise.POMs.TutorialsNinja;

import com.automation.automationexercise.POMs.Base.AddAddressPom;
import com.automation.automationexercise.POMs.Base.PomBase;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TutorialsNinjaAddAddressPom extends PomBase implements AddAddressPom {
    private final By _firstNameField;
    private final By _lastNameField;
    private final By _addressField;
    private final By _cityField;
    private final By _postCodeField;
    private final By _regionDropDown;
    private final By _continueButton;

    public TutorialsNinjaAddAddressPom(WebDriver driver) {
        super(driver);
        _firstNameField = By.id("input-firstname");
        _lastNameField = By.id("input-lastname");
        _addressField = By.id("input-address-1");
        _cityField = By.id("input-city");
        _postCodeField = By.id("input-postcode");
        _regionDropDown = By.id("input-zone");
        _continueButton = By.cssSelector(".btn-primary");
    }

    @Override
    public void enterFirstName(String first_name) {
        setElementText(_firstNameField, first_name);
    }

    @Override
    public void enterLastName(String last_name) {
        setElementText(_lastNameField, last_name);
    }

    @Override
    public void enterAddress(String address) {
        setElementText(_addressField, address);
    }

    @Override
    public void enterCity(String city) {
        setElementText(_cityField, city);
    }

    @Override
    public void enterPostCode(String post_code) {
        setElementText(_postCodeField, post_code);
    }

    @Override
    public void pickRegionDropDownItem(By option) {
        setDropDownOption(_regionDropDown, option);
    }

    public void clickContinue() {
        clickElement(_continueButton);
    }

    @Override
    public void validate() {
        throw new NotImplementedException();
    }

    @Override
    protected String getPageUrl() {
        return "http://tutorialsninja.com/demo/index.php?route=account/address/add";
    }
}
