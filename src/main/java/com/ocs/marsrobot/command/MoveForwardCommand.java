package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.validator.LocationValidator;
import com.ocs.marsrobot.handler.MarsRobotPositionHandler;
import com.ocs.marsrobot.handler.MarsRobotBackoffStrategyHandler;
import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;
import java.util.ArrayList;

public class MoveForwardCommand implements Command {

    private final static int FORWARD_BATTERY_CONSUMPTION = 3;
    private final static String MOVE_FORWARD_COMMAND_DESCRIPTION = "MoveForwardCommand";
    private boolean success;
    LocationValidator locationValidator = new LocationValidator();
    MarsRobotPositionHandler positionHandler = new MarsRobotPositionHandler();
    MarsRobotBackoffStrategyHandler backOffHandler = new MarsRobotBackoffStrategyHandler();

    @Override
    public void execute(Robot robot) {
        positionHandler.setPosition(robot.getPosition());
        Position nextPosition = positionHandler.getNextCellToVisit(this.getCommandType());
        Location nextLocation = nextPosition.getLocation();

        if (locationValidator.validateCoordinate(nextLocation,robot)) {
            if (locationValidator.checkIfIsObstacle(nextLocation, robot)) {
                // execute
                robot.increaseBackOffStrategyIndex();
                backOffHandler.runBackoffStrategy(robot);
            } else {
                //stores visited cell
                robot.setPosition(nextPosition);
                robot.setBackOffStrategyIndex(0);
                robot.storeVisitedCell(nextLocation);
                robot.setBattery(robot.getBattery() - FORWARD_BATTERY_CONSUMPTION);
            }
        }
    }

    @Override
    public String getCommandType() {
        return MOVE_FORWARD_COMMAND_DESCRIPTION;
    }

}
