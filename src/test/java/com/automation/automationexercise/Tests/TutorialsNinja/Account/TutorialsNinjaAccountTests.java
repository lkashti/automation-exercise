package com.automation.automationexercise.Tests.TutorialsNinja.Account;

import com.automation.automationexercise.POMs.Base.AddAddressPom;
import com.automation.automationexercise.POMs.Base.LoginPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaAddAddressPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaLoginPom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutorialsNinjaAccountTests {
    private final WebDriver _driver;
    private final LoginPom _loginPom;
    private final AddAddressPom _addAddressPom;

    public TutorialsNinjaAccountTests() {
        _driver = new ChromeDriver();
        _addAddressPom = new TutorialsNinjaAddAddressPom(_driver);
        _loginPom = new TutorialsNinjaLoginPom(_driver);
    }

    @Before
    public void setUp() {
        _driver.manage().window().setSize(new Dimension(1720, 1217));
        _loginPom.open();
        _loginPom.enterUser("username12479@gmail.com");
        _loginPom.enterPassword("123456");
        _loginPom.clickLogin();
        _addAddressPom.open();
    }

    @After
    public void tearDown() {
        _driver.quit();
    }

    @Test
    public void AddAddressPage_UserEntersValidAddress_ShouldBeSaved() {
        // Act
        _addAddressPom.enterFirstName("User");
        _addAddressPom.enterLastName("Name");
        _addAddressPom.enterAddress("Address");
        _addAddressPom.enterCity("City");
        _addAddressPom.enterPostCode("00000");
        _addAddressPom.pickRegionDropDownItem(By.xpath("//option[. = 'Aberdeen']"));
        _addAddressPom.clickContinue();

        // Assert
    }
}