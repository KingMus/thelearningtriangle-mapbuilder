package de.thelearningtriangle.mapbuilder.core;

import javax.swing.JOptionPane;

import de.thelearningtriangle.mapbuilder.ui.ImageLoader;
import de.thelearningtriangle.mapbuilder.ui.MainWindow;

public class Application {

	/*
	 * TODO General:
	 * 
	 * - Generate Maps from .jpg or so - Resize window after application start
	 */

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		ImageLoader imageLoader = new ImageLoader("Steven");

		
		int mode = defineMode();
		int windowSize = 600;

		int[][] map;

		if (mode == 0) {
			int mapSize = Integer.parseInt(JOptionPane.showInputDialog("Size of Map:"));
			map = MapController.generateBlankMap(mapSize);
		} else {
			String fileName = JOptionPane.showInputDialog("Filename?");
			map = FileController.parseMapFromFile(fileName);
		}

		// ensure that windowSize divided through worldSize is even (necessary
		// for UI). If it is, keep everything the same. If it is not, make it
		// even
		windowSize = windowSize % map.length == 0 ? windowSize : windowSize + (map.length - (windowSize % map.length));

		MainWindow mainW = new MainWindow(map, windowSize);
	}

	private static int defineMode() {
		Object[] options = { "New...", "Load..." };
		return JOptionPane.showOptionDialog(null, "New map or load map?", "Map Builder",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
				options, // the titles of buttons
				options[0]);
	}

}
