package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.validator.LocationValidator;
import com.ocs.marsrobot.handler.MarsRobotPositionHandler;
import com.ocs.marsrobot.model.Position;

public class MoveForwardCommand implements Command {

    private final static int FORWARD_BATTERY_CONSUMPTION = 3;
    private final static String MOVE_FORWARD_COMMAND_DESCRIPTION = "MoveForwardCommand";
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

        robot.setBattery(robot.getBattery()-FORWARD_BATTERY_CONSUMPTION);

    }

    @Override
    public String getCommandType() {
        return MOVE_FORWARD_COMMAND_DESCRIPTION;
    }

}
