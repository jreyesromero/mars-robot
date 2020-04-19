package com.ocs.marsrobot.service;

import com.ocs.marsrobot.command.Command;
import com.ocs.marsrobot.json.MarsRobotJsonRequest;
import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.model.Location;
import com.ocs.marsrobot.validator.TerrainValidator;
import com.ocs.marsrobot.validator.LocationValidator;
import com.ocs.marsrobot.parse.ParseRobotCommands;
import com.ocs.marsrobot.exception.MaterialDoesNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

@Service
public class MarsRobotService {

    ParseRobotCommands parseRobotCommands;
    TerrainValidator terrainValidator;


    public Robot runRobot(MarsRobotJsonRequest request) throws Exception {

        Robot robot = new Robot();
        try {
            if (terrainValidator.validateTerrain(request.getTerrain())) {
                robot.setBattery(request.getBattery());
                robot.setPosition(request.getInitialPosition());
                robot.setTerrain(request.getTerrain());
                robot.setSamplesCollected(new ArrayList<String>());
                robot.setVisitedCells(new ArrayList<Location>());

                robot.storeVisitedCell(request.getInitialPosition().getLocation());

                List<Command> commandList = parseRobotCommands.parse(request.getCommands());
                commandList.stream().forEach(command -> command.execute(robot));
            }
        } catch (MaterialDoesNotValidException materialException) {
                throw new Exception(materialException);
        }


        System.out.println("Visited cells final: " + robot.getVisitedCells());
        System.out.println("Final list of stored materials:\n" + robot.getSamplesCollected());

        return robot;
    }

    @Autowired
    public void setParseRobotCommands(ParseRobotCommands parseRobotCommands) {
        this.parseRobotCommands = parseRobotCommands;
    }

    @Autowired
    public void setTerrainValidator(TerrainValidator terrainValidator) {

        this.terrainValidator = terrainValidator;
    }
}
