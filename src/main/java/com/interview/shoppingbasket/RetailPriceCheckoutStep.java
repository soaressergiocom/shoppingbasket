package com.interview.shoppingbasket;

import java.util.List;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        List<Promotion> promotions = checkoutContext.getPromotions();
        retailTotal = 0.0;

        for (BasketItem basketItem: basket.getItems()) {
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());
            basketItem.setProductRetailPrice(price);

            // classic approach
            // check if item is part of promotions list
            for (Promotion promotion : promotions) {
                if(promotion.getProductCode().equals(basketItem.getProductCode())){
                    retailTotal = applyPromotion(promotion, basketItem, price);
                    break;
                }
            }

            retailTotal += quantity*price;
        }

        checkoutContext.setRetailPriceTotal(retailTotal);
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        double discountPrice = price - (promotion.getDiscount() * price / 100);
        return retailTotal += item.getQuantity() * discountPrice;
    }
}
