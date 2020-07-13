# cyclePricingProject
Project without consideration of errors/exceptions 

* created cyclePricingModule as required below.

The module to be developed is a pricing engine for a cycle. A cycle can be thought of as high level components -  
1. frame 
2. handle bar with brakes 
3. seating,  
4. wheels, 
5. chain assembly 
 
Each of the above high level components will have parts, for instance, a wheel has spokes, rim, tube, tyre. 
 
The pricing module should be able to calculate the price of the cycle given its configuration. For example, price a cycle with tubeless tyres, steel frame, 4 gears. The pricing of the parts is time sensitive, means the cost of a tyre will change with time and the module should support this. A tyre can cost 200Rs from Jan 2016 - Nov 2016, and its price can change to Rs 230 from Dec 2016 onwards. 
 
The pricing module should be a command line executable, no graphical ui needed. It can take its input as command line parameters or as a json text file, whatever is convenient to specify in. The inputs to the module will be the list of constituent parts, date of pricing and it will output the price of the entire cycle and also price for each high level component - frame, wheels etc. 
 
Modular code and well thought out class/object model is expected as well as Junit tests for main classes. 
 
Calculate Pricing for 1000 cycles using multithread and blocking queue using a maximum of 10 threads. 

* steps to test the code
1. It's a maven project, need to download the jar file(CyclePricingEngine).
2. It takes input as command line parameters.
3. command to execute: java -cp CyclePricingEngine.jar com.cyclePricingModule.Main <arg0 arg1 arg1>
4. smaple input: java -cp CyclePricingEngine.jar com.cyclePricingModule.Main LineBar 2 PvcGrip TubeLessTyre 2 Tube SteelFrame 4 Shocker 4 Pedal 7/2005
5. Input rules:

       * Last parameter always should be 'DATE' (date of buying) and it should be in 'month/year' format which should be only 'numbers'.
       * If you need 5 gears for a cycle the input will be in a format <arg0 arg1> = <5 Gears>
       * Or it will take a default number Gears.
       * The parameters can be in jumbeled except DATE.
       * Need to give atleast one parameter and it should be 'DATE', it will take default configuration for all core components. (We can even develope this to take current date          when no parameter is given.)
       * If we don't give DATE parameter it will not execute.
       * The output will be always Price of all 5 core components(as asked) with total price of a cycle.
       * And it will be for 1000 cycles.
       
6.  Configuration list:

       * ChainAssemblyComponent :
       
             chain, chainWheel, crank, pedal, numberOfPedals, toeClip, numberOfToeClips.
       * FrameComponent :
       
             frameType, framePrice, shocker, numberOfShocker.
       * HandleComponent :
       
             handleBar, handleGrips, numberOfGrips, brakes, gear,numberOfGears.
       * SeatComponent : 
       
             seatType, seatCover.
       * WheelsComponent :
       
             tyre, numberOfTyre, spokes, rim, tube, numberOfTubes.
