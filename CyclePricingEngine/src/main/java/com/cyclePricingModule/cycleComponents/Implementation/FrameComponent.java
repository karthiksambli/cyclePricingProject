package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;

public class FrameComponent implements Component {
    private BuyingDate date = null;
    //SteelFrame or AluminiumFrame
    private String frameType;
    private double framePrice;
    private String shocker;
    private int numberOfShocker;
    private double shockerPrice;

    public FrameComponent(String frameType, String shocker, int numberOfShocker, BuyingDate date) {
        this.frameType = frameType;
        this.shocker = shocker;
        this.numberOfShocker = numberOfShocker;
        this.date = date;
    }

    @Override
    public void setPricing()
    {
        if (date.getYear() == 2005) {
            if (date.getMonth() >= 1 && date.getMonth() <= 6) {
                if (frameType.equals("SteelFrame"))
                    framePrice = 2000;
                else if (frameType.equals("AluminiumFrame"))
                    framePrice = 1500;
                else
                    framePrice = 3000;
                shockerPrice = 500;
            } else {
                if (frameType.equals("SteelFrame"))
                    framePrice = 2300;
                else if (frameType.equals("AluminiumFrame"))
                    framePrice = 1700;
                else
                    framePrice = 3400;
                shockerPrice = 800;
            }
        } else {
            framePrice = 4000;
            shockerPrice = 1000;
        }
    }

    @Override
    public double totalComponentPrice()
    {
        return framePrice+(numberOfShocker*shockerPrice);
    }

}

