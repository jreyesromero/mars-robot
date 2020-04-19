package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class MoveForwardCommand implements Command {

    private final static int FORWARD_BATTERY_CONSUMPTION = 3;
    private final static String MOVE_FORWARD_COMMAND_DESCRIPTION = "MoveForwardCommand";

    @Override
    public void execute(Robot robot) {
        //System.out.println("FORWARD");
        robot.setBattery(robot.getBattery()-FORWARD_BATTERY_CONSUMPTION);
        //System.out.println("Battery after FORWARD: " + robot.getBattery());
    }

    @Override
    public String getCommandType() {
        return MOVE_FORWARD_COMMAND_DESCRIPTION;
    }
}
