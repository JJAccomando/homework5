package com.solvd.laba;

import com.solvd.laba.myinterfaces.UniqueIdInterface;
import com.solvd.laba.myenums.*;
import java.util.Map;
import java.util.HashMap;

public abstract class AirplaneBase implements UniqueIdInterface {

    private static int numPlanes;
    public static Map<Integer, AirbusA320> airbusA320Map = new HashMap<>();
    public static Map<Integer, AirbusA380> airbusA380Map = new HashMap<>();
    public static Map<Integer, Boeing737> boeing737Map = new HashMap<>();

    {
        //incraments total number of airplanes each time a new Object that extends AirplaneBase is created
        ++numPlanes;
    }

    abstract public PlaneType getPlaneType();

    abstract public boolean assignSeat(Passenger person, int index, SeatType seat);

    public static final <T extends AirplaneBase> void addToMap(T obj) {
        if (obj instanceof AirbusA320) {
            airbusA320Map.put(obj.getId(), (AirbusA320)obj);
        }
        else if (obj instanceof AirbusA380) {
            airbusA380Map.put(obj.getId(), (AirbusA380)obj);
        }
        else if (obj instanceof Boeing737) {
            boeing737Map.put(obj.getId(), (Boeing737)obj);
        }
    }

    //returns current number of AirplaneBase Objects instantiated
    public static int getTotalPlanes() {
        return numPlanes;
    }
    
}
