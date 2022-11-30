package org.tnd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BuildingManagementSystem {
    private static List<Building> buildings; // declaring building list. We can only initialize as List is abstract.

    public static void main(String[] args) {
        buildings = new ArrayList<>(); // initializing an instantiation of the building list. It needs to be an ArrayList as List is abstract.
        Building townHall = addBuilding("Town Hall"); // creating a building and saving the UUID return value for later use.
        Building hospital = addBuilding("Hospital"); // creating a building and saving the UUID return value for later use.
        Actuator windowOpener = townHall.addActuator("Window-Opener");
        windowOpener.setValue(5.6);
        Co2Sensor co2Sensor = townHall.addCo2Sensor("Entrance CO2-Sensor");
        TemperatureSensor tempSensor = townHall.addTemperatureSensor("Entrance Temperature-Sensor");
        townHall.prettyPrint();
    }

    public static Building addBuilding(String name){
        Building building = new Building(name);
        buildings.add(building);
        return building;
    }

    public static void removeBuilding(UUID id){
        buildings.removeIf(building -> building.getId() == id);
    }

    public static List<Building> getBuildings(){
        return buildings;
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
