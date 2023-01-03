package com.automation.automationexercise.POMs.TutorialsNinja;

import com.automation.automationexercise.POMs.Base.AccountPom;
import com.automation.automationexercise.POMs.Base.PomBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class TutorialsNinjaAccountPom extends PomBase implements AccountPom {
    private final By _myAccountHeader;
    private final By _myOrdersHeader;
    private final By _myAffiliateHeader;
    private final By _newsletterHeader;

    public TutorialsNinjaAccountPom(WebDriver driver) {
        super(driver);
        _myAccountHeader = By.cssSelector("#content > h2:nth-child(1)");
        _myOrdersHeader = By.cssSelector("#content > h2:nth-child(3)");
        _myAffiliateHeader = By.cssSelector("#content > h2:nth-child(5)");
        _newsletterHeader = By.cssSelector("#content > h2:nth-child(7)");
    }

    @Override
    public void validate() {
        assertThat(getElementText(_myAccountHeader)).isEqualTo("My Account");
        assertThat(getElementText(_myOrdersHeader)).isEqualTo("My Orders");
        assertThat(getElementText(_myAffiliateHeader)).isEqualTo("My Affiliate Account");
        assertThat(getElementText(_newsletterHeader)).isEqualTo("Newsletter");
    }

    @Override
    protected String getPageUrl() {
        return "http://tutorialsninja.com/demo/index.php?route=account/account";
    }
}
