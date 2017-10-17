package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import de.thelearningtriangle.mapbuilder.core.DrawController;
import de.thelearningtriangle.mapbuilder.core.MouseController;

public class OverworldPanel extends JPanel {

	private int[][] map;
	private boolean gridEnabled = false;
	private boolean imageEnabled = false;
	private boolean controlsEnabled = false;
	private int windowSize;

	private MouseController mouseController;

	public OverworldPanel(int[][] map, int windowSize) {
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

	private void drawOverworld(Graphics g, int[][] map) {

		for (int rowNumber = 0; rowNumber < map.length; rowNumber++) {
			for (int columnNumber = 0; columnNumber < map.length; columnNumber++) {

				DrawController.drawBottomLine(windowSize, mouseController, g);

				g.drawImage(DrawController.findMatchingImage(g, rowNumber, columnNumber, map),
						rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
						windowSize / map.length, windowSize / map.length, this);

				if (gridEnabled) {
					g.setColor(Color.BLACK);
					g.drawRect(rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
							windowSize / map.length, windowSize / map.length);
				}

				if (controlsEnabled) {
					DrawController.drawMenu(g);
				}

			}
		}
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
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
