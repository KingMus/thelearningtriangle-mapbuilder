package de.thelearningtriangle.mapbuilder.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import de.thelearningtriangle.mapbuilder.ui.OverworldPanel;

public class MouseController implements MouseListener, MouseMotionListener {

	private OverworldPanel overworldPanel;

	public MouseController(OverworldPanel overworldPanel) {

		this.overworldPanel = overworldPanel;

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int[][] map = overworldPanel.getMap();

		int fieldX = e.getX() / (600 / map.length);
		int fieldY = e.getY() / (600 / map.length);

		if (!(fieldX == 0 || fieldY == 0 || fieldX == map.length - 1 || fieldY == map.length - 1)) {

			if (e.isShiftDown()) {
				map[fieldY][fieldX] = map[fieldY][fieldX]-- < 2 ? 5 : map[fieldY][fieldX]--;
			} else {
				map[fieldY][fieldX] = map[fieldY][fieldX]++ > 4 ? 1 : map[fieldY][fieldX]++;
			}

		}

		overworldPanel.setMap(map);
		overworldPanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int[][] map = overworldPanel.getMap();

		int fieldX = e.getX() / (600 / map.length);
		int fieldY = e.getY() / (600 / map.length);

		if (!(fieldX == 0 || fieldY == 0 || fieldX == map.length - 1 || fieldY == map.length - 1)) {
				map[fieldY][fieldX] = 2;
		}

		overworldPanel.setMap(map);
		overworldPanel.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
