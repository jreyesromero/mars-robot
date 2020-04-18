package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class TakeSampleCommand implements Command {

    private final static int TAKE_SAMPLE_BATTERY_CONSUMPTION = 8;

    @Override
    public void execute(Robot robot) {

        //System.out.println("TAKE SAMPLE");
        robot.setBattery(robot.getBattery()-TAKE_SAMPLE_BATTERY_CONSUMPTION);
        //System.out.println("Battery after TAKE SAMPLE: " + robot.getBattery());

    }
}
