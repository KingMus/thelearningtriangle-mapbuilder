package de.thelearningtriangle.mapbuilder.core;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import de.thelearningtriangle.mapbuilder.ui.ImageLoader;

public enum Field {
	NORMAL(1, ImageLoader.normalField), WALL(2, ImageLoader.wallField), POISON(3, ImageLoader.poisonField), DEATH(4,
			ImageLoader.deathField), ENERGY(5, ImageLoader.energyField);

	private int value;
	private Image image;
	
	private static final Map<Integer, Field> map = new HashMap<>(values().length, 1);

	private Field(int value, Image image) {
		this.value = value;
		this.image = image;
	}
	
	public static Field of(int value) {
	   return map.get(value);
	  }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Image getImage() {
		return image;
	}
}
