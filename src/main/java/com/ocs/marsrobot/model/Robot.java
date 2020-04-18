package com.ocs.marsrobot.model;

import lombok.Data;

@Data public class Robot {
    int battery;
    private Position position;

    public Robot(int battery, Position position) {
        this.battery = battery;
        this.position = position;
    }
}
