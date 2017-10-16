package de.thelearningtriangle.mapbuilder.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	private OverworldPanel	overworldPanel;

	public MainWindow(int mapSize)
	{

		overworldPanel = new OverworldPanel(mapSize);

		this.setSize(606, 629);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		this.setTitle("The Learning Triangle");
		this.add(overworldPanel);
		this.setVisible(true);

	}

	public OverworldPanel getOverworldPanel()
	{
		return overworldPanel;
	}
}
