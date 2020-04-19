package com.ocs.marsrobot.parse;

import com.ocs.marsrobot.command.*;
import org.springframework.stereotype.Component;
import com.ocs.marsrobot.exception.CommandDoesNotValidException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParseRobotCommands {

    public List<Command> parse(ArrayList<String> inputCommands) {
        List<Command> outputCommands = new ArrayList<>();

        inputCommands.forEach(inputCommand -> {
            Command command = getCommand(inputCommand);
            outputCommands.add(command);

        });

        return outputCommands;
    }

    private Command getCommand(String command) {
        switch (command) {
            case "F":
                return new MoveForwardCommand();
            case "B":
                return new MoveBackwardsCommand();
            case "L":
                return new TurnLeftCommand();
            case "R":
                return new TurnRightCommand();
            case "S":
                return new TakeSampleCommand();
            case "E":
                return new ExtendSolarPanelsCommand();
            default:
                throw new CommandDoesNotValidException();
        }
    }

}
