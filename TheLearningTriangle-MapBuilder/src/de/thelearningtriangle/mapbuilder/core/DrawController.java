package de.thelearningtriangle.mapbuilder.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import de.thelearningtriangle.mapbuilder.ui.ImageLoader;

/**
 * <b>DrawController</b> controls the different tasks to draw specific things.
 * It is used by the OverworldPanel.
 * 
 * @author Marco Mueller
 *
 */
public class DrawController {

	/**
	 * this method creates the menu of the application. It contains the controls and
	 * an explanation.
	 * 
	 * @param Graphics
	 *            g
	 * @author Marco Mueller
	 */
	public static void drawMenu(Graphics g) {
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

	/**
	 * this method draws the bottom line which contains information about the actual
	 * field and important controls.
	 * 
	 * @param windowSize
	 *            - the application window size
	 * @param mouseController
	 *            - the mouse listener
	 * @param g
	 *            - Graphics
	 * @author Marco Mueller
	 */
	public static void drawBottomLine(int windowSize, MouseController mouseController, Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, windowSize, windowSize, 40);

		g.setColor(Color.WHITE);
		Font arial = new Font("Arial", Font.BOLD, 10);
		g.setFont(arial);
		g.drawString("C - Controls", 15, windowSize + 13);
		g.drawString("S - Save", 15, windowSize + 23);

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

		g.drawString("Actual MouseMove-Field: " + fieldType, 15, windowSize + 33);
	}

	/**
	 * this method finds the correct image for a given map position
	 * 
	 * @param g
	 *            - Graphics
	 * @param rowNumber
	 *            - actual row position
	 * @param columnNumber
	 *            - actual column map
	 * @param map
	 *            - the actual game map
	 * @return the correct image which should be drawn at the given map position
	 * @author Marco Mueller
	 */
	public static Image findMatchingImage(int rowNumber, int columnNumber, Field[][] map) {

		Image fieldImage = null;

		switch (map[columnNumber][rowNumber].getValue()) {
		case 1:
			fieldImage = ImageLoader.normalField;
			break;
		case 2:
			fieldImage = ImageLoader.wallField;
			break;
		case 3:
			fieldImage = ImageLoader.poisonField;
			break;
		case 4:
			fieldImage = ImageLoader.deathField;
			break;
		case 5:
			fieldImage = ImageLoader.energyField;
			break;
		case 9:
			fieldImage = ImageLoader.triangle;
			break;
		default:
			break;
		}

		return fieldImage;
	}

	
	/**
	 * ensure that windowSize divided through worldSize is even (necessary for UI).
	 * If it is, keep everything the same. If it is not, make it even
	 * 
	 * @author Marco Mueller
	 * @param windowSize
	 * @param map
	 * @return the new windowsize
	 */
	public static int calculateWindowSize(Field[][] map) {
		int windowSize = 600;
		windowSize = windowSize % map.length == 0 ? windowSize : windowSize + (map.length - (windowSize % map.length));
		return windowSize;
	}
}
