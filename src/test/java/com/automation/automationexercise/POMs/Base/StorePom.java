package com.automation.automationexercise.POMs.Base;

public interface StorePom<TStoreItem> extends Pom {
    void addToCart(TStoreItem item);

    void addToWishList(TStoreItem item);

    String getPriceText(TStoreItem item);
}
