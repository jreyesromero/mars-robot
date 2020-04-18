package com.ocs.marsrobot.json;

import com.ocs.marsrobot.model.Position;
import lombok.Data;

import java.util.ArrayList;

@Data public class MarsRobotJsonRequest {

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
