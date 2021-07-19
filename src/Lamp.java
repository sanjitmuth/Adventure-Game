
public class Lamp {

	/*
	 * Instance variables and methods go here, you're responsible for 
	 * choosing and naming them.
	 */
	private boolean isLit;
	
	public Lamp() {
		isLit = false;
	}
	
	public void offLamp() {
		isLit = false;
	}
	
	public void onLamp() {
		isLit = true;
	}
	
	public boolean getLampState() {
		return isLit;
	}
	


	
}