package com.ocs.marsrobot.model;

import lombok.Data;

@Data public class Position {
    Location location;
    String facing;

    public Position() {
    }

    public Position(Location location, String facing) {
        this.location = location;
        this.facing = facing;
    }
}
