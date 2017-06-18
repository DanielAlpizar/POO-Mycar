package Control;

import java.util.*;
import Tools.IConstants;
import Car.System;

public class Evaluator implements IConstants {
	
	private int actualScore = 100;
	private int maximumScore = 100;
	System system = new System();

	public Evaluator() {
		
	}

	public void evaluate(ArrayList list) {
		if(actualScore >= 0){
			if((int)system.returnActualValues().get(2) > 10){
				actualScore -= LOST_POINTS;
			}else if((int)system.returnActualValues().get(3) < (int)system.returnActualValues().get(14) ){
				actualScore -= LOST_POINTS;
			}else if((int)system.returnActualValues().get(3) > (int)system.returnActualValues().get(13) ){
				actualScore -= LOST_POINTS;
			}else if((boolean)system.returnActualValues().get(15) == false){
				if((int)system.returnActualValues().get(7) > 5){
					actualScore -= LOST_POINTS;
				}
			}else if((boolean)system.returnActualValues().get(16) == false){
				if((int)system.returnActualValues().get(8) > 5){
					actualScore -= LOST_POINTS;
				}
			}
		}
	}

}