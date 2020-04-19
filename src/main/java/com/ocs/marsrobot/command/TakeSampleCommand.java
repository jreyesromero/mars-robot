package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class TakeSampleCommand implements Command {

    private final static int TAKE_SAMPLE_BATTERY_CONSUMPTION = 8;
    private final static String TAKE_SAMPLE_COMMAND_DESCRIPTION = "TakeSampleCommand";

    @Override
    public void execute(Robot robot) {

        //System.out.println("TAKE SAMPLE");
        robot.setBattery(robot.getBattery()-TAKE_SAMPLE_BATTERY_CONSUMPTION);
        //System.out.println("Battery after TAKE SAMPLE: " + robot.getBattery());

    }

    @Override
    public String getCommandType() {
        return TAKE_SAMPLE_COMMAND_DESCRIPTION;
    }
}
