package com.ocs.marsrobot.service;

import com.ocs.marsrobot.command.Command;
import com.ocs.marsrobot.json.MarsRobotJsonRequest;
import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.model.Location;
import com.ocs.marsrobot.validator.TerrainValidator;
import com.ocs.marsrobot.validator.LocationValidator;
import com.ocs.marsrobot.parse.ParseRobotCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarsRobotService {

    ParseRobotCommands parseRobotCommands;
    TerrainValidator terrainValidator;


    public Robot startRobot(MarsRobotJsonRequest request) {

        if (!terrainValidator.validateTerrain(request.getTerrain()))
        {
            System.out.println("Algun elemento del terrain es no valido");
            return null;
        }

        System.out.println("El terrain es VALIDO");
        Robot robot = new Robot(request.getBattery(),
                request.getInitialPosition(),
                request.getTerrain(),
                new ArrayList<String>(),
                new ArrayList<Location>());

        robot.storeVisitedCell(request.getInitialPosition().getLocation());
        System.out.println("Initial visited cells in robot: " + robot.getVisitedCells());

        /*int externalTerrainCount = robot.getTerrain().size();
         System.out.println("Total TERRAIN size: " + externalTerrainCount);
         for (int i = 0; i < externalTerrainCount; i++) {
             int internalTerrainCount = robot.getTerrain().get(i).size();
             for (int j = 0; j < internalTerrainCount; j++) {
                 String material = robot.getTerrain().get(i).get(j);
                 System.out.println("x: " + j + " y: " + i + " material: " + material);
             }
        }*/

        List<Command> commandList = parseRobotCommands.parse(request.getCommands());
        commandList.stream().forEach(command -> command.execute(robot));

        System.out.println("Final list of visited cells:");
        robot.getVisitedCells().stream().forEach(location -> System.out.println("x: " + location.getX() + " y: " + location.getY()));
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
