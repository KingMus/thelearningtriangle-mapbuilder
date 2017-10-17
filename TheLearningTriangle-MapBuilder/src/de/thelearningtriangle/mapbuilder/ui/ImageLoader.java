package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageLoader {
	public static Image energyField, deathField, normalField;
	public static Image wallField;
	public static Image poisonField;
	public static Image triangle;

	public ImageLoader() {

		String pfad = System.getProperty("user.dir").replace('\\', '/');
		
		ImageIcon energyFieldIcon = new ImageIcon(pfad + "/Images/Style-Classic_Energy_Field.png");
		energyField = energyFieldIcon.getImage();
		ImageIcon deathFieldIcon = new ImageIcon(pfad + "/Images/Style-Classic_Death_Field.png");
		deathField = deathFieldIcon.getImage();
		ImageIcon normalFieldIcon = new ImageIcon(pfad + "/Images/Style-Classic_Normal_Field.png");
		normalField = normalFieldIcon.getImage();
		ImageIcon wallFieldIcon = new ImageIcon(pfad + "/Images/Style-Classic_Wall_Field.png");
		wallField = wallFieldIcon.getImage();
		ImageIcon poisonFieldIcon = new ImageIcon(pfad + "/Images/Style-Classic_Poison_Field.png");
		poisonField = poisonFieldIcon.getImage();

		ImageIcon triangleIcon = new ImageIcon(pfad + "/Images/LearningTriangle.png");
		triangle = triangleIcon.getImage();

	}

}
