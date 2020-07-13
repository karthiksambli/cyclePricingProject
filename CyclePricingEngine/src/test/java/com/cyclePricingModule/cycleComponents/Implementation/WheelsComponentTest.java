package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WheelsComponentTest {

    String spokes = "Spokes";
    String rim = "Rim";
    String tube = "Tube";
    String tyre = "RegularTyre";
    double expectedValue = 3900.0;
    Component wheelsComponent;

    @BeforeEach
    void setup(){

        BuyingDate date = new BuyingDate(2005,7);
        wheelsComponent = new WheelsComponent(date,tyre, spokes, rim, tube);
        wheelsComponent.setPricing();
    }

    @Test
    void totalComponentPrice() {
        double value=wheelsComponent.totalComponentPrice();
        assertEquals(expectedValue,value);
    }
}