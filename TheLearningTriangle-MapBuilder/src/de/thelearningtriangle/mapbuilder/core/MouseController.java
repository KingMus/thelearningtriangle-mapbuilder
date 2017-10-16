package de.thelearningtriangle.mapbuilder.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.thelearningtriangle.mapbuilder.ui.OverworldPanel;

public class MouseController implements MouseListener
{

	private OverworldPanel overworldPanel;

	public MouseController(OverworldPanel overworldPanel)
	{

		this.overworldPanel = overworldPanel;

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
		int[][] map = overworldPanel.getMap();
		
		map[1][1] = map[1][1]++ > 4 ? 1 : map[1][1]++;
		
		overworldPanel.setMap(map);
		overworldPanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
