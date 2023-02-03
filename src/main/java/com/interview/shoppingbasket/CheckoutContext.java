package com.interview.shoppingbasket;

import java.util.List;

class CheckoutContext {

    private Basket basket;

    private double retailPriceTotal = 0.0;

    List<Promotion> promotions = null;

    CheckoutContext(Basket basket) {
        this.basket = basket;
    }

    public PaymentSummary paymentSummary() {
        return new PaymentSummary(retailPriceTotal);
    }

    public void setRetailPriceTotal(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Basket getBasket() {
        return basket;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }
}
