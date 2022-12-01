package org.tnd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BuildingManagementSystem {
    private static List<Building> buildings; // declaring building list. We can only initialize as List is abstract.

    public static void main(String[] args) {
        buildings = new ArrayList<>(); // initializing an instantiation of the building list. It needs to be an ArrayList as List is abstract.
        Building townHall = addBuilding("Town Hall"); // creating the first building and saving the Building-object return value for later use.
        Building hospital = addBuilding("Hospital"); // creating a second building and saving the Building-object return value for later use.
        Building fireDepartment = addBuilding("Fire Department"); // creating a third building and saving the Building-object return value for later use.
        removeBuilding(hospital.getId()); // removing the hospital with its UUID.
        Co2Sensor entranceCo2Sensor = townHall.addCo2Sensor("Entrance CO2-Sensor"); // creating a CO2-sensor within the Town Hall and saving the Co2Sensor object return value.
        TemperatureSensor entranceTempSensor = townHall.addTemperatureSensor("Entrance Temperature-Sensor"); // creating a Temperature-sensor within the Town Hall and saving the TemperatureSensor object return value.
        townHall.removeSensor(entranceCo2Sensor.getId()); // removing the Entrance CO2-Sensor with its UUID.
        Actuator windowOpener = townHall.addActuator("Window-Opener"); // creating an Actuator within the Town Hall and saving the Actuator Object return value.
        windowOpener.setValue(5.6); // setting the Town Hall's Window Opener value (setpunkt).
        System.out.println("The Town Hall's Window Opener value: " + windowOpener.getValue()); // getting/printing the value of the Window Opener (actuator).
        Actuator doorOpener = townHall.addActuator("Door-Opener"); // creating an Actuator within the Town Hall and saving the Actuator Object return value.
        Actuator gateOpener = townHall.addActuator("Gate-Opener"); // creating an Actuator within the Town Hall and saving the Actuator Object return value.
        townHall.prettyPrint(); // printing the information for the Town Hall.
        getBuildings(); // printing a list of the buildings.
        townHall.getActuators(); // printing a list of actuators in the Town Hall.
    }

    public static Building addBuilding(String name){
        Building building = new Building(name);
        buildings.add(building);
        return building;
    }

    public static void removeBuilding(UUID id){
        buildings.removeIf(building -> building.getId() == id);
    }

    public static void getBuildings(){
        System.out.println("List of buildings: ");
        for (Building building : buildings){
            System.out.println("  " + building);
        }
    }

    @Override
    public String toString() {
        StringBuilder allBuildings = new StringBuilder();
        for (Building building : buildings) {
            allBuildings.append("\n").append(building.getName());
        }
        return allBuildings.toString();
    }
}
