package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class ExtendSolarPanelsCommand implements Command {

    private final static int EXTEND_SOLAR_PANELS_BATTERY_CONSUMPTION = 1;
    private final static int EXTEND_SOLAR_PANELS_BATTERY_CHARGE = 10;

    @Override
    public void execute(Robot robot) {

        //System.out.println("EXTENDS SOLAR PANELS");
        robot.setBattery(robot.getBattery() +
                (EXTEND_SOLAR_PANELS_BATTERY_CHARGE - EXTEND_SOLAR_PANELS_BATTERY_CONSUMPTION));
        //System.out.println("Battery after EXTENDS SOLAR PANELS: " + robot.getBattery());

    }
}
