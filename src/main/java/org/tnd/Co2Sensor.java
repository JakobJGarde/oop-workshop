package org.tnd;

public class Co2Sensor extends Sensor {
    Co2Sensor(String name){
        this.name = name;
    }

    public String toString(){
        return "name: " + getName() + " | id: " + getId() + " | CO2-level: " + getValue();
    }
}