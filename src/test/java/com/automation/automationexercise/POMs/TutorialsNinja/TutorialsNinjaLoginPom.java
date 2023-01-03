package com.automation.automationexercise.POMs.TutorialsNinja;

import com.automation.automationexercise.POMs.Base.LoginPom;
import com.automation.automationexercise.POMs.Base.PomBase;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TutorialsNinjaLoginPom extends PomBase implements LoginPom {
    private final By _loginButton;
    private final By _emailSection;
    private final By _passwordSection;

    public TutorialsNinjaLoginPom(WebDriver driver) {
        super(driver);
        _loginButton = By.cssSelector(".btn:nth-child(3)");
        _emailSection = By.id("input-email");
        _passwordSection = By.id("input-password");
    }

    @Override
    public void enterUser(String user) {
        setElementText(_emailSection, user);
    }

    @Override
    public void enterPassword(String password) {
        setElementText(_passwordSection, password);
    }

    @Override
    public void clickLogin() {
        clickElement(_loginButton);
    }

    @Override
    protected String getPageUrl() {
        return "http://tutorialsninja.com/demo/index.php?route=account/login";
    }

    @Override
    public void validate() {
        throw new NotImplementedException();
    }
}
