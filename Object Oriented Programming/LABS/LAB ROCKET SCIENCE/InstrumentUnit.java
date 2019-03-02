/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankhan;

/**
 *
 * @author arifu
 */
public class InstrumentUnit extends TimeScale{
    Rocket mRocket;
    //all info....
    long distanceCovered=19999994;
    long distanceOfDestination;
    double remainingFuelPercentageForStage;
    double Vf=0;
    int currentWeight;
    int focusedStage=1;
    int time=0;
    int time_scale=1000;
    String currentInfoString = "Mission Not Launched yet.";


    public InstrumentUnit() {
        this.mRocket = new Rocket("Saturn V");
        super.setInterval(time_scale);
        Vf=0;
        this.distanceOfDestination=this.mRocket.lunarModule.destinationDistance;
        this.currentInfoString="Building Rocket";
        
    }
    
    
    
    public void launchMission(){
        
        
        while(focusedStage<3){
            time++;
            mRocket.stages[focusedStage].mEngines.startEngine();
            currentInfoString="Engine Started of stage : "+ focusedStage;
            mRocket.getConnectedEngine().signal();
            this.onIntervalChange();
            if(mRocket.stages[focusedStage].mFuelTank.getWeight()<0){
                mRocket.cutOffStage(focusedStage);
                System.out.println("STAGE:"+focusedStage+" CUT OFF");
                focusedStage++;
                
            }
            if(distanceCovered>this.distanceOfDestination){
                success();
            }
            
            printInfo();
        }
        System.out.println("ALL STAGES CUT OFF");
        motion();
        
        
        
        
        
    }
    public void motion(){
        
        
        while(true){
            onIntervalChange();
            if(this.distanceCovered>this.distanceOfDestination){
                 success();   
                
            }
            else if(this.distanceCovered<=0){
                failed();
            }
        }
        
        
        
    }
    public void success(){
        System.out.println("CONGRATULATION SPACE MISSION SUCCEEDED!!!");
    }
    public void failed(){
        System.out.println("SORRY YOUR SPACE MISSION FAILED");
        this.onIntervalChange();
    }
        
    
    
    public void printInfo(){
        //clearConsole();
        System.out.println("___________________"+mRocket.name+"_________________"+time+"s");
        System.out.println("Velocity = "+ Vf);
        System.out.println("Height: "+ distanceCovered);
        System.out.println("Weight "+mRocket.getWeight());
        System.out.println("Distance Remaining: --");
        int temp=mRocket.getConnectedEngine().connectedTank.getWeight();
        System.out.println("Remaining fuel for stage " +focusedStage+": "+temp);
        temp=mRocket.getConnectedEngine().connectedTank.getRemainingPercentage();
        temp= temp/10;
        for(int i=0;i<temp;i++){
            System.out.printf("|");
        }
        for(int i=0;i<10-temp;i++){
            System.out.printf(" ");
        }
        //System.out.printf("|\nTotal TIme elapsed : %d",super.getTotalSecondsPassed());
        System.out.printf("\nINFO DISPLAY: \n\t%s\n", currentInfoString);




    }
    
   
    
    
    
    public double netForce(){
        double thrust=mRocket.getConnectedEngine().getThrust();
        double Moon=(9*10e11)*(mRocket.getWeight()*7.34e22)/Math.pow(distanceOfDestination-distanceCovered,2);
        double Earth=(9*10e11)*(mRocket.getWeight()*5.97e24)/Math.pow(distanceOfDestination+distanceCovered,2);
        return thrust+Moon+Earth;    
    }


    public void onIntervalChange() {
        
        if(mRocket.getConnectedEngine()!=null){
            if(mRocket.getConnectedEngine().isRunning){
                    
                   //update info for accelaration
                   double Vi=Vf;
                   currentWeight=mRocket.getWeight();
                   double a=netForce()/currentWeight;
                   
                   Vf=Vf+a*1;
                   
                   double s=(Math.pow(Vf,2)-Math.pow(Vi,2))/(2*a);
                   if(s>0)
                        distanceCovered+=s;
                   remainingFuelPercentageForStage=(mRocket.getConnectedEngine().connectedTank.getWeight()/mRocket.getConnectedEngine().connectedTank.maxCapacity)*100;
            }          
        }
        else{
            
                double a=netForce()/currentWeight;
                double s=(Math.pow(Vf,2)-Math.pow(Vf,2))/(2*a);
                   if(s>0)
                        distanceCovered+=s;
                   
        }
//        try{
//          printInfo();
//        }
//        catch(Exception e){
//                       
//        }
        
    }
        
        
    
}


