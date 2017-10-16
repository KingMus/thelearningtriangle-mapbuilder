package de.thelearningtriangle.mapbuilder.core;

import javax.jws.WebParam.Mode;

import de.thelearningtriangle.mapbuilder.ui.MainWindow;

public class Application
{

	public static void main(String[] args)
	{

		// 1=new 2=file
		int mode = 1;
		int[][] map;

		if (mode == 1)
		{
			map = MapController.generateBlankMap(20);
		} else
		{
			map = FileController.parseMapFromFile();
		}
		MainWindow mainW = new MainWindow(map);
	}

}
