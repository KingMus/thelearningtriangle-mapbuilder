package de.thelearningtriangle.mapbuilder.core;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * this class controls actions for the game map
 * 
 * @author Marco Mueller
 *
 */
public class MapController {

	/**
	 * this method creates a blank map with walls at each side.
	 * 
	 * @param worldSize
	 *            - The actual world size (world is always a square)
	 * @return two-dimensional int-array, which is a blank map
	 */
	public static Field[][] generateBlankMap(int worldSize) {

		Field[][] map = new Field[worldSize][worldSize];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {

				map[i][j] = Field.NORMAL;

				// if field is at the edge, change it to a wall
				if (i == 0 || j == 0 || i == map.length - 1 || j == map.length - 1) {
					map[i][j] = Field.WALL;
				}
			}
		}

		return map;
	}
	
	/**
	 * find a map through a mode. Generate a new blank map or load a map from file are the different possibilities.
	 * @author Marco Mueller
	 * @return
	 */
	public static Field[][] getWorldMap() {
		
		int mode = defineMode();

		Field[][] map;

		if (mode == 0) {
			int mapSize = Integer.parseInt(JOptionPane.showInputDialog("Size of Map:"));
			map = MapController.generateBlankMap(mapSize);
		} else {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(null);
			map = FileController.parseMapFromFile(fc.getSelectedFile());
		}

		return map;
	}
	
	/**
	 * choose mode through user interaction (new map or load map from file).
	 * @author Marco Mueller
	 * @return a value for mode
	 */
	private static int defineMode() {
		Object[] options = { "New...", "Load..." };
		return JOptionPane.showOptionDialog(null, "New map or load map?", "Map Builder",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
				options, // the titles of buttons
				options[0]);
	}

}
