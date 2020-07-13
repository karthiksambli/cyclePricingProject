package com.cyclePricingModule.cycleComponents;

public interface Component {
    //method to set prices for different parts of respective components.
    public void setPricing();
    //method to get total component price(sum of all parts price)
    public double totalComponentPrice();
}
