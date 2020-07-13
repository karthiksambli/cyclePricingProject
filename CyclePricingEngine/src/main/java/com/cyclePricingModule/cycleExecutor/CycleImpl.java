package com.cyclePricingModule.cycleExecutor;

import com.cyclePricingModule.BuyingDate;
import com.cyclePricingModule.cycleComponents.Component;
import com.cyclePricingModule.cycleComponents.Implementation.*;

public class CycleImpl implements Cycle{
    String[] arr;

    private String handleGrips = "PvcGrip";
    private int numberOfGrips = 1;
    private String gear = "Gear";
    private int numberOfGears = 2;

    private String seatType = "RubberSeat";

    private String tyre = "RegularTyre";

    private String frameType = "SteelFrame";
    private String shocker = "Shocker";
    private int numberOfShocker = 1;

    public CycleImpl(String[] arr){
        this.arr=arr;
    }

    @Override
    public double[] execute(){

        String[] dateValue = arr[arr.length-1].split("/");

        for(int i =0; i<arr.length-1; i++){
            int value = 1;
            if(isNumeric(arr[i])){
                value = Integer.parseInt(arr[i]);
                i++;
            }
            switch (arr[i]) {
                case "PvcGrip" -> {
                    handleGrips = "PvcGrip";
                    if (value > 1) {
                        numberOfGrips = value;
                    }
                }
                case "Gear" -> {
                    gear = "Gear";
                    if (value > 2) {
                        numberOfGears = value;
                    }
                }
                case "PlasticSeat" -> seatType = "PlasticSeat";
                case "TubeLessTyre" -> tyre = "TubeLessTyre";
                case "AluminiumFrame" -> frameType = "AluminiumFrame";
                case "Shocker" -> {
                    shocker = "Shocker";
                    if (value > 1) {
                        numberOfShocker = value;
                    }
                }
                default -> {
                    seatType = "RubberSeat";
                    tyre = "RegularTyre";
                    frameType = "SteelFrame";
                }
            }
        }

        BuyingDate date = new BuyingDate(Integer.parseInt(dateValue[1]),Integer.parseInt(dateValue[0]));

        String handleBar = "LineBar";
        String brakes = "DiscBrake";
        Component handleComponent = new HandleComponent(handleBar,handleGrips,numberOfGrips, brakes,gear,numberOfGears, date);
        handleComponent.setPricing();
        double handlePrice = handleComponent.totalComponentPrice();
       // System.out.println("HandleComponentPrice = "+handlePrice);

        String seatCover = "SeatCover";
        Component seatComponent = new SeatComponent(seatType, seatCover, date);
        seatComponent.setPricing();
        double seatPrice = seatComponent.totalComponentPrice();
       // System.out.println("SeatComponentPrice = "+seatPrice);

        Component frameComponent = new FrameComponent(frameType,shocker,numberOfShocker,date);
        frameComponent.setPricing();
        double framePrice = frameComponent.totalComponentPrice();
       // System.out.println("FrameComponentPrice = "+framePrice);

        String spokes = "Spokes";
        String rim = "Rim";
        String tube = "Tube";
        Component wheelsComponent = new WheelsComponent(date,tyre, spokes, rim, tube);
        wheelsComponent.setPricing();
        double wheelsPrice = wheelsComponent.totalComponentPrice();
       // System.out.println("WheelComponentPrice = "+wheelsPrice);

        String chain = "Chain";
        String chainWheel = "ChainWheel";
        String crank = "Crank";
        String pedal = "Pedal";
        String toeClip = "ToeClip";
        Component chainAssemblyComponent = new ChainAssemblyComponent(date, chain, chainWheel, crank, pedal, toeClip);
        chainAssemblyComponent.setPricing();
        double chainAssemblyPrice = chainAssemblyComponent.totalComponentPrice();
      //  System.out.println("ChainComponentPrice = "+chainAssemblyPrice);

        double totalCyclePrice = handlePrice+seatPrice+framePrice+wheelsPrice+chainAssemblyPrice;
       // System.out.println("TotalCyclePrice = "+totalCyclePrice);

        return new double[]{handlePrice, seatPrice, framePrice, wheelsPrice, chainAssemblyPrice, totalCyclePrice};
    }

    private static boolean isNumeric(String strNum)
    {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
