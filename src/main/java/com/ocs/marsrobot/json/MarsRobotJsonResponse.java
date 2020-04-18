package com.ocs.marsrobot.json;

import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;
import lombok.Data;

import java.util.ArrayList;

@Data public class MarsRobotJsonResponse {
    private ArrayList<Location> visitedCells;
    private ArrayList<String> samplesCollected;
    private int battery;
    private Position finalPosition;

    public MarsRobotJsonResponse() {}

    public MarsRobotJsonResponse(ArrayList<Location> visitedCells,
                                 ArrayList<String> samplesCollected,
                                 int battery,
                                 Position finalPosition) {
        this.visitedCells = visitedCells;
        this.samplesCollected = samplesCollected;
        this.battery = battery;
        this.finalPosition = finalPosition;
    }
}
