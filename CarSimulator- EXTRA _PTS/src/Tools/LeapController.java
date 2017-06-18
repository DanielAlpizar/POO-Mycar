package Tools;

import java.io.IOException;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

import Car.CarSystem;

public class LeapController {
	
	public LeapController(CarSystem system){
		
		LeapListener listener = new LeapListener();
		Controller controller = new Controller();
		listener.setSystem(system);
		controller.addListener(listener);
		
		System.out.println("Presionar enter para salir");
		
		try{
			System.in.read();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		controller.removeListener(listener);
	}
}
