package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.validator.LocationValidator;
import com.ocs.marsrobot.handler.MarsRobotPositionHandler;
import com.ocs.marsrobot.model.Position;

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
            System.out.println("La nueva posicion es valida");
        } else {
            System.out.println("Nueva posición INVALIDA");
        }

        robot.setBattery(robot.getBattery()-BACKWARDS_BATTERY_CONSUMPTION);
    }

    @Override
    public String getCommandType() {
        return MOVE_BACKWARDS_COMMAND_DESCRIPTION;
    }
}
