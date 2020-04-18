package com.ocs.marsrobot.service;

import com.ocs.marsrobot.command.Command;
import com.ocs.marsrobot.json.MarsRobotJsonRequest;
import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.parse.ParseRobotCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarsRobotService {

    ParseRobotCommands parseRobotCommands;

    public Robot startRobot(MarsRobotJsonRequest request) {

        Robot robot = new Robot(request.getBattery(),
                request.getInitialPosition());

        List<Command> commandList = parseRobotCommands.parse(request.getCommands());

        return robot;
    }

    @Autowired
    public void setParseRobotCommands(ParseRobotCommands parseRobotCommands) {
        this.parseRobotCommands = parseRobotCommands;
    }
}
