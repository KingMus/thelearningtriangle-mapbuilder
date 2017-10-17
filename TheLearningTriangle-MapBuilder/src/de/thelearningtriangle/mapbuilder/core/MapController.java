package de.thelearningtriangle.mapbuilder.core;

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

}
