package edu.kis.powp.jobs2d;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapterFromAbstract;
import edu.kis.powp.jobs2d.events.*;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestJobs2dPatterns {
	//pkrystian: changed order to match standards
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String BASIC_LINE_DRAWER = "Basic Line Drawer";
	private static final String DOTTED_LINE_DRAWER = "Dotted Line Drawer";
	private static final String SPECIAL_LINE_DRAWER = "Special Line Drawer";
    private static final String DRAWER_FROM_ABSTRACT = "Drawer from abstract";

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(final Application application) {
		final SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager());
		final SelectTestFigure2OptionListener selectTestFigure2OptionListener = new SelectTestFigure2OptionListener(
				DriverFeature.getDriverManager());
		final SelectTestTriangleFigureOptionListener selectTestTriangleFigureOptionListener =
				new SelectTestTriangleFigureOptionListener(DriverFeature.getDriverManager());
		final SelectTestRectangleFigureOptionListener selectTestRectangleFigureOptionListener =
				new SelectTestRectangleFigureOptionListener(DriverFeature.getDriverManager());
		final SelectTestRhombusFigureOptionListener selectTestRhombusFigureOptionListener =
				new SelectTestRhombusFigureOptionListener(DriverFeature.getDriverManager());

		application.addTest("Figure Joe 1", selectTestFigureOptionListener);
		application.addTest("Figure Joe 2", selectTestFigure2OptionListener);
		application.addTest("Triangle", selectTestTriangleFigureOptionListener);
		application.addTest("Rectangle", selectTestRectangleFigureOptionListener);
		application.addTest("Rhombus", selectTestRhombusFigureOptionListener);
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(final Application application) {
		final Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		final Job2dDriver testDriver = new Job2dDriverAdapter(DrawerFeature.getDrawerController());
		DriverFeature.addDriver("Buggy Simulator", testDriver);

		final Job2dDriver basicLineDriver = new LineDrawerAdapter(DrawerFeature.getDrawerController(),
				LineFactory.getBasicLine(),
				BASIC_LINE_DRAWER);
		DriverFeature.addDriver(BASIC_LINE_DRAWER, basicLineDriver);

		final Job2dDriver dottedLineDriver = new LineDrawerAdapter(DrawerFeature.getDrawerController(),
				LineFactory.getDottedLine(),
				DOTTED_LINE_DRAWER);
		DriverFeature.addDriver(DOTTED_LINE_DRAWER, dottedLineDriver);

		final Job2dDriver specialLineDriver = new LineDrawerAdapter(DrawerFeature.getDrawerController(),
				LineFactory.getSpecialLine(),
				SPECIAL_LINE_DRAWER);
		DriverFeature.addDriver(SPECIAL_LINE_DRAWER, specialLineDriver);

		final Job2dDriver drawerFromAbstract = new LineDrawerAdapterFromAbstract(DrawerFeature.getDrawerController());
        DriverFeature.addDriver(DRAWER_FROM_ABSTRACT, drawerFromAbstract);

		DriverFeature.updateDriverInfo();
	}

	//pkrystian: this method was used to create new window in app
//	/**
//	 * Auxiliary routines to enable using Buggy Simulator.
//	 *
//	 * @param application Application context.
//	 */
//	private static void setupDefaultDrawerVisibilityManagement(Application application) {
//		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
//		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
//				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
//		defaultDrawerWindow.setVisible(true);
//	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(final Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		//pkrystian: using Runnable is old-fashioned and considered as bad practise nowadays.
		// Replaced it with more up to date solution - java 8 lambda :)
		EventQueue.invokeLater(() -> {
			final Application app = new Application("2d jobs Visio");
			DrawerFeature.setupDrawerPlugin(app);

			//pkrystian: this line caused new, unnecessary window to pop out
			//setupDefaultDrawerVisibilityManagement(app);

			DriverFeature.setupDriverPlugin(app);
			setupDrivers(app);
			setupPresetTests(app);
			setupLogger(app);

			app.setVisibility(true);
		});
	}

}
