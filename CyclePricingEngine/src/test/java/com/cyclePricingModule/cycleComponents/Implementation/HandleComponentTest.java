package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandleComponentTest {

    String handleBar = "LineBar";
    String brakes = "DiscBrake";
    String handleGrips = "PvcGrip";
    int numberOfGrips = 2;
    String gear = "Gear";
    int numberOfGears = 2;
    double expectedValue = 2100.0;
    Component handleComponent;

    @BeforeEach
    void setup(){

        BuyingDate date = new BuyingDate(2005,7);
        handleComponent = new HandleComponent(handleBar,handleGrips,numberOfGrips, brakes,gear,numberOfGears, date);
        handleComponent.setPricing();
    }

    @Test
    void totalComponentPrice() {
        double value=handleComponent.totalComponentPrice();
        assertEquals(expectedValue,value);
    }
}