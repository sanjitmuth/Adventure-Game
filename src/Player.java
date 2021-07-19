public class Player {
	
	//instance variables
	private int x;
	private int y;
	//class variables
	private Lamp lamp;
	private Key key;
	
	//setter methods
	public void setX(int inX) {
		x = inX;
	}
	
	public void setY(int inY) {
		y = inY;
	}
	
	public void setLamp(Lamp inLamp) {
		lamp = inLamp;
	}
	
	public void setKey(Key inKey) {
		key = inKey;
	}
	
	//getter methods
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Lamp getLamp() {
		return lamp;
	}
	
	public Key getKey() {
		return key;
	}

	
}
