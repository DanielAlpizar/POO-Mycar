package Car;

import java.util.*;

public class Obstacles extends System {

	private boolean Day;
	private int MaximumSpeed;
	private int MinimumSpeed;
	private boolean Rain;
	
	public Obstacles() {
	}

	public boolean isDay() {
		return Day;
	}

	public void setDay(boolean day) {
		Day = day;
	}

	public int getMaximumSpeed() {
		return MaximumSpeed;
	}

	public void setMaximumSpeed(int maximumSpeed) {
		MaximumSpeed = maximumSpeed;
	}

	public int getMinimumSpeed() {
		return MinimumSpeed;
	}

	public void setMinimumSpeed(int minimumSpeed) {
		MinimumSpeed = minimumSpeed;
	}
	
	public boolean isRain() {
		return Rain;
	}

	public void setRain(boolean rain) {
		Rain = rain;
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