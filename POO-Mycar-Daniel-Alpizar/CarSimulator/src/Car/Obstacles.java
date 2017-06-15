package Car;

import java.util.*;

public class Obstacles extends System {

	private boolean Day;
	private int MaximumSpeed;
	private int MinimumSpeed;
	private boolean Rain;
	
	public Obstacles() {
	}


	public void establishMaximumSpeed(int pMaximumSpeed) {
		this.MaximumSpeed =pMaximumSpeed;
	}
	
	public void establishMinimumSpeed(int pMinimumSpeed) {
		this.MinimumSpeed = pMinimumSpeed;
	}
	
	public void showDay(boolean pDay) {
		this.Day = pDay;
	}
	
	public void showRain(boolean pRain) {
		this.Rain = pRain;
	}

}