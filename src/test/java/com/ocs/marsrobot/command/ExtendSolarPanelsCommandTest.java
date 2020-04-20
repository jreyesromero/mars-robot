package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.command.ExtendSolarPanelsCommand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

public class ExtendSolarPanelsCommandTest {

    private ExtendSolarPanelsCommand extendSolarPanelsCommand;

    @Mock
    private Robot robot;

    @BeforeEach
    public void setUp() {
        extendSolarPanelsCommand = new ExtendSolarPanelsCommand();
        robot = new Robot();
        robot.setBattery(20);

    }

    @Test
    public void checkExtendSonalPanels() {
        extendSolarPanelsCommand.execute(robot);
        Assertions.assertEquals(robot.getBattery(), 29);
    }
}