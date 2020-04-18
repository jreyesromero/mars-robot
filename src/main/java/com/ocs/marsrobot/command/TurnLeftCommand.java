package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class TurnLeftCommand implements Command {

    private final static int TURN_LEFT_BATTERY_CONSUMPTION = 2;

    @Override
    public void execute(Robot robot) {
        //System.out.println("TURN LEFT");
        robot.setBattery(robot.getBattery()-TURN_LEFT_BATTERY_CONSUMPTION);
        //System.out.println("Battery after TURN LEFT: " + robot.getBattery());
    }
}
