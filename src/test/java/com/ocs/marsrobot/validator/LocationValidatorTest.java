package com.ocs.marsrobot.validator;

import com.ocs.marsrobot.model.Location;
import com.ocs.marsrobot.model.Robot;
import com.ocs.marsrobot.validator.LocationValidator;
import com.ocs.marsrobot.exception.MaterialDoesNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

@SpringBootTest
public class LocationValidatorTest {

    private LocationValidator locationValidator;

    @Mock
    private Robot robot;

    @BeforeEach
    public void setUp() {

        locationValidator = new LocationValidator();
        when(robot.getMaxXValueFromTerrain()).thenReturn(3);
        when(robot.getMaxYValueFromTerrain()).thenReturn(3);
    }

    @Test
    public void checkValidCoordinate() {
        Location location = new Location(1,1);
        Assertions.assertTrue(locationValidator.validateCoordinate(location,robot));
    }

    @Test
    public void checkInvalidCoordinate() {
        Location location = new Location(3,3);
        Assertions.assertFalse(locationValidator.validateCoordinate(location,robot));
    }

}