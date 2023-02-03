package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class CheckoutPipelineTest {

    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @Mock
    CheckoutStep checkoutStep1;

    @Mock
    CheckoutStep checkoutStep2;

    @Mock
    CheckoutContext checkoutContext;

    @BeforeEach
    void setup() {
        checkoutPipeline = new CheckoutPipeline();
        checkoutStep1 = Mockito.mock(CheckoutStep.class);
        checkoutContext = Mockito.mock(CheckoutContext.class);
        basket = new Basket();
    }

    @Test
    void returnZeroPaymentForEmptyPipeline() {
        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        assertEquals(paymentSummary.getRetailTotal(), 0.0);
    }

    @Test
    void executeAllPassedCheckoutSteps() {
        // Exercise - implement testing passing through all checkout steps
        basket.add("code1", "product1", 10);
        basket.add("code2", "product2", 10);

        checkoutPipeline.addStep(checkoutStep1);

        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);
    }
}
