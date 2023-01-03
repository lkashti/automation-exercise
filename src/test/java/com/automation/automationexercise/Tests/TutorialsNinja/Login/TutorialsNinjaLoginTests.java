package com.automation.automationexercise.Tests.TutorialsNinja.Login;

import com.automation.automationexercise.POMs.Base.AccountPom;
import com.automation.automationexercise.POMs.Base.LoginPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaAccountPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaLoginPom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutorialsNinjaLoginTests {
    private final WebDriver _driver;
    private final LoginPom _loginPom;
    private final AccountPom _accountPom;

    public TutorialsNinjaLoginTests() {
        _driver = new ChromeDriver();
        _loginPom = new TutorialsNinjaLoginPom(_driver);
        _accountPom = new TutorialsNinjaAccountPom(_driver);
    }

    @Before
    public void setUp() {
        _driver.manage().window().setSize(new Dimension(1720, 1217));
        _loginPom.open();
    }

    @After
    public void tearDown() {
        _driver.quit();
    }

    @Test
    public void LoginPage_UserEntersValidCredentials_ShouldLoginSuccessfully() {
        // Arrange
        var email = "username12479@gmail.com";
        var password = "123456";

        // Act
        _loginPom.enterUser(email);
        _loginPom.enterPassword(password);
        _loginPom.clickLogin();

        // Assert
        _accountPom.validate();
    }
}
