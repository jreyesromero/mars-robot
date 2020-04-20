package com.ocs.marsrobot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ocs.marsrobot.exception.MaterialDoesNotValidException;
import com.ocs.marsrobot.exception.CommandDoesNotValidException;
import com.ocs.marsrobot.exception.LocationDoesNotValidException;
import com.ocs.marsrobot.json.MarsRobotJsonResponse;
import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;

import java.util.ArrayList;

@Component
public class MarsRobotErrorHandler {

    private static final String DEFAULT = "There is an exception while treating input request";
    private static final String MATERIAL_NOT_VALID = "Terrain includes a non valid material";
    private static final String COMMAND_NOT_VALID = "Command not valid";
    private static final String LOCATION_NOT_VALID = "Location includes a non valid material";

    public MarsRobotJsonResponse handler(Exception exception) {

        MarsRobotJsonResponse marsRobotJsonResponse = configureResponseByDefault();
        ArrayList<String> samplesCollected = new ArrayList<String>();

        if (exception instanceof MaterialDoesNotValidException) {
            samplesCollected.add(MATERIAL_NOT_VALID);
        }

        if (exception instanceof CommandDoesNotValidException) {
            samplesCollected.add(COMMAND_NOT_VALID);
        }

        if (exception instanceof LocationDoesNotValidException) {
            samplesCollected.add(LOCATION_NOT_VALID);
        }

        marsRobotJsonResponse.setSamplesCollected(samplesCollected);
        return marsRobotJsonResponse;
    }

    private MarsRobotJsonResponse configureResponseByDefault() {
        ArrayList<Location> visitedCells = new ArrayList<Location>();
        visitedCells.add(new Location(0,0));
        ArrayList<String> defaultSamplesCollected = new ArrayList<String>();
        defaultSamplesCollected.add(DEFAULT);
        int battery = 0;
        Position finalPosition = new Position(new Location(0,0), "DEFAULT");

        MarsRobotJsonResponse response = new MarsRobotJsonResponse(visitedCells,
                defaultSamplesCollected, battery, finalPosition);
        return response;
    }
}