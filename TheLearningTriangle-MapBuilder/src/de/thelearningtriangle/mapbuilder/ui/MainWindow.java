package de.thelearningtriangle.mapbuilder.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;

import de.thelearningtriangle.mapbuilder.core.KeyboardController;

/**
 * the implementation of the window
 * 
 * @author Marco Mueller
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private OverworldPanel overworldPanel;

	public MainWindow(int[][] map, int windowSize) {

		overworldPanel = new OverworldPanel(map, windowSize);

		// define window
		this.setSize(windowSize + 6, windowSize + 69);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		this.setTitle("The Learning Triangle - Map Builder");
		this.add(overworldPanel);
		this.addKeyListener(new KeyboardController(this));
		this.setVisible(true);

	}

	public OverworldPanel getOverworldPanel() {
		return overworldPanel;
	}
}
