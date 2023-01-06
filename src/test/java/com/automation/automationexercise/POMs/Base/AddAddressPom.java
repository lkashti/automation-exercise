package com.automation.automationexercise.POMs.Base;

import org.openqa.selenium.By;

public interface AddAddressPom extends Pom {
    void enterFirstName(String first_name);

    void enterLastName(String last_name);

    void enterAddress(String address);

    void enterCity(String city);

    void enterPostCode(String post_code);

    void pickRegionDropDownItem(By option);

    void clickContinue();
}
