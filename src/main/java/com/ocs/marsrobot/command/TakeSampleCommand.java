package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public class TakeSampleCommand implements Command {

    @Override
    public void execute(Robot robot) {
        //Orientation orientation = robot.getPosition().getOrientation().left();
        //robot.getPosition().setOrientation(orientation);
        System.out.println("TakeSampleCommand");
    }
}