package de.thelearningtriangle.mapbuilder.core;

import de.thelearningtriangle.mapbuilder.ui.MainWindow;

public class Application
{

	public static void main(String[] args)
	{
		int[][] map = new int[20][20];
		MainWindow mainW = new MainWindow(map);
	}
	
}
