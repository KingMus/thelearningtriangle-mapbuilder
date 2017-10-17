package de.thelearningtriangle.mapbuilder.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import de.thelearningtriangle.mapbuilder.ui.OverworldPanel;

/**
 * this class monitors the mouse and reacts when specific actions happen. It
 * uses the MouseListener methods.
 * 
 * @author Marco Mueller
 *
 */
public class MouseController implements MouseListener, MouseMotionListener {

	private OverworldPanel overworldPanel;

	private int actualFieldToDraw = 2;

	public MouseController(OverworldPanel overworldPanel) {
		this.overworldPanel = overworldPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// if middle mouse button is clicked, change actual field to draw
		if (e.getButton() == MouseEvent.BUTTON2) {

			actualFieldToDraw = actualFieldToDraw++ > 4 ? 1 : actualFieldToDraw++;

		} else {

			int[][] map = overworldPanel.getMap();

			// use mouse position to get the clicked field in map
			int fieldX = e.getX() / (overworldPanel.getWindowSize() / map.length);
			int fieldY = e.getY() / (overworldPanel.getWindowSize() / map.length);

			// only change field when it isnt a field at the edge
			if (!(fieldX == 0 || fieldY == 0 || fieldX == map.length - 1 || fieldY == map.length - 1)) {

				// left mouse button clicked? decrease field type
				// right mouse button clicked? increase field type
				// shift down? set spawn point
				if (e.getButton() == MouseEvent.BUTTON3) {
					map[fieldY][fieldX] = map[fieldY][fieldX]-- < 2 ? 5 : map[fieldY][fieldX]--;
				} else if (e.isShiftDown()) {
					map[fieldY][fieldX] = 9;
				} else {
					map[fieldY][fieldX] = map[fieldY][fieldX]++ > 4 ? 1 : map[fieldY][fieldX]++;
				}

			}

			overworldPanel.setMap(map);
		}

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

		// use mouse position to get the actual field in map
		int fieldX = e.getX() / (overworldPanel.getWindowSize() / map.length);
		int fieldY = e.getY() / (overworldPanel.getWindowSize() / map.length);

		// only change field when it isnt a field at the edge
		if (!(fieldX == 0 || fieldY == 0 || fieldX == map.length - 1 || fieldY == map.length - 1)) {
			map[fieldY][fieldX] = actualFieldToDraw;
		}

		overworldPanel.setMap(map);
		overworldPanel.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public int getActualFieldToDraw() {
		return actualFieldToDraw;
	}

	public void setActualFieldToDraw(int actualFieldToDraw) {
		this.actualFieldToDraw = actualFieldToDraw;
	}

}
