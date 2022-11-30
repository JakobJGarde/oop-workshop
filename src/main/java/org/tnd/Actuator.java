package org.tnd;

public class Actuator extends Unit {
    double value;

    Actuator(String name){
        this.name = name;
    }

    public void setValue(double value){
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }

    public String toString(){
        return "name: " + getName() + " | id: " + getId() + " | actuator-level: " + getValue();
    }
}
