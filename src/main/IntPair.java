package main;

public class IntPair {
	
	public int x, y;
	
	public IntPair(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	@Override
	public boolean equals(Object input) {
		if (input == this) return true;
		if (!(input instanceof IntPair)) return false;
		
		IntPair pair = (IntPair) input;
		
		return (x == pair.x) && (y == pair.y);
	}

}