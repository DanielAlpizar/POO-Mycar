package Car;

import java.util.*;
import Tools.IConstants;
import Tools.ThreadManager;

public class Motor   implements IConstants, Runnable {
	
	private int Gear=0;
    private int Speed=0;
    private int Revolutions=0;
    private int RevolutionsTime=0;
    private long StartTime = 0;
    private int FactorAceleracion = 1;
    private int CiclosAceleracion = 0;
    private CarSystem system;
   // public Motor() {
    	
   // }

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
    }

    public void decelerate() {
    	FactorAceleracion = -1; 

    }
    
    public void breack() {
    	FactorAceleracion = -2;

    }
    
    public int getFactorAceleracion() {
		return FactorAceleracion;
	}

	public void setFactorAceleracion(int factorAceleracion) {
		FactorAceleracion = factorAceleracion;
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

    public void setSystem(CarSystem system) {
		this.system = system;
	}

	public void run() {

		while(true){

			Speed += (KM_POR_SEC * FactorAceleracion);
			system.notifyObservers();
			system.setChanged(true);
	    	if(Speed<=0){
	    		Speed=0;
	    		FactorAceleracion=0;
	    	}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	    // falta hacer el ajuste por si se hace negativo o supera la velocidad maxima del carro, constantes
    }

}