package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class MoveBackwardsCommand implements Command {

    private final static int BACKWARDS_BATTERY_CONSUMPTION = 3;
    private final static String MOVE_BACKWARDS_COMMAND_DESCRIPTION = "MoveBackwardsCommand";

    @Override
    public void execute(Robot robot) {
        //System.out.println("BACKWARDS");
        robot.setBattery(robot.getBattery()-BACKWARDS_BATTERY_CONSUMPTION);
        //System.out.println("Battery after BACKWARDS: " + robot.getBattery());
    }

    @Override
    public String getCommandType() {
        return MOVE_BACKWARDS_COMMAND_DESCRIPTION;
    }
}
