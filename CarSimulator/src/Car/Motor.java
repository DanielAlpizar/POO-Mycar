package Car;

import java.util.*;
import Tools.IConstants;
import Tools.ThreadManager;

public class Motor extends System implements IConstants, Runnable {
	
	private int Gear;
    private int Speed;
    private int Revolutions;
    private int RevolutionsTime;
    private long StartTime = 0;
    private int FactorAceleracion = 1;
    private int CiclosAceleracion = 0;

    public Motor() {
    	
    }

    public int getGear() {
		return Gear;
	}

	public void setGear(int gear) {
		Gear = gear;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public int getRevolutions() {
		return Revolutions;
	}

	public void setRevolutions(int revolutions) {
		Revolutions = revolutions;
	}

	public int getRevolutionsTime() {
		return RevolutionsTime;
	}

	public void setRevolutionsTime(int revolutionsTime) {
		RevolutionsTime = revolutionsTime;
	}

	public long getStartTime() {
		return StartTime;
	}

	public void setStartTime(long startTime) {
		StartTime = startTime;
	}

	public void accelerate() { // estudiar synchronized 
    	FactorAceleracion = 1;
    	ThreadManager.getInstance().getExecutor().execute(this);
    }

    public void decelerate() {
    	FactorAceleracion = -1; 
    	ThreadManager.getInstance().getExecutor().execute(this);
    }
    
    public void breack() {
    	FactorAceleracion = -2;
    	ThreadManager.getInstance().getExecutor().execute(this);
    }
    
    public void gearChange(int pGear) {
    	this.Gear = pGear;
    }
    
    public void calculateRevolutions() {
    	this.Revolutions = (int)((Speed / ((Gear * 2) * Math.PI)) * MILISEC_TO_SEC);
    }
    
    public void calculateTimeRevolutions() {
    	if(this.Revolutions > 3500){
			this.StartTime = new Date().getTime();
		}else{
			long endTime = new Date().getTime();
			this.RevolutionsTime = (int)((endTime - StartTime) * MILISEC_TO_SEC);
		}
    }
    
    public void run() {
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	    this.Speed += (KM_POR_SEC * FactorAceleracion);
	    // falta hacer el ajuste por si se hace negativo o supera la velocidad maxima del carro, constantes
    }

}