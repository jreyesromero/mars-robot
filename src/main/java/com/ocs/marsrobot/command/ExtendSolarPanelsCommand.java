package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class ExtendSolarPanelsCommand implements Command {

    private final static int EXTEND_SOLAR_PANELS_BATTERY_CONSUMPTION = 1;
    private final static int EXTEND_SOLAR_PANELS_BATTERY_CHARGE = 10;
    private final static String EXTEND_SOLAR_PANELS_COMMAND_DESCRIPTION = "ExtendSolarPanelsCommand";

    @Override
    public void execute(Robot robot) {

        //System.out.println("EXTENDS SOLAR PANELS");
        robot.setBattery(robot.getBattery() +
                (EXTEND_SOLAR_PANELS_BATTERY_CHARGE - EXTEND_SOLAR_PANELS_BATTERY_CONSUMPTION));
        //System.out.println("Battery after EXTENDS SOLAR PANELS: " + robot.getBattery());

    }

    @Override
    public String getCommandType() {
        return EXTEND_SOLAR_PANELS_COMMAND_DESCRIPTION;
    }
}
