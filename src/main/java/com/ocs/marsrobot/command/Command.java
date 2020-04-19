package com.ocs.marsrobot.command;

import com.ocs.marsrobot.model.Robot;

public interface Command {

    void execute(Robot robot);
    String getCommandType();
}
