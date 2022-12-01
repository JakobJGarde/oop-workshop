package org.tnd;

import java.util.*;

public class BuildingManagementSystem implements IBuildingManagementSystem {
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
        windowOpener.setValue(5.6); // setting the Town Hall's Window Opener value.
        System.out.println("The Town Hall's Window Opener value: " + windowOpener.getValue()); // getting/printing the value of the Window Opener (actuator).
        Actuator doorOpener = townHall.addActuator("Door-Opener"); // creating an Actuator within the Town Hall and saving the Actuator Object return value.
        Actuator gateOpener = townHall.addActuator("Gate-Opener"); // creating an Actuator within the Town Hall and saving the Actuator Object return value.
        townHall.prettyPrint(); // printing the information for the Town Hall.
        getBuildings(); // printing a list of the buildings.
        System.out.println(townHall.getActuators()); // printing a list of actuators in the Town Hall.

        IBuildingManagementSystem bms = new BuildingManagementSystem();
        System.out.println("Getting building information: " + bms.getBuildingInformation());
        System.out.println("Getting sensor information for Town Hall: " + bms.getSensorInformation(townHall.getId()));
        System.out.println("Getting actuator information for Town Hall: " + bms.getActuatorInformation(townHall.getId()));
        bms.addTemperatureSensor(townHall.getId(), "Hallway Temperature Sensor");
        UUID bathroomCo2SensorId = bms.addCo2Sensor(townHall.getId(), "Bathroom CO2-Sensor");
        System.out.println("Getting sensor information for Town Hall: " + bms.getSensorInformation(townHall.getId()));
        UUID ventActuatorId = bms.addVentilationActuator(townHall.getId(), "Ventilation Actuator");
        System.out.println("Getting actuator information for Town Hall: " + bms.getActuatorInformation(townHall.getId()));
        bms.removeSensor(townHall.getId(), bathroomCo2SensorId);
        System.out.println("Getting sensor information for Town Hall: " + bms.getSensorInformation(townHall.getId()));
        bms.removeActuator(townHall.getId(), ventActuatorId);
        System.out.println("Getting actuator information for Town Hall: " + bms.getActuatorInformation(townHall.getId()));
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

    @Override
    public Map<UUID, String> getBuildingInformation() {
        Map<UUID, String> buildingsInfo = new HashMap<>();
        for (Building building : buildings){
            buildingsInfo.put(building.getId(), building.getName());
        }
        return buildingsInfo;
    }

    @Override
    public Map<UUID, String> getSensorInformation(UUID buildingId) {
        Map<UUID, String> sensorInfo = new HashMap<>(); // declare
        for (Building building : buildings){
            if (building.getId() == buildingId){
                for (Sensor sensor : building.getSensors()){
                    sensorInfo.put(sensor.getId(), sensor.getName());
                }
                break;
            }
        } return sensorInfo;
    }

    @Override
    public Map<UUID, String> getActuatorInformation(UUID buildingId) {
        Map<UUID, String> actuatorInfo = new HashMap<>(); // declare
        for (Building building : buildings){
            if (building.getId() == buildingId){
                for (Actuator actuator : building.getActuators()){
                    actuatorInfo.put(actuator.getId(), actuator.getName());
                }
                break;
            }
        } return actuatorInfo;
    }

    @Override
    public UUID addTemperatureSensor(UUID buildingId, String name) {
        TemperatureSensor addedTempSensor = null;
        for (Building building : buildings){
            if (building.getId() == buildingId){
                addedTempSensor = building.addTemperatureSensor(name);
                break;
            } else System.out.println("No building with this id.");
        }
        return addedTempSensor.id;
    }

    @Override
    public UUID addCo2Sensor(UUID buildingId, String name) {
        Co2Sensor addedCo2Sensor = null;
        for (Building building : buildings){
            if (building.getId() == buildingId){
                addedCo2Sensor = building.addCo2Sensor(name);
                break;
            } else System.out.println("No building with this id.");
        }
        return addedCo2Sensor.id;
    }

    @Override
    public void removeSensor(UUID buildingId, UUID sensorId) {
        for (Building building : buildings){
            if (building.getId() == buildingId){
                building.removeSensor(sensorId);
                break;
            }
        }
    }

    @Override
    public UUID addVentilationActuator(UUID buildingId, String name) {
        Actuator addedActuator = null;
        for (Building building : buildings){
            if (building.getId() == buildingId){
                addedActuator = building.addActuator(name);
                break;
            } else System.out.println("No building with this id.");
        }
        return addedActuator.id;
    }

    @Override
    public void removeActuator(UUID buildingId, UUID actuatorId) {
        for (Building building : buildings){
            if (building.getId() == buildingId){
                building.removeActuator(actuatorId);
                break;
            }
        }
    }
}
