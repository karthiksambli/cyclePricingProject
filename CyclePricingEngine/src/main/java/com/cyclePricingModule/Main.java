package com.cyclePricingModule;

import com.cyclePricingModule.cycleExecutor.Cycle;
import com.cyclePricingModule.cycleExecutor.CycleImpl;
import com.cyclePricingModule.cycleExecutor.CycleBuilder;

import java.util.concurrent.*;

public class Main {

  public static void main(String[] args) throws InterruptedException {
   // String arr[] = {"LineBar", "2", "PvcGrip", "TubeLessTyre","2", "Tube", "SteelFrame","4", "Shocker","4","Pedal","7/2005"};
    System.out.println("The cycle configuration that you have requested with month/year of order :");
    for (String s:args) {
          System.out.print(s+", ");
      }
    System.out.println();
    System.out.println("Calculation is done for 1000 cycles of same configuration :");
    System.out.println("Cycles are ordered on this month/year : "+args[args.length-1]);
    System.out.println("Below is the Price of each component and total Price of one cycle :");
        BlockingQueue<Cycle> queue = new ArrayBlockingQueue<Cycle>(50);

        CycleBuilder[] cycleBuilders = new CycleBuilder[8];
        for (int i=0; i<cycleBuilders.length; i++){
          cycleBuilders[i] = new CycleBuilder(queue);
          cycleBuilders[i].start();
        }

        for(int i=0; i<1000; i++ ) {
            Cycle cycle = new CycleImpl(args);
            queue.put(cycle);
        }
  }

}
