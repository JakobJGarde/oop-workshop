package org.tnd;

public class Co2Sensor extends Sensor {
    Co2Sensor(String name){
        this.name = name;
    }

    private double getValue(){
        this.value = Math.random() * 1500;
        return this.value;
    }

    public String toString(){
        return "name: " + getName() + " | CO2-level: " + getValue() + " PPM";
    }
}