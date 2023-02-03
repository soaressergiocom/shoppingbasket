package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    void emptyBasket() {
        Basket basket = new Basket();
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(), 0);
    }

    @Test
    void createBasketFullConstructor() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(), 1);
        assertEquals(basketSize.get(0).getProductCode(), "productCode");
        assertEquals(basketSize.get(0).getProductName(), "myProduct");
        assertEquals(basketSize.get(0).getQuantity(), 10);
    }

    @Test
    void createBasketWithMultipleProducts() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        basket.add("productCode2", "myProduct2", 10);
        basket.add("productCode3", "myProduct3", 10);

        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(),3);
        assertEquals(basketSize.get(0).getProductCode(), "productCode");
        assertEquals(basketSize.get(0).getProductName(), "myProduct");
        assertEquals(basketSize.get(0).getQuantity(), 10);
        assertEquals(basketSize.get(1).getProductCode(), "productCode2");
        assertEquals(basketSize.get(1).getProductName(), "myProduct2");
        assertEquals(basketSize.get(1).getQuantity(), 10);
        assertEquals(basketSize.get(2).getProductCode(), "productCode3");
        assertEquals(basketSize.get(2).getProductName(), "myProduct3");
        assertEquals(basketSize.get(2).getQuantity(), 10);
    }

    @Test
    void consolidateBasketTest() {
        // Exercise - implement the unit test for consolidate items
        Basket basket = new Basket();
        basket.add("code1", "product1", 10);
        basket.add("code2", "product2", 10);
        basket.add("code3", "product3", 10);
        basket.add("code1", "product1", 1);
        basket.add("code2", "product2", 1);
        basket.consolidateItems();

        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(),3);
        assertEquals(basketSize.get(0).getProductCode(), "code1");
        assertEquals(basketSize.get(0).getProductName(), "product1");
        assertEquals(basketSize.get(0).getQuantity(), 11);
        assertEquals(basketSize.get(1).getProductCode(), "code2");
        assertEquals(basketSize.get(1).getProductName(), "product2");
        assertEquals(basketSize.get(1).getQuantity(), 11);
        assertEquals(basketSize.get(2).getProductCode(), "code3");
        assertEquals(basketSize.get(2).getProductName(), "product3");
        assertEquals(basketSize.get(2).getQuantity(), 10);

    }
}
