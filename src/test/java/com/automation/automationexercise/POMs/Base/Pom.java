package com.automation.automationexercise.POMs.Base;

import com.automation.automationexercise.Enums.TutorialsNinja.TutorialsNinjaCurrency;

public interface Pom {
    void open();

    void validate();

    void setCurrency(TutorialsNinjaCurrency currency);
}
