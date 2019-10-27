package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private final int x;
    private final int y;

    public SetPositionCommand(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(final Job2dDriver job2dDriver) {
        job2dDriver.setPosition(this.x, this.y);
    }
}
