package com.cyclePricingModule.cycleExecutor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CycleImplTest {
    double expectedCyclePrice = 16580.0;
    static Cycle cycle;

    @BeforeAll
    static void setup(){
        String[] arr ={"LineBar", "2", "PvcGrip", "TubeLessTyre", "2", "Tube", "SteelFrame", "4", "Shocker", "4", "Pedal", "7/2005"};
        cycle = new CycleImpl(arr);
    }

    @Test
    void testExecute() {
        double[] value = cycle.execute();
        assertEquals(expectedCyclePrice,value[5]);
    }
}