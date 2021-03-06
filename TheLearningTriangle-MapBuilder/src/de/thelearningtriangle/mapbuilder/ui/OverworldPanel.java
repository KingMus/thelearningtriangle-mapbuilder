package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import de.thelearningtriangle.mapbuilder.core.DrawController;
import de.thelearningtriangle.mapbuilder.core.Field;
import de.thelearningtriangle.mapbuilder.core.MouseController;

/**
 * the implementation of the main panel
 * 
 * @author Marco Mueller
 *
 */
public class OverworldPanel extends JPanel {

	private Field[][] map;
	private boolean gridEnabled = false;
	private boolean imageEnabled = false;
	private boolean controlsEnabled = false;
	private int windowSize;

	private MouseController mouseController;

	public OverworldPanel(Field[][] map, int windowSize) {
		this.map = map;
		this.windowSize = windowSize;

		mouseController = new MouseController(this);

		this.addMouseListener(mouseController);
		this.addMouseMotionListener(mouseController);

	}

	public void paint(Graphics g) {
		super.paint(g);

		try {

			drawOverworld(g, map);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * draws the whole game
	 * 
	 * @param g
	 *            - Graphics
	 * @param map
	 *            - the game map
	 */
	private void drawOverworld(Graphics g, Field[][] map) {

		DrawController.drawBottomLine(windowSize, mouseController, g);


		// draw game map with matching field and draw grid when activated
		for (int rowNumber = 0; rowNumber < map.length; rowNumber++) {
			for (int columnNumber = 0; columnNumber < map.length; columnNumber++) {

				g.drawImage(DrawController.findMatchingImage(rowNumber, columnNumber, map),
						rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
						windowSize / map.length, windowSize / map.length, this);

				if (gridEnabled) {
					g.setColor(Color.BLACK);
					g.drawRect(rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
							windowSize / map.length, windowSize / map.length);
				}
			}
		}
		
		if (controlsEnabled) {
			DrawController.drawMenu(g);
		}
	}

	// getters and setters
	public Field[][] getMap() {
		return map;
	}

	public void setMap(Field[][] map) {
		this.map = map;
	}

	public void setGridEnabled(boolean gridEnabled) {
		this.gridEnabled = gridEnabled;
		repaint();
	}

	public boolean isGridEnabled() {
		return gridEnabled;
	}

	public boolean isImageEnabled() {
		return imageEnabled;

	}

	public void setImageEnabled(boolean imageEnabled) {
		this.imageEnabled = imageEnabled;
		repaint();
	}

	public boolean isControlsEnabled() {
		return controlsEnabled;
	}

	public void setControlsEnabled(boolean controlsEnabled) {
		this.controlsEnabled = controlsEnabled;
		repaint();
	}

	public int getWindowSize() {
		return windowSize;
	}
}
