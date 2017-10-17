package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import de.thelearningtriangle.mapbuilder.core.KeyboardController;
import de.thelearningtriangle.mapbuilder.core.MouseController;

public class OverworldPanel extends JPanel {

	private int[][] map;
	private boolean gridEnabled = false;
	private boolean imageEnabled = false;
	private int windowSize;

	public OverworldPanel(int[][] map, int windowSize) {
		this.map = map;
		this.windowSize = windowSize;

		MouseController mouseController = new MouseController(this);

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

				drawMatchingField(g, map, rowNumber, columnNumber);

				if (gridEnabled) {
					g.setColor(Color.WHITE);
					g.drawRect(rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
							windowSize / map.length, windowSize / map.length);
				}

			}
		}
	}

	private void drawMatchingField(Graphics g, int[][] map, int rowNumber, int columnNumber) {
		switch (map[columnNumber][rowNumber]) {
		case 1:
			if (imageEnabled) {
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.normalField);
			} else {
				drawMatchingRect(rowNumber, columnNumber, g, Color.GRAY);
			}
			break;
		case 2:
			if (imageEnabled) {
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.wallField);
			} else {
				drawMatchingRect(rowNumber, columnNumber, g, Color.BLACK);
			}
			break;
		case 3:
			if (imageEnabled) {
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.poisonField);
			} else {
				drawMatchingRect(rowNumber, columnNumber, g, Color.MAGENTA);
			}
			break;
		case 4:
			if (imageEnabled) {
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.deathField);
			} else {
				drawMatchingRect(rowNumber, columnNumber, g, Color.RED);
			}
			break;
		case 5:
			if (imageEnabled) {
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.energyField);
			} else {
				drawMatchingRect(rowNumber, columnNumber, g, Color.GREEN);
			}
			break;
		case 9:
			if (imageEnabled) {
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.triangle);
			} else {
				drawMatchingRect(rowNumber, columnNumber, g, Color.LIGHT_GRAY);
			}
			break;
		default:
			break;
		}
	}

	public void drawMatchingImage(int rowNumber, int columnNumber, Graphics g, Image field) {
		g.drawImage(field, rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
				windowSize / map.length, windowSize / map.length, this);
	}

	public void drawMatchingRect(int rowNumber, int columnNumber, Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(rowNumber * windowSize / map.length, columnNumber * windowSize / map.length, windowSize / map.length,
				windowSize / map.length);
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

	public int getWindowSize() {
		return windowSize;
	}
}
