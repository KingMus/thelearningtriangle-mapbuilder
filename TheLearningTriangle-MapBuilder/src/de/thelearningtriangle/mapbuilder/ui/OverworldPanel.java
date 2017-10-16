package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import de.thelearningtriangle.mapbuilder.core.KeyboardController;
import de.thelearningtriangle.mapbuilder.core.MouseController;

public class OverworldPanel extends JPanel
{

	private int[][] map;
	private boolean gridEnabled = false;

	public OverworldPanel(int[][] map)
	{
		this.map = map;
		
		MouseController mouseController = new MouseController(this);
		
		this.addMouseListener(mouseController);
		this.addMouseMotionListener(mouseController);
		
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
				
				switch (map[columnNumber][rowNumber])
				{
				case 1:
					g.setColor(Color.GRAY);
					break;
				case 2:
					g.setColor(Color.BLACK);
					break;
				case 3:
					g.setColor(Color.MAGENTA);
					break;
				case 4:
					g.setColor(Color.RED);
					break;
				case 5:
					g.setColor(Color.GREEN);
					break;
				default:
					break;
				}
				
				g.fillRect(rowNumber*600/map.length, columnNumber*600/map.length, 600/map.length, 600/map.length);
				
				if(gridEnabled){
					g.setColor(Color.WHITE);
					g.drawRect(rowNumber*600/map.length, columnNumber*600/map.length, 600/map.length, 600/map.length);
				}
				
			}
		}
	}

	public int[][] getMap()
	{
		return map;
	}

	public void setMap(int[][] map)
	{
		this.map = map;
	}
	
	public void setGridEnabled(boolean gridEnabled)
	{
		this.gridEnabled = gridEnabled;
		repaint();
	}

	public boolean isGridEnabled()
	{
		return gridEnabled;
	}
}
