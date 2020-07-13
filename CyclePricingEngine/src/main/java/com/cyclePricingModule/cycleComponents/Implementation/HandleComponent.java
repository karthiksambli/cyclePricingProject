package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;

public class HandleComponent implements Component {

    private BuyingDate date = null;

    private String handleBar;
    private double handleBarPrice;
    private String handleGrips;
    private int numberOfGrips;
    private double handleGripsPrice;
    private String brakes;
    private double brakesPrice;
    private String gear;
    private int numberOfGears;
    private double gearPrice;


    public HandleComponent(String handleBar, String handleGrips, int numberOfGrips, String brakes, String gear, int numberOfGears, BuyingDate date) {
        this.handleBar = handleBar;
        this.handleGrips = handleGrips;
        this.numberOfGrips = numberOfGrips;
        this.brakes = brakes;
        this.gear = gear;
        this.numberOfGears = numberOfGears;
        this.date = date;

    }

    @Override
    public void setPricing()
    {
        if (date.getYear() == 2005) {
            if (date.getMonth() >= 1 && date.getMonth() <= 6) {
                handleBarPrice = 200;
                handleGripsPrice = 50;
                brakesPrice = 800;
                gearPrice = 200;
            } else {
                handleBarPrice = 300;
                handleGripsPrice = 100;
                brakesPrice = 1000;
                gearPrice = 300;
            }
        } else {
            handleBarPrice = 400;
            handleGripsPrice = 200;
            brakesPrice = 1500;
            gearPrice = 500;
        }
    }

    @Override
    public double totalComponentPrice()
    {
        return handleBarPrice+(numberOfGrips*handleGripsPrice)+brakesPrice+(numberOfGears*gearPrice);
    }

}
