package de.thelearningtriangle.mapbuilder.core;

import javax.swing.JOptionPane;

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
			map = MapController.generateBlankMap(15);
		} else {
			String fileName = JOptionPane.showInputDialog("Welche Datei laden?");
			map = FileController.parseMapFromFile(fileName);
		}
		MainWindow mainW = new MainWindow(map);
	}

}
