package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        // classic approach
        Boolean addItem;
        List<BasketItem> singleItems = new ArrayList<>();

        for(BasketItem basketItem : items) {
            if(singleItems.isEmpty()) singleItems.add(basketItem);
            else {
                addItem = true;

                for (BasketItem singleItem : singleItems) {
                    if (basketItem.getProductCode().equals(singleItem.getProductCode())) {
                        addItem = false;
                        singleItem.setQuantity(singleItem.getQuantity() + basketItem.getQuantity());
                        break;
                    }
                }

                if (addItem == true) {
                    singleItems.add(basketItem);
                }
            }
        }

        items = singleItems;
    }
}

