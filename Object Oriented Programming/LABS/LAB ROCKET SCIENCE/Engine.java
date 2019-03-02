/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankhan;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arifu
 */
public class Engine{
    
    String id;
    int weight;
    int combustionRate;
    int thrust;
    FuelTank connectedTank;
    boolean isRunning=false;
   
    
    

    public Engine(String id,int weight,FuelTank tankReference,int combustionRate,int thrust) {
        this.id = id;
        this.weight=weight;
        this.combustionRate=combustionRate;
        this.connectedTank=tankReference;
        this.thrust=thrust;

    }
    
    private  void onConstructorFinished(){
        
    }
    
    public void startEngine(){

        isRunning=true;
    }
    public void stopEngine(){
        isRunning=false;
    }
    public boolean isRunning(){
        return isRunning;
    }
    
    public int getThrust(){
        if(isRunning){
            return thrust;
        }
        return 0;
    }

    public void signal(){
        this.connectedTank.decrement(combustionRate);
    }
    
    
    
}
