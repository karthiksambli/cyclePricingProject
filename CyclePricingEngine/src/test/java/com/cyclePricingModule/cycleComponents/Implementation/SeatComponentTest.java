package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatComponentTest {

    String seatType = "RubberSeat";
    String seatCover = "SeatCover";
    double expectedValue = 2500.0;
    Component seatComponent;

    @BeforeEach
    void setup(){

        BuyingDate date = new BuyingDate(2005,7);
        seatComponent = new SeatComponent(seatType, seatCover, date);
        seatComponent.setPricing();
    }

    @Test
    void totalComponentPrice() {
        double value=seatComponent.totalComponentPrice();
        assertEquals(expectedValue,value);
    }
}