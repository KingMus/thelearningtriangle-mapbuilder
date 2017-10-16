package de.thelearningtriangle.mapbuilder.core;

import de.thelearningtriangle.mapbuilder.ui.MainWindow;

public class Application
{

	public static void main(String[] args)
	{
		int[][] map = FileController.parseMapFromFile();
		MainWindow mainW = new MainWindow(map);
	}
	
}
