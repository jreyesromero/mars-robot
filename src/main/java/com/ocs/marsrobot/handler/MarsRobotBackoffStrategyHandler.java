package com.ocs.marsrobot.handler;

import org.springframework.stereotype.Component;

import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;
import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.command.Command;
import com.ocs.marsrobot.parse.ParseRobotCommands;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
@Data public class MarsRobotBackoffStrategyHandler {

    //ParseRobotCommands parseRobotCommands;

    public void runBackoffStrategy(Robot robot) {

        ParseRobotCommands parseRobotCommands = new ParseRobotCommands();
        Map<Integer,ArrayList<String>> strategies = initStrategiesListMap();
        int strategyIndex = robot.getBackOffStrategyIndex();
        ArrayList<String> strategyCommands = strategies.get(strategyIndex);

        List<Command> commandList = parseRobotCommands.parse(strategyCommands);
        commandList.stream().forEach(command -> command.execute(robot));
   }

    private Map<Integer,ArrayList<String>> initStrategiesListMap() {
        Map<Integer,ArrayList<String>> strategiesMap = new HashMap<>();
        strategiesMap.put(1,configureFirstStrategy());
        strategiesMap.put(2,configureSecondStrategy());
        strategiesMap.put(3,configureThirdStrategy());
        strategiesMap.put(4,configureFourthStrategy());
        strategiesMap.put(5,configureFifthStrategy());
        strategiesMap.put(6,configureSixthStrategy());
        strategiesMap.put(7,configureSeventhStrategy());
        return strategiesMap;
    }

    private ArrayList<String> configureFirstStrategy() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        commands.add("R");
        commands.add("F");
        return commands;
    }

    private ArrayList<String> configureSecondStrategy() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        commands.add("L");
        commands.add("F");
        return commands;
    }

    private ArrayList<String> configureThirdStrategy() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        commands.add("L");
        commands.add("L");
        commands.add("F");
        return commands;
    }

    private ArrayList<String> configureFourthStrategy() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        commands.add("B");
        commands.add("R");
        commands.add("F");
        return commands;
    }

    private ArrayList<String> configureFifthStrategy() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        commands.add("B");
        commands.add("B");
        commands.add("L");
        commands.add("F");
        return commands;
    }

    private ArrayList<String> configureSixthStrategy() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        commands.add("F");
        commands.add("F");
        return commands;
    }

    private ArrayList<String> configureSeventhStrategy() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        commands.add("F");
        commands.add("L");
        commands.add("F");
        commands.add("L");
        commands.add("F");
        return commands;
    }
}