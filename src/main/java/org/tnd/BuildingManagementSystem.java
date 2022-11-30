package org.tnd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BuildingManagementSystem {
    private static List<Building> buildings; // declaring building list. We can only initialize as List is abstract.

    public static void main(String[] args) {
        buildings = new ArrayList<Building>(); // initializing an instantiation of the building list. It needs to be an ArrayList as List is abstract.
        UUID townHallId = addBuilding("Town Hall"); // creating a building and saving the UUID return value for later use.
        System.out.println(getBuildings()); // printing the current state of our building list.
        removeBuilding(townHallId); // removing a building from our list using our previously saved UUID.
        System.out.println(getBuildings()); // printing the new state of the building list.
    }

    public static UUID addBuilding(String name){
        Building building = new Building(name);
        buildings.add(building);
        return building.getId();
    }

    public static void removeBuilding(UUID id){
        buildings.removeIf(building -> building.getId() == id);
    }

    public static List<Building> getBuildings(){
        return buildings;
    }

    @Override
    public String toString() {
        String allBuildings = "";
        for (Building building : buildings) {
            allBuildings += "\n" + building.getName();
        }
        return allBuildings;
    }
}
