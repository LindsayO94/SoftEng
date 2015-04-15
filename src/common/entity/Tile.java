package common.entity;

public class Tile {
	int value;
	int multiplier;
	
	public Tile(int value, int multiplier) {
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
