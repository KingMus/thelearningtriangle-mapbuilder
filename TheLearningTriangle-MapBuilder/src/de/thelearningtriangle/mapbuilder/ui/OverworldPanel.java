package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class OverworldPanel extends JPanel
{

	private int[][] map;

	public OverworldPanel(int[][] map)
	{
		this.map = map;
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		try
		{

			drawOverworld(g, map);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private void drawOverworld(Graphics g, int[][] map)
	{

		for (int rowNumber = 0; rowNumber < map.length; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < map.length; columnNumber++)
			{
				g.fillRect(rowNumber*600/map.length, columnNumber*600/map.length, 600/map.length, 600/map.length);
			}
		}
	}
}
