package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;

public class WheelsComponent implements Component {
    private BuyingDate date = null;
    //TubelessTyre or RegularTyre
    private String tyre;
    private int numberOfTyre = 2;
    private double tyrePrice;
    private String spokes;
    private double spokesPrice;
    private String rim;
    private double rimPrice;
    private String tube;
    private int numberOfTubes = 2;
    private double tubePrice;

    public WheelsComponent(BuyingDate date, String tyre, String spokes, String rim, String tube) {
        this.date = date;
        this.tyre = tyre;
        this.spokes = spokes;
        this.rim = rim;
        this.tube = tube;
    }

    @Override
    public void setPricing()
    {
        if (date.getYear() == 2005) {
            if (date.getMonth() >= 1 && date.getMonth() <= 6) {
                if (tyre.equals("TubeLessTyre"))
                    tyrePrice = 500;
                else if (tyre.equals("RegularTyre"))
                    tyrePrice = 600;
                else
                    tyrePrice = 700;
                spokesPrice = 800;
                rimPrice = 800;
                tubePrice = 50;
            } else {
                if (tyre.equals("TubeLessTyre"))
                    tyrePrice = 700;
                else if (tyre.equals("RegularTyre"))
                    tyrePrice = 900;
                else
                    tyrePrice = 800;
                spokesPrice = 900;
                rimPrice = 1000;
                tubePrice = 100;
            }
        } else {
            tyrePrice = 1000;
            spokesPrice = 1000;
            rimPrice = 1000;
            tubePrice = 100;
        }
    }

    @Override
    public double totalComponentPrice()
    {
        return (numberOfTyre*tyrePrice)+spokesPrice+rimPrice+(numberOfTubes*tubePrice);
    }
}
