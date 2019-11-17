package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommandFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestRectangleFigureOptionListener implements ActionListener {
    private final DriverManager driverManager;

    public SelectTestRectangleFigureOptionListener(final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        ComplexCommandFactory.drawRectangle(-80, -50, 100, 200).execute(driverManager.getCurrentDriver());
    }
}
