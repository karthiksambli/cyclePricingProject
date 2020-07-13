package com.cyclePricingModule;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyingDateTest {
    static BuyingDate buyingDate;

    @BeforeAll
    static void setup(){
        buyingDate = new BuyingDate(2010,10);
    }

    @Test
    void getYear() {
        assertEquals(2010, buyingDate.getYear());
    }

    @Test
    void getMonth() {
        assertEquals(10, buyingDate.getMonth());
    }
}