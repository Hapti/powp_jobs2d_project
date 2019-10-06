package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigure2OptionListener implements ActionListener {

    private final DriverManager driverManager;

    public SelectTestFigure2OptionListener(final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        FiguresJoe.figureScript2(driverManager.getCurrentDriver());
    }
}
