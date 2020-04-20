package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.model.Position;
import com.ocs.marsrobot.model.Location;
import com.ocs.marsrobot.command.TurnLeftCommand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

public class TurnLeftCommandTest {

    private TurnLeftCommand turnLeftCommand;

    @Mock
    private Robot robot;

    @BeforeEach
    public void setUp() {
        turnLeftCommand = new TurnLeftCommand();
        robot = new Robot();
        Location location = new Location(0,0);
        Position position = new Position(location,"North");
        robot.setPosition(position);
        robot.setBattery(20);

    }

    @Test
    public void checkExtendSonalPanels() {
        turnLeftCommand.execute(robot);
        Assertions.assertEquals(robot.getPosition().getFacing(), "EAST");
        Assertions.assertEquals(robot.getBattery(),18);
    }

}