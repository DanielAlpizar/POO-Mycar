package Car;

import java.util.*;

import Tools.Observer;
import Tools.Subject;

public class System implements Subject{
	
	private Motor motor = new Motor();
	private Direction direction = new Direction();
	private Electric electric = new Electric();
	private Obstacles obstacles = new Obstacles();
	private List<Observer> observers;
	private final Object MUTEX= new Object();
	private boolean changed;

	public System() {
		
	}
	
	public void start() {
		motor.setGear(1);
		motor.setRevolutions(0);
		motor.setRevolutionsTime(0);
		motor.setSpeed(0);
		
		direction.turnLeft(false);
		direction.turnRight(false);
		
		electric.setLeftBlinker(false);
		electric.setRightBlinker(false);
		electric.setLights(false);
		electric.setWindshield(false);
		electric.setTimeLightsNight(0);
		electric.setTimeWindshield(0);
	}
	
	public Motor getMotor() {
		notifyObservers();
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Direction getDirection() {
		notifyObservers();

		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Electric getElectric() {
		notifyObservers();

		return electric;
	}

	public void setElectric(Electric electric) {
		this.electric = electric;
	}

	public Obstacles getObstacles() {
		notifyObservers();

		return obstacles;
	}

	public void setObstacles(Obstacles obstacles) {
		this.obstacles = obstacles;
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

	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update(this);
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		// TODO Auto-generated method stub
		return null;
	}

}