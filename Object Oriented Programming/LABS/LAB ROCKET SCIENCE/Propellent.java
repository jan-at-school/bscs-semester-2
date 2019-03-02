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
public class Propellent {
    private int weight;
    public String type;

    public Propellent(int quantity,String type) {
        if(quantity >=0 ){
            this.weight = quantity;
        }
        
    }

    public int getWeight() {
        return weight;
        
    }

    public void setWeight(int weight) {
        this.weight = weight;
        System.out.println("fuel set to "+ weight +"kg");
    }
    
    
}
