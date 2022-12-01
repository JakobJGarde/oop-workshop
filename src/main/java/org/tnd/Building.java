package org.tnd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Building extends Unit {
    private List<Sensor> sensors;
    private List<Actuator> actuators;

    Building(String name){
        sensors = new ArrayList<>();
        actuators = new ArrayList<>();
        this.name = name;
    }

    public void getSensors(){
        System.out.println("List of sensors for " + getName() + ":");
        for (Sensor sensor : sensors){
            System.out.println("  " + sensor);
        }
    }

    public void getActuators(){
        System.out.println("List of actuators for " + getName() + ":");
        for (Actuator actuator : actuators){
            System.out.println("  " + actuator);
        }
    }

    public TemperatureSensor addTemperatureSensor(String name){
        TemperatureSensor tempSensor = new TemperatureSensor(name);
        sensors.add(tempSensor);
        return tempSensor;
    }

    public Co2Sensor addCo2Sensor(String name){
        Co2Sensor co2Sensor = new Co2Sensor(name);
        sensors.add(co2Sensor);
        return co2Sensor;
    }

    public void removeSensor(UUID id){
        sensors.removeIf(sensor -> sensor.getId() == id);
    }

    public Actuator addActuator(String name){
        Actuator actuator = new Actuator(name);
        actuator.setValue(1.0);
        actuators.add(actuator);
        return actuator;
    }

    public void removeActuator(UUID id){
        actuators.removeIf(actuator -> actuator.getId() == id);
    }

    public void prettyPrint(){
        System.out.println("Building Name: " + getName());
        getActuators();
        getSensors();
    }
}
