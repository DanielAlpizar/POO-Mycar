package Car;

import java.util.*;

public class Direction extends System {
	
	private boolean TurnLeft;
	private boolean TurnRight;
	private int Degrees;

	public Direction() {
		
	}
	
	public boolean isTurnLeft() {
		return TurnLeft;
	}



	public boolean isTurnRight() {
		return TurnRight;
	}
	


	public int getDegrees() {
		return Degrees;
	}

	public void setDegrees(int degrees) {
		Degrees = degrees;
	}

	public void turnLeft(boolean turnLeft){
		TurnLeft=turnLeft;
	}
	
	public void turnRight(boolean turnRight){
		TurnRight=turnRight;
	}
}