package com.ocs.marsrobot.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data public class Robot {
    private int battery;
    private Position position;
    private ArrayList<ArrayList<String>> terrain;
    private ArrayList<String> samplesCollected;
    private ArrayList<Location> visitedCells;

    public Robot(){}

    public Robot(int battery,
                 Position position,
                 ArrayList<ArrayList<String>> terrain,
                 ArrayList<String> samplesCollected,
                 ArrayList<Location> visitedCells) {
        this.battery = battery;
        this.position = position;
        this.terrain = terrain;
        this.samplesCollected = samplesCollected;
        this.visitedCells = visitedCells;
    }

    public Integer getMaxYValueFromTerrain() {
        return this.terrain.size();
    }

    public Integer getMaxXValueFromTerrain() {
        return this.terrain.get(0).size();
    }

    public void storeVisitedCell(Location visitedLocation) {
        Integer x = visitedLocation.getX();
        Integer y = visitedLocation.getY();
        this.visitedCells.add(new Location(x,y));
    }
}
