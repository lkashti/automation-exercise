package com.automation.automationexercise.POMs.Base;

public interface ShoppingCartPom<TStoreItem> extends Pom {
    int getItemQuantity(TStoreItem item);

    String getItemUnitPrice(TStoreItem item);

    String getItemTotalPrice(TStoreItem item);

    String getCartTotalPrice();
}
