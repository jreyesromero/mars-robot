package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.handler.MarsRobotFacingHandler;
import com.ocs.marsrobot.model.Position;

public class TurnLeftCommand implements Command {

    private final static int TURN_LEFT_BATTERY_CONSUMPTION = 2;
    private final static String TURN_LEFT_COMMAND_DESCRIPTION = "TurnLeftCommand";
    MarsRobotFacingHandler facingHandler = new MarsRobotFacingHandler();

    @Override
    public void execute(Robot robot) {
        String currentFacing = robot.getPosition().getFacing().toUpperCase();
        String newFacing = facingHandler.updateFacing(currentFacing,this.getCommandType());
        robot.getPosition().setFacing(newFacing);
        robot.setBattery(robot.getBattery()-TURN_LEFT_BATTERY_CONSUMPTION);
    }

    @Override
    public String getCommandType() {
        return TURN_LEFT_COMMAND_DESCRIPTION;
    }

}
