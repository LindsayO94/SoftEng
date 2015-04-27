package common.entity;

public class Tile {
	int oldValue;
	int value;
	int multiplier;
	
	public Tile(int value, int multiplier) {
		this.oldValue = value;
		this.value = value;
		this.multiplier = multiplier;
	}

	public int getValue() {
		return value;
	}

	public int getMultiplier() {
		return multiplier;
	}
	
	public void toggleActive(){
		if (this.value != 7){
			this.value = 7;
		}
		else
			this.value = oldValue;
	}
}
