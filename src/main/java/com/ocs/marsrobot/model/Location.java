package com.ocs.marsrobot.model;

import lombok.Data;

@Data public class Location {

    private Integer x;
    private Integer y;

    public Location() {
    }

    public Location(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
