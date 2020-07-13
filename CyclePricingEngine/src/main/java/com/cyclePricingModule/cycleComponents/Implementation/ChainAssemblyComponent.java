package com.cyclePricingModule.cycleComponents.Implementation;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;

public class ChainAssemblyComponent implements Component {
    private BuyingDate date = null;

    private String chain;
    private double chainPrice;
    private String chainWheel;
    private double chainWheelPrice;
    private String crank;
    private double crankPrice;
    private String pedal;
    private int numberOfPedals = 2;
    private double pedalPrice;
    private String toeClip;
    private int numberOfToeClips = 2;
    private double toeClipPrice;

    public ChainAssemblyComponent(BuyingDate date, String chain, String chainWheel, String crank, String pedal, String toeClip) {
        this.date = date;
        this.chain = chain;
        this.chainWheel = chainWheel;
        this.crank = crank;
        this.pedal = pedal;
        this.toeClip = toeClip;
    }

    @Override
    public void setPricing()
    {
        if (date.getYear() == 2005) {
            if (date.getMonth() >= 1 && date.getMonth() <= 6) {
                chainPrice = 500;
                chainWheelPrice = 800;
                crankPrice = 800;
                pedalPrice = 50;
                toeClipPrice = 50;
            } else {
                chainPrice = 600;
                chainWheelPrice = 900;
                crankPrice = 800;
                pedalPrice = 70;
                toeClipPrice = 70;
            }
        } else {
            chainPrice = 800;
            chainWheelPrice = 900;
            crankPrice = 1000;
            pedalPrice = 80;
            toeClipPrice = 80;
        }
    }

    @Override
    public double totalComponentPrice()
    {
        return chainPrice+chainWheelPrice+crankPrice+(numberOfPedals*pedalPrice)+(numberOfToeClips*toeClipPrice);
    }

}
