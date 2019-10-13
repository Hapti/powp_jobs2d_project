package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.AbstractDriver;

public class LineDrawerAdapterFromAbstract extends AbstractDriver {
    private final DrawPanelController drawPanelController;

    public LineDrawerAdapterFromAbstract(final DrawPanelController drawPanelController) {
        super(0,0);
        this.drawPanelController = drawPanelController;
    }

    @Override
    public void operateTo(final int x, final int y) {
        final ILine line = LineFactory.getBasicLine();
        line.setStartCoordinates(super.getX(), super.getY());
        line.setEndCoordinates(x, y);

        drawPanelController.drawLine(line);
        setPosition(x, y); //update position of drawer "head"
    }

    @Override
    public String toString(){
        return "Adapter from abstract";
    }
}
