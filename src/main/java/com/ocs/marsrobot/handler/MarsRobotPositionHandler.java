package com.ocs.marsrobot.handler;

import org.springframework.stereotype.Component;

import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;

import lombok.Data;
import java.util.ArrayList;

@Component
@Data public class MarsRobotPositionHandler {
    private final static String MOVE_FORWARD_COMMAND_DESCRIPTION = "MoveForwardCommand";
    private final static String MOVE_BACKWARDS_COMMAND_DESCRIPTION = "MoveBackwardsCommand";
    private final static String TURN_LEFT_COMMAND_DESCRIPTION = "TurnLeftCommand";
    private final static String TURN_RIGHT_COMMAND_DESCRIPTION = "TurnRightCommand";


    private Integer axisX;
    private Integer axisY;
    private String currentFacing;

    public Position getNextCellToVisit(Position position, String command) {
        this.setAxisX(position.getLocation().getX());
        this.setAxisY(position.getLocation().getY());
        this.setCurrentFacing(position.getFacing().toUpperCase());

        System.out.println("MarsRobotPositionHandler");
        System.out.println("\nX: " + this.axisX);
        System.out.println("\nX: " + this.axisY);
        System.out.println("\ncurrentFacing: " + this.currentFacing);
        System.out.println("\ncommand: " + command);

        switch (command) {
            case MOVE_FORWARD_COMMAND_DESCRIPTION:
                return getNextCellToVisitWhenMoveForward(position);
            case MOVE_BACKWARDS_COMMAND_DESCRIPTION:
                return getNextCellToVisitWhenMoveBackwards(position);
            default:
                return position;
        }
    }

    private Position getNextCellToVisitWhenMoveForward(Position position) {
        System.out.println("getNextCellToVisit. currentFacing: " + this.currentFacing);
        switch (this.currentFacing) {
            case "NORTH":
                axisY++;
                break;
            case "SOUTH":
                axisY--;
                break;
            case "EAST":
                axisX++;
                break;
            case "WEST":
                axisX--;
                break;
            default:
        }

        position.getLocation().setX(axisX);
        position.getLocation().setY(axisY);
        System.out.println("Next cell to visit:\n X: " + position.getLocation().getX()
                + " Y: " + position.getLocation().getY());
        return position;
    }

    private Position getNextCellToVisitWhenMoveBackwards(Position position) {
        switch (this.currentFacing) {
            case "NORTH":
                axisY--;
                break;
            case "SOUTH":
                axisY++;
                break;
            case "EAST":
                axisX--;
                break;
            case "WEST":
                axisX++;
                break;
            default:
        }

        position.getLocation().setX(axisX);
        position.getLocation().setY(axisY);
        System.out.println("Next cell to visit:\n X: " + position.getLocation().getX()
                + " Y: " + position.getLocation().getY());
        return position;
    }

}