package org.tnd;

public class TemperatureSensor extends Sensor {
    TemperatureSensor(String name){
        this.name = name;
    }

    private double getValue(){
        this.value = -8 + (int)(Math.random() * 50);
        return this.value;
    }

    public String toString(){
        return "name: " + getName() + " | id: " + getId() + " | temperature: " + getValue();
    }
}
