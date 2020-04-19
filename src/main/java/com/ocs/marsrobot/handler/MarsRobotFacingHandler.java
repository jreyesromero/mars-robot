package com.ocs.marsrobot.handler;

import org.springframework.stereotype.Component;

import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;

import lombok.Data;
import java.util.Map;
import java.util.HashMap;

@Component
@Data public class MarsRobotFacingHandler {

    private final static String TURN_LEFT_COMMAND_DESCRIPTION = "TurnLeftCommand";
    private final static String TURN_RIGHT_COMMAND_DESCRIPTION = "TurnRightCommand";


    public String updateFacing(String currentFacing, String command) {
        if (command.equals(TURN_LEFT_COMMAND_DESCRIPTION)) {
            return updateFacingWhenTurningLeft(currentFacing);
        }

        if (command.equals(TURN_RIGHT_COMMAND_DESCRIPTION)) {
            return updateFacingWhenTurningRigth(currentFacing);
        }

        return currentFacing;
    }

    private String updateFacingWhenTurningLeft(String currentFacing) {
        Map<String,String> turningMap = initTurningLeftMap();
        String newFacing = turningMap.get(currentFacing);
        return newFacing;
    }

    private String updateFacingWhenTurningRigth(String currentFacing) {
        Map<String,String> turningMap = initTurningRightMap();
        return turningMap.get(currentFacing);
    }

    private Map<String,String> initTurningLeftMap() {
        Map<String,String> turningMap = new HashMap<>();
        turningMap.put("NORTH","EAST");
        turningMap.put("SOUTH","WEST");
        turningMap.put("EAST","SOUTH");
        turningMap.put("WEST","NORTH");
        return turningMap;
    }

    private Map<String,String> initTurningRightMap() {
        Map<String,String> turningMap = new HashMap<>();
        turningMap.put("NORTH","WEST");
        turningMap.put("SOUTH","EAST");
        turningMap.put("EAST","NORTH");
        turningMap.put("WEST","SOUTH");
        return turningMap;
    }

}