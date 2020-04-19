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
    private Position position;

    //public Position getNextCellToVisit(Position position, String command) {
    public Position getNextCellToVisit(String command) {
        this.setAxisX(this.position.getLocation().getX());
        this.setAxisY(this.position.getLocation().getY());
        this.setCurrentFacing(this.position.getFacing().toUpperCase());

        switch (command) {
            case MOVE_FORWARD_COMMAND_DESCRIPTION:
                return getNextCellToVisitWhenMoveForward();
            case MOVE_BACKWARDS_COMMAND_DESCRIPTION:
                return getNextCellToVisitWhenMoveBackwards();
            default:
                return this.position;
        }
    }

    //private Position getNextCellToVisitWhenMoveForward(Position position) {
    private Position getNextCellToVisitWhenMoveForward() {
        Position newPosition = new Position(this.position.getLocation(), this.position.getFacing());

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

        newPosition.setLocation(new Location(axisX,axisY));
        return newPosition;
    }

    private Position getNextCellToVisitWhenMoveBackwards() {
        Position newPosition = new Position(this.position.getLocation(), this.position.getFacing());

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

        newPosition.setLocation(new Location(axisX,axisY));
        return newPosition;

    }

}