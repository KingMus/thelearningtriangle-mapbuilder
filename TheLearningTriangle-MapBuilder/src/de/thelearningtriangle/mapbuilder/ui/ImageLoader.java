package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Image;
import javax.swing.ImageIcon;

import de.thelearningtriangle.mapbuilder.core.Application;

/**
 * this class loads all necessary images for the builder.
 * 
 * @author Marco-Uni
 *
 */
public class ImageLoader {
	public static Image energyField, deathField, normalField;
	public static Image wallField;
	public static Image poisonField;
	public static Image triangle;

	public ImageLoader(String style) {

		String pfad = System.getProperty("user.dir").replace('\\', '/');

		// use style-string to load the matching image
		ImageIcon energyFieldIcon = new ImageIcon(Application.class.getResource("/Style-" + style + "_Energy_Field.png"));
		energyField = energyFieldIcon.getImage();
		ImageIcon deathFieldIcon = new ImageIcon(Application.class.getResource("/Style-" + style + "_Death_Field.png"));
		deathField = deathFieldIcon.getImage();
		ImageIcon normalFieldIcon = new ImageIcon(Application.class.getResource("/Style-" + style + "_Normal_Field.png"));
		normalField = normalFieldIcon.getImage();
		ImageIcon wallFieldIcon = new ImageIcon(Application.class.getResource("/Style-" + style + "_Wall_Field.png"));
		wallField = wallFieldIcon.getImage();
		ImageIcon poisonFieldIcon = new ImageIcon(Application.class.getResource("/Style-" + style + "_Poison_Field.png"));
		poisonField = poisonFieldIcon.getImage();

		ImageIcon triangleIcon = new ImageIcon(Application.class.getResource("/LearningTriangle.png"));
		triangle = triangleIcon.getImage();

	}

}
