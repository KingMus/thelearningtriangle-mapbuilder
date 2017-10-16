package de.thelearningtriangle.mapbuilder.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	private OverworldPanel	overworldPanel;

	public MainWindow()
	{

		overworldPanel = new OverworldPanel();
//		settingsPanel = new SettingsPanel();

		this.setSize(400+6, 400+29);
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
