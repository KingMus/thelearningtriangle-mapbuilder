package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

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
				
				drawBottomLine(g);
				
				drawMatchingField(g, map, rowNumber, columnNumber);

				if (gridEnabled) {
					g.setColor(Color.BLACK);
					g.drawRect(rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
							windowSize / map.length, windowSize / map.length);
				}

				if (controlsEnabled) {
					drawMenu(g);
				}

			}
		}
	}

	private void drawMenu(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(60, 60, 300, 320);

		g.setColor(Color.BLACK);
		
		g.setFont(new Font("Arial", Font.BOLD, 12));
		g.drawString("HOW TO USE", 70, 80);
		g.drawString("Left/Right Click - Change Field", 70, 130);
		g.drawString("Move Mouse - Draw Field", 70, 160);
		g.drawString("Middle Mouse - Change Field for Mouse Move", 70, 190);
		g.drawString("Click + SHIFT - Set Spawn", 70, 220);
		g.drawString("G - Show Grid", 70, 250);
		g.drawString("I - Change to Image Mode", 70, 280);
		g.drawString("S - Save Map", 70, 310);
		g.drawString("C - Close/open this menu", 70, 360);
	}

	private void drawBottomLine(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, windowSize, windowSize, 40);
		
		g.setColor(Color.WHITE);
		Font arial = new Font("Arial", Font.BOLD, 10);
		g.setFont(arial);
		g.drawString("C - Controls", 15, windowSize+13);
		g.drawString("S - Save", 15, windowSize+23);
		
		String fieldType;
		switch (mouseController.getActualFieldToDraw()) {
		case 1:
			fieldType = "Normal";
			break;
		case 2:
			fieldType = "Wall";
			break;
		case 3:
			fieldType = "Poison";
			break;
		case 4:
			fieldType = "Death";
			break;
		case 5:
			fieldType = "Energy";
			break;
		default:
			fieldType = "Normal";
			break;
		}
		
		g.drawString("Actual MouseMove-Field: "+fieldType, 15, windowSize+33);
	}

	private void drawMatchingField(Graphics g, int[][] map, int rowNumber, int columnNumber) {
		switch (map[columnNumber][rowNumber]) {
		case 1:
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.normalField);
			break;
		case 2:
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.wallField);
			break;
		case 3:
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.poisonField);
			break;
		case 4:
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.deathField);
			break;
		case 5:
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.energyField);
			break;
		case 9:
				drawMatchingImage(rowNumber, columnNumber, g, ImageLoader.triangle);
			break;
		default:
			break;
		}
	}

	public void drawMatchingImage(int rowNumber, int columnNumber, Graphics g, Image field) {
		g.drawImage(field, rowNumber * windowSize / map.length, columnNumber * windowSize / map.length,
				windowSize / map.length, windowSize / map.length, this);
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
