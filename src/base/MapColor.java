package base;

import java.awt.Color;

import base.unit.Direction;

public class MapColor {
	public static Color dtC(Direction direction) {
		return switch (direction) {
			case EAST -> new Color(233,84,160);
			case NORTH -> new Color(255,241,80);
			case WEST -> new Color(107,225,49);
			case SOUTH -> new Color(84,193,225);
		};
	}
}
