package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class ExtendSolarPanelsCommand implements Command {

    private final static int EXTEND_SOLAR_PANELS_BATTERY_CONSUMPTION = 1;
    private final static int EXTEND_SOLAR_PANELS_BATTERY_CHARGE = 10;
    private final static String EXTEND_SOLAR_PANELS_COMMAND_DESCRIPTION = "ExtendSolarPanelsCommand";

    @Override
    public void execute(Robot robot) {

        robot.setBattery(robot.getBattery() +
                (EXTEND_SOLAR_PANELS_BATTERY_CHARGE - EXTEND_SOLAR_PANELS_BATTERY_CONSUMPTION));

    }

    @Override
    public String getCommandType() {
        return EXTEND_SOLAR_PANELS_COMMAND_DESCRIPTION;
    }
}
