package com.automation.automationexercise.POMs.Base;

public interface LoginPom extends Pom {
    void enterUser(String user);

    void enterPassword(String password);

    void clickLogin();
}
