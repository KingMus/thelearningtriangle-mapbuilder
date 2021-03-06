package de.thelearningtriangle.mapbuilder.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import de.thelearningtriangle.mapbuilder.ui.ImageLoader;
import de.thelearningtriangle.mapbuilder.ui.MainWindow;
import de.thelearningtriangle.mapbuilder.ui.OverworldPanel;

/**
 * this class monitors the keyboard and reacts when specific actions happen. It
 * uses the KeyListener methods.
 * 
 * @author Marco Mueller
 *
 */
public class KeyboardController implements KeyListener {

	private MainWindow mainWindow;
	private int decider = 0;

	public KeyboardController(MainWindow mainWindow) {

		this.mainWindow = mainWindow;

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// if G is pressed, change grid mode
		if (e.getKeyCode() == KeyEvent.VK_G) {
			mainWindow.getOverworldPanel().setGridEnabled(!mainWindow.getOverworldPanel().isGridEnabled());
		}

		// if I is pressed, change image mode
		if (e.getKeyCode() == KeyEvent.VK_I) {
			decider = decider++ >= 5 ? 0 : decider++;
			String newStyle;
			switch (decider) {
			case 0:
				newStyle = "Stesty";
				break;
			case 1:
				newStyle = "Classic";
				break;
			case 2:
				newStyle = "RPG";
				break;
			case 3:
				newStyle = "Nature";
				break;
			case 4:
				newStyle = "Water";
				break;
			case 5:
				newStyle = "Space";
				break;
			default:
				newStyle = "Stesty";
				break;
			}
			ImageLoader imageLoader = new ImageLoader(newStyle);

			mainWindow.getOverworldPanel().setImageEnabled(!mainWindow.getOverworldPanel().isImageEnabled());
		}

		// if C is pressed, change control menu mode
		if (e.getKeyCode() == KeyEvent.VK_C) {
			mainWindow.getOverworldPanel().setControlsEnabled(!mainWindow.getOverworldPanel().isControlsEnabled());
		}

		// if S is pressed, start save action
		if (e.getKeyCode() == KeyEvent.VK_S) {
			FileController.parseFileFromMap(mainWindow.getOverworldPanel().getMap());
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
