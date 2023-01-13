package com.automation.automationexercise.POMs.Base;

public interface WishlistPom extends Pom {
    String getLastItemHTML();

    void deleteLastWishlistItem();
}
