package de.thelearningtriangle.mapbuilder.core;

import javax.swing.JOptionPane;

import de.thelearningtriangle.mapbuilder.ui.ImageLoader;
import de.thelearningtriangle.mapbuilder.ui.MainWindow;

public class Application
{

	public static void main(String[] args)
	{

		@SuppressWarnings("unused")
		ImageLoader imageLoader = new ImageLoader("Classic");
		
		// 1=new 2=file
		int mode = 1;
		int windowSize=600;
		
		int[][] map;

		if (mode == 1)
		{
			map = MapController.generateBlankMap(20);
		} else {
			String fileName = JOptionPane.showInputDialog("Welche Datei laden?");
			map = FileController.parseMapFromFile(fileName);
		}
		
		// ensure that windowSize divided through worldSize is even (necessary
				// for UI). If it is, keep everything the same. If it is not, make it
				// even
				windowSize = windowSize % map.length == 0 ? windowSize : windowSize + (map.length - (windowSize % map.length));

		
		MainWindow mainW = new MainWindow(map, windowSize);
	}

}
