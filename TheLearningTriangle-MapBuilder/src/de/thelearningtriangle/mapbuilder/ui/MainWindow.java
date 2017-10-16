package de.thelearningtriangle.mapbuilder.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;

import de.thelearningtriangle.mapbuilder.core.KeyboardController;


@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	private OverworldPanel	overworldPanel;

	public MainWindow(int[][] map)
	{

		overworldPanel = new OverworldPanel(map);

		this.setSize(606, 629);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		this.setTitle("The Learning Triangle");
		this.add(overworldPanel);
		this.addKeyListener(new KeyboardController(this));
		this.setVisible(true);

	}

	public OverworldPanel getOverworldPanel()
	{
		return overworldPanel;
	}
}
