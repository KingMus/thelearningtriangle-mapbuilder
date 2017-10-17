package de.thelearningtriangle.mapbuilder.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import de.thelearningtriangle.mapbuilder.ui.ImageLoader;
import de.thelearningtriangle.mapbuilder.ui.MainWindow;
import de.thelearningtriangle.mapbuilder.ui.OverworldPanel;

public class KeyboardController implements KeyListener
{

	private MainWindow mainWindow;
	private int decider=0;

	public KeyboardController(MainWindow mainWindow)
	{

		this.mainWindow = mainWindow;

	}

	@Override
	public void keyPressed(KeyEvent e)
	{

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_G)
		{
			mainWindow.getOverworldPanel().setGridEnabled(!mainWindow.getOverworldPanel().isGridEnabled());
		}
		
		if (e.getKeyCode() == KeyEvent.VK_I)
		{
			decider = decider++ >= 2 ? 0 : decider++;
			String newStyle;
			switch (decider) {
			case 0:
				newStyle="Steven";
				break;
			case 1:
				newStyle="Classic";
				break;
			case 2:
				newStyle="RPG";
				break;
			default:
				newStyle="Steven";
				break;
			}
			ImageLoader imageLoader = new ImageLoader(newStyle);
			mainWindow.getOverworldPanel().setImageEnabled(!mainWindow.getOverworldPanel().isImageEnabled());
		}
		
		if (e.getKeyCode() == KeyEvent.VK_C)
		{
			mainWindow.getOverworldPanel().setControlsEnabled(!mainWindow.getOverworldPanel().isControlsEnabled());
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			String fileName = JOptionPane.showInputDialog("Bennene deine Map");
			FileController.parseFileFromMap(mainWindow.getOverworldPanel().getMap(), fileName);
		}

	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

}
