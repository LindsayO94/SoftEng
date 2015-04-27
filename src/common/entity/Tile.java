package common.entity;

public class Tile {
	final int value;
	final int multiplier;
	
	public Tile(int value, int multiplier) {
		if (value < 1 || value > 6 || multiplier < 1 || multiplier > 3) {
			throw new IllegalArgumentException("Illegal value passed to tile constructor");
		}
		
		this.value = value;
		this.multiplier = multiplier;
	}

	public int getValue() {
		return value;
	}

	public int getMultiplier() {
		return multiplier;
	}
}
