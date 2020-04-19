package com.ocs.marsrobot.controller;

import com.ocs.marsrobot.json.MarsRobotJsonResponse;
import com.ocs.marsrobot.model.Location;
import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.service.MarsRobotService;
import com.ocs.marsrobot.handler.MarsRobotErrorHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.marsrobot.json.MarsRobotJsonRequest;

import java.util.ArrayList;

@RestController
public class MarsRobotApplicationController {

    private MarsRobotService marsRobotService;
    private MarsRobotErrorHandler errorHandler;

    @PostMapping(path = "/robot")
    @ResponseBody
    public MarsRobotJsonResponse marsRobotHandleRequest(@RequestBody MarsRobotJsonRequest request) {

        MarsRobotJsonResponse response = new MarsRobotJsonResponse();
        // Robot start up
        try {
            Robot robot = marsRobotService.runRobot(request);
            response = buildJsonResponse(robot);
        } catch (Exception e) {
            response = errorHandler.handler(e);
        }

        return response;

    }

    @Autowired
    public void setMarsRobotService(MarsRobotService marsRobotService) {
        this.marsRobotService = marsRobotService;
    }

    private MarsRobotJsonResponse buildJsonResponse(Robot robot) {
        MarsRobotJsonResponse response = new MarsRobotJsonResponse();
        response.setBattery(robot.getBattery());
        response.setFinalPosition(robot.getPosition());
        response.setSamplesCollected(robot.getSamplesCollected());
        response.setVisitedCells(robot.getVisitedCells());

        return response;
    }

}
