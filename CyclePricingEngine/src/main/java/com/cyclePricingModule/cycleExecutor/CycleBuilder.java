package com.cyclePricingModule.cycleExecutor;

import java.util.concurrent.BlockingQueue;

public class CycleBuilder extends Thread {
    BlockingQueue<Cycle> queue;

    public CycleBuilder(BlockingQueue<Cycle> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                Cycle cycle = queue.take();
                if(cycle == null) break;
                double[] componentPriceAndTotalPrice = cycle.execute();
                System.out.println("Handle Component Price = "+componentPriceAndTotalPrice[0]);
                System.out.println("Seat Component Price = "+componentPriceAndTotalPrice[1]);
                System.out.println("Frame Component Price = "+componentPriceAndTotalPrice[2]);
                System.out.println("Wheel Component Price = "+componentPriceAndTotalPrice[3]);
                System.out.println("Chain Component Price = "+componentPriceAndTotalPrice[4]);
                System.out.println("Total Price of One Cycle= "+componentPriceAndTotalPrice[5]);
            }
        }catch (InterruptedException ignored){
        }
    }
}
