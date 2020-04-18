package com.ocs.marsrobot.controller;

import com.ocs.marsrobot.json.MarsRobotJsonResponse;
import com.ocs.marsrobot.model.Location;
import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.service.MarsRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.marsrobot.json.MarsRobotJsonRequest;

import java.util.ArrayList;

@RestController
public class MarsRobotApplicationController {

    MarsRobotService marsRobotService;

    @PostMapping(path = "/postRequest")
    @ResponseBody
    public MarsRobotJsonResponse marsRobotHandleRequest(@RequestBody MarsRobotJsonRequest request) {
        MarsRobotJsonResponse response = new MarsRobotJsonResponse();
        ArrayList<Location> visitedCells = new ArrayList<Location>();
        ArrayList<String> samplesCollected = new ArrayList<String>();
        Location location = new Location(1,3);
        Position finalPosition = new Position(location, "WEST");

        visitedCells.add(new Location(1,2));
        visitedCells.add(new Location(3,3));
        samplesCollected.add("Fe");
        samplesCollected.add("Si");
        response.setVisitedCells(visitedCells);
        response.setSamplesCollected(samplesCollected);
        response.setBattery(request.getBattery());
        response.setFinalPosition(finalPosition);


        Robot robot = marsRobotService.startRobot(request);

        return response;
        /*return "Mars robot information request receveid. \nCommands: " + request.getCommands()
                + " \nbattery: " + request.getBattery()
                + "\nTerrain: " + request.getTerrain()
                + "\nX coordinate: " + request.getInitialPosition().getLocation().getX()
                + "\nY coordinate: " + request.getInitialPosition().getLocation().getY()
                + "\nfacing: " + request.getInitialPosition().getFacing().toUpperCase();*/
    }

    @Autowired
    public void setMarsRobotService(MarsRobotService marsRobotService) {
        this.marsRobotService = marsRobotService;
    }

}
