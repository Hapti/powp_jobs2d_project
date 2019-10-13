package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter implements Job2dDriver {
    private final DrawPanelController drawPanelController;
    private int startX = 0;
    private int startY = 0;
    private final ILine line;
    private final String label;

    public LineDrawerAdapter(final DrawPanelController drawPanelController, final ILine line, final String label) {
        this.drawPanelController = drawPanelController;
        this.line = line;
        this.label = label;
    }

    @Override
    public void setPosition(final int x, final int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(final int x, final int y) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        drawPanelController.drawLine(line);
        setPosition(x, y);
    }

    @Override
    public String toString() {
        return this.label;
    }
}
