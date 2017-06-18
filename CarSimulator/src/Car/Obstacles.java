package Car;

import java.util.*;

import Road.PistaTools;

public class Obstacles {

	private boolean Day=true;
	private int MaximumSpeed=60;
	private int MinimumSpeed=0;
	private boolean Rain;
	


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