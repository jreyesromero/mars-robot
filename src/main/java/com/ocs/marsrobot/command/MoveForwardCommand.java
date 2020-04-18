package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class MoveForwardCommand implements Command {

    private final static int FORWARD_BATTERY_CONSUMPTION = 3;

    @Override
    public void execute(Robot robot) {
        //System.out.println("FORWARD");
        robot.setBattery(robot.getBattery()-FORWARD_BATTERY_CONSUMPTION);
        //System.out.println("Battery after FORWARD: " + robot.getBattery());
    }
}
