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
public class FuelTank {
    
    Propellent mPropellent;
    int maxCapacity;

    public FuelTank(int maxCapacity) {
        mPropellent= new Propellent (maxCapacity,"solid");
        this.maxCapacity=maxCapacity;
        
    }
    public void decrement(int x){
        mPropellent.setWeight(mPropellent.getWeight()-x);
    }
    public int getWeight(){
        return mPropellent.getWeight();
    }
    public int getRemainingPercentage(){
        return ((getWeight())/maxCapacity)*100;
    }
        
    
    
    
    
    
}
