package Car;

import java.util.*;
import Tools.IConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Electric implements IConstants {
	
	private boolean Lights;
	private boolean Windshield;
	private boolean RightBlinker;
	private boolean LeftBlinker;
	private int TimeLightsNight;
	private int TimeWindshield;
	private long StartTime = 0;
	private long StartTime2 = 0;
	
	public Electric() {
		
	}
	
	public boolean isLights() {
		return Lights;
	}

	public void setLights(boolean lights) {
		Lights = lights;
	}

	public boolean isWindshield() {
		return Windshield;
	}

	public void setWindshield(boolean windshield) {
		Windshield = windshield;
	}

	public boolean isRightBlinker() {
		return RightBlinker;
	}

	public void setRightBlinker(boolean rightBlinker) {
		RightBlinker = rightBlinker;
	}

	public boolean isLeftBlinker() {
		return LeftBlinker;
	}

	public void setLeftBlinker(boolean leftBlinker) {
		LeftBlinker = leftBlinker;
	}

	public int getTimeLightsNight() {
		return TimeLightsNight;
	}

	public void setTimeLightsNight(int timeLightsNight) {
		TimeLightsNight = timeLightsNight;
	}

	public int getTimeWindshield() {
		return TimeWindshield;
	}
	
	public void setTimeWindshield(int timeWindshield) {
		TimeWindshield = timeWindshield;
	}

	public void turnOnLights() {
		if(Lights == false){
			Lights = true;
		}
	}

	public void turnOffLights() {
		if(Lights){
			Lights = false;
		}
	}

	public void turnOnRightBlinker() {
		if(RightBlinker == false){
			RightBlinker = true;
		}
	}

	public void turnOffRightBlinker() {
		RightBlinker = false;
	}

	public void turnOnLeftBlinker() {
		if(LeftBlinker == false){
			LeftBlinker = true;
		}
	}

	public void turnOffLeftBlinker() {
		if(LeftBlinker){
			LeftBlinker = false;
		}
	}

	public void turnOnWindshield() {
		if(Windshield == false){
			Windshield = true;
		}
	}

	public void turnOffWindshield() {
		if(Windshield){
			Windshield = false;
		}
	}

	public void calculateTimeLights() {
		if(this.Lights == false){
			this.StartTime = new Date().getTime();
		}else{
			long endTime = new Date().getTime();
			this.TimeLightsNight = (int)((endTime - StartTime) * MILISEC_TO_SEC);
		}
	}

	public void calculateTimeWindshield() {
		if(this.Windshield == false){
			this.StartTime2 = new Date().getTime();
		}else{
			long endTime = new Date().getTime();
			this.TimeLightsNight = (int)((endTime - StartTime2) * MILISEC_TO_SEC);
		}
	}

}