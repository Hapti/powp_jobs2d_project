package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommandFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestTriangleFigureOptionListener implements ActionListener {
    private final DriverManager driverManager;

    public SelectTestTriangleFigureOptionListener(final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        ComplexCommandFactory.drawTriangle(-100, 50, -25, -100, 50, 50).execute(driverManager.getCurrentDriver());
    }
}
