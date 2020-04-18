package com.ocs.marsrobot.json;

import com.ocs.marsrobot.model.Position;
import lombok.Data;

import java.util.ArrayList;

@Data public class MarsRobotJsonRequest {

    /*
    {
        "terrain": [
            ["Fe", "Fe", "Se"],
            ["W", "Si", "Obs"],
            ["W", "Obs", "Zn"]
        ],
        "battery": 50,
        "commands": [
            "F", "S", "R", "F", "S", "R", "F", "L", "F", "S"
        ],
        "initialPosition": {
            "location" : {
                "x" : 0,
                "y" : 0
            },
        "facing" : "East"
        }
    }
     */

    private ArrayList<ArrayList<String>> terrain;
    private int battery;
    private ArrayList<String> commands;
    private Position initialPosition;

    public MarsRobotJsonRequest() {}

    public MarsRobotJsonRequest(ArrayList<ArrayList<String>> terrain,
                                int battery,
                                ArrayList<String> commands,
                                Position initialPosition) {
        this.terrain = terrain;
        this.battery = battery;
        this.commands = commands;
        this.initialPosition = initialPosition;
    }
}
