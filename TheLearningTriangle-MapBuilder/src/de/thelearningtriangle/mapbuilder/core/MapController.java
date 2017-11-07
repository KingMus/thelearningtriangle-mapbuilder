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
	public static int[][] generateBlankMap(int worldSize) {

		int[][] map = new int[worldSize][worldSize];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {

				map[i][j] = 1;

				// if field is at the edge, change it to a wall
				if (i == 0 || j == 0 || i == map.length - 1 || j == map.length - 1) {
					map[i][j] = 2;
				}
			}
		}

		return map;
	}
	
	public static int[][] getMapWithMode() {
		
		int mode = defineMode();

		int[][] map;

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
	
	private static int defineMode() {
		Object[] options = { "New...", "Load..." };
		return JOptionPane.showOptionDialog(null, "New map or load map?", "Map Builder",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
				options, // the titles of buttons
				options[0]);
	}

}
