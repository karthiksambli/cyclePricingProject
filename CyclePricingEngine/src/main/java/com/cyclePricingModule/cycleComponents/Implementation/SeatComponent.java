package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;

public class SeatComponent implements Component {
    private BuyingDate date = null;

    //RubberSeat or PlasticSeat
    private String seatType;
    private double seatPrice;
    private String seatCover;
    private double seatCoverPrice;

    public SeatComponent(String seatType, String seatCover, BuyingDate date) {
        this.seatType = seatType;
        this.seatCover = seatCover;
        this.date = date;
    }

    @Override
    public void setPricing()
    {
        if (date.getYear() == 2005) {
            if (date.getMonth() >= 1 && date.getMonth() <= 6) {
                if (seatType.equals("PlasticSeat"))
                    seatPrice = 1000;
                else if (seatType.equals("RubberSeat"))
                    seatPrice = 1500;
                else
                    seatPrice = 2000;
                seatCoverPrice = 500;
            } else {
                if (seatType.equals("PlasticSeat"))
                    seatPrice = 1200;
                else if (seatType.equals("RubberSeat"))
                    seatPrice = 1700;
                else
                    seatPrice = 2500;
                seatCoverPrice = 800;
            }
        } else {
            seatPrice = 3000;
            seatCoverPrice = 1000;
        }
    }

    @Override
    public double totalComponentPrice()
    {
        return seatPrice+seatCoverPrice;
    }
}
