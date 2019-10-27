package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.List;

public class ComplexCommand implements DriverCommand {

    private final List<DriverCommand> driverCommands;

    public ComplexCommand(final List<DriverCommand> driverCommands) {
        this.driverCommands = driverCommands;
    }

    @Override
    public void execute(final Job2dDriver job2dDriver) {
        driverCommands.forEach(driverCommand -> driverCommand.execute(job2dDriver));
    }
}
