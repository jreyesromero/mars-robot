package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.handler.MarsRobotFacingHandler;
import com.ocs.marsrobot.model.Position;

public class TurnRightCommand implements Command {

    private final static int TURN_RIGHT_BATTERY_CONSUMPTION = 2;
    private final static String TURN_RIGHT_COMMAND_DESCRIPTION = "TurnRightCommand";
    MarsRobotFacingHandler facingHandler = new MarsRobotFacingHandler();

    @Override
    public void execute(Robot robot) {
        String currentFacing = robot.getPosition().getFacing().toUpperCase();
        String newFacing = facingHandler.updateFacing(currentFacing,this.getCommandType());
        robot.getPosition().setFacing(newFacing);
        robot.setBattery(robot.getBattery()-TURN_RIGHT_BATTERY_CONSUMPTION);
    }

    @Override
    public String getCommandType() {
        return TURN_RIGHT_COMMAND_DESCRIPTION;
    }
}
