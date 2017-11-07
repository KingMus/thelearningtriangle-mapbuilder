package de.thelearningtriangle.mapbuilder.core;

import java.util.HashMap;
import java.util.Map;

public enum Field {
	NORMAL(1), WALL(2), POISON(3), DEATH(4), ENERGY(5);

	private int value;

	private static final Map<Integer, Field> map = new HashMap<>(values().length, 1);

	static {
		for (Field field : values())
			map.put(field.value, field);
	}

	private Field(int value) {
		this.value = value;
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

}
