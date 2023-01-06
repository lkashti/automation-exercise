package com.automation.automationexercise.Tests.TutorialsNinja.Account;

import com.automation.automationexercise.POMs.Base.AddAddressPom;
import com.automation.automationexercise.POMs.Base.AddressPom;
import com.automation.automationexercise.POMs.Base.LoginPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaAddAddressPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaAddressPom;
import com.automation.automationexercise.POMs.TutorialsNinja.TutorialsNinjaLoginPom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;

import static org.assertj.core.api.Assertions.assertThat;

public class TutorialsNinjaAddAddressTests {
    private final WebDriver _driver;
    private final LoginPom _loginPom;
    private final AddAddressPom _addAddressPom;
    private final AddressPom _addressPom;

    public TutorialsNinjaAddAddressTests() {
        _driver = new ChromeDriver();
        _loginPom = new TutorialsNinjaLoginPom(_driver);
        _addAddressPom = new TutorialsNinjaAddAddressPom(_driver);
        _addressPom = new TutorialsNinjaAddressPom(_driver);
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
        _addressPom.deleteLastAddress();
        assertThat(_addressPom.getLastAddressHTML()).isEqualTo("user name<br>aaa<br>bbb 12345<br>Cardiff<br>United Kingdom");
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

        assertThat(_addressPom.getLastAddressHTML()).isEqualTo("User Name<br>Address<br>City 00000<br>Aberdeen<br>United Kingdom");


    }
}