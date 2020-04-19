package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import java.util.ArrayList;

public class TakeSampleCommand implements Command {

    private final static int TAKE_SAMPLE_BATTERY_CONSUMPTION = 8;
    private final static String TAKE_SAMPLE_COMMAND_DESCRIPTION = "TakeSampleCommand";

    @Override
    public void execute(Robot robot) {
        storeSampleInRobot(robot);
        robot.setBattery(robot.getBattery()-TAKE_SAMPLE_BATTERY_CONSUMPTION);
    }

    @Override
    public String getCommandType() {
        return TAKE_SAMPLE_COMMAND_DESCRIPTION;
    }

    private void storeSampleInRobot(Robot robot) {
        ArrayList<ArrayList<String>> terrain = robot.getTerrain();
        Integer x = robot.getPosition().getLocation().getX();
        Integer y = robot.getPosition().getLocation().getY();
        String material = terrain.get(y).get(x);
        robot.getSamplesCollected().add(material);
    }

}
