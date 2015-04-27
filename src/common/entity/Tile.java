package common.entity;

public class Tile {
<<<<<<< HEAD
	int oldValue;
	int value;
	int multiplier;
	
	public Tile(int value, int multiplier) {
		this.oldValue = value;
=======
	final int value;
	final int multiplier;
	
	public Tile(int value, int multiplier) {
		if (value < 1 || value > 6 || multiplier < 1 || multiplier > 3) {
			throw new IllegalArgumentException("Illegal value passed to tile constructor");
		}
		
>>>>>>> 850fa54edc1e794a25390c60dd58c1ecc72d693a
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
