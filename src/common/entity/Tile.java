package common.entity;

public class Tile {
	int oldValue;
		
	final int value;
	final int multiplier;
	
	public Tile(int value, int multiplier) {
		if (value < 1 || value > 6 || multiplier < 1 || multiplier > 3) {
			throw new IllegalArgumentException("Illegal value passed to tile constructor");
		}
		this.oldValue = value;
		this.value = value;
		this.multiplier = multiplier;
	}

	public int getValue() {
		return value;
	}
	
	public int getOldValue() {
		return oldValue;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
