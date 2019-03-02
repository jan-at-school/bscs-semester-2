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
public class Rocket {
    Stage[] stages= new Stage[3];
    Subject lunarModule;
    String name;
    
    Rocket(String name){
        stages[0]= new Stage(130000,2290000-130000,("Rocketdyne F-1"),8400,5,165,951000000);
        stages[1]= new Stage(40100,496200-40100,"Rocketdyne J-2",1400,5,360,5141000);
        stages[2] =new Stage(13500,123000-13500,"Rocketdyne J-2",1400,1,(165+335),1000000);
        lunarModule= new Subject(16000,384400*1000);
        this.name=name;
    }
    
    
    public Engine getConnectedEngine(){
        for(int i=0;i<3;i++){
            if(stages[i].mEngines.isRunning()){
                return stages[i].mEngines;
            }
        }
        for(int i=0;i<3;i++){
            if(stages[i]!=null)
                return stages[i].mEngines;
        }
        return null;    
        
    }
    
        
    

    public int getWeight(){
        int temp=0;
        for(int i=0;i<3;i++){
            if(stages[i]!=null){
                temp+=stages[i].getGrossWeight();
            }
        }
        return temp+lunarModule.weight;   
    }
    
    public void startEngineOFStage(int stage){
        stages[stage-1].mEngines.startEngine();
        System.out.println("Engine of stage "+ stage+" started.");
    }
    public void cutOffStage(int stage){
        stages[stage-1]=null;
    }
    
    
    
    
        
    
        
    
}
