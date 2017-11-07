package de.thelearningtriangle.mapbuilder.core;

import de.thelearningtriangle.mapbuilder.ui.ImageLoader;
import de.thelearningtriangle.mapbuilder.ui.MainWindow;

public class Application {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		ImageLoader imageLoader = new ImageLoader("Stesty");

		int[][] map = MapController.getWorldMap();

		MainWindow mainW = new MainWindow(map);
	}



}
