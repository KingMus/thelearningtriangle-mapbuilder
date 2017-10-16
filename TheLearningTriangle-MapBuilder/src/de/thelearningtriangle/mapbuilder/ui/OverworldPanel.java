package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class OverworldPanel extends JPanel
{

	private int mapSize;

	public OverworldPanel(int mapSize)
	{
		this.mapSize = mapSize;
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		try
		{

			drawOverworld(g, mapSize);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private void drawOverworld(Graphics g, int mapSize)
	{

		for (int rowNumber = 0; rowNumber < mapSize; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < mapSize; columnNumber++)
			{

			}
		}
	}
}
