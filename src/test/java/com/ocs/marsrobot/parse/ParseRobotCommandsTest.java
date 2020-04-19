package com.ocs.marsrobot.validator;

import com.ocs.marsrobot.parse.ParseRobotCommands;
import com.ocs.marsrobot.command.Command;
import com.ocs.marsrobot.exception.CommandDoesNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParseRobotCommandsTest {

    private final static String MOVE_FORWARD_COMMAND_DESCRIPTION = "MoveForwardCommand";
    private final static String MOVE_BACKWARDS_COMMAND_DESCRIPTION = "MoveBackwardsCommand";
    private final static String TURN_LEFT_COMMAND_DESCRIPTION = "TurnLeftCommand";
    private final static String TURN_RIGHT_COMMAND_DESCRIPTION = "TurnRightCommand";
    private final static String TAKE_SAMPLE_COMMAND_DESCRIPTION = "TakeSampleCommand";
    private final static String EXTEND_SOLAR_PANELS_COMMAND_DESCRIPTION = "ExtendSolarPanelsCommand";

    ParseRobotCommands parseRobotCommands = new ParseRobotCommands();

    @BeforeEach
    public void setUp() {
        parseRobotCommands = new ParseRobotCommands();
    }

    @Test
    public void checkMoveForwardValidCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("F");
        Command myMoveForwardCommand = parseRobotCommands.parse(commands).get(0);
        Assertions.assertEquals(myMoveForwardCommand.getCommandType(), MOVE_FORWARD_COMMAND_DESCRIPTION);
    }

    @Test
    public void checkMoveBackwardsdValidCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("B");
        Command myMoveForwardCommand = parseRobotCommands.parse(commands).get(0);
        Assertions.assertEquals(myMoveForwardCommand.getCommandType(), MOVE_BACKWARDS_COMMAND_DESCRIPTION);
    }

    @Test
    public void checkTurnLeftdValidCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("L");
        Command myMoveForwardCommand = parseRobotCommands.parse(commands).get(0);
        Assertions.assertEquals(myMoveForwardCommand.getCommandType(), TURN_LEFT_COMMAND_DESCRIPTION);
    }

    @Test
    public void checkTurnRightValidCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("R");
        Command myMoveForwardCommand = parseRobotCommands.parse(commands).get(0);
        Assertions.assertEquals(myMoveForwardCommand.getCommandType(), TURN_RIGHT_COMMAND_DESCRIPTION);
    }

    @Test
    public void checkTakeSampleValidCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("S");
        Command myMoveForwardCommand = parseRobotCommands.parse(commands).get(0);
        Assertions.assertEquals(myMoveForwardCommand.getCommandType(), TAKE_SAMPLE_COMMAND_DESCRIPTION);
    }

    @Test
    public void checkExtendSolarPanelsValidCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("E");
        Command myMoveForwardCommand = parseRobotCommands.parse(commands).get(0);
        Assertions.assertEquals(myMoveForwardCommand.getCommandType(), EXTEND_SOLAR_PANELS_COMMAND_DESCRIPTION);
    }

    @Test
    public void checkInvalidCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("X");
        Assertions.assertThrows(CommandDoesNotValidException.class, () -> {
            parseRobotCommands.parse(commands).get(0);
        });

    }
}