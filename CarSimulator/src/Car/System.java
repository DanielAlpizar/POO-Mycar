package Car;

import java.util.*;

public class System {
	
	Motor motor = new Motor();
	Direction direction = new Direction();
	Electric electric = new Electric();
	Obstacles obstacles = new Obstacles();

	public System() {
		
	}
	
	public void start() {
		motor.setGear(1);
		motor.setRevolutions(0);
		motor.setRevolutionsTime(0);
		motor.setSpeed(0);
		
		direction.setDegrees(90);
		direction.setTurnLeft(false);
		direction.setTurnRight(false);
		
		electric.setLeftBlinker(false);
		electric.setRightBlinker(false);
		electric.setLights(false);
		electric.setWindshield(false);
		electric.setTimeLightsNight(0);
		electric.setTimeWindshield(0);
	}
	
	public void reportNavegation(int speed, int degrees, int gear) {
		motor.setSpeed(speed);
		motor.setGear(gear);
		direction.setDegrees(degrees);
	}
	
	public void reportDash(boolean statusRightBlinker, boolean statusLeftBlinker, boolean statusWindshield, boolean statusLight) {
		electric.setRightBlinker(statusRightBlinker);
		electric.setLeftBlinker(statusLeftBlinker);
		electric.setWindshield(statusWindshield);
		electric.setLights(statusLight);;
	}
	
    public ArrayList returnActualValues() {
    	ArrayList actualValues = new ArrayList();
    	
    	actualValues.add(motor.getGear());//0
    	actualValues.add(motor.getRevolutions());//1
    	actualValues.add(motor.getRevolutionsTime());//2
    	actualValues.add(motor.getSpeed());//3
    	
    	actualValues.add(direction.getDegrees());//4
    	actualValues.add(direction.isTurnLeft());//5
    	actualValues.add(direction.isTurnRight());//6
    	
    	actualValues.add(electric.getTimeLightsNight());//7
    	actualValues.add(electric.getTimeWindshield());//8
    	actualValues.add(electric.isLights());//9
    	actualValues.add(electric.isLeftBlinker());//10
    	actualValues.add(electric.isRightBlinker());//11
    	actualValues.add(electric.isWindshield());//12
    	
    	actualValues.add(obstacles.getMaximumSpeed());//13
    	actualValues.add(obstacles.getMinimumSpeed());//14
    	actualValues.add(obstacles.isDay());//15
    	actualValues.add(obstacles.isRain());//16
    	
		return actualValues;
    }

}