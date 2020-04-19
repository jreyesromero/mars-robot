package com.ocs.marsrobot.model;

import lombok.Data;

import java.util.ArrayList;

@Data public class Robot {
    private int battery;
    private Position position;
    private ArrayList<ArrayList<String>> terrain;
    private ArrayList<String> samplesCollected;

    public Robot(){}

    public Robot(int battery,
                 Position position,
                 ArrayList<ArrayList<String>> terrain,
                 ArrayList<String> samplesCollected) {
        this.battery = battery;
        this.position = position;
        this.terrain = terrain;
        this.samplesCollected = samplesCollected;
    }

    public Integer getMaxYValueFromTerrain() {
        return this.terrain.size();
    }

    public Integer getMaxXValueFromTerrain() {
        return this.terrain.get(0).size();
    }
}
