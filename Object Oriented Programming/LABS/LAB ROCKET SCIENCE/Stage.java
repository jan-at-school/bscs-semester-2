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
public class Stage {
    int numberOfEngines;
    int bodyWeight;
    int burnTime;
    int thrust;
    public Engine mEngines;
    FuelTank mFuelTank;

    public Stage(int bodyWeight,int fuelCapacity,String engineName,int engineWeight,int numberOfEngines,int burnTime,int thrust) {
        this.burnTime=burnTime;
        this.numberOfEngines=numberOfEngines;
        this.bodyWeight=bodyWeight - numberOfEngines*engineWeight;
        this.mFuelTank = new FuelTank(fuelCapacity);
        mEngines=new Engine(engineName,numberOfEngines*engineWeight,this.mFuelTank,fuelCapacity/burnTime,thrust);
        this.thrust=thrust;
                
        
    }
    public int getWeightOfEngines(){
        return mEngines.weight;
    }
    
    public int getGrossWeight(){
        return mFuelTank.getWeight()+bodyWeight+this.getWeightOfEngines();
    }
    
    public boolean isWorking(){
        if(mFuelTank!=null && mEngines!= null){
            return true;
        }
        return false;
    }
    
    
    
}