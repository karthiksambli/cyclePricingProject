package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainAssemblyComponentTest {
    String chain = "Chain";
    String chainWheel = "ChainWheel";
    String crank = "Crank";
    String pedal = "Pedal";
    String toeClip = "ToeClip";
    double expectedValue = 2580.0;
    Component chainAssemblyComponent;

    @BeforeEach
    void setup(){
        BuyingDate date = new BuyingDate(2005,7);
        chainAssemblyComponent = new ChainAssemblyComponent(date, chain, chainWheel, crank, pedal, toeClip);
        chainAssemblyComponent.setPricing();
    }

    @Test
    void totalComponentPrice() {
        double value=chainAssemblyComponent.totalComponentPrice();
        assertEquals(expectedValue,value);
    }
}