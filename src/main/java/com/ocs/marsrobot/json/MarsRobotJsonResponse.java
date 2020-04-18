package com.ocs.marsrobot.json;

import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;
import lombok.Data;

import java.util.ArrayList;

/*
{
    "VisitedCells": [
        {
            "X": 0,
            "Y": 0
        },
        {
            "X": 1,
            "Y": 0
        }
    ],
    "SamplesCollected": [
        "Fe",
        "Si",
        "W"
    ],
    "Battery": 8,
    "FinalPosition": {
        "Location": {
            "X": 0,
            "Y": 2
        },
        "Facing": "South"
     }
}

*/

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
