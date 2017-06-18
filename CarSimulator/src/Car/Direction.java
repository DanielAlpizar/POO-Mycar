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

	public void setTurnLeft(boolean turnLeft) {
		TurnLeft = turnLeft;
	}

	public boolean isTurnRight() {
		return TurnRight;
	}
	
	public void setTurnRight(boolean turnRight) {
		TurnRight = turnRight;
	}

	public int getDegrees() {
		return Degrees;
	}

	public void setDegrees(int degrees) {
		Degrees = degrees;
	}

	public void turnLeft(int pDegrees){
		
	}
	
	public void turnRight(int pDegrees){
		
	}
}