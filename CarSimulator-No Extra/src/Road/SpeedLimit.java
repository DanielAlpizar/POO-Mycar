package Road;

import java.util.*;

import Car.Obstacles;

/**
 * 
 */
public class SpeedLimit extends Obstacle {

	private int maximumSpeed;

	private int minimumSpeed;

	public SpeedLimit() {
	}

	public int getMaximumSpeed() {
		return maximumSpeed;
	}

	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}

	public int getMinimumSpeed() {
		return minimumSpeed;
	}

	public void setMinimumSpeed(int minimumSpeed) {
		this.minimumSpeed = minimumSpeed;
	}
	
	public int[][] Build(int[][] map){
		return map;

		
	}
}