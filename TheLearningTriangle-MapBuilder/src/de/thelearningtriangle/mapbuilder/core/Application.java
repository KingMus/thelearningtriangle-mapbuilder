package de.thelearningtriangle.mapbuilder.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
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
		ImageLoader imageLoader = new ImageLoader("Stesty");

		int windowSize = 600;

		int[][] map = MapController.getMapWithMode();

		windowSize = calculateWindowSize(windowSize, map);

		MainWindow mainW = new MainWindow(map, windowSize);
	}



	private static int calculateWindowSize(int windowSize, int[][] map) {
		// ensure that windowSize divided through worldSize is even (necessary
		// for UI). If it is, keep everything the same. If it is not, make it
		// even
		windowSize = windowSize % map.length == 0 ? windowSize : windowSize + (map.length - (windowSize % map.length));
		return windowSize;
	}



}
