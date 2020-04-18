package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class TurnRightCommand implements Command {

    private final static int TURN_RIGHT_BATTERY_CONSUMPTION = 2;

    @Override
    public void execute(Robot robot) {
        //System.out.println("TURN RIGHT");
        robot.setBattery(robot.getBattery()-TURN_RIGHT_BATTERY_CONSUMPTION);
        //System.out.println("Battery after TURN RIGHT: " + robot.getBattery());
    }
}
