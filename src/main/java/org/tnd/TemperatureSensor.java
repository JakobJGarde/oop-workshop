package org.tnd;

public class TemperatureSensor extends Sensor {
    TemperatureSensor(String name){
        this.name = name;
    }

    public String toString(){
        return "name: " + getName() + " | id: " + getId() + " | temperature: " + getValue();
    }
}
