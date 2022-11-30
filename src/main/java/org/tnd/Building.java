package org.tnd;

import java.util.List;
import java.util.UUID;

public class Building extends Unit {
    private List<Sensor> sensors;
    private List<Actuator> actuators;

    Building(String name){
        this.name = name;
    }

    public List<Sensor> getSensors(){
        return this.sensors;
    }

    public List<Actuator> getActuators(){
        return this.actuators;
    }

    public UUID addTemperatureSensor(String name){
        TemperatureSensor tempSensor = new TemperatureSensor(name);
        sensors.add(tempSensor);
        return tempSensor.getId();
    }

    public UUID addCo2Sensor(String name){
        Co2Sensor co2Sensor = new Co2Sensor(name);
        sensors.add(co2Sensor);
        return co2Sensor.getId();
    }

    public void removeSensor(UUID id){
        sensors.removeIf(sensor -> sensor.getId() == id);
    }

    public UUID addActuator(String name){
        Actuator actuator = new Actuator(name);
        actuators.add(actuator);
        return actuator.getId();
    }

    public void removeActuator(UUID id){
        actuators.removeIf(actuator -> actuator.getId() == id);
    }
}
