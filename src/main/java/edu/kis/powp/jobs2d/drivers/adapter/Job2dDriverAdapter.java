package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class Job2dDriverAdapter implements Job2dDriver {
    private final DrawPanelController drawPanelController;
    //pkrystian: declarations in one line should be avoided - code looks cleaner and is easier to read
    private int startX = 0;
    private int startY = 0;

    public Job2dDriverAdapter(final DrawPanelController drawPanelController) {
        this.drawPanelController = drawPanelController;
    }

    @Override
    public void setPosition(final int x, final int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(final int x, final int y) {
        final ILine line = LineFactory.getBasicLine();
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        drawPanelController.drawLine(line);
        setPosition(x, y); //update position of drawer "head"
    }

    @Override
    public String toString() {
        return "@Q!$!@$!#@$(*#@&Q(%^*#@";
    }
}
