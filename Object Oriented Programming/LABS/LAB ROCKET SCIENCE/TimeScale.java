/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankhan;

import java.util.Date;

/**
 *
 * @author arifu
 */
public abstract class TimeScale {
    Date time;
    long startTime;
    long currentTime;
    int interval=1000;

    public TimeScale() {
            
        
        
    }
    public void setInterval(int interval){
        this.interval=interval;
    }
    public void onSubclassClasObjectConstructed(){
        time= new Date();
        startTime=time.getTime();
        while(true){
            currentTime=time.getTime();
            if((currentTime-startTime)%interval==0){
                onIntervalChange();
            }
            
        }
    }
    
    public int getTotalSecondsPassed(){
        return (int)(currentTime-startTime)/1000;
    }
   
    abstract void onIntervalChange();
    
    
    
    
    
    
}
