package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameComponentTest {
    String frameType = "SteelFrame";
    String shocker = "Shocker";
    int numberOfShocker = 4;
    double expectedValue = 5500.0;
    Component frameComponent;

    @BeforeEach
    void setup(){

        BuyingDate date = new BuyingDate(2005,7);
        frameComponent = new FrameComponent(frameType,shocker,numberOfShocker,date);
        frameComponent.setPricing();
    }
    
    @Test
    void totalComponentPrice() {
        double value=frameComponent.totalComponentPrice();
        assertEquals(expectedValue,value);
    }
}