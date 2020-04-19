package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.validator.LocationValidator;
import com.ocs.marsrobot.handler.MarsRobotPositionHandler;
import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;
import java.util.ArrayList;

public class MoveBackwardsCommand implements Command {

    private final static int BACKWARDS_BATTERY_CONSUMPTION = 3;
    private final static String MOVE_BACKWARDS_COMMAND_DESCRIPTION = "MoveBackwardsCommand";
    LocationValidator locationValidator = new LocationValidator();
    MarsRobotPositionHandler positionHandler = new MarsRobotPositionHandler();

    @Override
    public void execute(Robot robot) {
        Position nextPosition = positionHandler.getNextCellToVisit(robot.getPosition(), this.getCommandType());

        if (locationValidator.validateCoordinate(nextPosition.getLocation(),
                robot)) {
            //stores visited cell
            robot.storeVisitedCell(nextPosition.getLocation());
            robot.setBattery(robot.getBattery()-BACKWARDS_BATTERY_CONSUMPTION);
        } else {
            System.out.println("Nueva posición INVALIDA");
        }
    }

    @Override
    public String getCommandType() {
        return MOVE_BACKWARDS_COMMAND_DESCRIPTION;
    }
}
