package org.tnd;
import java.util.UUID;

public class Unit {
    protected String name;
    protected UUID id;

    public Unit(){
        id = UUID.randomUUID();
    }

    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "name: " + getName() + " | id: " + getId();
    }
}
